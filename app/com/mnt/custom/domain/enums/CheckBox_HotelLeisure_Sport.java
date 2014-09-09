package com.mnt.custom.domain.enums;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonNode;

import play.libs.Json;

import com.mnt.custom.domain.enums.CheckBox_HotelBusinessFeature.EObject;

public enum CheckBox_HotelLeisure_Sport {

	cb_Arcade_Game_Room("Arcade / Game Room", 1),
	cb_BBQPicnic_area("BBQ/Picnic area", 2),
	cb_Duty_free_shop("Duty free shop", 3),
	cb_Fitness_Classes("Fitness Classes", 4),
	cb_Golf_Course("Golf Course", 5),
	cb_Gymnasium("Gymnasium", 6),	
	cb_Jacuzzi("Jacuzzi", 7),
	cb_Jogging_Track("Jogging Track", 8),
	cb_Kids_Club("Kids Club", 9),
	cb_Kids_Play_Ground("Kids Play Ground", 10),
	cb_Kids_Pool("Kids Pool", 11),
	cb_Live_entertainment("Live entertainment", 12),
	cb_OnSite_Beach("On-Site Beach", 13),	
	cb_Personal_Trainer_available("Personal Trainer available	", 14),
	cb_Poolside_snack_bar("Poolside snack bar", 15),
	cb_Sauna("Sauna", 16),
	cb_Scuba_Diving("Scuba Diving", 17),
	cb_Snow_sports("Snow sports", 18),
	cb_Spa("Spa", 19),
	cb_Squash_Court("Squash Court", 20),	
	cb_Steam_Room("Steam Room", 21),
	cb_Swimming_Pool_Indoor("Swimming Pool - Indoor	", 22),
	cb_Swimming_Pool_Outdoor("Swimming Pool- Outdoor	", 23),
	cb_Teen_Club("Teen Club", 24),
	cb_Tennis_Courts("Tennis Courts", 25),
	cb_Water_Sports("Water Sports", 26);
	
public static List<EObject> enumObject = null; 
	
	private CheckBox_HotelLeisure_Sport(String displayName,int value){
		this.displayName = displayName;
		this.value = value;
	}
	
	private String displayName;
	private int value;
	
	public static JsonNode toJSON(){
		if(enumObject ==null){
			enumObject = new ArrayList<EObject>();
			for(CheckBox_HotelLeisure_Sport cb : CheckBox_HotelLeisure_Sport.values()){
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
