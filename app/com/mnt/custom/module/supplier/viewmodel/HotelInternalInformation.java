package com.mnt.custom.module.supplier.viewmodel;

import java.util.List;

import com.mnt.core.ui.annotation.Form;
import com.mnt.core.ui.annotation.UIFields;
import com.mnt.core.ui.annotation.UISelect;
import com.mnt.core.ui.annotation.Validation;
import com.mnt.core.ui.component.FieldType;
import com.mnt.custom.domain.BuilderFactory;
import com.mnt.custom.domain.BuilderFactory.KVMap;


@Form(action="/save-supplier-hotel-internal-info",
		  bindUrl="/supplier-hotel-internal-info-as-json")
public class HotelInternalInformation {

	
	@UIFields(cssClass="casute3")
	public String builtYear;
	
	@UIFields(cssClass="casute3")
	public String lastRenovateYear;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3")
	public String noOfFloors;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3")
	public String noOfRooms;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3")
	public String guestTelCityCode;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3")
	public String guestTelCityNumber;
	
	@UIFields(cssClass="casute3")
	public String guestFaxCityCode;
	
	@UIFields(cssClass="casute3")
	public String guestFaxCityNumber;
	
	@UIFields(cssClass="casute3")
	public String hotelWebsite;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3")
	public String hotelEmail;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3")
	public String directTelCityCode;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3")
	public String directTelCityNumber;
	
	@UIFields(cssClass="casute3")
	public String directFaxCityCode;
	
	@UIFields(cssClass="casute3")
	public String directFaxCityNumber;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3")
	public String generalManagerName;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3")
	public String generalManagerEmail;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoMap")
	public String isSafetyComplaint;
	
	public List<KVMap> yesnoMap = BuilderFactory.me().getByKey("yesno");
	
}
