package com.mnt.custom.module.supplier.viewmodel;

import java.util.List;

import com.mnt.core.ui.annotation.Form;
import com.mnt.core.ui.annotation.UIFields;
import com.mnt.core.ui.annotation.UISelect;
import com.mnt.core.ui.annotation.Validation;
import com.mnt.core.ui.component.FieldType;
import com.mnt.custom.domain.BuilderFactory;
import com.mnt.custom.domain.BuilderFactory.KVMap;


@Form(action="/save-supplier-hotel-billing-info",
		  bindUrl="/supplier-hotel-business-billing-as-json")
public class HotelBillingInformation {

	@UIFields(cssClass="casute3" ,htmlAttrib="disabled = disabled")
	public String name;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3" ,htmlAttrib="disabled = disabled")
	public String accountingCntctFirstName;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3" ,htmlAttrib="disabled = disabled")
	public String accountingCntctLastName;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3" ,htmlAttrib="disabled = disabled")
	public String accountingCntctTitle;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3" ,htmlAttrib="disabled = disabled")
	public String accountingCntctEmail;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3" ,htmlAttrib="disabled = disabled")
	public String accountingCntctTelCode;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3" ,htmlAttrib="disabled = disabled")
	public String accountingCntctTelNumber;
	
	@UIFields(cssClass="casute3" ,htmlAttrib="disabled = disabled")
	public String accountingCntctFaxCode;
	
	@UIFields(cssClass="casute3" ,htmlAttrib="disabled = disabled")
	public String accountingCntctFaxNumber;
	
	@UIFields(cssClass="casute3" ,htmlAttrib="disabled = disabled")
	public String accountingCntctExt;
	
	@Validation(required=true)
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoMap")
	public String isInvoicesWillGo ="0";
	
	@Validation(required=true)
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoMap")
	public String isWireService ="0";
	
	public List<KVMap> yesnoMap = BuilderFactory.me().getByKey("yesno");
}
