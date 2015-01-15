package models;
import play.db.ebean.*;
import javax.persistence.*;
import play.data.validation.Constraints;
import java.util.*;
import play.data.format.*;

@Entity
public class User_Action extends Model{
	
	@Id
	public Long id;
	
	@Constraints.Required
	@Basic(optional=false) public String description;
	
	@Constraints.Required
	@Basic(optional=false) public String verb;	
	
	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date createDate = new Date();
	
	public String toString(){
		return String.format("%s",description);
	}
	
    public static Finder<Long,User_Action> find = new Finder<Long,User_Action>(
       Long.class, User_Action.class
     );
}