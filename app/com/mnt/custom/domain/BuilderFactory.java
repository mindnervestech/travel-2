package com.mnt.custom.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import models.CCTVStatus;
import models.Country;
import models.Currency;
import models.Day;
import models.HotelAmenities;
import models.HotelBusinessAmenities;
import models.HotelDescriptionOptions;
import models.HotelLeisureAmenities;
import models.HotelLocationArea;
import models.MarketRatePolicy;
import models.Months;
import models.NightLife;
import models.RoomAmenity;
import models.Salutation;
import models.ShoppingFacility;
import models.Time;
import models.Year;

import com.avaje.ebean.Ebean;

public class BuilderFactory {

	private static List<KVMap> countryMap;
	private static List<KVMap> marketRatePolicyMap;
	private static List<KVMap> yesnoMap;
	private static List<KVMap> affiliatedChain;
	private static List<KVMap> locatinAreaMap;
	private static List<KVMap> shoppingFacilityMap;
	private static List<KVMap> nightLifeMap;
	private static List<KVMap> hotelDescriptionOptionMap;
	private static List<KVMap> salutationMap;
	private static List<KVMap> additionalMandatoryServiceCheckinMap;
	private static List<KVMap> isApplyMap;
	private static List<KVMap> relatedSelectionMap;
	private static List<KVMap> monthMap;
	private static List<KVMap> dayMap;
	private static List<KVMap> yearMap;
	private static List<KVMap> currencyMap;
	private static List<KVMap> isTaxMap;
	private static List<KVMap> includeMap;
	private static List<KVMap> timeMap;
	private static List<KVMap> hotelAmenitiesMap;
	private static List<KVMap> hotelBusinessAmenitiesMap;
	public static List<KVMap> hotelLeisureAmenitiesMap;
	private static List<KVMap> parameterMap;
	private static List<KVMap> yesnoNAMap;
	private static List<KVMap> monthsMap;
	private static List<KVMap> cctvStatusMap;
	private static List<KVMap> mealMap;
	private static List<KVMap> ageMap;
	private static List<KVMap> percentMap;
	private static List<KVMap> ratingMap;
	private static List<KVMap> statusMap;
	private static List<KVMap> daysMap;
	private static List<KVMap> marketMap;
	
	
	private static List<KVMap> maxOccupancyMap;
	private static List<KVMap> childSharingMap;
	private static List<KVMap> netRateMap;
	private static List<KVMap> roomAmenityMap;
	private static List<KVMap> roomTypesMap;
	private static List<KVMap> freeStayTypesMap;
	private static List<KVMap> activeMap;
	private static List<KVMap> applyCountryMap;
	
	private static List<KVMap> specifyAllotmentMap;
	private static List<KVMap> releasePeriodMap;
	private static List<KVMap> cutOffMap;
	private static List<KVMap> penaltyPolicyMap;
	private static List<KVMap> cancellationMap;
	private static List<KVMap> penaltyChargeMap;
	private static List<KVMap> nightsMap;
	private static List<KVMap> percentageMap;
	private static List<KVMap> ageInMap;
	
	public static BuilderFactory  me(){
		return new BuilderFactory();
	}
	
	// TODO: implement synchronised List
	public static List<KVMap> getByKey(String _key){
		if(_key.equals("country")){
			if(countryMap == null ){
				countryMap = new ArrayList<KVMap>();
				List<Country> list = Ebean.find(Country.class).select("name").findList();
				for(Country c : list){
					countryMap.add(new KVMap(String.valueOf(c.id),c.name));
				}
			}
			return countryMap;
		}
		
		if(_key.equals("marketRatePolicyMap")){
			if(marketRatePolicyMap == null ){
				marketRatePolicyMap = new ArrayList<KVMap>();
				List<MarketRatePolicy> list = Ebean.find(MarketRatePolicy.class).select("name").findList();
				for(MarketRatePolicy c : list){
					marketRatePolicyMap.add(new KVMap(String.valueOf(c.id),c.name));
				}
			}
			return marketRatePolicyMap;
		}
		if(_key.equals("yesno")){
			if(yesnoMap == null ){
				yesnoMap = new ArrayList<KVMap>();
				yesnoMap.add(new KVMap("1","Yes"));
				yesnoMap.add(new KVMap("0","No"));
				
			}
			return yesnoMap;
		}
		if(_key.equals("affiliatedChain")){
			if(affiliatedChain == null ){
				affiliatedChain = new ArrayList<KVMap>();
				affiliatedChain.add(new KVMap("0","Accor Hotels"));
				affiliatedChain.add(new KVMap("1","A Famosa"));
				affiliatedChain.add(new KVMap("2","Taj Group"));
				affiliatedChain.add(new KVMap("3","Oberoi Group"));
				affiliatedChain.add(new KVMap("4","Le Meridian"));
				affiliatedChain.add(new KVMap("5","Tuli International"));
			}
			return affiliatedChain;
		}
		if(_key.equals("locationArea")){
			if(locatinAreaMap == null ){
				locatinAreaMap = new ArrayList<KVMap>();
				List<HotelLocationArea> list = Ebean.find(HotelLocationArea.class).select("name").findList();
				for(HotelLocationArea c : list){
					locatinAreaMap.add(new KVMap(String.valueOf(c.id),c.name));
				}
			}
			return locatinAreaMap;
		}
		if(_key.equals("shoppingFacility")){
			if(shoppingFacilityMap == null ){
				shoppingFacilityMap = new ArrayList<KVMap>();
				List<ShoppingFacility> list = Ebean.find(ShoppingFacility.class).select("name").findList();
				for(ShoppingFacility c : list){
					shoppingFacilityMap.add(new KVMap(String.valueOf(c.id),c.name));
				}
			}
			return shoppingFacilityMap;
		}
		if(_key.equals("nightLife")){
			if(nightLifeMap == null ){
				nightLifeMap = new ArrayList<KVMap>();
				List<NightLife> list = Ebean.find(NightLife.class).select("name").findList();
				for(NightLife c : list){
					nightLifeMap.add(new KVMap(String.valueOf(c.id),c.name));
				}
			}
			return nightLifeMap;
		}
		if(_key.equals("hotelDescriptionOptionsMap")){
			if(hotelDescriptionOptionMap == null ){
				hotelDescriptionOptionMap = new ArrayList<KVMap>();
				List<HotelDescriptionOptions> list = Ebean.find(HotelDescriptionOptions.class).select("name").findList();
				for(HotelDescriptionOptions c : list){
					hotelDescriptionOptionMap.add(new KVMap(String.valueOf(c.id),c.name));
				}
			}
			return hotelDescriptionOptionMap;
		}
		if(_key.equals("salutation")){
			if(salutationMap == null ){
				salutationMap = new ArrayList<KVMap>();
				List<Salutation> list = Ebean.find(Salutation.class).select("name").findList();
				for(Salutation c : list){
					salutationMap.add(new KVMap(String.valueOf(c.id),c.name));
				}
			}
			return salutationMap;
		}
		if(_key.equals("additionalMandatoryServiceCheckinMap")){
			if(additionalMandatoryServiceCheckinMap == null ){
				additionalMandatoryServiceCheckinMap = new ArrayList<KVMap>();
				additionalMandatoryServiceCheckinMap.add(new KVMap("1","Check In"));
				additionalMandatoryServiceCheckinMap.add(new KVMap("0","Check Out"));
			}
			return additionalMandatoryServiceCheckinMap;
		}
		if(_key.equals("isApplyMap")){
			if(isApplyMap == null ){
				isApplyMap = new ArrayList<KVMap>();
				isApplyMap.add(new KVMap("1","Per Person"));
				isApplyMap.add(new KVMap("0","Per Room"));
			}
			return isApplyMap;
		}
		if(_key.equals("relatedSelectionMap")){
			if(relatedSelectionMap == null ){
				relatedSelectionMap = new ArrayList<KVMap>();
				relatedSelectionMap.add(new KVMap("0","Radio Selection"));
				relatedSelectionMap.add(new KVMap("1","Multiple Choices"));
				relatedSelectionMap.add(new KVMap("2","Free Text"));
				relatedSelectionMap.add(new KVMap("3","Date"));
				relatedSelectionMap.add(new KVMap("4","Date Time"));
				relatedSelectionMap.add(new KVMap("5","Date Interval"));
			}
			return relatedSelectionMap;
		}
		if(_key.equals("monthMap")){
			if(monthMap == null ){
				monthMap = new ArrayList<KVMap>();
				List<Months> list = Ebean.find(Months.class).select("name").findList();
				for(Months c : list){
					monthMap.add(new KVMap(String.valueOf(c.id),c.name));
				}
			}
			return monthMap;
		}
		if(_key.equals("dayMap")){
			if(dayMap == null ){
				dayMap = new ArrayList<KVMap>();
				List<Day> list = Ebean.find(Day.class).select("name").findList();
				for(Day c : list){
					dayMap.add(new KVMap(String.valueOf(c.id),c.name));
				}
			}
			return dayMap;
		}
		if(_key.equals("yearMap")){
			if(yearMap == null ){
				yearMap = new ArrayList<KVMap>();
				List<Year> list = Ebean.find(Year.class).select("name").findList();
				for(Year c : list){
					yearMap.add(new KVMap(String.valueOf(c.id),c.name));
				}
			}
			return yearMap;
		}
		if(_key.equals("currencyMap")){
			if(currencyMap == null ){
				currencyMap = new ArrayList<KVMap>();
				List<Currency> list = Ebean.find(Currency.class).select("name").findList();
				for(Currency c : list){
					currencyMap.add(new KVMap(String.valueOf(c.id),c.name));
				}
			}
			return currencyMap;
		}
		if(_key.equals("isTaxMap")){
			if(isTaxMap == null ){
				isTaxMap = new ArrayList<KVMap>();
				isTaxMap.add(new KVMap("0","%"));
				isTaxMap.add(new KVMap("1","Fixed Amount"));
			}
			return isTaxMap;
		}
		if(_key.equals("includeMap")){
			if(includeMap == null ){
				includeMap = new ArrayList<KVMap>();
				includeMap.add(new KVMap("0","Included in Rate"));
				includeMap.add(new KVMap("1","Not Included in Rate"));
			}
			return includeMap;
		}
		if(_key.equals("timeMap")){
			if(timeMap == null ){
				timeMap = new ArrayList<KVMap>();
				List<Time> list = Ebean.find(Time.class).select("name").findList();
				for(Time c : list){
					timeMap.add(new KVMap(String.valueOf(c.id),c.name));
				}
			}
			return timeMap;
		}
		if(_key.equals("hotelAmenitiesMap")){
			if(hotelAmenitiesMap == null ){
				hotelAmenitiesMap = new ArrayList<KVMap>();
				List<HotelAmenities> list = Ebean.find(HotelAmenities.class).select("name").findList();
				for(HotelAmenities c : list){
					hotelAmenitiesMap.add(new KVMap(String.valueOf(c.id),c.name));
				}
			}
			return hotelAmenitiesMap;
		}
		if(_key.equals("hotelBusinessAmenitiesMap")){
			if(hotelBusinessAmenitiesMap == null ){
				hotelBusinessAmenitiesMap = new ArrayList<KVMap>();
				List<HotelBusinessAmenities> list = Ebean.find(HotelBusinessAmenities.class).select("name").findList();
				for(HotelBusinessAmenities c : list){
					hotelBusinessAmenitiesMap.add(new KVMap(String.valueOf(c.id),c.name));
				}
			}
			return hotelBusinessAmenitiesMap;
		}
		if(_key.equals("hotelLeisureAmenitiesMap")){
			if(hotelLeisureAmenitiesMap == null ){
				hotelLeisureAmenitiesMap = new ArrayList<KVMap>();
				List<HotelLeisureAmenities> list = Ebean.find(HotelLeisureAmenities.class).select("name").findList();
				for(HotelLeisureAmenities c : list){
					hotelLeisureAmenitiesMap.add(new KVMap(String.valueOf(c.id),c.name));
				}
			}
			return hotelLeisureAmenitiesMap;
		}
		if(_key.equals("parameterMap")){
			if(parameterMap == null ){
				parameterMap = new ArrayList<KVMap>();
				parameterMap.add(new KVMap("1","Km"));
				parameterMap.add(new KVMap("0","Miles"));
			}
			return parameterMap;
		}
		if(_key.equals("yesnoNAMap")){
			if(yesnoNAMap == null ){
				yesnoNAMap = new ArrayList<KVMap>();
				yesnoNAMap.add(new KVMap("0","Yes"));
				yesnoNAMap.add(new KVMap("1","No"));
				yesnoNAMap.add(new KVMap("2","N/A"));
			}
			return yesnoNAMap;
		}
		if(_key.equals("monthsMap")){
			if(monthsMap == null ){
				monthsMap = new ArrayList<KVMap>();
				monthsMap.add(new KVMap("0","January"));
				monthsMap.add(new KVMap("1","February"));
				monthsMap.add(new KVMap("2","March"));
				monthsMap.add(new KVMap("3","April"));
				monthsMap.add(new KVMap("4","May"));
				monthsMap.add(new KVMap("5","June"));
				monthsMap.add(new KVMap("6","July"));
				monthsMap.add(new KVMap("7","August"));
				monthsMap.add(new KVMap("8","September"));
				monthsMap.add(new KVMap("9","October"));
				monthsMap.add(new KVMap("10","November"));
				monthsMap.add(new KVMap("11","December"));
			}
			return monthsMap;
		}
		if(_key.equals("cctvStatusMap")){
			if(cctvStatusMap == null ){
				cctvStatusMap = new ArrayList<KVMap>();
				List<CCTVStatus> list = Ebean.find(CCTVStatus.class).select("name").findList();
				for(CCTVStatus c : list){
					cctvStatusMap.add(new KVMap(String.valueOf(c.id),c.name));
				}
			}
			return cctvStatusMap;
		}
		if(_key.equals("percentMap")){
			if(percentMap == null ){
				percentMap = new ArrayList<KVMap>();
				percentMap.add(new KVMap("0","%"));
				percentMap.add(new KVMap("1","THB"));
			}
			return percentMap;
		}
		if(_key.equals("mealMap")){
			if(mealMap == null ){
				mealMap = new ArrayList<KVMap>();
				mealMap.add(new KVMap("0","BreakFast"));
				mealMap.add(new KVMap("1","Lunch"));
				mealMap.add(new KVMap("2","Dinner"));
				mealMap.add(new KVMap("3","Self Catering"));
			}
			return mealMap;
		}
		if(_key.equals("ageMap")){
			if(ageMap == null ){
				ageMap = new ArrayList<KVMap>();
				ageMap.add(new KVMap("0","10"));
				ageMap.add(new KVMap("1","11"));
				ageMap.add(new KVMap("2","12"));
				ageMap.add(new KVMap("3","13"));
			}
			return ageMap;
		}
		if(_key.equals("ratingMap")){
			if(ratingMap == null ){
				ratingMap = new ArrayList<KVMap>();
				ratingMap.add(new KVMap("0","Economy *"));
				ratingMap.add(new KVMap("1","Budget **"));
				ratingMap.add(new KVMap("2","Standard ***"));
				ratingMap.add(new KVMap("3","Superior ****"));
				ratingMap.add(new KVMap("3","Luxury *****"));
				ratingMap.add(new KVMap("3","Serviced Apartment"));
			}
			return ratingMap;
		}
		if(_key.equals("maxOccupancy")){
			if(maxOccupancyMap == null){
				maxOccupancyMap = new ArrayList<KVMap>();
				maxOccupancyMap.add(new KVMap("1", "1"));
				maxOccupancyMap.add(new KVMap("2", "2"));
				maxOccupancyMap.add(new KVMap("3", "3"));
				maxOccupancyMap.add(new KVMap("4", "4"));
				maxOccupancyMap.add(new KVMap("5", "5"));
				maxOccupancyMap.add(new KVMap("6", "6"));
				maxOccupancyMap.add(new KVMap("7", "7"));
				maxOccupancyMap.add(new KVMap("8", "8"));
				maxOccupancyMap.add(new KVMap("9", "9"));
				maxOccupancyMap.add(new KVMap("10", "10"));
			}
			return maxOccupancyMap;
		}
		if(_key.equals("childSharing")){
			if(childSharingMap == null){
				System.out.println("Here");
				childSharingMap = new ArrayList<KVMap>();
				childSharingMap.add(new KVMap("-1", "Please select"));
				childSharingMap.add(new KVMap("0", "0"));
				childSharingMap.add(new KVMap("1", "1"));
				childSharingMap.add(new KVMap("2", "2"));
				childSharingMap.add(new KVMap("3", "3"));
				childSharingMap.add(new KVMap("4", "4"));
				childSharingMap.add(new KVMap("5", "5"));
				childSharingMap.add(new KVMap("6", "6"));
			}
			return childSharingMap;
		}
		if(_key.equals("netRate")){
			if(netRateMap == null){
				System.out.println("Here");
				netRateMap = new ArrayList<KVMap>();
				netRateMap.add(new KVMap("1", "add to"));
				netRateMap.add(new KVMap("2", "% of "));
			}
			return netRateMap;
		}
		if(_key.equals("roomAmenityMap")){
			if(roomAmenityMap == null ){
				roomAmenityMap = new ArrayList<KVMap>();
				List<RoomAmenity> list = Ebean.find(RoomAmenity.class).select("name").findList();
				for(RoomAmenity r : list){
					roomAmenityMap.add(new KVMap(String.valueOf(r.code),r.name));
				}
			}
			return roomAmenityMap;
		}
		if(_key.equals("roomTypes")){
			if(roomTypesMap == null){
				roomTypesMap = new ArrayList<KVMap>();
				roomTypesMap.add(new KVMap("1", "Deluxe Room"));
				roomTypesMap.add(new KVMap("2", "Semi-Deluxe Room"));
				roomTypesMap.add(new KVMap("3", "Private Room"));
				roomTypesMap.add(new KVMap("4", "Semi-Private Room"));
			}
			return roomTypesMap;
		}
		if(_key.equals("freeStayType")){
			if(freeStayTypesMap == null){
				freeStayTypesMap = new ArrayList<KVMap>();
				freeStayTypesMap.add(new KVMap("1", "Standard Policy"));
				freeStayTypesMap.add(new KVMap("2", "First Night"));
				freeStayTypesMap.add(new KVMap("3", "Cheapest Night"));
				freeStayTypesMap.add(new KVMap("4", "Most Expensive Night/s"));
			}
			return freeStayTypesMap;
		}
		if(_key.equals("active")){
			if(activeMap == null){
				activeMap = new ArrayList<KVMap>();
				activeMap.add(new KVMap("1", "Draft"));
				activeMap.add(new KVMap("2", "Live"));
			}
			return activeMap;
		}
		if(_key.equals("applyCountry")){
			List<Country> countries = Country.find.all();
			if(applyCountryMap == null){
				applyCountryMap = new ArrayList<BuilderFactory.KVMap>();
				for(Country c : countries){
					applyCountryMap.add(new KVMap(c.id.toString(),c.name));
				}
			}
			return applyCountryMap;
		}
		if(_key.equals("statusMap")){
			if(statusMap == null){
				statusMap = new ArrayList<KVMap>();
				statusMap.add(new KVMap("Approved", "Approve"));
				statusMap.add(new KVMap("Disapproved", "Disapprove"));
				statusMap.add(new KVMap("Pending", "Pending"));
			}
			return statusMap;
		}
		
		if(_key.equals("specifyAllotment")){
			if(specifyAllotmentMap == null){
				specifyAllotmentMap = new ArrayList<KVMap>();
				specifyAllotmentMap.add(new KVMap("1", "Per Room Type"));
				specifyAllotmentMap.add(new KVMap("2", "Per Occupancy"));
			}
			return specifyAllotmentMap;
		}
		
		if(_key.equals("releasePeriod")){
			if(releasePeriodMap == null){
				releasePeriodMap = new ArrayList<KVMap>();
				releasePeriodMap.add(new KVMap("0", "--Choose--"));
				releasePeriodMap.add(new KVMap("1", "Same day up to check-in"));
				releasePeriodMap.add(new KVMap("2", "Same day up to 8 PM"));
				releasePeriodMap.add(new KVMap("3", "Same day up to 11 PM"));
				releasePeriodMap.add(new KVMap("4", "24 hours prior to check-in"));
				releasePeriodMap.add(new KVMap("5", "48 hours prior to check-in"));
				releasePeriodMap.add(new KVMap("5", "72 hours prior to check-in"));
				releasePeriodMap.add(new KVMap("5", "Other"));
			}
			return releasePeriodMap;
		}
		
		if(_key.equals("cutoff")){
			if(cutOffMap == null){
				cutOffMap = new ArrayList<KVMap>();
				cutOffMap.add(new KVMap("1", "1"));
				cutOffMap.add(new KVMap("2", "2"));
				cutOffMap.add(new KVMap("3", "3"));
				cutOffMap.add(new KVMap("4", "4"));
				cutOffMap.add(new KVMap("5", "5"));
				cutOffMap.add(new KVMap("6", "6"));
				cutOffMap.add(new KVMap("7", "7"));
				cutOffMap.add(new KVMap("8", "8"));
			}
			return cutOffMap;
		}
			if(_key.equals("daysMap")){
			if(daysMap == null){
				daysMap = new ArrayList<KVMap>();
				daysMap.add(new KVMap("0", "Sun"));
				daysMap.add(new KVMap("1", "Mon"));
				daysMap.add(new KVMap("2", "Tues"));
				daysMap.add(new KVMap("3", "Wed"));
				daysMap.add(new KVMap("4", "Thurs"));
				daysMap.add(new KVMap("5", "Fri"));
				daysMap.add(new KVMap("6", "Sat"));
			}
			return daysMap;
		}
		if(_key.equals("marketMap")){
			if(marketMap == null){
				marketMap = new ArrayList<KVMap>();
				marketMap.add(new KVMap("0", "India"));
				marketMap.add(new KVMap("1", "Dubai Airport"));
				marketMap.add(new KVMap("2", "Africa"));
				marketMap.add(new KVMap("3", "Algeria"));
				marketMap.add(new KVMap("4", "Angola "));
				marketMap.add(new KVMap("5", "Benin"));
				marketMap.add(new KVMap("6", "Fly Dubai"));
			}
			return marketMap;
		}
		
		if(_key.equals("penaltyPolicy")){
			if(penaltyPolicyMap == null){
				penaltyPolicyMap = new ArrayList<KVMap>();
				penaltyPolicyMap.add(new KVMap("0", ""));
				penaltyPolicyMap.add(new KVMap("1", "% of total Stay"));
			}
			return penaltyPolicyMap;
		}
		
		if(_key.equals("cancellationTime")){
			if(cancellationMap == null){
				cancellationMap = new ArrayList<KVMap>();
				cancellationMap.add(new KVMap("1", "Same Day By 18:00"));
				cancellationMap.add(new KVMap("2", "Same Day By 16:00"));
				cancellationMap.add(new KVMap("3", "Same Day By 12:00"));
				cancellationMap.add(new KVMap("4", "1 Day"));
				cancellationMap.add(new KVMap("5", "2 Days"));
				cancellationMap.add(new KVMap("6", "3 Days"));
				cancellationMap.add(new KVMap("7", "4 Days"));
				cancellationMap.add(new KVMap("8", "5 Days"));
				cancellationMap.add(new KVMap("9", "6 Days"));
			}
			return cancellationMap;
		}
		
		if(_key.equals("penaltyCharge")){
			if(penaltyChargeMap == null){
				penaltyChargeMap = new ArrayList<KVMap>();
				penaltyChargeMap.add(new KVMap("0", "Yes"));
				penaltyChargeMap.add(new KVMap("1", "% of total stay"));
			}
			return penaltyChargeMap;
		}
		
		if(_key.equals("nights")){
			if(nightsMap == null){
				nightsMap = new ArrayList<KVMap>();
				nightsMap.add(new KVMap("0", "1 night/s"));
				nightsMap.add(new KVMap("1", "2 night/s"));
				nightsMap.add(new KVMap("2", "3 night/s"));
				nightsMap.add(new KVMap("3", "4 night/s"));
				nightsMap.add(new KVMap("4", "5 night/s"));
				nightsMap.add(new KVMap("5", "6 night/s"));
				nightsMap.add(new KVMap("6", "7 night/s"));
				nightsMap.add(new KVMap("7", "8 night/s"));
				nightsMap.add(new KVMap("8", "9 night/s"));
				nightsMap.add(new KVMap("9", "10 night/s"));
			}
			return nightsMap;
		}
		
		if(_key.equals("percentage")){
			if(percentageMap == null){
				percentageMap = new ArrayList<KVMap>();
				percentageMap.add(new KVMap("0", "1%"));
				percentageMap.add(new KVMap("1", "2%"));
				percentageMap.add(new KVMap("2", "3%"));
				percentageMap.add(new KVMap("3", "4%"));
				percentageMap.add(new KVMap("4", "5%"));
				percentageMap.add(new KVMap("5", "6%"));
				percentageMap.add(new KVMap("6", "7%"));
				percentageMap.add(new KVMap("7", "8%"));
				percentageMap.add(new KVMap("8", "9%"));
				percentageMap.add(new KVMap("9", "10%"));
			}
			return percentageMap;
		}
		
		if(_key.equals("age")){
			if(ageInMap == null ){
				ageInMap = new ArrayList<KVMap>();
				ageInMap.add(new KVMap("1","1"));
				ageInMap.add(new KVMap("2","2"));
				ageInMap.add(new KVMap("3","3"));
				ageInMap.add(new KVMap("4","4"));
				ageInMap.add(new KVMap("5","5"));
				ageInMap.add(new KVMap("6","6"));
				ageInMap.add(new KVMap("7","7"));
				ageInMap.add(new KVMap("8","8"));
				ageInMap.add(new KVMap("9","9"));
				ageInMap.add(new KVMap("10","10"));
				ageInMap.add(new KVMap("11","11"));
				ageInMap.add(new KVMap("12","12"));
				ageInMap.add(new KVMap("13","13"));
				ageInMap.add(new KVMap("14","14"));
				ageInMap.add(new KVMap("15","15"));
				ageInMap.add(new KVMap("16","16"));
				ageInMap.add(new KVMap("17","17"));
				ageInMap.add(new KVMap("18","18"));
			}
			return ageInMap;
		}
		
		else{
			return null;
		}
	}
	
	public static String getNameByCodeFrom(String code, String mapName) throws Exception, IllegalAccessException, NoSuchFieldException, SecurityException{
		List<KVMap> list =  getByKey(mapName);
		for(KVMap kv: list) {
			if(kv.code.equalsIgnoreCase(code) ){
				return kv.name;
			}
		}
		return "";
	}
	
	public static Set<String> getNamesByCodesFrom(Set<String> codes, String mapName) throws Exception, IllegalAccessException, NoSuchFieldException, SecurityException{
		List<KVMap> list =  getByKey(mapName);
		
		Set<String> names = new HashSet<String>();
		for(String code : codes){
			for(KVMap kv: list) {
				if(kv.code.equalsIgnoreCase(code) ){
					names.add(kv.name);
				}
			}
		}
		
		return names;
	}
	
	public static class KVMap{
		public KVMap(String code,String name){
			this.code = code;
			this.name = name;
		}
		public String code;
		public String name;
	}
}
