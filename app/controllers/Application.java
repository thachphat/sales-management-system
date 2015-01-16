package controllers;

import models.Customer;
import models.Customer_Transaction;
import play.*;
import play.mvc.*;
import models.User_Action;
import views.html.home;
import java.util.*;
import models.Supplier_Transaction;

public class Application extends Controller {

    public static Result home() {
		List<User_Action> actions=User_Action.find.order("createDate desc").findList();
		double supplierUnpaid = Supplier_Transaction.findUnpaidAmount();
		double supplierPaid = Supplier_Transaction.findPaidAmount();
		double customerUnpaid = Customer_Transaction.findUnpaidAmount();
		double customerPaid = Customer_Transaction.findPaidAmount();
		return ok(home.render(supplierPaid,supplierUnpaid,customerPaid,customerUnpaid,actions));
	}

}
