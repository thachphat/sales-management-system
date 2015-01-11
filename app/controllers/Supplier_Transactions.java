package controllers;

import play.*;
import play.mvc.*;

import views.html.*;
import models.Supplier;
import models.Product;
import models.Supplier_Transaction;
import play.mvc.Result;
import play.data.Form;
import play.data.DynamicForm;
import java.lang.Boolean;
import java.lang.Integer;
import views.html.supplier_transactions.update;
import java.util.*;

public class Supplier_Transactions extends Controller {
	private static final Form<Supplier_Transaction> transactionForm = Form.form(Supplier_Transaction.class);

	public static Result newTransaction(String name){
		return ok(update.render(transactionForm,name));
	}
	public static Result save(String name){
	    DynamicForm requestData = Form.form().bindFromRequest();
		if(requestData.hasErrors()){
			flash("error","Please correct the form below.");
			return badRequest(update.render(transactionForm,name));
		}
		List<Product> products = Product.findByEan(requestData.get("product_ean"));
		if (products.isEmpty()){
			flash("error","Product is not found.");
			return badRequest(update.render(transactionForm,name));
		}
		if (requestData.get("quantity")==""){
			flash("error","Please input quantity.");
			return badRequest(update.render(transactionForm,name));
		}
		if (requestData.get("status")==null){
			flash("error","Please input status.");
			return badRequest(update.render(transactionForm,name));
		}
		List<Supplier> suppliers = Supplier.findByName(name);
		Supplier supplier=suppliers.get(0);
		Product product = products.get(0);
		
		Supplier_Transaction transaction = new Supplier_Transaction();
		transaction.supplier = supplier;
		transaction.quantity = Integer.parseInt(requestData.get("quantity"));
		transaction.isPaid = Boolean.parseBoolean(requestData.get("status"));
		product.setInstock(product.instock + transaction.quantity);
		transaction.product = product;
		product.update();
		transaction.save();
		return redirect(routes.Suppliers.details(name));		
	}
}
