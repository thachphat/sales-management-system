package models;


import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

//This class provides User relation using ebean ORM
@Entity
public class User extends Model {

    @Id
    public Long id;
    @Constraints.Required
    public String email;
    @Constraints.Required
    public String password;

    //constructor
    public User() {
    }

    //constructor
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    /*
	Function name: authenticate(String email, String password)
	Input:
		- String email
		- String password
	Output:
	    - return User instance
	Description:
	    - find User instance in database by email and password; and return it
	 */
    public static User authenticate(String email, String password) {
        return finder.where().eq("email",email).eq("password",password).findUnique();
    }

    public static Finder<Long, User> finder = new Finder<>(Long.class, User.class);

    /*
	Function name: findByEmail(String email)
	Input:
		- String email
	Output:
	    - return User instance
	Description:
	    - find User instance in database by email and return it
	 */
    public static User findByEmail(String email){
        return finder.where().eq("email",email).findUnique();
    }
}