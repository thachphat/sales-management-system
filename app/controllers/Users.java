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
        if (boundForm.hasErrors()) {
            Application.flash("error", "Please correct the form below.");
            return Application.badRequest(register.render(boundForm));
        }
        String email = boundForm.get().email;
        String password = boundForm.get().password;
        if (User.authenticate(email, password) == null) {
            Application.flash("error", "Invalid password");
            return Application.badRequest(login.render(loginForm));
        }
        Application.session().clear();
        Application.session("email", email);
        return Application.redirect(routes.Application.home());
    }

    public static Result register() {
        return Application.ok(register.render(loginForm));
    }

    public static Result save() {
        Form<User> boundForm = loginForm.bindFromRequest();
        if (boundForm.hasErrors()) {
            Application.flash("error", "Please correct the form below.");
            return Application.badRequest(register.render(boundForm));
        }
        User user = boundForm.get();
        if (User.findByEmail(user.email) != null) {
            Application.flash("error", "Username already taken.");
            return Application.badRequest(register.render(boundForm));
        }
        Application.flash("success", "Successful registered.");
        user.save();
        return Application.redirect(routes.Application.home());
    }

    public static Result logout(){
        session().clear();
        flash("success","You've been logged out.");
        return redirect(routes.Users.login());
    }
}