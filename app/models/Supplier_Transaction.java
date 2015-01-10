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
	
}