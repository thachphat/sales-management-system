package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.avaje.ebean.ExpressionList;
import play.data.validation.Constraints;
import play.db.ebean.Model;

import java.util.List;

@Entity
public class Customer extends Model{
	@Id
	@Column(name="CUSTOMER_ID")
	public Long id;
	
	@Constraints.Required
	public String name;
	@Constraints.Required
	public String address;
	@Constraints.Required
	public String phone1;
	public String phone2;
	@Constraints.Required
	@Column(unique = true)
	public String email1;
	public String email2;
	
	@OneToMany(mappedBy="customer")
	public List<Customer_Transaction> transactions;

	public static Finder<Long,Customer> find = new Finder<>(Long.class, Customer.class);

	public static Customer findByID(Long id) {
		return find.byId(id);
	}
	public static Customer findByEmail(String email){
		return find.where().eq("email1",email).findUnique();
	}
}
