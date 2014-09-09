package com.mnt.custom.module.supplierStatus.controllers;

import static play.data.Form.form;

import java.lang.reflect.InvocationTargetException;

import models.SupplierCode;
import models.suppliers.Supplier;

import org.apache.commons.beanutils.BeanUtilsBean;

import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import com.mnt.core.helper.UIGeneratorHelper;
import com.mnt.custom.module.admin.controllers.routes;
import com.mnt.custom.module.supplierStatus.viewmodel.SupplierStatusVM;

public class SupplierStatus extends Controller{
	

	public static Result status(){
		return ok();
	}
	
	public static Result statusIndex()
	{
		DynamicForm dynamicForm = new DynamicForm().bindFromRequest();
		session().clear();
    	response().setCookie("id", dynamicForm.get("id"));
    	session("id", dynamicForm.get("id"));
		return ok(com.mnt.custom.module.supplierStatus.views.html.status.render());
	}
	// Supplier Status Function Starts
	public static Result getSupplierStatusInformationPage(){
		
		UIGeneratorHelper helper = new UIGeneratorHelper(SupplierStatusVM.class);
		return ok(com.mnt.custom.module.supplierStatus.views.html.supplierStatusDetails.render(helper));
	}
	
	public static Result generateSupplierStatusInfoScript(){
	
		UIGeneratorHelper helper = new UIGeneratorHelper(SupplierStatusVM.class);
		return ok(views.html.script.render(helper)).as("application/javascript");
	}
	
	public static Result getSupplierStatusJson() throws IllegalAccessException, InvocationTargetException{
		SupplierStatusVM supplierStatusVM = new SupplierStatusVM();
		String supplierIdFromSession = session().get("id");
		Supplier supplierObject = Supplier.find.byId(Long.valueOf(supplierIdFromSession));
		if(supplierObject != null)
		{
		BeanUtilsBean.getInstance().copyProperties(supplierStatusVM, supplierObject.generalInformation);
		BeanUtilsBean.getInstance().copyProperties(supplierStatusVM, supplierObject.billingInformationModel);
		supplierStatusVM.status = supplierObject.supplierStatus;
		}
		return ok(play.libs.Json.toJson(supplierStatusVM)).as("JSON");
	}
	
	public static Result saveSupplierStatusInfo() throws IllegalAccessException, InvocationTargetException{
		Form<SupplierStatusVM> supplierStatusVMForm = form(SupplierStatusVM.class).bindFromRequest();
		String supplierIdFromSession = session().get("id");
		Supplier supplierObject = Supplier.find.byId(Long.valueOf(supplierIdFromSession));
		BeanUtilsBean.getInstance().copyProperties(supplierObject.generalInformation, supplierStatusVMForm.get());
		BeanUtilsBean.getInstance().copyProperties(supplierObject.billingInformationModel, supplierStatusVMForm.get());
		supplierObject.supplierStatus = supplierStatusVMForm.get().status;
		supplierObject.update();
		return ok("/supplierIndex");
		
	}
	
	// Supplier Status Function Starts
}
