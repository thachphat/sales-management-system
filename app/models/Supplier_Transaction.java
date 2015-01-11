package models;
import play.db.ebean.*;
import javax.persistence.*;
import play.data.validation.Constraints;
import models.Supplier;
import java.util.*;
import play.data.format.*;

@Entity
public class Supplier_Transaction extends Model{
	
	@Id
	@GeneratedValue
	public Long internalId;
		
	@ManyToOne
    @JoinColumn(name="SUPPLIER_ID")
	@Constraints.Required
	@Basic(optional=false)
	public Supplier supplier;
	
	@ManyToOne
	@JoinColumn(name="ean")
	@Constraints.Required
	@Basic(optional=false)
	public Product product;
	
	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date buyDate = new Date();
	
	@Constraints.Required
	@Basic(optional=false)
	public int quantity;
	
	@Constraints.Required
	@Basic(optional=false)
	public boolean isPaid;
	
    public static Finder<Long,Supplier_Transaction> find = new Finder<Long,Supplier_Transaction>(
       Long.class, Supplier_Transaction.class
     ); 
	
	public static double findUnpaidAmount(){
		List<Supplier_Transaction> transactions = find.where().eq("isPaid","false").findList();
		double unPaid=0;
		for(int i=0;i < transactions.size(); i++){
			unPaid= unPaid + (double)transactions.get(i).quantity;
		}
		return unPaid;
	}
	public static double findPaidAmount(){
		List<Supplier_Transaction> transactions = find.where().eq("isPaid","true").findList();
		double paid =0 ;
		for(int i=0;i < transactions.size(); i++){
			paid= paid + (double)transactions.get(i).quantity;
		}
		return paid;
		
	}
}