package com.mnt.custom.domain.enums;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonNode;

import play.libs.Json;

public enum CheckBox_HotelAmenities {
	cb_24_hour_food_and_beverage_outlet("24-hour food and beverage outlet", 1),
	cb_Adjoining_rooms("Adjoining rooms", 2),
	cb_Air_Conditioning("Air Conditioning", 3),
	cb_Airport_Shuttle_Free("Airport Shuttle - Free", 4),
	cb_Airport_Shuttle_Paid("Airport Shuttle - Paid", 5),
	cb_ATM_Machine("ATM Machine", 6),
	cb_Baby_Sitting("Baby Sitting", 7),
	cb_Banquet_Hall("Banquet Hall", 8),
	cb_Bar("Bar", 9),
	cb_Barber_shop("Barber shop", 10),
	cb_Beauty_Salon("Beauty Salon", 11),
	cb_Bicycle_rentals("Bicycle rentals", 12),
	cb_Business_Centre("Business Centre", 13),
	cb_Car_Parking_Onsite_Free("Car Parking - Onsite Free", 14),
	cb_Car_Parking_Onsite_Paid("Car Parking - Onsite Paid", 15),
	cb_Car_Rental_Desk("Car Rental Desk", 16),
	cb_Casino("Casino", 17),
	cb_Children_not_allowed("Children not allowed", 18),
	cb_Childrens_nursery("Children's nursery", 19),
	cb_Complimentary_inroom_coffee_or_tea("Complimentary in-room coffee or tea", 20),
	cb_Complimentary_WiFi_access("Complimentary WiFi access", 21),
	cb_Concierge("Concierge", 22),
	cb_Doctor_on_call("Doctor on call", 23),
	cb_Driving_range("Driving range", 24),
	cb_Drugstorepharmacy("Drugstore/pharmacy", 25),
	cb_Dry_Hotel_Noalcohol_served("Dry Hotel – No alcohol served", 26),
	cb_DVDvideo_rental("DVD/video rental", 27),
	cb_Elevators("Elevators", 28),
	cb_Exhibitionconvention_Facilities("Exhibition/convention Facilities", 29),
	cb_Express_checkin("Express check-in", 30),
	cb_Express_checkout("Express check-out", 31),
	cb_Florist("Florist", 32),
	cb_Foreign_Currency_Exchange("Foreign Currency Exchange", 33),
	cb_Free_Ice_available("Free Ice available", 34),
	cb_Hair_Dresser("Hair Dresser", 35),
	cb_Halal_food_available("Halal food available", 36),
	cb_Hearing_impaired_services("Hearing impaired services", 37),
	cb_High_Speed_Internet("High Speed Internet", 38),
	cb_Housekeeping_daily("Housekeeping-daily", 39),
	cb_Housekeeping_weekly("Housekeeping-weekly", 40),
	cb_Kosher_food_available("Kosher food available", 41),
	cb_Laundry_Service("Laundry Service", 42),
	cb_Library("Library", 43),
	cb_Limited_Time_Reception("Limited Time Reception", 44),
	cb_Limousine_service_Paid("Limousine service - Paid", 45),
	cb_Local_Shuttle_Free("Local Shuttle - Free", 46),
	cb_Long_term_parking("Long term parking", 47),
	cb_Multilingual_Staff("Multilingual Staff", 48),
	cb_Night_Club("Night Club", 49),
	cb_Pets_Allowed("Pets Allowed", 50),
	cb_Porterage("Porterage", 51),
	cb_Ramp_access("Ramp access", 52),
	cb_Restaurant("Restaurant", 53),
	cb_Room_service24_hours("Room service - 24 hours", 54),
	cb_Room_service_limited_hours("Room service-limited hours", 55),
	cb_Safety_Deposit_Box("Safety Deposit Box", 56),
	cb_Shopping_Arcade("Shopping Arcade", 57),
	cb_Tour_Desk("Tour Desk", 58),
	cb_Valet_Parking("Valet Parking", 59),
	cb_Wheelchair_Access("Wheelchair Access", 60);
	
	public static List<EObject> enumObject = null; 
	
	private CheckBox_HotelAmenities(String displayName,int value){
		this.displayName = displayName;
		this.value = value;
	}
	
	private String displayName;
	private int value;
	
	public static JsonNode toJSON(){
		if(enumObject ==null){
			enumObject = new ArrayList<EObject>();
			for(CheckBox_HotelAmenities cb : CheckBox_HotelAmenities.values()){
				enumObject.add(new EObject(cb.displayName,cb.value));
			}
		}
		
		return Json.toJson(enumObject);
	}
	
	static class EObject{
		public String displayName;
		public int value;
		EObject(String displayName,int value){
			this.displayName =displayName;
			this.value = value;
		}
	}
}
