package com.mnt.custom.module.yieldmgmt.viewmodel;

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

@Form(action="/save-yield",
		bindUrl="/yield-as-json")
public class YieldMgmt {
	
	// Repeat Sections
	@UIFields(cssClass="casute3",type=FieldType.FType.repeat)
	public List<RepeatRateSections> repeatRateSections;
	
	
	@Form(name="repeatRateSections")
	public static class RepeatRateSections{
		
	@UIFields(cssClass="casute3")
	public String generalRateAdult1;
	
	@UIFields(cssClass="casute3")
	public String generalRateAdult2;
	
	@UIFields(cssClass="casute3")
	public String generalRateAdult3;
	
	@Validation(required=true)
	@UIFields(type=FieldType.FType.radio)
	@UISelect(seed="yesNoMap")
	public String generalRateAdultInclude1 = "0";
	
	
	@Validation(required=true)
	@UIFields(type=FieldType.FType.radio)
	@UISelect(seed="yesNoMap")
	public String generalRateAdultInclude2 = "0";
	
	
	@Validation(required=true)
	@UIFields(type=FieldType.FType.radio)
	@UISelect(seed="yesNoMap")
	public String generalRateAdultInclude3 = "0";

	@Validation(required=true)
	@UIFields(type=FieldType.FType.select)
	@UISelect(seed="mealMap")
	public String generalAdultRateBasis1;
	
	
	@Validation(required=true)
	@UIFields(type=FieldType.FType.select)
	@UISelect(seed="mealMap")
	public String generalAdultRateBasis2;
	
	
	@Validation(required=true)
	@UIFields(type=FieldType.FType.select)
	@UISelect(seed="mealMap")
	public String generalAdultRateBasis3;
	
	@UIFields(cssClass="casute3")
	public String generalAdultRateType1;
	
	@UIFields(cssClass="casute3")
	public String generalAdultRateType2;
	
	@UIFields(cssClass="casute3")
	public String generalAdultRateType3;
	
	@UIFields(type=FieldType.FType.radio)
	@UISelect(seed="yesNoMap")
	public String differentNetRates = "0";
	
	@UIFields(type = FieldType.FType.checkbox)
	@UISelect(seed="daysMap")
	public List<String> applicableDays = Lists.newArrayList();
	
	@UIFields(cssClass="casute3")
	public String differentRateAdult1;
	
	@UIFields(cssClass="casute3")
	public String differentRateAdult2;
	
	@UIFields(cssClass="casute3")
	public String differentRateAdult3;
	
	@Validation(required=true)
	@UIFields(type=FieldType.FType.radio)
	@UISelect(seed="yesNoMap")
	public String differentRateAdultInclude1 = "0";
	
	
	@Validation(required=true)
	@UIFields(type=FieldType.FType.radio)
	@UISelect(seed="yesNoMap")
	public String differentRateAdultInclude2 = "0";
	
	
	@Validation(required=true)
	@UIFields(type=FieldType.FType.radio)
	@UISelect(seed="yesNoMap")
	public String differentRateAdultInclude3 = "0";
	
	@Validation(required=true)
	@UIFields(type=FieldType.FType.select)
	@UISelect(seed="mealMap")
	public String differentAdultRateBasis1;
	
	
	@Validation(required=true)
	@UIFields(type=FieldType.FType.select)
	@UISelect(seed="mealMap")
	public String differentAdultRateBasis2;
	
	
	@Validation(required=true)
	@UIFields(type=FieldType.FType.select)
	@UISelect(seed="mealMap")
	public String differentAdultRateBasis3;
	
	@UIFields(cssClass="casute3")
	public String differentAdultRateType1;
	
	@UIFields(cssClass="casute3")
	public String differentAdultRateType2;
	
	@UIFields(cssClass="casute3")
	public String differentAdultRateType3;
	
	@UIFields(type=FieldType.FType.radio)
	@UISelect(seed="yesNoMap")
	public String isPassengerNationality = "0";
	
	@UIFields(cssClass="casute3",type=FieldType.FType.multiselect)
	@UISelect(seed="marketMap")
	public List<String> rateMarketType = Lists.newArrayList();
	
	@UIFields(type = FieldType.FType.checkbox)
	@UISelect(seed="daysMap")
	public List<String> minimumStayDays = Lists.newArrayList();
	
	@Validation(required=true)
	@UIFields(type=FieldType.FType.select)
	@UISelect(seed="dayMap")
	public String noOfMinNights;
	
	public List<KVMap> mealMap = BuilderFactory.me().getByKey("mealMap");
	public List<KVMap> daysMap = BuilderFactory.me().getByKey("daysMap");
	public List<KVMap> marketMap = BuilderFactory.me().getByKey("marketMap");
	public List<KVMap> dayMap = BuilderFactory.me().getByKey("dayMap");
	public List<KVMap> yesNoMap = BuilderFactory.me().getByKey("yesno");
	public List<KVMap> cancellationMap = BuilderFactory.me().getByKey("cancellationMap");
	
	@UIVisibility(agents={"generalRateAdultInclude1() == 1"})
	@UIFields(type = FieldType.FType.control)
	public String mealInclude1;
	
	@UIVisibility(agents={"generalRateAdultInclude2() == 1"})
	@UIFields(type = FieldType.FType.control)
	public String mealInclude2;
	
	@UIVisibility(agents={"generalRateAdultInclude3() == 1"})
	@UIFields(type = FieldType.FType.control)
	public String mealInclude3;
	
	@UIVisibility(agents={"differentRateAdultInclude1() == 1"})
	@UIFields(type = FieldType.FType.control)
	public String differenrMealInclude1;
	
	@UIVisibility(agents={"differentRateAdultInclude2() == 1"})
	@UIFields(type = FieldType.FType.control)
	public String differenrMealInclude2;
	
	@UIVisibility(agents={"differentRateAdultInclude3() == 1"})
	@UIFields(type = FieldType.FType.control)
	public String differenrMealInclude3;
	
	@UIVisibility(agents={"differentNetRates() == 1"})
	@UIFields(type = FieldType.FType.control)
	public String differentNetRatesRequired;
	
	@UIVisibility(agents={"isPassengerNationality() == 1"})
	@UIFields(type = FieldType.FType.control)
	public String marketRate;
	
	@UIFields(cssClass="casute3", type=FieldType.FType.hidden)
	public String _key = String.valueOf(new Date().getTime() + (Math.random()*10));
	
	@UIFields(cssClass="casute3",type=FieldType.FType.repeat)
	public List<CancellationSection> repeatCancellations;
	
	@UIFields(cssClass="casute3",type=FieldType.FType.repeat)
	public List<CancellationSection1> repeatCancellations1;
	
		@Form(name="repeatCancellations")
		public static class CancellationSection{
			
			public List<KVMap> cancellationTimeMap = BuilderFactory.me().getByKey("cancellationTime");
			public List<KVMap> penaltyChargesMap = BuilderFactory.me().getByKey("penaltyCharge");
			public List<KVMap> nightsMap = BuilderFactory.me().getByKey("nights");
			public List<KVMap> percentageMap = BuilderFactory.me().getByKey("percentage");
			
			@UIFields(cssClass="casute3",type = FieldType.FType.select)
			@UISelect(seed="cancellationTimeMap")
			public String cancellationTime;

			@UIFields(cssClass="casute3",type = FieldType.FType.radio)
			@UISelect(seed="penaltyChargesMap")
			public String penaltyCharge= "0";

			@UIFields(cssClass="casute3",type = FieldType.FType.select)
			@UISelect(seed="nightsMap")
			public String nights;
			
			@UIFields(cssClass="casute3",type = FieldType.FType.select)
			@UISelect(seed="percentageMap")
			public String percentages;
			
			@UIFields(type = FieldType.FType.control)
			@UIVisibility(agents={"penaltyCharge() == 1"})
			public String nightsDisplay;
			
			@UIFields(type = FieldType.FType.control)
			@UIVisibility(agents={"penaltyCharge() == 1"})
			public String percentagesDisplay;
		}
		
		@Form(name="repeatCancellations1")
		public static class CancellationSection1{
			
			public List<KVMap> cancellationTimeMap = BuilderFactory.me().getByKey("cancellationTime");
			public List<KVMap> penaltyChargesMap = BuilderFactory.me().getByKey("penaltyCharge");
			public List<KVMap> nightsMap = BuilderFactory.me().getByKey("nights");
			public List<KVMap> percentageMap = BuilderFactory.me().getByKey("percentage");
			
			@UIFields(cssClass="casute3",type = FieldType.FType.select)
			@UISelect(seed="cancellationTimeMap")
			public String cancellationTime1;

			@UIFields(cssClass="casute3",type = FieldType.FType.radio)
			@UISelect(seed="penaltyChargesMap")
			public String penaltyCharge1= "0";

			@UIFields(cssClass="casute3",type = FieldType.FType.select)
			@UISelect(seed="nightsMap")
			public String nights1;
			
			@UIFields(cssClass="casute3",type = FieldType.FType.select)
			@UISelect(seed="percentageMap")
			public String percentages1;
			
			@UIFields(type = FieldType.FType.control)
			@UIVisibility(agents={"penaltyCharge1() == 1"})
			public String nightsDisplay1;
			
			@UIFields(type = FieldType.FType.control)
			@UIVisibility(agents={"penaltyCharge1() == 1"})
			public String percentagesDisplay1;
		}
	}
	
	
	public String minimumStayDaysWithCommas;
	public String applicableDaysWithCommas;
	public String rateMarketTypeWithCommas;
	public String allotmentMarketRatesWithCommas;
	public String applyToAllMarketsWithCommas;
	public String applyToAllMarketsOccupancyWithCommas;

	
	//Allotment Markets
	@UIFields(cssClass="casute3",type=FieldType.FType.repeat)
	public List<AllottmentMarket> allottmentMarkets;
	
	@Form(name="allottmentMarkets")
	public static class AllottmentMarket{
		public List<KVMap> yesNoMap = BuilderFactory.me().getByKey("yesno");
		
		@UIFields(cssClass="casute3",type=FieldType.FType.radio)
		@UISelect(seed="yesNoMap")
		public String isApplyToRates = "1";
		
		public List<KVMap> countryMap = BuilderFactory.me().getByKey("country");
		
		@UIFields(cssClass="casute3",type=FieldType.FType.multiselect)
		@UISelect(seed="countryMap")
		public List<String> allotmentMarketRates = Lists.newArrayList();
		
		@UIVisibility(agents={"isApplyToRates()==0"})
		@UIFields(type = FieldType.FType.control)
		public String market_1_1;
		
		public List<KVMap> allotmentMap = BuilderFactory.me().getByKey("specifyAllotment");
		
		@UIFields(cssClass="casute3",type=FieldType.FType.radio)
		@UISelect(seed="allotmentMap")
		public String isSpecifyAllotment = "1";
		
		@UIVisibility(agents={"isSpecifyAllotment()==1"})
		@UIFields(type = FieldType.FType.control)
		public String specifyAllotment;
		
		@UIFields(cssClass="casute3",type=FieldType.FType.radio)
		@UISelect(seed="yesNoMap")
		public String isFreeSell = "1";
		
		@UIFields(cssClass="casute3",type=FieldType.FType.radio)
		@UISelect(seed="yesNoMap")
		public String isStopSellOnReq = "1";
		
		@UIVisibility(agents={"isFreeSell()==0"})
		@UIFields(type = FieldType.FType.control)
		public String stopsell_market_div;
		
		@UIVisibility(agents={"isStopSellOnReq()==0"})
		@UIFields(type = FieldType.FType.control)
		public String stopsell_market_choose;
		
		@UIFields(cssClass="casute3",type=FieldType.FType.multiselect)
		@UISelect(seed="countryMap")
		public List<String> applyToAllMarkets = Lists.newArrayList();
		
		@UIFields(cssClass="casute3",type=FieldType.FType.radio)
		@UISelect(seed="yesNoMap")
		public String isApplyToAllMarkets = "1";
		
		@UIVisibility(agents={"isApplyToAllMarkets()==0"})
		@UIFields(type = FieldType.FType.control)
		public String applyToAllMarket;
		
		@UIVisibility(agents={"isSpecifyAllotment()==2"})
		@UIFields(type = FieldType.FType.control)
		public String allotmentOccupacy;
		
		@UIFields(cssClass="casute3",type=FieldType.FType.radio)
		@UISelect(seed="yesNoMap")
		public String isApplyToAllMarketsOccupancy = "1";
		
		@UIFields(cssClass="casute3",type=FieldType.FType.multiselect)
		@UISelect(seed="countryMap")
		public List<String> applyToAllMarketsOccupancy = Lists.newArrayList();
		
		@UIVisibility(agents={"isApplyToAllMarketsOccupancy()==0"})
		@UIFields(type = FieldType.FType.control)
		public String market_1_1_occupancy;
		
		@UIFields(cssClass="casute3",type=FieldType.FType.radio)
		@UISelect(seed="yesNoMap")
		public String isFreeSellOccAdult1 = "1";
		
		@UIFields(cssClass="casute3",type=FieldType.FType.radio)
		@UISelect(seed="yesNoMap")
		public String isStopSellOnReqAdult1 = "1";
		
		@UIVisibility(agents={"isFreeSellOccAdult1()==0"})
		@UIFields(type = FieldType.FType.control)
		public String stopsell_market_div_adult1;
		
		@UIVisibility(agents={"isStopSellOnReqAdult1()==0"})
		@UIFields(type = FieldType.FType.control)
		public String stopsell_market_choose_adult1;
		
		@UIFields(cssClass="casute3",type=FieldType.FType.radio)
		@UISelect(seed="yesNoMap")
		public String isFreeSellOccAdult2 = "1";
		
		@UIFields(cssClass="casute3",type=FieldType.FType.radio)
		@UISelect(seed="yesNoMap")
		public String isStopSellOnReqAdult2 = "1";
		
		@UIVisibility(agents={"isFreeSellOccAdult2()==0"})
		@UIFields(type = FieldType.FType.control)
		public String stopsell_market_div_adult2;
		
		@UIVisibility(agents={"isStopSellOnReqAdult2()==0"})
		@UIFields(type = FieldType.FType.control)
		public String stopsell_market_choose_adult2;
		
		@UIFields(cssClass="casute3",type=FieldType.FType.radio)
		@UISelect(seed="yesNoMap")
		public String isFreeSellOccAdult3 = "1";
		
		@UIFields(cssClass="casute3",type=FieldType.FType.radio)
		@UISelect(seed="yesNoMap")
		public String isStopSellOnReqAdult3 = "1";
		
		@UIVisibility(agents={"isFreeSellOccAdult3()==0"})
		@UIFields(type = FieldType.FType.control)
		public String stopsell_market_div_adult3;
		
		@UIVisibility(agents={"isStopSellOnReqAdult3()==0"})
		@UIFields(type = FieldType.FType.control)
		public String stopsell_market_choose_adult3;
		
		public List<KVMap> releasePeriodMap = BuilderFactory.me().getByKey("releasePeriod");
		
		@UIFields(cssClass="casute3",type=FieldType.FType.select)
		@UISelect(seed="releasePeriodMap")
		public String releasePeriod1;
		
		@UIFields(cssClass="casute3",type=FieldType.FType.select)
		@UISelect(seed="releasePeriodMap")
		public String releasePeriod2;
		
		@UIFields(cssClass="casute3",type=FieldType.FType.select)
		@UISelect(seed="releasePeriodMap")
		public String releasePeriod3;
		
		@UIFields(cssClass="casute3",type=FieldType.FType.select)
		@UISelect(seed="releasePeriodMap")
		public String releasePeriod4;
		
		public List<KVMap> cutoffMap = BuilderFactory.me().getByKey("cutoff");
		
		@UIFields(cssClass="casute3",type=FieldType.FType.select)
		@UISelect(seed="cutoffMap")
		public String cutoff_occupancy1;
		
		@UIFields(cssClass="casute3",type=FieldType.FType.select)
		@UISelect(seed="cutoffMap")
		public String cutoff_occupancy2;
		
		@UIFields(cssClass="casute3",type=FieldType.FType.select)
		@UISelect(seed="cutoffMap")
		public String cutoff_occupancy3;
	}
}
