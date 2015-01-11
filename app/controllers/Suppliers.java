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
	public static Result details(String name){
		List<Supplier> suppliers = Supplier.findByName(name);
		if (suppliers ==null){
			return notFound(String.format("Supplier %s does not exist.",name));
		}
		System.out.print(suppliers);
		Supplier supplier=suppliers.get(0);
		return ok(details.render(supplier));
	}
	public static Result save(){
		Form<Supplier> boundForm = supplierForm.bindFromRequest();
		if(boundForm.hasErrors()){
			flash("error","Please correct the form below.");
			return badRequest(update.render(boundForm));
		}
		Supplier supplier = boundForm.get();
		if (!Supplier.findByName(supplier.name).isEmpty()){
			flash("error","Supplier is already exist");
			return badRequest(update.render(boundForm));
		}
		else{
			supplier.save();
			flash("success","Successfully created");
			return redirect(routes.Suppliers.list());
		}		
		
	}
	public static Result delete(String name){
		List<Supplier> suppliers = Supplier.findByName(name);
		if (Supplier.findByName(suppliers.get(0).name).isEmpty()){
			return notFound(String.format("Supplier %s does not exist.",name));
		}
		suppliers.get(0).delete();
		return redirect(routes.Suppliers.list());
	}
}