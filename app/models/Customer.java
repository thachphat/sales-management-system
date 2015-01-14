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
	public String email1;
	public String email2;
	
	@OneToMany(mappedBy="customer")
	public List<Customer_Transaction> transactions;

	public static Finder<Long,Customer> find = new Finder<Long, Customer>(Long.class, Customer.class);

	public static Customer findByID(Long id) {
		return find.where().eq("id",id).findUnique();
	}
}
