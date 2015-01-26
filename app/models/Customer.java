package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import play.data.validation.Constraints;
import play.db.ebean.Model;
import java.util.List;

//This class provides Customer relation using ebean ORM
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

	//Create one to many relationship with Customer_Transaction
	@OneToMany(mappedBy="customer")
	public List<Customer_Transaction> transactions;

	public static Finder<Long,Customer> find = new Finder<>(Long.class, Customer.class);

	/*
	Function name: findByID(Long id)
	Input:
		- Long id
	Output:
	    - return Customer instance
	Description:
	    - find Customer instance in database by ID and return it
	 */
	public static Customer findByID(Long id) {
		return find.byId(id);
	}

	/*
	Function name: findByEmail(String email)
	Input:
		- String email
	Output:
	    - return Customer instance
	Description:
	    - find Customer instance in database by email and return it
	 */
	public static Customer findByEmail(String email){
		return find.where().eq("email1",email).findUnique();
	}
}
