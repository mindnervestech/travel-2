package com.mnt.custom.module.viewWebPage.viewmodel;

import java.util.List;

import com.mnt.core.ui.annotation.Form;
import com.mnt.core.ui.annotation.UIFields;
import com.mnt.core.ui.component.FieldType;


@Form(action="/save-supplier-viewPage-info",
		  bindUrl="/supplier-viewPage-as-json")
public class ViewPageVM {
	
	@UIFields(type= FieldType.FType.label)
	public String propertyName;
	
	@UIFields(type= FieldType.FType.label)
	public String address;
	
	@UIFields(type= FieldType.FType.label)
	public String profileDescription;
	
	@UIFields(type= FieldType.FType.label)
	public String locationArea;
	
	@UIFields(type= FieldType.FType.label)
	public String shoppingFacility;
	
	@UIFields(type= FieldType.FType.label)
	public String nightLife;
	
	@UIFields(type= FieldType.FType.repeatlabel)
	public List<String> hotelAmenities;
	
	@UIFields(type= FieldType.FType.repeatlabel)
	public List<String> hotelLeisureAmenities;
	
	@UIFields(type= FieldType.FType.repeatlabel)
	public List<String> hotelBusinessAmenities;
	
	@UIFields(type= FieldType.FType.label)
	public String areaName1;
	
	@UIFields(type= FieldType.FType.label)
	public String areaDistance1;
	
	@UIFields(type= FieldType.FType.label)
	public String areaMinutes1;
	
	@UIFields(type= FieldType.FType.label)
	public String areaParameter1;
	
	@UIFields(type= FieldType.FType.label)
	public String airportName1;
	
	@UIFields(type= FieldType.FType.label)
	public String airportDirection1;
	
	@UIFields(type= FieldType.FType.label)
	public String airportDistance1;
	
	@UIFields(type= FieldType.FType.label)
	public String airportMinutes1;
	
	@UIFields(type= FieldType.FType.label)
	public String airportParameter1;
	
	@UIFields(cssClass="imageWidth1",type= FieldType.FType.image)
	public String imageId1;
	
	@UIFields(cssClass="imageWidth2",type= FieldType.FType.image)
	public String imageId2;
	
	@UIFields(cssClass="imageWidth2",type= FieldType.FType.image)
	public String imageId3;
	
	@UIFields(cssClass="imageWidth",type= FieldType.FType.image)
	public String imageId4;
	
	public String hotelAmenitiesWithCommas;
	public String hotelLeisureAmenitiesWithCommas;
	public String hotelBusinessAmenitiesWithCommas;

}
