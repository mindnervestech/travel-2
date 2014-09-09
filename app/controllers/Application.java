package controllers;

import static play.data.Form.form;
import models.suppliers.Supplier;
import models.user.User;

import com.mnt.custom.module.supplier.controllers.Suppliers;

import play.*;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {
  
    public static Result index() {
        return Suppliers.profile();
    }
    
    
    
    public static Result logout() {
        session().clear();
        response().discardCookie("id");
        return redirect(routes.Application.loginUser());
    }
    
    public static Result authenticate()
    {
    	DynamicForm dynamicForm = new DynamicForm().bindFromRequest();
		String userName , password, userType;
		
		userName = dynamicForm.get("username");
		password = dynamicForm.get("password");
		userType = dynamicForm.get("userType");
		
		if(userName == "" || password == "")
		{
			flash("error","Please enter the Details");
        	return badRequest(views.html.login.login.render());
		}
		else
		{
			User user= User.find.where().eq("userName", userName).eq("password", password).findUnique();
			if(user != null)
			{
				if(user.userType.equals("Supplier") && userType.equals("Supplier"))
				{
					if(user.supplierObject.supplierStatus.equals("Approved")){
					session().clear();
			    	response().setCookie("id", user.supplierObject.id.toString());
			    	session("id", user.supplierObject.id.toString());
					return redirect(routes.Application.index());
					}
					else{
						flash("error","Please be Patient You are not yet approved to Login");
			        	return badRequest(views.html.login.login.render());
					}
						
				}
				else if(user.userType.equals("Admin") && userType.equals("Admin"))
				{
					return redirect(routes.Application.showInformation());
				}
				else{
					flash("error","Please Choose Correct Login Type");
		        	return badRequest(views.html.login.login.render());
				}
					
			}
			else{
				flash("error","Please Enter Valid Details");
        	return badRequest(views.html.login.login.render());
			}
		}
    }
    
    public static Result showInformation(){
    	return ok(com.mnt.custom.module.admin.views.html.supplierSearchMain.render());
    }
    
    public static Result loginUser()
    {
    	return ok(views.html.login.login.render());
    }
    
    public static Result testPage(){
    	return ok();
    }
}
