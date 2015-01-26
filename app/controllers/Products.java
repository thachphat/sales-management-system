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

//This class provides respond function for web interaction with Product relation in the database
public class Products extends Controller{
	private static final Form<Product> productForm = Form.form(Product.class);

	/*
	Function name: list()
	Input: None
	Output:
	    - return products list page
	Description:
		- find all products
		- return products page with product list
	 */
	@Security.Authenticated(Secured.class)
	public static Result list(){
		List<Product> products = Product.find.all();
		return ok(list.render(products));
	}

	/*
	Function name: newProduct()
	Input: None
	Output:
	    - return product form page
	Description:
		- return product form page
	 */
	@Security.Authenticated(Secured.class)
	public static Result newProduct(){
		return ok(update.render(productForm));
	}

	/*
	Function name: details(String ean)
	Input:
		- product's ean
	Output:
	    - return not found page or product form page
	Description:
		- find product with ean
		- if not exist, return not found page
		- else return product form page with filled data from exist product
	 */
	@Security.Authenticated(Secured.class)
	public static Result details(String ean){
		Product product = Product.findByEan(ean);
		if (product ==null){
			return notFound(String.format("Product %s does not exist.",ean));
		}
		Form<Product> filledForm = productForm.fill(product);
		return ok(update.render(filledForm));
	}

	/*
	Function name: update(String ean)
	Input:
		- product's ean
	Output:
	    - return not found page or product form page
	Description:
		- find product with ean
		- if not exist, return not found page
		- else return product form page with filled data from exist product
	 */
	@Security.Authenticated(Secured.class)
	public static Result update(String ean){
		Product product = Product.findByEan(ean);
		if (product ==null){
			return notFound(String.format("Product %s does not exist.",ean));
		}
		Form<Product> filledForm = productForm.fill(product);
		return ok(update.render(filledForm));
	}

	/*
	Function name: save()
	Input: None
	Output:
	    - return products page
	Description:
		- gather data from product form
		- save or update the product to database
		- return products page
	 */
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

	/*
	Function name: delete(String ean)
	Input:
		- product's ean
	Output:
	    - return not found page products page
	Description:
		- find product with ean
		- if not exist, return not found page
		- else delete exist product
	*/
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