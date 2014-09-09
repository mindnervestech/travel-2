package com.mnt.custom.module.supplier.viewmodel;

import java.util.List;

import com.mnt.core.ui.annotation.Form;
import com.mnt.core.ui.annotation.UIFields;
import com.mnt.core.ui.annotation.UISelect;
import com.mnt.core.ui.annotation.Validation;
import com.mnt.core.ui.component.FieldType;
import com.mnt.custom.domain.BuilderFactory;
import com.mnt.custom.domain.BuilderFactory.KVMap;


@Form(action="/save-supplier-hotel-transportation-info",
		  bindUrl="/supplier-hotel-transportation-as-json")
public class HotelTransportatin {

	
	@Validation(required=true)
	@UIFields(cssClass="casute3")
	public String airportName1;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3")
	public String airportDirection1;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3")
	public String airportDistance1;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3")
	public String airportMinutes1;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3",type=FieldType.FType.select)
	@UISelect(seed="parameterMap")
	public String airportParameter1;
	
	@UIFields(cssClass="casute3")
	public String airportName2;
	
	@UIFields(cssClass="casute3")
	public String airportDirection2;
	
	@UIFields(cssClass="casute3")
	public String airportDistance2;
	
	@UIFields(cssClass="casute3")
	public String airportMinutes2;
	
	@UIFields(cssClass="casute3",type=FieldType.FType.select)
	@UISelect(seed="parameterMap")
	public String airportParameter2;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3")
	public String railWayStationName1;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3")
	public String railWayStationDirection1;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3")
	public String railWayStationDistance1;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3")
	public String railWayStationMinutes1;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3",type=FieldType.FType.select)
	@UISelect(seed="parameterMap")
	public String railWayStationParameter1;
	
	@UIFields(cssClass="casute3")
	public String railWayStationName2;
	
	@UIFields(cssClass="casute3")
	public String railWayStationDirection2;
	
	@UIFields(cssClass="casute3")
	public String railWayStationDistance2;
	
	@UIFields(cssClass="casute3")
	public String railWayStationMinutes2;
	
	@UIFields(cssClass="casute3",type=FieldType.FType.select)
	@UISelect(seed="parameterMap")
	public String railWayStationParameter2;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3")
	public String subwayName1;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3")
	public String subwayDirection1;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3")
	public String subwayDistance1;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3")
	public String subwayMinutes1;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3",type=FieldType.FType.select)
	@UISelect(seed="parameterMap")
	public String subwayParameter1;
	
	@UIFields(cssClass="casute3")
	public String subwayName2;
	
	@UIFields(cssClass="casute3")
	public String subwayDirection2;
	
	@UIFields(cssClass="casute3")
	public String subwayDistance2;
	
	@UIFields(cssClass="casute3")
	public String subwayMinutes2;
	
	@UIFields(cssClass="casute3",type=FieldType.FType.select)
	@UISelect(seed="parameterMap")
	public String subwayParameter2;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3")
	public String cruisePortName1;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3")
	public String cruisePortDirection1;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3")
	public String cruisePortDistance1;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3")
	public String cruisePortMinutes1;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3",type=FieldType.FType.select)
	@UISelect(seed="parameterMap")
	public String cruisePortParameter1;
	
	@UIFields(cssClass="casute3")
	public String cruisePortName2;
	
	@UIFields(cssClass="casute3")
	public String cruisePortDirection2;
	
	@UIFields(cssClass="casute3")
	public String cruisePortDistance2;
	
	@UIFields(cssClass="casute3")
	public String cruisePortMinutes2;
	
	@UIFields(cssClass="casute3",type=FieldType.FType.select)
	@UISelect(seed="parameterMap")
	public String cruisePortParameter2;
	
	public List<KVMap> parameterMap = BuilderFactory.me().getByKey("parameterMap");
}
