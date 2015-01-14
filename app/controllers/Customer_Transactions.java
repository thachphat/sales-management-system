package controllers;

import models.Customer_Transaction;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

public class Customer_Transactions extends Controller {

    public static Result list(Long id){//chua xong
        List<Customer_Transaction> transactions = Customer_Transaction.findByCustomer(id);
        return TODO;
    }

    public static Result newTransaction(Long id){
        return ok();
    }

    public static Result save(Long id){
        return TODO;
    }

    public static Result details(Long id, Long tid){
        return TODO;
    }

    public static Result update(Long id){
        return TODO;
    }
}
