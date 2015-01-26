package models;

import java.util.List;

import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import play.db.ebean.Model;

//This class provides Customer_Transaction relation using ebean ORM
@Entity
public class Customer_Transaction extends Model{
	@Id
	public Long internalId;
	
	public String sellDate;
	@Constraints.Required
	public int price;
	@Constraints.Required
	public boolean isPaid;
	@Constraints.Required
	public int quantity;

	//Create many to one relationship with customer
	@ManyToOne
	@JoinColumn(name="CUSTOMER_ID")
	public Customer customer;


	//Create many to one relationship with product
	@ManyToOne
	@JoinColumn(name="ean")
	public Product product;

	public static Finder<Long,Customer_Transaction> find = new Finder<>(Long.class, Customer_Transaction.class);

	/*
	Function name: findUnpaidAmount()
	Input: None
	Output:
	    - return total unpaid amount of all transactions
	Description:
		- find all transactions with isPaid=false
		- return sum all of their balance
	 */
	public static double findUnpaidAmount(){
		List<Customer_Transaction> transactions = find.where().eq("isPaid","false").findList();
		double unPaid=0;
		for(Customer_Transaction transaction:transactions){
			unPaid= unPaid + (double)(transaction.quantity*transaction.price);
		}
		return unPaid;
	}

	/*
	Function name: findPaidAmount()
	Input: None
	Output:
	    - return total paid amount of all transactions
	Description:
		- find all transactions with isPaid=true
		- return sum all of their balance
	 */
	public static double findPaidAmount(){
		List<Customer_Transaction> transactions = find.where().eq("isPaid","true").findList();
		double paid =0 ;
		for(Customer_Transaction transaction:transactions){
			paid= paid + (double)(transaction.quantity*transaction.price);
		}
		return paid;
	}
}
