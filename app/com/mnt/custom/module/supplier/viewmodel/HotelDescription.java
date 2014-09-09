package com.mnt.custom.module.supplier.viewmodel;

import java.util.List;
import java.util.Set;

import models.suppliers.HotelDescriptionModal;

import com.google.common.base.Splitter;
import com.google.common.collect.Sets;
import com.mnt.core.ui.annotation.Form;
import com.mnt.core.ui.annotation.UIFields;
import com.mnt.core.ui.annotation.UISelect;
import com.mnt.core.ui.component.FieldType;
import com.mnt.custom.domain.BuilderFactory;
import com.mnt.custom.domain.BuilderFactory.KVMap;


@Form(action="/save-supplier-hotel-description",
		  bindUrl="/supplier-hotel-description-as-json")
public class HotelDescription {

	
	@UIFields(cssClass="casute3",type=FieldType.FType.textarea)
	public String profileDescription;
	
	@UIFields(cssClass="casute3",type=FieldType.FType.select)
	@UISelect(seed="locationAreaMap")
	public String locationArea;
	
	@UIFields(cssClass="casute3",type=FieldType.FType.select)
	@UISelect(seed="shoppingFacilityMap")
	public String shoppingFacility;
	
	@UIFields(cssClass="casute3",type=FieldType.FType.select)
	@UISelect(seed="nightLifeMap")
	public String nightLife;
	
	@UIFields(type = FieldType.FType.checkbox)
	@UISelect(seed="hotelDescriptionOptionsMap")
	public List<String> hotelDescriptionOptions;
	
	public String hotelDescriptionOptionWithCommas;
	
	public List<KVMap> locationAreaMap = BuilderFactory.me().getByKey("locationArea");
	public List<KVMap> shoppingFacilityMap = BuilderFactory.me().getByKey("shoppingFacility");
	public List<KVMap> nightLifeMap = BuilderFactory.me().getByKey("nightLife");
	public List<KVMap> hotelDescriptionOptionsMap = BuilderFactory.me().getByKey("hotelDescriptionOptionsMap");
	

}
