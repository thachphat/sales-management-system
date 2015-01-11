package controllers;

import play.*;
import play.mvc.*;
import models.Supplier_Transaction;
import views.html.home;
import java.util.*;

public class Application extends Controller {

    public static Result home() {
		List<Supplier_Transaction> supplier_transactions=Supplier_Transaction.find.all();
		double unpaid = Supplier_Transaction.findUnpaidAmount();
		double paid = Supplier_Transaction.findPaidAmount();
		double total = unpaid+paid;
        return ok(home.render((double)Math.round(paid/total*100),(double)Math.round(unpaid/total*100),supplier_transactions));
    }

}
