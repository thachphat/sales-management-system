package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User extends Model{

    @Id
    public String username;
    public String password;

    public static Finder<String,User> find = new Finder<String, User>(String.class,User.class);

    public static User authenticate(String username, String password) {
        return find.where().eq("username",username).findUnique();
    }
}
