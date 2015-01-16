package controllers;

import models.Customer;
import models.User_Action;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.customers.details;
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

	public static Result update(Long id){
		Customer customer = Customer.findByID(id);
		if(customer==null){
			return notFound("No customer with name: " + id);
		}
		Form<Customer> filledForm = customerForm.fill(customer);
		return ok(update.render(filledForm));
	}

	public static Result details(Long id){
		return ok(details.render(Customer.findByID(id)));
	}

	public static Result save(){
		Form<Customer> boundForm = customerForm.bindFromRequest();
		if(boundForm.hasErrors()){
			flash("error","Please correct the form below");
			return badRequest(update.render(boundForm));
		}
		Customer customer = boundForm.get();
		User_Action action = new User_Action();
		Customer oldCustomer = Customer.findByEmail(customer.email1);
		if(customer.id!=null || oldCustomer!=null){
			if(oldCustomer!=null){
				oldCustomer.name = customer.name;
				oldCustomer.address = customer.address;
				oldCustomer.email2 = customer.email2;
				oldCustomer.phone1 = customer.phone1;
				oldCustomer.phone2 = customer.phone2;
				oldCustomer.update();
				action.description = String.format("Customer's info: %s-%s-%s",oldCustomer.id,oldCustomer.name,oldCustomer.email1);
			}
			else {
				customer.update();
				action.description = String.format("Customer's info: %s-%s-%s", customer.id, customer.name,customer.email1);
			}
			action.verb = "Update";
			flash("success", "Successfully updated");
		}
		else{
			customer.save();
			flash("success", "Successfully created");
			action.verb="Insert";
			action.description=String.format("Customer: %s-%s-%s",customer.id,customer.name,customer.email1);
		}
		action.save();
		return redirect(routes.Customers.list());
	}

	public static Result delete(Long id){
		Customer customer = Customer.findByID(id);
		if(customer==null) return notFound("No customer with id: "+id);
		User_Action action = new User_Action();
		action.verb = "Delete";
		action.description = String.format("Customer: %s-%s.",customer.id,customer.name);
		action.save();
		customer.delete();
		return redirect(routes.Customers.list());
	}
}
