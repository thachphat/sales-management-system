package models;
import play.db.ebean.*;
import javax.persistence.*;
import play.data.validation.Constraints;
import java.util.*;
import play.data.format.*;

//This class provides User_Action relation using ebean ORM
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

	/*
	Function name: toString()
	Input: None
	Output:
	    - return description in String format
	Description:
		- return description in String format
	 */
	public String toString(){
		return String.format("%s",description);
	}

    public static Finder<Long,User_Action> find = new Finder<>(
       Long.class, User_Action.class
     );
}