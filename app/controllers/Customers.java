package controllers;

import models.Customer;
import models.User_Action;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.customers.details;
import views.html.customers.list;
import views.html.customers.update;

import java.util.List;

//This class provides respond function for web interaction with Customer relation in the database
public class Customers extends Controller {
	private static final Form<Customer> customerForm = Form.form(Customer.class);

	/*
	Function name: list()
	Input: None
	Output:
	    - return customers list page
	Description:
		- find all customers
		- return customers page with customer list
	 */
	@Security.Authenticated(Secured.class)
	public static Result list(){
		List<Customer> customers = Customer.find.all();
		return ok(list.render(customers));
	}

	/*
	Function name: newCustomer()
	Input: None
	Output:
	    - return customer form page
	Description:
		- return customer form page
	 */
	@Security.Authenticated(Secured.class)
	public static Result newCustomer(){
		return ok(update.render(customerForm));
	}

	/*
	Function name: update(Long id)
	Input:
		- customer's id
	Output:
	    - return not found page or customer form page
	Description:
		- find customer with id
		- if not exist, return not found page
		- else return customer form page with filled data from exist customer
	 */
	@Security.Authenticated(Secured.class)
	public static Result update(Long id){
		Customer customer = Customer.findByID(id);
		if(customer==null){
			return notFound("No customer with name: " + id);
		}
		Form<Customer> filledForm = customerForm.fill(customer);
		return ok(update.render(filledForm));
	}

	/*
	Function name: details(Long id)
	Input:
		- customer's id
	Output:
	    - return customer's transactions page
	Description:
		- return customer's transaction page
	 */
	@Security.Authenticated(Secured.class)
	public static Result details(Long id){
		return ok(details.render(Customer.findByID(id)));
	}

	/*
	Function name: save()
	Input: None
	Output:
	    - return customers page
	Description:
		- gather data from customer form
		- save or update the customer to database
		- return customers page
	 */
	@Security.Authenticated(Secured.class)
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

	/*
	Function name: delete(Long id)
	Input:
		- customer's id
	Output:
	    - return not found page customers page
	Description:
		- find customer with id
		- if not exist, return not found page
		- else delete exist customer
	*/
	@Security.Authenticated(Secured.class)
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
