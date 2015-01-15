package controllers;

import play.mvc.*;

import models.Supplier;
import models.Product;
import models.Supplier_Transaction;
import play.mvc.Result;
import play.data.Form;
import play.data.DynamicForm;
import java.lang.Boolean;
import java.lang.Integer;
import views.html.supplier_transactions.update;
import views.html.supplier_transactions.list;
import views.html.supplier_transactions.details;
import java.util.*;
import models.User_Action;

public class Supplier_Transactions extends Controller {
	private static final Form<Supplier_Transaction> transactionForm = Form.form(Supplier_Transaction.class);

	public static Result newTransaction(Long id){
		return ok(update.render(transactionForm,id));
	}
	public static Result list(){
		List<Supplier_Transaction> transactions = Supplier_Transaction.find.all();
		return ok(list.render(transactions));
	}
	public static Result details(Long id){
		Supplier_Transaction transaction = Supplier_Transaction.find.byId(id);
		return ok(details.render(transaction));
	}
	public static Result save(Long id){
	    DynamicForm requestData = Form.form().bindFromRequest();
		if(requestData.hasErrors()){
			flash("error","Please correct the form below.");
			return badRequest(update.render(transactionForm,id));
		}
		List<Product> products = Product.findByEan(requestData.get("product_ean"));
		if (products.isEmpty()){
			flash("error","Product is not found.");
			return badRequest(update.render(transactionForm,id));
		}
		if (requestData.get("quantity")==""){
			flash("error","Please input quantity.");
			return badRequest(update.render(transactionForm,id));
		}
		if (requestData.get("status")==null){
			flash("error","Please input status.");
			return badRequest(update.render(transactionForm,id));
		}
		Supplier supplier = Supplier.findByID(id);
		Product product = products.get(0);
		Supplier_Transaction transaction = new Supplier_Transaction();
		transaction.supplier = supplier;
		transaction.quantity = Integer.parseInt(requestData.get("quantity"));
		transaction.isPaid = Boolean.parseBoolean(requestData.get("status"));
		product.setInstock(product.instock + transaction.quantity);
		transaction.product = product;
		product.update();
		transaction.save();
		User_Action action = new User_Action();
		String str = String.format("Transaction %s : Imported %s from %s",transaction.internalId,transaction.quantity, transaction.supplier.name);
		action.verb= "Insert";
		action.description=str;
		action.save();
		return redirect(routes.Suppliers.details(id));
	}
	public static Result delete(Long id){
		Supplier_Transaction transaction = Supplier_Transaction.find.byId(id);
		if (transaction==null){
			return notFound(String.format("Transaction %s does not exist.", id));
		}
		transaction.delete();
		User_Action action = new User_Action();
		String str = String.format("Transaction %s : Remove %s from %s",transaction.internalId,transaction.quantity, transaction.supplier.name);
		action.verb= "Delete";
		action.description=str;
		action.save();
		return redirect(routes.Supplier_Transactions.list());
	}
}
