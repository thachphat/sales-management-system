package models;

import java.sql.Date;

import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.db.ebean.Model;

@Entity
public class Customer_Transaction extends Model{
	@Id
	public Long internalId;
	
	@Constraints.Required
	public Date sellDate;
	public int price;
	public boolean isPaid;
	public int quantity;
	
	@ManyToOne
	public Customer customer;

	@ManyToOne
	public Product product;

	public static Finder<Long,Customer_Transaction> find = new Finder<Long, Customer_Transaction>(Long.class, Customer_Transaction.class);

	public static Customer_Transaction findByID(Long id){
		return find.where().eq("id",id).findUnique();
	}
}
