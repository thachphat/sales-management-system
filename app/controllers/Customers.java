package controllers;

import models.Customer;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.customers.list;
import views.html.customers.update;

import java.util.List;

public class Customers extends Controller {
	private static final Form<Customer> customerForm = Form.form(Customer.class);

	public static Result list(){
		List<Customer> customers = Customer.find.all();
		return ok(list.render(customers));
	}

	public static Result newCustomer(){
		return ok(update.render(customerForm));
	}

	public static Result details(Long id){
		Customer customer = Customer.findByID(id);
		if(customer==null){
			return notFound("No customer with name: " + id);
		}
		Form<Customer> filledForm = customerForm.fill(customer);
		return ok(update.render(filledForm));
	}

	public static Result save(){
		Form<Customer> boundForm = customerForm.bindFromRequest();
		if(boundForm.hasErrors()){
			flash("error","Please correct the form below");
			return badRequest(update.render(boundForm));
		}
		Customer customer = boundForm.get();
		if(Customer.findByID(customer.id)!=null){
			customer.update();
			flash("success", "Successfully updated");
		}
		else{
			customer.save();
			flash("success","Successfully created");
		}
		return redirect(routes.Customers.list());
	}

	public static Result delete(Long id){
		Customer customer = Customer.findByID(id);
		if(customer==null) return notFound("No customer with id: "+id);
		customer.delete();
		return redirect(routes.Customers.list());
	}
}
