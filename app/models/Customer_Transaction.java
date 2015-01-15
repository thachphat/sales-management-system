package models;

import java.util.List;

import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import play.db.ebean.Model;

@Entity
public class Customer_Transaction extends Model{
	@Id
	public Long internalId;
	
	@Constraints.Required
	public String sellDate;
	@Constraints.Required
	public int price;
	@Constraints.Required
	public boolean isPaid;
	@Constraints.Required
	public int quantity;
	
	@ManyToOne
	@JoinColumn(name="CUSTOMER_ID")
	public Customer customer;

	@ManyToOne
	@JoinColumn(name="ean")
	public Product product;

	public static Finder<Long,Customer_Transaction> find = new Finder<Long, Customer_Transaction>(Long.class, Customer_Transaction.class);

	public static List<Customer_Transaction> findByCustomer(Long id) {
		return find.where().eq("customer.id",id).findList();
	}

	public static double findUnpaidAmount(){
		List<Customer_Transaction> transactions = find.where().eq("isPaid","false").findList();
		double unPaid=0;
		for(int i=0;i < transactions.size(); i++){
			unPaid= unPaid + (double)transactions.get(i).quantity;
		}
		return unPaid;
	}

	public static double findPaidAmount(){
		List<Customer_Transaction> transactions = find.where().eq("isPaid","true").findList();
		double paid =0 ;
		for(int i=0;i < transactions.size(); i++){
			paid= paid + (double)transactions.get(i).quantity;
		}
		return paid;
	}
}
