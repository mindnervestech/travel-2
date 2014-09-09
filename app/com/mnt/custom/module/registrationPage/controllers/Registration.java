package com.mnt.custom.module.registrationPage.controllers;

import static play.data.Form.form;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtilsBean;

import models.SupplierCode;
import models.suppliers.HotelBillingInformationModel;
import models.suppliers.ProfieGeneralInformationModel;
import models.suppliers.Supplier;
import models.user.User;
import play.core.Router.Routes;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import com.mnt.core.helper.UIGeneratorHelper;
import com.mnt.custom.module.registrationPage.viewmodel.RegistrationPageVM;
import com.mnt.custom.module.supplier.viewmodel.HotelBillingInformation;
import com.mnt.custom.module.supplier.viewmodel.HotelBusinessAmenities;
import com.mnt.custom.module.supplier.viewmodel.ProfileGeneralInformation;

public class Registration extends Controller {
	
	public static Result register(){
		return ok(com.mnt.custom.module.registrationPage.views.html.register.render());
	}

	// Registration Section Starts 
	public static Result getRegisterInformationPage(){
		
		UIGeneratorHelper helper = new UIGeneratorHelper(RegistrationPageVM.class);
		return ok(com.mnt.custom.module.registrationPage.views.html.registrationPage.render(helper));
	}
	
	public static Result generateRegisterInfoScript(){
	
		UIGeneratorHelper helper = new UIGeneratorHelper(RegistrationPageVM.class);
		return ok(views.html.script.render(helper)).as("application/javascript");
	}
	
	public static Result getRegisterJson(){
		RegistrationPageVM registrationPageVM = new RegistrationPageVM();
		return ok(play.libs.Json.toJson(registrationPageVM)).as("JSON");
	}
	
	public static Result saveSupplierRegisterInfo() throws IllegalAccessException, InvocationTargetException{
		Form<HotelBillingInformation> hotelBillingInformationVMForm = form(HotelBillingInformation.class).bindFromRequest();
		Form<ProfileGeneralInformation> profileGeneralInformationVMForm = form(ProfileGeneralInformation.class).bindFromRequest();
		DynamicForm dynamicForm = new DynamicForm().bindFromRequest();
		SupplierCode supplierCode = SupplierCode.find.byId(1L);
		Supplier supplierObject = new Supplier();
		
		ProfieGeneralInformationModel generalInformationViewModel = new ProfieGeneralInformationModel();
		HotelBillingInformationModel hotelBillingInformationModel = new HotelBillingInformationModel();
		BeanUtilsBean.getInstance().copyProperties(generalInformationViewModel, profileGeneralInformationVMForm.get());
		BeanUtilsBean.getInstance().copyProperties(hotelBillingInformationModel, hotelBillingInformationVMForm.get());
		
		if(supplierCode.code != null)
		{
			supplierCode.code +=1L;	
			generalInformationViewModel.code = supplierCode.code.toString();
			supplierObject.code = supplierCode.code.toString();
			supplierCode.update();
		}
		else
		{
			supplierCode.code = 1000L;
			supplierCode.code +=1L;
			supplierObject.code = supplierCode.code.toString();
			generalInformationViewModel.code = supplierCode.code.toString();
			supplierCode.save();
		
		}
		
		User user = new User();
		
		supplierObject.supplierStatus = "Pending";
		supplierObject.generalInformation = generalInformationViewModel;
		supplierObject.billingInformationModel = hotelBillingInformationModel;
		supplierObject.save();
		user.supplierObject = supplierObject;
		user.userName = dynamicForm.get("userName");
		user.password = dynamicForm.get("password");
		user.userType = "Supplier";
		user.code = supplierObject.code;
		user.save();
		
		hotelBillingInformationModel.supplierObject = supplierObject;
		generalInformationViewModel.supplierObject = supplierObject;
		
		hotelBillingInformationModel.save();
		generalInformationViewModel.save();
		
		return ok("/loginUser");
	}
	

	// Registration Section Ends
	
}
