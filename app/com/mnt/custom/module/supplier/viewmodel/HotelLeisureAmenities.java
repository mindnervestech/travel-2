package com.mnt.custom.module.supplier.viewmodel;

import java.util.List;

import com.google.common.collect.Lists;
import com.mnt.core.ui.annotation.Form;
import com.mnt.core.ui.annotation.UIFields;
import com.mnt.core.ui.annotation.UISelect;
import com.mnt.core.ui.component.FieldType;
import com.mnt.custom.domain.BuilderFactory;
import com.mnt.custom.domain.BuilderFactory.KVMap;


@Form(action="/save-supplier-hotel-leisure-amenities-info",
		  bindUrl="/supplier-hotel-leisure-amenities-as-json")
public class HotelLeisureAmenities {

	
	@UIFields(type = FieldType.FType.checkbox)
	@UISelect(seed="hotelLeisureAmenitiesMap")
	public List<String> hotelLeisureAmenities;
	
	public String hotelLeisureAmenitiesWithCommas;
	
	
	public List<KVMap> hotelLeisureAmenitiesMap = BuilderFactory.me().getByKey("hotelLeisureAmenitiesMap");
}
