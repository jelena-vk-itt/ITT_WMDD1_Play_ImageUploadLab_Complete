package models.users;

import java.util.*;
import javax.persistence.*;

import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;



@Entity
public class User extends Model {
    @Id
    private String email;

    @Constraints.Required
    private String role;

    @Constraints.Required
    private String name;

    @Constraints.Required
    private String password;

    // Default constructor
    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Check if a user is logged in (by id - email address)
    public static User getUserById(String id) {
        if (id == null)
            return null;
        else    
            // Find user by id and return object
            return find.byId(id);
    }

    // Generic query helper for entity User with unique id String
    public static Finder<String, User> find = new Finder<String, User>(User.class);
    
    // Find all Users in the database
    public static List<User> findAll() {
        return User.find.all();
    }

    // Static method to authenticate based on username and password
    // Returns user object if found, otherwise NULL
    public static User authenticate(String email, String password) {
        return find.query().where().eq("email", email).eq("password", password).findUnique();
    }   

}