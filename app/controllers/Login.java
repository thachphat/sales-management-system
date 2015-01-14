package controllers;

import models.User;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Login extends Controller{
    private final static Form<LoginModel> loginForm = new Form<LoginModel>(LoginModel.class);

    public static Result index() {
        return ok(views.html.login.render(loginForm));
    }

    public static class LoginModel {

        public String username;
        public String password;

        public String validate() {
            if (User.authenticate(username, password) == null) {
                return "Invalid user or password";
            }
            return null;
        }

    }

    public static Result authenticate() {
        Form<LoginModel> form = loginForm.bindFromRequest();

        if (form.hasErrors()) {
            return badRequest(views.html.login.render(form));
        } else {
            session().clear();
            session("username", form.get().username);
            return redirect(routes.Application.home());
        }
    }
}
