package com.mnt.custom.module.supplier.viewmodel;

import java.util.Date;
import java.util.List;

import com.google.common.collect.Lists;
import com.mnt.core.ui.annotation.Form;
import com.mnt.core.ui.annotation.UIFields;
import com.mnt.core.ui.annotation.UISelect;
import com.mnt.core.ui.annotation.UIVisibility;
import com.mnt.core.ui.annotation.Validation;
import com.mnt.core.ui.component.FieldType;
import com.mnt.custom.domain.BuilderFactory;
import com.mnt.custom.domain.BuilderFactory.KVMap;


@Form(action="/save-supplier-hotel-additional-info",
		  bindUrl="/supplier-hotel-business-additional-as-json")
public class HotelAdditionalInformation {

	@Validation(required=true)
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="includeMap")
	public String roomTax ="0";
	
	
	@Validation(required=true)
	@UIFields(cssClass="casute3",type=FieldType.FType.select)
	@UISelect(seed="currencyMap")
	public String currencyMandatory;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoMap")
	public String isMandatoryCharges ="0";
	
	@UIFields(cssClass="casute3")
	public String surchargePerRoom;
	
	@UIFields(cssClass="casute3")
	public String surchargePerRoomPerctntage;
	
	
	@Validation(required=true)
	@UIFields(cssClass="casute3",type=FieldType.FType.textarea)
	public String tariffNotes;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoMap")
	public String isMandatoryTransfers ="0";
	
	
	@UIFields(cssClass="casute3")
	public String guestAgeValidity;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3",type=FieldType.FType.select)
	@UISelect(seed="timeMap")
	public String checkInTime;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3",type=FieldType.FType.select)
	@UISelect(seed="timeMap")
	public String checkOutTime;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoMap")
	public String isMandatorySupplement ="0";
	
	
	
		
	
	// Visibility Section
	
	@UIVisibility(agents={"roomTax()==1"})
	@UIFields(type = FieldType.FType.control)
	public String taxContainer;
	
	@UIVisibility(agents={"isMandatoryCharges:==1"})
	public String AdditioanlM;
	
	@UIVisibility(agents={"isMandatorySupplement()==1"})
	@UIFields(type = FieldType.FType.control)
	public String supplementPeriod;
	
	
	
	
	
	//Repeat Sections
	@UIFields(cssClass="casute3",type=FieldType.FType.repeat)
	public List<RepeatTaxSections> repeatTaxSections;
	
	@Form(name="repeatTaxSections")
	public static class RepeatTaxSections{
		
		@Validation(required=true)
		@UIFields(cssClass="casute3")
		public String taxPeriodFrom;
		
		@Validation(required=true)
		@UIFields(cssClass="casute3")
		public String taxPeriodTo;
		
		@Validation(required=true)
		@UIFields(cssClass="casute3")
		public String taxName;
		
		@Validation(required=true)
		@UIFields(cssClass="casute3")
		public String taxAmount;
		
		
		@UIFields(type = FieldType.FType.radio,cssClass="casute3")
		@UISelect(seed="isTaxMap")
		public String taxIs ="0";
		
		@Validation(required=true)
		@UIFields(cssClass="casute3",type=FieldType.FType.select)
		@UISelect(seed="currencyMap")
		public String currency;
		
		
		@UIVisibility(agents={"taxIs() == 1"})
		@UIFields(type = FieldType.FType.control)
		public String taxcurrency1;
		
		public List<KVMap> isTaxMap = BuilderFactory.me().getByKey("isTaxMap");
		public List<KVMap> currencyMap = BuilderFactory.me().getByKey("currencyMap");
		
		
		@UIFields(cssClass="casute3", type=FieldType.FType.hidden)
		public String _key = String.valueOf(new Date().getTime() + (Math.random()*10));
	}
	
	
	@UIFields(cssClass="casute3",type=FieldType.FType.repeat)
	public List<RepeatSupplementSections> repeatSupplementSections;
	
	@Form(name="repeatSupplementSections")
	public static class RepeatSupplementSections{
		
		@UIFields(cssClass="casute3",type=FieldType.FType.select)
		@UISelect(seed="monthMap")
		public String supplementFromMonth;
		
		@UIFields(cssClass="casute3",type=FieldType.FType.select)
		@UISelect(seed="monthMap")
		public String supplementToMonth;
		
		@UIFields(cssClass="casute3",type=FieldType.FType.select)
		@UISelect(seed="dayMap")
		public String supplementFromDay;
		
		@UIFields(cssClass="casute3",type=FieldType.FType.select)
		@UISelect(seed="dayMap")
		public String supplementToDay;
		
		@UIFields(cssClass="casute3",type=FieldType.FType.select)
		@UISelect(seed="yearMap")
		public String supplementFromYear;
		
		@UIFields(cssClass="casute3",type=FieldType.FType.select)
		@UISelect(seed="yearMap")
		public String supplementToYear;
		
		@UIFields(cssClass="casute3")
		public String supplementName;
		
		@Validation(required=true)
		@UIFields(cssClass="casute3",type=FieldType.FType.textarea)
		public String supplementDescription;
		
		@UIFields(type = FieldType.FType.radio)
		@UISelect(seed="isApplyMap")
		public String isApply ="1";
		
		@UIFields(cssClass="casute3")
		public String supplementPerRoomRate;
		
		@UIFields(type = FieldType.FType.radio)
		@UISelect(seed="yesnoMap")
		public String isPerRoomRate ="1";
		
		@Validation(required=true)
		@UIFields(cssClass="casute3")
		public String perRoomRateTax;
		
		@Validation(required=true)
		@UIFields(type = FieldType.FType.radio)
		@UISelect(seed="isTaxMap")
		public String perRoomRateTaxPercent ="0";
		
		@Validation(required=true)
		@UIFields(cssClass="casute3")
		public String perRoomRateDiscount;
		
		@Validation(required=true)
		@UIFields(type = FieldType.FType.radio)
		@UISelect(seed="isTaxMap")
		public String perRoomRateDiscountPercent ="0";
		
		@UIFields(cssClass="casute3")
		public String supplementPerPersonAdultRate;
		
		@UIFields(cssClass="casute3")
		public String supplementPerPersonChildRate;
		
		@UIFields(type = FieldType.FType.radio)
		@UISelect(seed="yesnoMap")
		public String isPerPersonAdultRate ="1";
		
		@UIFields(type = FieldType.FType.radio)
		@UISelect(seed="yesnoMap")
		public String isPerPersonChildRate ="1";
		
		@Validation(required=true)
		@UIFields(cssClass="casute3")
		public String perPersonAdultRateTax;
		
		@Validation(required=true)
		@UIFields(type = FieldType.FType.radio)
		@UISelect(seed="isTaxMap")
		public String perPersonAdultRateTaxPercent ="0";
		
		@Validation(required=true)
		@UIFields(cssClass="casute3")
		public String perPersonAdultRateDiscount;
		
		@Validation(required=true)
		@UIFields(type = FieldType.FType.radio)
		@UISelect(seed="isTaxMap")
		public String perPersonAdultRateDiscountPercent ="0";
		
		@Validation(required=true)
		@UIFields(cssClass="casute3")
		public String perPersonChildRateTax;
		
		@Validation(required=true)
		@UIFields(type = FieldType.FType.radio)
		@UISelect(seed="isTaxMap")
		public String perPersonChildRateTaxPercent ="0";
		
		@Validation(required=true)
		@UIFields(cssClass="casute3")
		public String perPersonChildRateDiscount;
		
		@Validation(required=true)
		@UIFields(type = FieldType.FType.radio)
		@UISelect(seed="isTaxMap")
		public String perPersonChildRateDiscountPercent ="0";
		
		public List<KVMap> monthMap= BuilderFactory.me().getByKey("monthMap");
		public List<KVMap> dayMap = BuilderFactory.me().getByKey("dayMap");
		public List<KVMap> yearMap = BuilderFactory.me().getByKey("yearMap");
		public List<KVMap> yesnoMap = BuilderFactory.me().getByKey("yesno");
		public List<KVMap> isTaxMap = BuilderFactory.me().getByKey("isTaxMap");
		public List<KVMap> isApplyMap= BuilderFactory.me().getByKey("isApplyMap");
		
		
		@UIVisibility(agents={"isApply() == 1"})
		@UIFields(type = FieldType.FType.control)
		public String perroom;
		
		@UIVisibility(agents={"isApply() == 0"})
		@UIFields(type = FieldType.FType.control)
		public String perperson;
		
		@UIVisibility(agents={"isPerPersonAdultRate() == 0"})
		@UIFields(type = FieldType.FType.control)
		public String perPersonAdultTax;
		
		@UIVisibility(agents={"isPerPersonChildRate() == 0"})
		@UIFields(type = FieldType.FType.control)
		public String perPersonChildTax;
		
		@UIVisibility(agents={"isPerRoomRate() == 0"})
		@UIFields(type = FieldType.FType.control)
		public String perRoomRateDiv;
		
		
		
		@UIFields(cssClass="casute3", type=FieldType.FType.hidden)
		public String _key = String.valueOf(new Date().getTime() + (Math.random()*10));
		
	}
	
	
	
	// Map Section
	
	public List<KVMap> isApplyMap= BuilderFactory.me().getByKey("isApplyMap");
	
	public List<KVMap> monthMap= BuilderFactory.me().getByKey("monthMap");
	public List<KVMap> dayMap = BuilderFactory.me().getByKey("dayMap");
	public List<KVMap> yearMap = BuilderFactory.me().getByKey("yearMap");
	public List<KVMap> currencyMap = BuilderFactory.me().getByKey("currencyMap");
	public List<KVMap> isTaxMap = BuilderFactory.me().getByKey("isTaxMap");
	public List<KVMap> includeMap = BuilderFactory.me().getByKey("includeMap");
	public List<KVMap> yesnoMap = BuilderFactory.me().getByKey("yesno");
	public List<KVMap> timeMap = BuilderFactory.me().getByKey("timeMap");
}
