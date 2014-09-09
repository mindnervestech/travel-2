package com.mnt.custom.domain.enums;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonNode;

import play.libs.Json;

public enum CheckBox_HotelType {
	
	cb_Airport_Appartment("Airport Appartment",1),
	cb_Airport_Hotel("Airport Hotel",2),
	cb_All_Suite("All Suite",3),
	cb_Art_Decor("Art Decor",4),
	cb_Beach_Apartment("Beach Apartment",5),
	cb_Beach_Resort("Beach Resort", 6),
	cb_Boutique("Boutique", 7),
	cb_Business("Business", 8),
	cb_Camp_Site("Camp Site", 9),
	cb_Child_Friendly("Child Friendly", 10),
	cb_City_apartment("City apartment", 11),
	cb_City_hotel("City hotel", 12),
	cb_Colonial_Style("Colonial Style", 13),
	cb_Desert_Resort("Desert Resort", 14),
	cb_Design_Trendy("Design Trendy", 15),
	cb_Diving_Resort("Diving Resort", 16),
	cb_Eco_Friendly("Eco Friendly", 17),
	cb_Equestrian_Resort("Equestrian Resort", 18),
	cb_Family_Style("Family Style", 19),
	cb_Floatel("Floatel", 20),
	cb_Full_Service("Full Service", 21),
	cb_Golf_Resort("Golf Resort", 22),
	cb_Health_Resort("Health Resort", 23),
	cb_Heritage_Building("Heritage Building", 24),
	cb_Honeymoon("Honeymoon", 25),
	cb_Leisure("Leisure", 26),
	cb_Limited_Service("Limited Service", 27),
	cb_Lodge("Lodge", 28),
	cb_Modern("Modern", 29),
	cb_Motel("Motel", 30),
	cb_Pet_Friendly("Pet Friendly", 31),
	cb_Polo_Resort("Polo Resort", 32),
	cb_Renaissance_Style("Renaissance Style", 33),
	cb_Resort("Resort", 34),
	cb_Ski_Resort("Ski Resort", 35),
	cb_Spa_Resort("Spa Resort", 36),
	cb_Sports_Resort("Sports Resort", 37),
	cb_Tourist("Tourist", 38),
	cb_Traditional("Traditional", 39),
	cb_Villa_Apartment("Villa Apartment", 40),
	cb_Villa_Resort("Villa Resort", 41);
	
	public static List<EObject> enumObject = null; 
	
	private CheckBox_HotelType(String displayName,int value){
		this.displayName = displayName;
		this.value = value;
	}
	
	private String displayName;
	private int value;
	
	public static JsonNode toJSON(){
		if(enumObject ==null){
			enumObject = new ArrayList<EObject>();
			for(CheckBox_HotelType cb : CheckBox_HotelType.values()){
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
