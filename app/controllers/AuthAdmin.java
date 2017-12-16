package controllers;

import play.mvc.*;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.CompletableFuture;

import models.users.*;


// Check if this is an admin user (before permitting an action)
public class AuthAdmin extends Action.Simple {
    
    // The following method is executed concurrently
    // CompletionStage<Result> represents a handle for the result
    // when it is avaliable.
    // Http.Context contains the current request.
    public CompletionStage<Result> call(Http.Context ctx) {

        // Check if current user (in session) is an admin
        String id = ctx.session().get("email");
        if (id != null) {
            User u = User.getUserById(id);
            if ("admin".equals(u.getRole())) {
                 // User is an administrator so continue with the http request
                 return delegate.call(ctx);
            }
        }
        ctx.flash().put("success", "Administrator login required.");
        return CompletableFuture.completedFuture(redirect(routes.LoginController.login()));
    }
}