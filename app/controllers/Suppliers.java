package controllers;

import models.User_Action;
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
		User_Action action = new User_Action();
		if (supplier.id!=null){
			supplier.update();
			flash("success", "Successfully updated");
			action.verb = "Update";
			action.description = String.format("Supplier: %s-%s",supplier.id,supplier.name);
		}
		else{
			action.verb="Insert";
			action.description=String.format("Supplier: %s-%s",supplier.id, supplier.name);
			supplier.save();
			flash("success","Successfully created");
		}
		action.save();
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
		User_Action action = new User_Action();
		action.verb="Delete";
		action.description=String.format("Supplier: %s-%s",supplier.id,supplier.name);
		action.save();
		supplier.delete();
		return redirect(routes.Suppliers.list());
	}
}