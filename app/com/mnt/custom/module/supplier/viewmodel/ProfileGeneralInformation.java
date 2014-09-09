package com.mnt.custom.module.supplier.viewmodel;

import java.util.List;

import models.Country;

import com.google.common.collect.Lists;
import com.mnt.core.ui.annotation.Form;
import com.mnt.core.ui.annotation.UIFields;
import com.mnt.core.ui.annotation.UISelect;
import com.mnt.core.ui.annotation.UIVisibility;
import com.mnt.core.ui.annotation.Validation;
import com.mnt.core.ui.component.FieldType;
import com.mnt.custom.domain.BuilderFactory;
import com.mnt.custom.domain.BuilderFactory.KVMap;

@Form(action="/save-supplier-general-information",
	  bindUrl="/supplier-general-information-as-json")
public class ProfileGeneralInformation {
	
	@Validation(unique=true, required=true)
	@UIFields(cssClass="casute3" ,htmlAttrib="disabled = disabled")
	public String code;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3" ,htmlAttrib="disabled = disabled")
	public String propertyName;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3" ,htmlAttrib="disabled = disabled")
	public String name;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3",type=FieldType.FType.textarea ,htmlAttrib="disabled = disabled")
	public String address;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3",type=FieldType.FType.select ,htmlAttrib="disabled = disabled")
	@UISelect(seed="countryMap")
	public String country;
	
	
	@Validation(required=true)
	@UIFields(cssClass="casute3",type=FieldType.FType.select)
	@UISelect(remote=true,depends={"country"},params={"country"},dataSourceURL="/get-province",seed="provinceMap")
	public String province;
	public List<KVMap> provinceMap;
	
	@Validation(required=true)
	@UIFields(htmlAttrib="disabled = disabled")
	public String city;
	@UIFields(htmlAttrib="disabled = disabled")
	public String pin;
	
	
	@UIFields(cssClass="casute3",type=FieldType.FType.select ,htmlAttrib="disabled = disabled")
	@UISelect(seed="ratingMap")
	public String rating;
	
	@Validation(required=true)
	@UIFields(htmlAttrib="disabled = disabled")
	public String password;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="marketRatePolicyMap")
	public String marketRatePolicy;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoMap")
	public String isChain ="0";
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoMap")
	public String isHealthComplaint = "0";
	
	@UISelect(seed="affiliatedChainMap")
	@UIFields(cssClass="casute3",type=FieldType.FType.select)
	public String affiliatedChain;
	
	@UIFields(cssClass="casute3",type=FieldType.FType.select ,htmlAttrib="disabled = disabled")
	@UISelect(seed="currencyMap")
	public String currency;
	
	public List<KVMap> yesnoMap = BuilderFactory.me().getByKey("yesno");
	public List<KVMap> marketRatePolicyMap = BuilderFactory.me().getByKey("marketRatePolicyMap");
	public List<KVMap> affiliatedChainMap = BuilderFactory.me().getByKey("affiliatedChain");
	public List<KVMap> countryMap = BuilderFactory.me().getByKey("country");
	public List<KVMap> currencyMap = BuilderFactory.me().getByKey("currencyMap");
	public List<KVMap> ratingMap = BuilderFactory.me().getByKey("ratingMap");
	
	
	@UIVisibility(agents={"isChain()==1"})
	@UIFields(type = FieldType.FType.control)
	public String group1;
	
	
}
