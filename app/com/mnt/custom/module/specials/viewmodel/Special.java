package com.mnt.custom.module.specials.viewmodel;

import java.util.List;

import play.data.format.Formats;

import com.google.common.collect.Lists;
import com.mnt.core.ui.annotation.Form;
import com.mnt.core.ui.annotation.UIFields;
import com.mnt.core.ui.annotation.UISelect;
import com.mnt.core.ui.annotation.UIVisibility;
import com.mnt.core.ui.annotation.Validation;
import com.mnt.core.ui.component.FieldType;
import com.mnt.custom.domain.BuilderFactory;
import com.mnt.custom.domain.BuilderFactory.KVMap;

@Form(action="/save-special",
		bindUrl="/special-as-json")
public class Special {

	//Repeat Sections
	@UIFields(cssClass="casute3",type=FieldType.FType.repeat)
	public List<RepeatPeriodSection> repeatPeriodSection = Lists.newArrayList(new RepeatPeriodSection());
	
	@Form(name="repeatPeriodSection")
	public static class RepeatPeriodSection{
		@Validation(unique=true)
		@UIFields(cssClass="casute3")
		public String fromDate;
		
		@Validation(unique=true)
		@UIFields(cssClass="casute3")
		public String toDate;
		
		@Validation(unique=true)
		@UIFields(cssClass="casute3")
		public String promotionName;
		
		public List<KVMap> roomTypesMap = BuilderFactory.me().getByKey("roomTypes");
		
		@UIFields(cssClass="casute3",type=FieldType.FType.multiselect)
		@UISelect(seed="roomTypesMap")
		public String roomTypes;
		
		@UIFields(cssClass="casute3",type=FieldType.FType.repeat)
		public List<RepeatMarket> repeatMarkets;
		
		@Form(name="repeatMarkets")
		public static class RepeatMarket{
			public List<KVMap> stayDaysMap = BuilderFactory.me().getByKey("maxOccupancy");
			
			@UIFields(cssClass="casute3",type=FieldType.FType.select)
			@UISelect(seed="stayDaysMap")
			public String stayDays;
			
			@UIFields(cssClass="casute3",type=FieldType.FType.select)
			@UISelect(seed="stayDaysMap")
			public String payDays;
			
			public List<KVMap> yesNoMap = BuilderFactory.me().getByKey("yesno");
			
			@UIFields(cssClass="casute3",type=FieldType.FType.radio)
			@UISelect(seed="yesNoMap")
			public String isApplyAllMarkets="1";
			
			public List<KVMap> applyCountriesMap = BuilderFactory.me().getByKey("applyCountry");
			
			@UIFields(cssClass="casute3",type=FieldType.FType.multiselect)
			@UISelect(seed="applyCountriesMap")
			public String applyToCountries;
			
			@UIVisibility(agents={"isApplyAllMarkets:==0"})
			public String market_1_1;
			
			public List<KVMap> freeStayTypeMap = BuilderFactory.me().getByKey("freeStayType");
			
			@UIFields(cssClass="casute3",type=FieldType.FType.select)
			@UISelect(seed="freeStayTypeMap")
			public String freeStayType;
			
			@UIFields(cssClass="casute3",type=FieldType.FType.radio)
			@UISelect(seed="yesNoMap")
			public String isApplicableMultipleTimes="1";
			
			@UIFields(cssClass="casute3",type=FieldType.FType.radio)
			@UISelect(seed="yesNoMap")
			public String isCombinedWithSpecials="1";
		}
		
		public List<KVMap> activeMap = BuilderFactory.me().getByKey("active");
		
		@UIFields(cssClass="casute3",type=FieldType.FType.radio)
		@UISelect(seed="activeMap")
		public String isActive="1";
		
	}
	
}
