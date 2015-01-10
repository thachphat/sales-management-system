package models;
import play.db.ebean.*;
import javax.persistence.*;
import play.data.validation.Constraints;
import java.util.*;
import models.Supplier_Transaction;
@Entity
public class Product extends Model{
	
	@Id
	public Long id;
	
	@Constraints.Required
	@Basic(optional=false) @Column(unique=true) public String ean;
	
	@Constraints.Required
	public String name;
	
	public String description;
	
	@Constraints.Required
	@Basic(optional=false)
	public int in_stock;
	
	@OneToMany(mappedBy="product",cascade=CascadeType.ALL)
	public List<Supplier_Transaction> transactions;
			
	public String toString(){
		return String.format("%s - %s",ean,name);
	}
	
    public static Finder<Long,Product> find = new Finder<Long,Product>(
       Long.class, Product.class
     ); 
	
	public static List<Product> findByEan(String ean){
		return find.where().eq("ean",ean).findList();
	}
}