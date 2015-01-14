package models;
import play.db.ebean.*;
import javax.persistence.*;
import play.data.validation.Constraints;
import java.util.*;

@Entity
public class Supplier extends Model{

	@Id
	@GeneratedValue
    @Column(name = "SUPPLIER_ID")
	public Long id;
	@Constraints.Required
	public String address;
	@Constraints.Required
	public String phone1;
	public String phone2;
	@Constraints.Required
	public String email1;
	public String email2;
	
	@Constraints.Required
	@Basic(optional=false) @Column(unique=true) public String name;
	
	@OneToMany(mappedBy="supplier",cascade=CascadeType.ALL)
	public List<Supplier_Transaction> transactions;
	
    public static Finder<Long,Supplier> find = new Finder<Long,Supplier>(
       Long.class, Supplier.class
     ); 
	public static List<Supplier> findByID(Long id){
		return find.where().eq("id",id).findList();
	}
}