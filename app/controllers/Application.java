package controllers;

import play.*;
import play.mvc.*;
import models.User_Action;
import views.html.home;
import java.util.*;
import models.Supplier_Transaction;

public class Application extends Controller {

    public static Result home() {
		List<User_Action> supplier_transactions=User_Action.find.order("createDate desc").findList();
		double unpaid = Supplier_Transaction.findUnpaidAmount();
		double paid = Supplier_Transaction.findPaidAmount();
		double total = unpaid+paid;
		return ok(home.render((double)Math.round(paid/total*100),(double)Math.round(unpaid/total*100),supplier_transactions));
	}

}
