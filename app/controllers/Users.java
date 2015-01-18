package controllers;

import models.User;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.users.login;
import views.html.users.register;

public class Users extends Controller{
    static final Form<User> loginForm = Form.form(User.class).bindFromRequest();

    public static Result login() {
        return ok(login.render(Users.loginForm));
    }

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

    public static Result register() {
        return ok(register.render(loginForm));
    }

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
        return redirect(routes.Application.home());
    }

    public static Result logout(){
        session().clear();
        flash("success","You've been logged out.");
        return redirect(routes.Users.login());
    }
}