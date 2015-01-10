package controllers;

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
		if (!Product.findByEan(product.ean).isEmpty()){
			flash("error","Product is already exist");
			return badRequest(update.render(boundForm,suppliers));
		}
		else{
			product.save();
			flash("success","Successfully created");
			return redirect(routes.Products.list());
		}
	}
	public static Result delete(String ean){
		List<Product> product = Product.findByEan(ean);
		if (Product.findByEan(product.get(0).ean).isEmpty()){
			return notFound(String.format("Product %s does not exist.",ean));
		}
		product.get(0).delete();
		return redirect(routes.Products.list());
	}
}