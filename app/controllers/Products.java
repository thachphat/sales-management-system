package controllers;

import models.User_Action;
import play.mvc.Controller;
import play.mvc.Result;
import play.data.Form;
import views.html.products.list;
import views.html.products.details;
import views.html.products.update;

import models.Product;
import java.util.*;
import models.Supplier;
public class Products extends Controller{
	private static final Form<Product> productForm = Form.form(Product.class);

	public static Result list(){
		List<Product> products = Product.find.all();
		return ok(list.render(products));
	}
	public static Result newProduct(){
		List<Supplier> suppliers=Supplier.find.all();
		return ok(update.render(productForm,suppliers));
	}
	public static Result details(String ean){
		List<Product> products=Product.findByEan(ean);
		return ok(details.render(products.get(0)));
	}
	public static Result update(String ean){
		List<Product> product = Product.findByEan(ean);
		if (product ==null){
			return notFound(String.format("Product %s does not exist.",ean));
		}
		Form<Product> filledForm = productForm.fill(product.get(0));
		// Also return list of companies
		List<Supplier> suppliers=Supplier.find.all();
					
		return ok(update.render(filledForm,suppliers));
	}
	public static Result save(){
		List<Supplier> suppliers=Supplier.find.all();
		Form<Product> boundForm = productForm.bindFromRequest();
		if(boundForm.hasErrors()){
			flash("error","Please correct the form below.");
			return badRequest(update.render(boundForm,suppliers));
		}
		
		Product product = boundForm.get();
		User_Action action = new User_Action();
		if (!Product.findByEan(product.ean).isEmpty()){
			List<Product> old_product = Product.findByEan(product.ean);
			Product old = old_product.get(0);
			old.setName(product.name);
			old.setDescription(product.description);
			old.setInstock(product.instock);
			old.update();
			action.verb = "Update";
			action.description = String.format("Product: %s-%s",old.ean,old.name);
		}
		else{
			product.save();
			flash("success","Successfully created");
			action.verb = "Insert";
			action.description = String.format("Product: %s-%s",product.ean,product.name);
		}
		action.save();
		return redirect(routes.Products.list());
	}
	public static Result delete(String ean){
		List<Product> product = Product.findByEan(ean);
		if (Product.findByEan(product.get(0).ean).isEmpty()){
			return notFound(String.format("Product %s does not exist.",ean));
		}
		User_Action action = new User_Action();
		action.verb = "Delete";
		action.description = String.format("Product: %s-%s",product.get(0).ean,product.get(0).name);
		product.get(0).delete();
		return redirect(routes.Products.list());
	}
}