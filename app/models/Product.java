package models;
import play.db.ebean.*;
import javax.persistence.*;
import play.data.validation.Constraints;
import java.util.*;
@Entity
public class Product extends Model{
	
	@Id
	public Long id;
	
	@Constraints.Required
	@Basic(optional=false) @Column(unique=true) public String ean;
	
	@Constraints.Required
	public String name;
	
	public String description;
	
	public int instock;
	
	@OneToMany(mappedBy="product",cascade=CascadeType.ALL)
	public List<Supplier_Transaction> transactions;

    public static Finder<Long,Product> find = new Finder<>(
       Long.class, Product.class
     ); 
	
	public static Product findByEan(String ean){
		return find.where().eq("ean",ean).findUnique();
	}
}