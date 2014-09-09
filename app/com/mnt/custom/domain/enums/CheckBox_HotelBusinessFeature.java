package com.mnt.custom.domain.enums;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonNode;

import play.libs.Json;

public enum CheckBox_HotelBusinessFeature {
	
	cb_AV_Equipment_available("AV Equipment available", 1),
	cb_Conference_Rooms("Conference Rooms", 3),
	cb_Lounge_Access("Lounge Access for Club/Executive Rooms	", 3),
	cb_Meeting_Rooms("Meeting Rooms", 4),
	cb_PostCourier_services("Post/Courier services", 5),
	cb_Video_Conference("Video Conference", 6);
	
public static List<EObject> enumObject = null; 
	
	private CheckBox_HotelBusinessFeature(String displayName,int value){
		this.displayName = displayName;
		this.value = value;
	}
	
	private String displayName;
	private int value;
	
	public static JsonNode toJSON(){
		if(enumObject ==null){
			enumObject = new ArrayList<EObject>();
			for(CheckBox_HotelBusinessFeature cb : CheckBox_HotelBusinessFeature.values()){
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
