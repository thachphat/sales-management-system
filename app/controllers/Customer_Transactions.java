package controllers;

import models.Customer;
import models.Customer_Transaction;
import models.Product;
import models.User_Action;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.customer_transactions.list;
import views.html.customer_transactions.update;

import java.util.List;

public class Customer_Transactions extends Controller {
    private static final Form<Customer_Transaction> transactionForm = Form.form(Customer_Transaction.class);

    public static Result newTransaction(Long id){
        return ok(update.render(transactionForm, id));
    }
    //List all transactions
    public static Result list(){
        List<Customer_Transaction> transactions = Customer_Transaction.find.all();
        return ok(list.render(transactions));
    }
    //Update transaction with transactionID
    public static Result details(Long id){
        Customer_Transaction transaction = Customer_Transaction.find.byId(id);
        if(transaction==null){
            return notFound("Transaction ID "+id+" not found.");
        }
        Form<Customer_Transaction> filledForm = transactionForm.fill(transaction);
        return ok(update.render(filledForm,transaction.customer.id));
    }
    //Save to customerID
    public static Result save(Long id){
        Form<Customer_Transaction> filledForm = transactionForm.bindFromRequest();
        if(filledForm.hasErrors()){
            flash("error","Please correct the form below.");
            return badRequest(update.render(transactionForm, id));
        }
        Customer_Transaction transaction = filledForm.get();
        List<Product> products = Product.findByEan(filledForm.apply("product_ean").value());
        if (products.isEmpty()){
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
            flash("error","Please input date.");
            return badRequest(update.render(filledForm,id));
        }
		/*if (transaction.isPaid==null){
			flash("error","Please input status.");
			return badRequest(update.render(filledForm,id));
		}*/
		/*SimpleDateFormat format = new SimpleDateFormat("mm/dd/yy");
		String dateString = requestData.get("buyDate");
		try{
			transaction.buyDate = format.parse(dateString);
		}
		catch (java.text.ParseException e){

		}*/
        Product product = products.get(0);
        User_Action action = new User_Action();
        if (transaction.internalId==null) {
            Customer customer = Customer.findByID(id);
            transaction.customer = customer;
            product.setInstock(product.instock - transaction.quantity);
            transaction.product = product;
            product.save();
            transaction.save();
            String str = String.format("Transaction %s : Imported %s to product %s-%s from %s",transaction.internalId,transaction.quantity, product.id, product.name, transaction.customer.name);
            action.verb= "Insert";
            action.description=str;
            action.update();
        }else{
            Customer_Transaction oldTransaction = Customer_Transaction.find.byId(transaction.internalId);
            Product oldProduct = oldTransaction.product;
            String str = String.format("Transaction %s : Updated", transaction.internalId);
            if(product.ean != oldProduct.ean) {
                str=str.concat(" product EAN from " + oldProduct.ean + " to " + product.ean+",");
                transaction.product = product;
            }
            if(transaction.quantity!=oldTransaction.quantity)
                str=str.concat(" selling quantity from "+oldTransaction.quantity+" to "+transaction.quantity+",");
            if(transaction.price!=oldTransaction.price)
                str=str.concat(" sold price from "+oldTransaction.price+" to "+transaction.price+",");
            if(transaction.sellDate!=oldTransaction.sellDate)
                str=str.concat(" sold date from "+oldTransaction.sellDate+" to "+transaction.sellDate);
            str=str.concat(" to product "+product.id+"-"+product.name+" from "+oldTransaction.customer.name);
            action.verb= "Update";
            action.description=str;
            action.save();
            oldProduct.setInstock(oldProduct.instock + oldTransaction.quantity);
            if(product.ean != oldProduct.ean) oldProduct.update();
            product.setInstock(product.instock - transaction.quantity);
            product.update();
            transaction.update();
        }

        return redirect(routes.Customers.details(id));
    }
    public static Result delete(Long id){
        Customer_Transaction transaction = Customer_Transaction.find.byId(id);
        if (transaction==null){
            return notFound(String.format("Transaction %s does not exist.", id));
        }

        Product product = transaction.product;
        product.setInstock(product.instock + transaction.quantity);
        product.update();

        transaction.delete();
        User_Action action = new User_Action();
        String str = String.format("Transaction %s : Remove %s of product %s-%s from %s",transaction.internalId,transaction.quantity, product.id, product.name, transaction.customer.name);
        action.verb= "Delete";
        action.description=str;
        action.save();
        return redirect(routes.Customer_Transactions.list());
    }
}
