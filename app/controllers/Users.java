package controllers;

import models.User;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.users.login;
import views.html.users.register;

//This class provides respond function for web interaction with User relation in the database
public class Users extends Controller{
    static final Form<User> loginForm = Form.form(User.class).bindFromRequest();

    /*
	Function name: login()
	Input: None
	Output:
	    - return login form page
	Description:
	    - return login form page
	 */
    public static Result login() {
        return ok(login.render(Users.loginForm));
    }

    /*
	Function name: authenticate()
	Input: None
	Output:
	    - return homepage
	Description:
	    - gather data from login form
	    - authenticate with server
	    - if success, return homepage
	    - else, return bad request
	 */
    public static Result authenticate() {
        Form<User> boundForm = loginForm.bindFromRequest();

        if(boundForm.apply("email").value().equals("")){
            flash("error","Please enter username/email.");
            return badRequest(login.render(loginForm));
        }
        if(boundForm.apply("password").value().equals("")){
            flash("error","Please enter password.");
            return badRequest(login.render(boundForm));
        }
        String email = boundForm.get().email;
        String password = boundForm.get().password;
        if (User.findByEmail(email) == null) {
            flash("error", "Invalid username/email.");
            return badRequest(login.render(loginForm));
        }
        if (User.authenticate(email, password) == null) {
            flash("error", "Invalid password.");
            return badRequest(login.render(boundForm));
        }
        session().clear();
        session("email", email);
        flash("success","Log in successfully.");
        return redirect(routes.Application.home());
    }

    /*
	Function name: register()
	Input: None
	Output:
	    - return register form page
	Description:
	    - return register form page
	 */
    public static Result register() {
        return ok(register.render(loginForm));
    }

    /*
	Function name: save()
	Input: None
	Output:
	    - return login page
	Description:
	    - gather data from register form
	    - save new user to database if username/email has not been taken.
	    - return login page
	 */
    public static Result save() {
        Form<User> boundForm = loginForm.bindFromRequest();
        if(boundForm.apply("email").value().equals("")){
            flash("error","Please enter username/email.");
            return badRequest(register.render(loginForm));
        }
        if(boundForm.apply("password").value().equals("")){
            flash("error","Please enter password.");
            return badRequest(register.render(boundForm));
        }
        User user = boundForm.get();
        if (User.findByEmail(user.email) != null) {
            flash("error", "Username already taken.");
            return badRequest(register.render(loginForm));
        }
        flash("success", "Successful registered.");
        user.save();
        return redirect(routes.Users.login());
    }

    /*
	Function name: logout()
	Input: None
	Output:
	    - return login page
	Description:
	    - clear login session
	    - return login page
	 */
    public static Result logout(){
        session().clear();
        flash("success","You've been logged out.");
        return redirect(routes.Users.login());
    }
}