package com.mnt.custom.module.supplier.viewmodel;

import java.util.List;

import com.mnt.core.ui.annotation.Form;
import com.mnt.core.ui.annotation.UIFields;
import com.mnt.core.ui.annotation.UISelect;
import com.mnt.core.ui.annotation.UIVisibility;
import com.mnt.core.ui.annotation.Validation;
import com.mnt.core.ui.component.FieldType;
import com.mnt.custom.domain.BuilderFactory;
import com.mnt.custom.domain.BuilderFactory.KVMap;

@Form(action="/save-supplier-hotel-contact-info",
		  bindUrl="/supplier-hotel-contact-info-as-json")
public class HotelContactInformation {

	@UIFields(cssClass="casute3")
	public String mainContactName;
	
	@UIFields(cssClass="casute3")
	public String title;
	
	@UIFields(cssClass="casute3")
	public String directTelCode;
	
	@UIFields(cssClass="casute3")
	public String directTelNumber;
	
	@UIFields(cssClass="casute3")
	public String directFaxCode;
	
	@UIFields(cssClass="casute3")
	public String directFaxNumber;
	
	@UIFields(cssClass="casute3")
	public String extension;
	
	@UIFields(cssClass="casute3")
	public String directEmail;
	
	@UIFields(cssClass="casute3")
	public String tollFreeCode;
	
	@UIFields(cssClass="casute3")
	public String tollFreeNumber;
	
	@UIFields(cssClass="casute3",databind=FieldType.makeMeEnableWhen + "isSameAddress() == 0")
	public String reservationContactName;
	
	@UIFields(cssClass="casute3",databind=FieldType.makeMeEnableWhen + "isSameAddress() == 0")
	public String reservationtitle;
	
	@UIFields(cssClass="casute3",databind=FieldType.makeMeEnableWhen + "isSameAddress() == 0")
	public String reservationDirectTelCode;
	
	@UIFields(cssClass="casute3",databind=FieldType.makeMeEnableWhen + "isSameAddress() == 0")
	public String reservationDirectTelNumber;
	
	@UIFields(cssClass="casute3",databind=FieldType.makeMeEnableWhen + "isSameAddress() == 0")
	public String reservationDirectEmail;
	
	@UIFields(cssClass="casute3",databind=FieldType.makeMeEnableWhen + "isSameAddress() == 0")
	public String reservationExtension;
	
	@UIFields(cssClass="casute3",databind=FieldType.makeMeEnableWhen + "isSameAddress() == 0")
	public String reservationDeptDirectTelCode;
	
	@UIFields(cssClass="casute3",databind=FieldType.makeMeEnableWhen + "isSameAddress() == 0")
	public String reservationDeptDirectTelNumber;
	
	@UIFields(cssClass="casute3",databind=FieldType.makeMeEnableWhen + "isSameAddress() == 0")
	public String reservationDeptFaxCode;
	
	@UIFields(cssClass="casute3",databind=FieldType.makeMeEnableWhen + "isSameAddress() == 0")
	public String reservationDeptFaxNumber;
	
	@UIFields(cssClass="casute3" ,databind=FieldType.makeMeEnableWhen + "isSameAddress() == 0")
	public String reservationDeptExtension;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3",type=FieldType.FType.select)
	@UISelect(seed="salutationMap")
	public String salutation;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoMap")
	public String isSameAddress ="1";
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoMap")
	public String faxRecieve ="0";
	
	public List<KVMap> yesnoMap = BuilderFactory.me().getByKey("yesno");
	public List<KVMap> salutationMap = BuilderFactory.me().getByKey("salutation");
	
//	@UIVisibility(control="disable",actors={"reservationDeptExtension","reservationDeptDirectTelNumber",
//			"reservationDeptFaxNumber","reservationDeptFaxCode",
//			"reservationDirectTelCode","reservationExtension",
//			"reservationDirectEmail","reservationDirectTelNumber",
//			"reservationDeptDirectTelCode","reservationtitle",
//			"reservationContactName"},agents={"isSameAddress:==1"})
//	public String addressDiv;
	
}
