package controllers;

import models.Product;
import net.sf.ehcache.util.ProductInfo;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.products.list;
import views.html.products.details;

import java.util.List;

public class Products extends Controller{

	private static Form<Product> productForm = Form.form(Product.class);

	public static Result list(){
		List<Product> products = Product.findAll();
		return ok(list.render(products));
	}

	public static Result newProduct(){
		return ok(details.render(productForm));
	}
	
	public static Result details(String ean){
		final Product product = Product.findByEan(ean);
		if (product==null){
			return notFound(String.format("Product %s does not exist.",ean));
		}

		Form<Product> filledForm = productForm.fill(product);
		return ok(details.render(filledForm));
	}
	
	public static Result save(){
		Form<Product> boundForm = productForm.bindFromRequest();
		if(boundForm.hasErrors()){
			flash("error", "Please correct the form below.");
			return badRequest(details.render(boundForm));
		}

		Product product = boundForm.get();
		product.save();
		flash("success",String.format("Successfully added product %s",product));
		return redirect(routes.Products.list());
	}

	public static Result delete(String ean){
		final Product product = Product.findByEan(ean);
		if(product==null){
			return notFound(String.format("Product %s does not exist.",ean));
		}

		Product.remove(product);
		return redirect(routes.Products.list());
	}

}
