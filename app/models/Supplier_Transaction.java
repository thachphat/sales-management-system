package models;

import play.data.validation.Constraints;
import java.util.List;

import play.db.ebean.Model;

import javax.persistence.*;

@Entity
public class Supplier_Transaction extends Model {
	
	@Id
	@GeneratedValue
	public Long internalId;

	public String buyDate;
	
	@Constraints.Required
	@Basic(optional=false)
	public int quantity;

	@Constraints.Required
	@Basic(optional=false)
	public int price;

	@Constraints.Required
	@Basic(optional=false)
	public boolean isPaid;
	
    public static Finder<Long,Supplier_Transaction> find = new Finder<>(
       Long.class, Supplier_Transaction.class
     ); 
	
	public static double findUnpaidAmount(){
		List<Supplier_Transaction> transactions = find.where().eq("isPaid","false").findList();
		double unPaid=0;
		for(Supplier_Transaction transaction:transactions){
			unPaid= unPaid + (double)(transaction.quantity*transaction.price);
		}
		return unPaid;
	}
	public static double findPaidAmount(){
		List<Supplier_Transaction> transactions = find.where().eq("isPaid","true").findList();
		double paid =0 ;
		for(Supplier_Transaction transaction:transactions){
			paid= paid + (double)(transaction.quantity*transaction.price);
		}
		return paid;
	}

	@ManyToOne
	@JoinColumn(name="SUPPLIER_ID")
	@Basic(optional=false)
	public Supplier supplier;

	@ManyToOne
	@JoinColumn(name="ean")
	@Basic(optional=false)
	public Product product;
}