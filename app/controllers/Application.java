package controllers;

import models.Customer_Transaction;
import models.Supplier_Transaction;
import models.User_Action;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.home;

import java.util.List;

//This class provides homepage functions
public class Application extends Controller {

	/*
	Function name: home()
	Input: None
	Output:
		- return to home page
	Description:
		- calculate supplier's and customer's paid and unpaid amount
		- render homepage dashboard
	 */
	@Security.Authenticated(Secured.class)
    public static Result home() {
		List<User_Action> actions=User_Action.find.order("createDate desc").findList();
		double supplierUnpaid = Supplier_Transaction.findUnpaidAmount();
		double supplierPaid = Supplier_Transaction.findPaidAmount();
		double customerUnpaid = Customer_Transaction.findUnpaidAmount();
		double customerPaid = Customer_Transaction.findPaidAmount();
		return ok(home.render(supplierPaid,supplierUnpaid,customerPaid,customerUnpaid,actions));
	}
}
