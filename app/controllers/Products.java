package controllers;

import models.User_Action;
import play.mvc.Controller;
import play.mvc.Result;
import play.data.Form;
import play.mvc.Security;
import views.html.products.list;
import views.html.products.update;

import models.Product;
import java.util.*;
public class Products extends Controller{
	private static final Form<Product> productForm = Form.form(Product.class);

	@Security.Authenticated(Secured.class)
	public static Result list(){
		List<Product> products = Product.find.all();
		return ok(list.render(products));
	}
	@Security.Authenticated(Secured.class)
	public static Result newProduct(){
		return ok(update.render(productForm));
	}
	@Security.Authenticated(Secured.class)
	public static Result details(String ean){
		return ok(update.render(productForm));
	}
	@Security.Authenticated(Secured.class)
	public static Result update(String ean){
		Product product = Product.findByEan(ean);
		if (product ==null){
			return notFound(String.format("Product %s does not exist.",ean));
		}
		Form<Product> filledForm = productForm.fill(product);
		// Also return list of companies
		return ok(update.render(filledForm));
	}
	@Security.Authenticated(Secured.class)
	public static Result save(){
		Form<Product> boundForm = productForm.bindFromRequest();
		if(boundForm.hasErrors()){
			flash("error","Please correct the form below.");
			return badRequest(update.render(boundForm));
		}
		
		Product product = boundForm.get();
		User_Action action = new User_Action();
		if (Product.findByEan(product.ean)!=null){
			Product old = Product.findByEan(product.ean);
			old.name=product.name;
			old.description=product.description;
			old.instock=product.instock;
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
	@Security.Authenticated(Secured.class)
	public static Result delete(String ean){
		Product product = Product.findByEan(ean);
		if (product==null){
			return notFound(String.format("Product %s does not exist.",ean));
		}
		User_Action action = new User_Action();
		action.verb = "Delete";
		action.description = String.format("Product: %s-%s",product.ean,product.name);
		action.save();
		product.delete();
		return redirect(routes.Products.list());
	}
}