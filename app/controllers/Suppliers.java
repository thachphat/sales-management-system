package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import play.data.Form;
import views.html.suppliers.list;
import views.html.suppliers.details;
import views.html.suppliers.update;
import models.Supplier;
import java.util.*;

public class Suppliers extends Controller{
	private static final Form<Supplier> supplierForm = Form.form(Supplier.class);

	public static Result list(){
		List<Supplier> suppliers = Supplier.find.all();
		return ok(list.render(suppliers));
	}
	public static Result newSupplier(){
		return ok(update.render(supplierForm));
	}
	public static Result details(Long id){
		Supplier supplier = Supplier.findByID(id);
		if (supplier ==null){
			return notFound(String.format("Supplier %s does not exist.",id));
		}
		return ok(details.render(supplier));
	}
	public static Result save(){
		Form<Supplier> boundForm = supplierForm.bindFromRequest();
		if(boundForm.hasErrors()){
			flash("error","Please correct the form below.");
			return badRequest(update.render(boundForm));
		}
		Supplier supplier = boundForm.get();
		if (supplier.id!=null){
			supplier.update();
			flash("success", "Successfully updated");
		}
		else{
			supplier.save();
			flash("success","Successfully created");
		}
		return redirect(routes.Suppliers.list());
	}

	public static Result update(Long id){
		Supplier supplier = Supplier.findByID(id);
		if(supplier==null){
			return notFound("Supplier " + id + " does not exist.");
		}
		Form<Supplier> filledForm = supplierForm.fill(supplier);
		return ok(update.render(filledForm));
	}

	public static Result delete(Long id){
		Supplier supplier = Supplier.findByID(id);
		if (supplier==null){
			return notFound(String.format("Supplier %s does not exist.",id));
		}
		supplier.delete();
		return redirect(routes.Suppliers.list());
	}
}