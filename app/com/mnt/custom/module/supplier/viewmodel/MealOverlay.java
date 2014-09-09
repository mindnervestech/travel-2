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
import com.mnt.custom.module.supplier.viewmodel.HotelAdditionalInformation.RepeatTaxSections;


@Form(action="/save-supplier-hotel-meal-info",
		  bindUrl="/supplier-hotel-meal-as-json")
public class MealOverlay {

	@Validation(required=true)
	@UIFields(cssClass="casute3")
	public String mealFromDate;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3")
	public String mealToDate;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3",type=FieldType.FType.select)
	@UISelect(seed="mealMap")
	public String mealType;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3")
	public String mealName;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3")
	public String mealAdultRate;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoMap")
	public String isAdultIncludeTax ="0";
	
	@Validation(required=true)
	@UIFields(cssClass="casute3")
	public String mealAdultTax;
	
	@UIFields(cssClass="casute3",type=FieldType.FType.select)
	@UISelect(seed="percentMap")
	public String mealAdultTaxPercent;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3")
	public String mealAdultDiscount;
	
	@UIFields(cssClass="casute3",type=FieldType.FType.select)
	@UISelect(seed="percentMap")
	public String mealAdultDiscountPercent;
	
	
	@UIVisibility(agents={"isAdultIncludeTax:==1"})
	public String adultTaxInclude;
	

	
	//Repeat Sections
	@UIFields(cssClass="casute3",type=FieldType.FType.repeat)
	public List<RepeatChildMealRateSections> repeatChildMealRateSections;
	
	@Form(name="repeatChildMealRateSections")
	public static class RepeatChildMealRateSections{
		
		@UIFields(cssClass="casute3",type=FieldType.FType.select)
		@UISelect(seed="ageMap")
		public String childFromAge;
		
		@UIFields(cssClass="casute3",type=FieldType.FType.select)
		@UISelect(seed="ageMap")
		public String childToAge;
		
		@Validation(required=true)
		@UIFields(cssClass="casute3")
		public String mealChildRate;
		
		@UIFields(type = FieldType.FType.radio)
		@UISelect(seed="yesnoMap")
		public String isChildIncludeTax ="1";
		
		@Validation(required=true)
		@UIFields(cssClass="casute3")
		public String mealChildTax;
		
		@UIFields(cssClass="casute3",type=FieldType.FType.select)
		@UISelect(seed="percentMap")
		public String mealChildTaxPercent;
		
		@Validation(required=true)
		@UIFields(cssClass="casute3")
		public String mealChildDiscount;
		
		@UIFields(cssClass="casute3",type=FieldType.FType.select)
		@UISelect(seed="percentMap")
		public String mealChildDiscountPercent;
		
		@UIVisibility(agents={"isChildIncludeTax() == 0"})
		@UIFields(type = FieldType.FType.control)
		public String childTaxInclude;
		
		public List<KVMap> yesnoMap = BuilderFactory.me().getByKey("yesno");
		public List<KVMap> ageMap = BuilderFactory.me().getByKey("ageMap");
		public List<KVMap> percentMap = BuilderFactory.me().getByKey("percentMap");
		
		@UIFields(cssClass="casute3", type=FieldType.FType.hidden)
		public String _key = String.valueOf(new Date().getTime() + (Math.random()*10));
	}
	
	public List<KVMap> yesnoMap = BuilderFactory.me().getByKey("yesno");
	public List<KVMap> mealMap = BuilderFactory.me().getByKey("mealMap");
	//public List<KVMap> ageMap = BuilderFactory.me().getByKey("ageMap");
	public List<KVMap> percentMap = BuilderFactory.me().getByKey("percentMap");
	
}
