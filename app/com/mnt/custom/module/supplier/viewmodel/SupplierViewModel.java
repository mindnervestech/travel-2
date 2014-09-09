package com.mnt.custom.module.supplier.viewmodel;

import java.util.List;

import models.suppliers.Supplier;

import org.codehaus.jackson.JsonNode;

import com.mnt.custom.domain.BuilderFactory;
import com.mnt.custom.domain.enums.CheckBox_HotelAmenities;
import com.mnt.custom.domain.enums.CheckBox_HotelBusinessFeature;
import com.mnt.custom.domain.enums.CheckBox_HotelLeisure_Sport;
import com.mnt.custom.domain.enums.CheckBox_HotelType;
import com.mnt.custom.domain.enums.RadioButton_Documentation;
import com.mnt.custom.domain.enums.RadioButton_Fire_Precautions_Procedures;

public class SupplierViewModel extends Supplier {
	public JsonNode hotelTypes_json = CheckBox_HotelType.toJSON();
	public JsonNode hotelAmenities_json = CheckBox_HotelAmenities.toJSON();
	public JsonNode hotelBusinessFeature_json = CheckBox_HotelBusinessFeature.toJSON();
	public JsonNode hotelLeisureSport_json = CheckBox_HotelLeisure_Sport.toJSON();
	public JsonNode hoteldocumentation_json = RadioButton_Documentation.toJSON();
	public JsonNode hotelFirePP_json = RadioButton_Fire_Precautions_Procedures.toJSON();
	public List<String> hotelTypes;
	public List<String> hotelAmenities;
	public List<String> hotelBusinessFeature;
	public List<String> hotelLeisureSport;
	public List<String> firePP;
	public List<String> docu;
	//public List<String> availableCountries = BuilderFactory.me().getByKey("country");
	
}
