package controllers;

import play.mvc.*;
import play.mvc.Http.*;
import play.mvc.Http.MultipartFormData.FilePart;

import play.api.Environment;
import play.data.*;
import play.db.ebean.Transactional;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import java.io.File;

import org.im4java.core.ConvertCmd;
import org.im4java.core.IMOperation;

import views.html.*;
import models.*;
import models.users.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    // Declare a private FormFactory instance
    private FormFactory formFactory;
    
    private Environment e;

    // Inject an instance of FormFactory into the controller via its constructor
    @Inject
    public HomeController(FormFactory f, Environment env) {
        this.e = env;
        this.formFactory = f;
    }

    public Result index(Long cat) {
        
        // Declare the product list
        List<Product> productList = null;

        // Get the list of all categories in ascending order
        List<Category> categoryList = Category.findAll();

        if (cat == 0) {
            // Get list of all products
            productList = Product.findAll();
        } else {
            // Get products for selected category: find category first,
            // then extract products for that category
            productList = Category.find.ref(cat).getProducts();
        }
        
        return ok(index.render(productList, categoryList, User.getUserById(session().get("email")), e));
    }

    @Security.Authenticated(Secured.class)
    @With(AuthAdmin.class)
    public Result addProduct() {

        Form<Product> productForm = formFactory.form(Product.class);

        return ok(addProduct.render(productForm, User.getUserById(session().get("email"))));        
    }


    public Result addProductSubmit() {

        // Retrieve the submitted form object (bind from the HTTP request)
        Form<Product> newProductForm = formFactory.form(Product.class).bindFromRequest();

        // Check for errors (based on constraints set in the Product class)
        if (newProductForm.hasErrors()) {
            // Display the form again by returning a bad request
            return badRequest(addProduct.render(newProductForm, User.getUserById(session().get("email"))));
        } else {
            // No errors found - extract the product detail from the form
            Product p = newProductForm.get();
            
            // A new, unsaved, product will not have an id
            if (p.getId() == null) {
                // Save the object to the Products table in the database
                p.save();
                // Set a success message in flash (for display in return view)
                flash("success", "Product " + p.getName() + " was added");
            } else if (p.getId() != null) {
                // Product exists
                p.update();
                // Set a success message in flash (for display in return view)
                flash("success", "Product " + p.getName() + " was updated");
            }

            MultipartFormData data = request().body().asMultipartFormData();
            FilePart<File> image = data.getFile("upload");

            String saveImageMsg = saveFile(p.getId(), image);

            flash("success", "Product " + p.getName() + " has been created/updated " + saveImageMsg);
            
            // Redirect to the index page
            return redirect(controllers.routes.HomeController.index(0));
        }
    }
  
    @Security.Authenticated(Secured.class)
    @Transactional
    public Result deleteProduct(Long id) {
        
        // find product by id and call delete method
        Product.find.ref(id).delete();

        // Add message to flash session
        flash("success", "Product has been deleted");

        // Redirect to index page
        return redirect(routes.HomeController.index(0));
    }

    @Security.Authenticated(Secured.class)
    @With(AuthAdmin.class)
    @Transactional
    public Result updateProduct(Long id) {

        Product p;
        Form<Product> productForm;

        try {
            // Find the product by id
            p = Product.find.byId(id);

            // Create a form based on the Product class and fill using p
            productForm = formFactory.form(Product.class).fill(p);

        } catch (Exception ex) {
            // Display an error message or page
            return badRequest("error");
        }

        // Render the updateProduct view - pass form as parameter
        return ok(addProduct.render(productForm, User.getUserById(session().get("email"))));
    }


    public String saveFile(Long id, FilePart<File> uploaded) {
        // make sure that the file exists
        if (uploaded != null) {
            // make sure that the content is indeed an image
            String mimeType = uploaded.getContentType(); 
            if (mimeType.startsWith("image/")) {
                // get the file name
                String fileName = uploaded.getFilename();                
                // save the file object (created without a path, File saves
                // the content to a default location, usually the temp or tmp
                // directory)
                File file = uploaded.getFile();
                // create an ImageMagik operation - this object is used to specify
                // the required image processing
                IMOperation op = new IMOperation();
                // add the uploaded image to the operationop.addImage(file.getAbsolutePath());
                op.addImage(file.getAbsolutePath());
                // resize the image using height and width saveFileOld(Long id, FilePart<File> uploaded) {
        // make su
                op.resize(300, 200);
                // save the image as jpg 
                op.addImage("public/images/productImages/" + id + ".jpg");
                // create another Image Magick operation and repeat the process above to
                // specify how a thumbnail image should be processed - size 60px
                IMOperation thumb = new IMOperation();
                thumb.addImage(file.getAbsolutePath());
                thumb.resize(60);
                thumb.addImage("public/images/productImages/thumbnails/" + id + ".jpg");
                // we must make sure that the directories exist before running the operations
                File dir = new File("public/images/productImages/thumbnails/");
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                // now we create an Image Magick command and execute the operations
                ConvertCmd cmd = new ConvertCmd();
                try {
                    cmd.run(op);
                    cmd.run(thumb);
                } catch(Exception e) {
                    e.printStackTrace();
                }
                return " and image saved";
            }
        }
        return "/ no file";
    }


    public String saveFileOld(Long id, FilePart<File> uploaded) {
        // make sure that the file exists
        String mimeType = uploaded.getContentType(); 
        if (uploaded != null) {
            // make sure that the content is indeed an image
            if (mimeType.startsWith("image/")) {
                // get the file name
                String fileName = uploaded.getFilename();      
                String extension = "";
                int i = fileName.lastIndexOf('.');
                if (i >= 0) {
                    extension = fileName.substring(i+1);
                }
                // save the file object (created without a path, File saves
                // the content to a default location, usually the temp or tmp
                // directory)
                File file = uploaded.getFile();
                // we must make sure that the directory for the images exists before we save it
                File dir = new File("public/images/productImages");
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                // move the file to the required location (in a real application 
                // the path to where images are stored would be configurable, but 
                // for the lab we just hard-code it)
                if(file.renameTo(new File("public/images/productImages/", id + "." + extension))) {
                    return "/ file uploaded";
                } else {
                    return "/ file upload failed";
                }
            }
        }
        return "/ no file";
    }
}

