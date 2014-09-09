package com.mnt.custom.module.registrationPage.viewmodel;

import java.util.List;

import com.mnt.core.ui.annotation.Form;
import com.mnt.core.ui.annotation.UIFields;
import com.mnt.core.ui.annotation.UISelect;
import com.mnt.core.ui.annotation.Validation;
import com.mnt.core.ui.component.FieldType;
import com.mnt.custom.domain.BuilderFactory;
import com.mnt.custom.domain.BuilderFactory.KVMap;

@Form(action="/save-register-info",
		  bindUrl="/supplier-register-as-json")
public class RegistrationPageVM {

	@Validation(required=true)
	@UIFields(cssClass="casute3" , htmlAttrib="placeholder=Property Name")
	public String propertyName;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3" , htmlAttrib="placeholder=Supplier Name")
	public String name;
	
	@Validation(required=true)
	@UIFields(type=FieldType.FType.textarea , htmlAttrib="placeholder=Address")
	public String address;
	
	@Validation(required=true)
	@UIFields(type=FieldType.FType.select)
	@UISelect(seed="countryMap")
	public String country;
	
	@Validation(required=true ,email= true)
	@UIFields(htmlAttrib="placeholder=User Name")
	public String userName;
	
	@Validation(required=true, minlength= 6)
	@UIFields(htmlAttrib="placeholder=Password",type= FieldType.FType.password)
	public String password;
	
	@Validation(required=true)
	@UIFields(htmlAttrib="placeholder=Confirm Password", type= FieldType.FType.password)
	public String cpassword;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3" , htmlAttrib="placeholder=City")
	public String city;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3" , htmlAttrib="placeholder=Pin")
	public String pin;
	
	@Validation(required=true)
	@UIFields(type=FieldType.FType.select)
	@UISelect(seed="currencyMap")
	public String currency;
	
	@Validation(required=true)
	@UIFields(type=FieldType.FType.select)
	@UISelect(seed="ratingMap")
	public String rating;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3" , htmlAttrib="placeholder=First Name")
	public String accountingCntctFirstName;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3" , htmlAttrib="placeholder=Last Name")
	public String accountingCntctLastName;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3" , htmlAttrib="placeholder=Designation")
	public String accountingCntctTitle;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3" , htmlAttrib="placeholder=E-Mail ID")
	public String accountingCntctEmail;
	
	@Validation(required=true)
	@UIFields(htmlAttrib="placeholder=Code")
	public String accountingCntctTelCode;
	
	@Validation(required=true)
	@UIFields(htmlAttrib="placeholder=Number")
	public String accountingCntctTelNumber;
	
	@Validation(required=true)
	@UIFields(htmlAttrib="placeholder=Code")
	public String accountingCntctFaxCode;
	
	@Validation(required=true)
	@UIFields(htmlAttrib="placeholder=Number")
	public String accountingCntctFaxNumber;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3" , htmlAttrib="placeholder=Extension")
	public String accountingCntctExt;
	
	public List<KVMap> countryMap = BuilderFactory.me().getByKey("country");
	public List<KVMap> currencyMap = BuilderFactory.me().getByKey("currencyMap");
	public List<KVMap> ratingMap = BuilderFactory.me().getByKey("ratingMap");
	
	
}
