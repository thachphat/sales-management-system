package models;


import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User extends Model {

    @Id
    public Long id;
    @Constraints.Required
    public String email;
    @Constraints.Required
    public String password;

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static User authenticate(String email,String password) {
        return finder.where().eq("email",email).eq("password",password).findUnique();
    }

    public static Finder<Long, User> finder = new Finder<>(Long.class, User.class);

    public static User findByEmail(String email){
        return finder.where().eq("email",email).findUnique();
    }
}