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

	//Create one to many relationship with Supplier_Transaction
	@OneToMany(mappedBy="product",cascade=CascadeType.ALL)
	public List<Supplier_Transaction> transactions;

    public static Finder<Long,Product> find = new Finder<>(
       Long.class, Product.class
     );

	/*
	Function name: findByEan(String ean)
	Input:
		- String ean
	Output:
	    - return Product instance
	Description:
	    - find Product instance in database by ean and return it
	 */
	public static Product findByEan(String ean){
		return find.where().eq("ean",ean).findUnique();
	}
}