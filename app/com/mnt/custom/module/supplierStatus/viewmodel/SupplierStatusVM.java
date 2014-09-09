package com.mnt.custom.module.supplierStatus.viewmodel;

import java.util.List;

import com.mnt.core.ui.annotation.Form;
import com.mnt.core.ui.annotation.UIFields;
import com.mnt.core.ui.annotation.UISelect;
import com.mnt.core.ui.annotation.Validation;
import com.mnt.core.ui.component.FieldType;
import com.mnt.custom.domain.BuilderFactory;
import com.mnt.custom.domain.BuilderFactory.KVMap;

@Form(action="/save-status-info",
		  bindUrl="/supplier-status-as-json")
public class SupplierStatusVM {

	@Validation(required=true)
	@UIFields(cssClass="casute3")
	public String code;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3")
	public String propertyName;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3")
	public String name;
	
	@Validation(required=true)
	@UIFields(type=FieldType.FType.textarea)
	public String address;
	
	@Validation(required=true)
	@UIFields(type=FieldType.FType.select)
	@UISelect(seed="countryMap")
	public String country;
	
	
	@Validation(required=true)
	@UIFields(cssClass="casute3")
	public String city;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3")
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
	@UIFields(cssClass="casute3")
	public String accountingCntctFirstName;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3")
	public String accountingCntctLastName;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3")
	public String accountingCntctTitle;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3")
	public String accountingCntctEmail;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3")
	public String accountingCntctTelCode;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3")
	public String accountingCntctTelNumber;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3")
	public String accountingCntctFaxCode;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3")
	public String accountingCntctFaxNumber;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3")
	public String accountingCntctExt;
	
	@Validation(required=true)
	@UIFields(type=FieldType.FType.select)
	@UISelect(seed="statusMap")
	public String status;
	
	public List<KVMap> countryMap = BuilderFactory.me().getByKey("country");
	public List<KVMap> currencyMap = BuilderFactory.me().getByKey("currencyMap");
	public List<KVMap> ratingMap = BuilderFactory.me().getByKey("ratingMap");
	public List<KVMap> statusMap = BuilderFactory.me().getByKey("statusMap");

}
