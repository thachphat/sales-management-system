package controllers;

import models.Customer;
import models.Customer_Transaction;
import models.Product;
import models.User_Action;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.customer_transactions.list;
import views.html.customer_transactions.update;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//This class provides respond function for web interaction with Customer_Transaction relation in the database
public class Customer_Transactions extends Controller {
    private static final Form<Customer_Transaction> transactionForm = Form.form(Customer_Transaction.class);

    /*
	Function name: newTransaction(Long id)
	Input:
	    - id: customer's id
	Output:
	    - return transaction form page
	Description:
		- direct new transaction of a customer with customer's id request to transaction form page
	 */
    @Security.Authenticated(Secured.class)
    public static Result newTransaction(Long id){
        return ok(update.render(transactionForm, id));
    }

    /*
	Function name: list()
	Input: None
	Output:
	    - return transaction list page
	Description:
		- find all transactions performed by all customers
		- return transactions page with transactions list
	 */
    @Security.Authenticated(Secured.class)
    public static Result list(){
        List<Customer_Transaction> transactions = Customer_Transaction.find.all();
        return ok(list.render(transactions));
    }

    /*
	Function name: details(Long id)
	Input:
	    - id: transaction's id
	Output:
	    - return not found page or transaction form page
	Description:
        - find a transaction with id
        - if not exist, return not found page
        - else return transaction form page with filled data from found transaction
	 */
    @Security.Authenticated(Secured.class)
    public static Result details(Long id){
        Customer_Transaction transaction = Customer_Transaction.find.byId(id);
        if(transaction==null){
            return notFound("Transaction ID "+id+" not found.");
        }
        Form<Customer_Transaction> filledForm = transactionForm.fill(transaction);
        return ok(update.render(filledForm,transaction.customer.id));
    }

    /*
	Function name: save(Long id)
	Input:
	    - id: customer's id
	Output:
	    - return customer's transactions page
	Description:
        - gather information from transaction form page
        - save or update the transaction to database
        - update product's in stock
        - return customer's transactions page
	 */
    @Security.Authenticated(Secured.class)
    public static Result save(Long id){
        Form<Customer_Transaction> filledForm = transactionForm.bindFromRequest();
        if(filledForm.hasErrors()){
            flash("error","Please correct the form below.");
            return badRequest(update.render(transactionForm, id));
        }
        Customer_Transaction transaction = filledForm.get();
        Product product = Product.findByEan(filledForm.apply("product_ean").value());
        if (product==null){
            flash("error","Product is not found.");
            return badRequest(update.render(filledForm,id));
        }
        if (transaction.quantity==0){
            flash("error","Please input quantity.");
            return badRequest(update.render(filledForm,id));
        }
        if (transaction.price==0){
            flash("error","Please input price.");
            return badRequest(update.render(filledForm,id));
        }
        if (transaction.sellDate==null){
            DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
            Date date = new Date();
            transaction.sellDate = format.format(date);
        }

        User_Action action = new User_Action();
        if (transaction.internalId==null) {
            if(transaction.quantity>product.instock){
                flash("error",String.format("Please input a quantity at most %s",product.instock));
                return badRequest(update.render(filledForm,id));
            }
            transaction.customer = Customer.findByID(id);
            product.instock = product.instock - transaction.quantity;
            transaction.product = product;
            product.save();
            transaction.save();
            String str = String.format("Transaction %s : Selling %s units with %s price/unit on %s to product %s-%s from %s",transaction.internalId,transaction.quantity,transaction.price,transaction.sellDate, product.id, product.name, transaction.customer.name);
            action.verb= "Insert";
            action.description=str;
            action.save();
        }else{
            Customer_Transaction oldTransaction = Customer_Transaction.find.byId(transaction.internalId);
            Product oldProduct = oldTransaction.product;

            //Checking for change
            if(!product.ean.equals(oldProduct.ean) || transaction.quantity!=oldTransaction.quantity || transaction.price!=oldTransaction.price || !transaction.sellDate.equals(oldTransaction.sellDate) || transaction.isPaid!=oldTransaction.isPaid) {
                if(!product.id.equals(oldProduct.id) && transaction.quantity>product.instock){
                    flash("error",String.format("Please input a quantity at most %s",product.instock));
                    return badRequest(update.render(filledForm,id));
                }
                else if(product.id.equals(oldProduct.id) && transaction.quantity>oldProduct.instock+oldTransaction.quantity){
                    flash("error",String.format("Please input a quantity at most %s",oldProduct.instock+oldTransaction.quantity));
                    return badRequest(update.render(filledForm,id));
                }
                String str = String.format("Transaction %s : Updated", transaction.internalId);
                if (!product.ean.equals(oldProduct.ean)) {
                    str = str.concat(" product EAN from " + oldProduct.ean + " to " + product.ean + ",");
                    transaction.product = product;
                }
                if (transaction.quantity != oldTransaction.quantity)
                    str = str.concat(" selling quantity from " + oldTransaction.quantity + " to " + transaction.quantity + ",");
                if (transaction.price != oldTransaction.price)
                    str = str.concat(" sold price from " + oldTransaction.price + " to " + transaction.price + ",");
                if (!transaction.sellDate.equals(oldTransaction.sellDate))
                    str = str.concat(" sold date from " + oldTransaction.sellDate + " to " + transaction.sellDate + ",");
                if (transaction.isPaid != oldTransaction.isPaid)
                    str = str.concat(" status from " + ((oldTransaction.isPaid) ? "Paid" : "Unpaid") + " to " + ((transaction.isPaid) ? "Paid" : "Unpaid"));
                str = str.concat(" to product " + product.id + "-" + product.name + " from " + oldTransaction.customer.name);
                action.verb = "Update";
                action.description = str;
                action.save();
                if (!product.ean.equals(oldProduct.ean)){
                    oldProduct.instock=oldProduct.instock + oldTransaction.quantity;
                    oldProduct.update();
                }
                else product.instock=oldProduct.instock+oldTransaction.quantity;
                product.instock=product.instock - transaction.quantity;
                product.update();
                transaction.update();
            }
        }

        return redirect(routes.Customers.details(id));
    }

    /*
	Function name: delete(Long id)
	Input:
	    - id: transaction's id
	Output:
	    - return not found page or transactions page
	Description:
        - find a transaction with id
        - if not exist, return not found page
        - else
            - update product in stock
            - delete transaction from database
	 */
    @Security.Authenticated(Secured.class)
    public static Result delete(Long id){
        Customer_Transaction transaction = Customer_Transaction.find.byId(id);
        if (transaction==null){
            return notFound(String.format("Transaction %s does not exist.", id));
        }

        Product product = transaction.product;
        product.instock=product.instock + transaction.quantity;
        product.update();

        User_Action action = new User_Action();
        String str = String.format("Transaction %s : Remove %s of product %s-%s from %s",transaction.internalId,transaction.quantity, product.id, product.name, transaction.customer.name);
        action.verb= "Delete";
        action.description=str;
        action.save();
        transaction.delete();
        return redirect(routes.Customer_Transactions.list());
    }
}
