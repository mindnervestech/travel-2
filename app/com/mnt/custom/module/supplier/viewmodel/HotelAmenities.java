package com.mnt.custom.module.supplier.viewmodel;

import java.util.List;

import com.google.common.collect.Lists;
import com.mnt.core.ui.annotation.Form;
import com.mnt.core.ui.annotation.UIFields;
import com.mnt.core.ui.annotation.UISelect;
import com.mnt.core.ui.component.FieldType;
import com.mnt.custom.domain.BuilderFactory;
import com.mnt.custom.domain.BuilderFactory.KVMap;

@Form(action="/save-supplier-hotel-amenities-info",
		  bindUrl="/supplier-hotel-amenities-as-json")
public class HotelAmenities {

	
	@UIFields(type = FieldType.FType.checkbox)
	@UISelect(seed="hotelAmenitiesMap")
	public List<String> hotelAmenities;
	
	public String hotelAmenitiesWithCommas;
	
	public List<KVMap> hotelAmenitiesMap = BuilderFactory.me().getByKey("hotelAmenitiesMap");
}
