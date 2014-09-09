package com.mnt.custom.module.supplier.viewmodel;

import java.util.List;

import com.google.common.collect.Lists;
import com.mnt.core.ui.annotation.Form;
import com.mnt.core.ui.annotation.UIFields;
import com.mnt.core.ui.annotation.UISelect;
import com.mnt.core.ui.component.FieldType;
import com.mnt.custom.domain.BuilderFactory;
import com.mnt.custom.domain.BuilderFactory.KVMap;


@Form(action="/save-supplier-hotel-business-amenities-info",
		  bindUrl="/supplier-hotel-business-amenities-as-json")
public class HotelBusinessAmenities {

	
	@UIFields(type = FieldType.FType.checkbox)
	@UISelect(seed="hotelBusinessAmenitiesMap")
	public List<String> hotelBusinessAmenities;
	
	public String hotelBusinessAmenitiesWithCommas;
	
	public List<KVMap> hotelBusinessAmenitiesMap = BuilderFactory.me().getByKey("hotelBusinessAmenitiesMap");
}
