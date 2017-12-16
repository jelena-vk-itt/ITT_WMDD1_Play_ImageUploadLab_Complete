package controllers;

import play.api.Environment;
import play.mvc.*;
import play.data.*;
import play.db.ebean.Transactional;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import views.html.*;

import models.users.*;

public class LoginController extends Controller {

    // Dependency Injection
    private FormFactory formFactory;

    private Environment env;

    @Inject
    public LoginController(Environment e, FormFactory f) {
        this.env = e;
        this.formFactory = f;
    }

    // Render and return the Login view
    public Result login() {
        // Create a form by wrapping the Product class
        // in a FormFactory form instance
        Form<Login> loginForm = formFactory.form(Login.class);

        // Render the Add Product View, passing the form object
        return ok(login.render(loginForm, User.getUserById(session().get("email"))));
    }

    // Handle login submit
    public Result loginSubmit() {
        // Bind form instance to the values submitted from the form
        Form<Login> loginForm = formFactory.form(Login.class).bindFromRequest();

        // Check for errors
        // Uses the validate method defined in the Login class
        if (loginForm.hasErrors()) {
            return badRequest(login.render(loginForm, User.getUserById(session().get("email"))));
        } else {
            // User logged in successfully
            // Clear the existing session - resets session id
            session().clear();
            // Store the logged in email in the session (cookie)
            session("email", loginForm.get().getEmail());
        }
        // Return to home page
        return redirect(controllers.routes.HomeController.index(0));
    }


    // Logout
    public Result logout() {
        // Delete the current session
        // Generates a new session id
        session().clear();
        flash("success", "You've been logged out");
        return redirect(routes.LoginController.login());
    }
}