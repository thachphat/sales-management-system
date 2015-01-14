package models;
import play.db.ebean.*;
import javax.persistence.*;
import play.data.validation.Constraints;
import java.util.*;

@Entity
public class Supplier extends Model{
	
	@Id
    @Column(name = "SUPPLIER_ID")
	public Long id;
	
	@Constraints.Required
	@Basic(optional=false) @Column(unique=true) public Long name;
	
	@OneToMany(mappedBy="supplier",cascade=CascadeType.ALL)
	public List<Supplier_Transaction> transactions;
	
	public String toString(){
		return String.format("%s",name);
	}
	
    public static Finder<Long,Supplier> find = new Finder<Long,Supplier>(
       Long.class, Supplier.class
     ); 
	public static List<Supplier> findByID(Long id){
		return find.where().eq("id",id).findList();
	}
}