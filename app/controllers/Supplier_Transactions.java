package controllers;

import models.Supplier;
import models.Product;
import models.Supplier_Transaction;
import play.mvc.Controller;
import play.mvc.Result;
import play.data.Form;
import play.mvc.Security;
import views.html.supplier_transactions.update;
import views.html.supplier_transactions.list;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import models.User_Action;

public class Supplier_Transactions extends Controller {
	private static final Form<Supplier_Transaction> transactionForm = Form.form(Supplier_Transaction.class);

	@Security.Authenticated(Secured.class)
	public static Result newTransaction(Long id){
		return ok(update.render(transactionForm,id));
	}
	//List all transactions
	@Security.Authenticated(Secured.class)
	public static Result list(){
		List<Supplier_Transaction> transactions = Supplier_Transaction.find.all();
		return ok(list.render(transactions));
	}

	//Update transaction with transactionID
	@Security.Authenticated(Secured.class)
	public static Result details(Long id){
		Supplier_Transaction transaction = Supplier_Transaction.find.byId(id);
		if(transaction==null){
			return notFound("Transaction ID "+id+" not found.");
		}
		Form<Supplier_Transaction> filledForm = transactionForm.fill(transaction);
		return ok(update.render(filledForm,transaction.supplier.id));
	}

	//Save to supplierID
	@Security.Authenticated(Secured.class)
	public static Result save(Long id){
		Form<Supplier_Transaction> filledForm = transactionForm.bindFromRequest();
		if(filledForm.hasErrors()){
			flash("error","Please correct the form below.");
			return badRequest(update.render(transactionForm, id));
		}
		Supplier_Transaction transaction = filledForm.get();
		Product product = Product.findByEan(filledForm.apply("product_ean").value());
		if (product==null){
			flash("error","Product is not found.");
			return badRequest(update.render(filledForm,id));
		}
		if (transaction.quantity<0){
			flash("error","Please input quantity.");
			return badRequest(update.render(filledForm,id));
		}
		if (transaction.price==0){
			flash("error","Please input price.");
			return badRequest(update.render(filledForm,id));
		}
		if (transaction.buyDate==null){
			DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
			Date date = new Date();
			transaction.buyDate = format.format(date);
		}

		User_Action action = new User_Action();
		if (transaction.internalId==null) {
			transaction.supplier = Supplier.findByID(id);
			product.setInstock(product.instock + transaction.quantity);
			transaction.product = product;
			product.update();
			transaction.save();
			String str = String.format("Transaction %s : Buying %s units with %s price/unit on %s to product %s-%s from %s",transaction.internalId,transaction.quantity,transaction.price,transaction.buyDate, product.id, product.name, transaction.supplier.name);
			action.verb= "Insert";
			action.description=str;
			action.save();
		}else{
			Supplier_Transaction oldTransaction = Supplier_Transaction.find.byId(transaction.internalId);
			Product oldProduct = oldTransaction.product;

			//Checking for change
			if(!product.ean.equals(oldProduct.ean) || transaction.quantity!=oldTransaction.quantity || transaction.price!=oldTransaction.price || !transaction.buyDate.equals(oldTransaction.buyDate) || transaction.isPaid!=oldTransaction.isPaid) {
				String str = String.format("Transaction %s : Updated", transaction.internalId);
				if (!product.ean.equals(oldProduct.ean)) {
					str = str.concat(" product EAN from " + oldProduct.ean + " to " + product.ean + ",");
					transaction.product = product;
				}
				if (transaction.quantity != oldTransaction.quantity)
					str = str.concat(" buying quantity from " + oldTransaction.quantity + " to " + transaction.quantity + ",");
				if (transaction.price != oldTransaction.price)
					str = str.concat(" bought price from " + oldTransaction.price + " to " + transaction.price + ",");
				if (!transaction.buyDate.equals(oldTransaction.buyDate))
					str = str.concat(" bought date from " + oldTransaction.buyDate + " to " + transaction.buyDate + ",");
				if (transaction.isPaid != oldTransaction.isPaid)
					str = str.concat(" status from " + ((oldTransaction.isPaid) ? "Paid" : "Unpaid") + " to " + ((transaction.isPaid) ? "Paid" : "Unpaid"));
				str = str.concat(" to product " + product.id + "-" + product.name + " from " + oldTransaction.supplier.name);
				action.verb = "Update";
				action.description = str;
				action.save();
				oldProduct.setInstock(oldProduct.instock - oldTransaction.quantity);
				if (!product.ean.equals(oldProduct.ean)) oldProduct.update();
				product.setInstock(product.instock + transaction.quantity);
				product.update();
				transaction.update();
			}
		}

		return redirect(routes.Suppliers.details(id));
	}

	//delete transaction
	@Security.Authenticated(Secured.class)
	public static Result delete(Long id){
		Supplier_Transaction transaction = Supplier_Transaction.find.byId(id);
		if (transaction==null){
			return notFound(String.format("Transaction %s does not exist.", id));
		}

		Product product = transaction.product;
		product.setInstock(product.instock - transaction.quantity);
		product.update();

		transaction.delete();
		User_Action action = new User_Action();
		String str = String.format("Transaction %s : Remove %s of product %s-%s from %s",transaction.internalId,transaction.quantity, product.id, product.name, transaction.supplier.name);
		action.verb= "Delete";
		action.description=str;
		action.save();
		return redirect(routes.Supplier_Transactions.list());
	}
}
