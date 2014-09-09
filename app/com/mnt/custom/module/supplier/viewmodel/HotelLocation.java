package com.mnt.custom.module.supplier.viewmodel;

import com.mnt.core.ui.annotation.Form;
import com.mnt.core.ui.annotation.UIFields;
import com.mnt.core.ui.annotation.Validation;


@Form(action="/save-supplier-hotel-location",
		  bindUrl="/supplier-hotel-location-as-json")
public class HotelLocation {
	
	@Validation(required=true)
	@UIFields(cssClass="casute3")
	public String hotelLocation1;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3")
	public String hotelLocation2;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3")
	public String hotelLocation3;

}
