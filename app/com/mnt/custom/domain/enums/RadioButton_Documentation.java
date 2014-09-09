package com.mnt.custom.domain.enums;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonNode;

import play.libs.Json;

public enum RadioButton_Documentation {
	
	docu_1("Public Liability or indemnity insurance:",1,"Yes,No"),
	docu_2("Fire Risk Assessment / Certificate:",2,"Yes,No"),
	docu_3("Local Tourist authority license:",3,"Yes,No"),
	docu_4("Internal fire alarm testing logs:",4,"Yes,No"),
	docu_5("HACCP certificate:",5,"Yes,No"),
	docu_6("Staff training records for fire evacuation procedures:",6,"Yes,No"),
	docu_7("Public Liability or indemnity insurance:",7,"Yes,No"),
	docu_8("Staff training records for health & hygiene:",8,"Yes,No");
	
	private String displayName;
	private int value;
	private String type;
	
	RadioButton_Documentation(String displayName, int value, String type){
		this.displayName = displayName;
		this.value = value;
		this.type = type;
	}
	public static List<EObject> enumObject = null; 
	
	public static JsonNode toJSON(){
		if(enumObject ==null){
			enumObject = new ArrayList<EObject>();
			for(RadioButton_Documentation cb : RadioButton_Documentation.values()){
				enumObject.add(new EObject(cb.displayName,cb.value,"docu",cb.type));
			}
		}
		
		return Json.toJson(enumObject);
	}
	
	static class EObject{
		public String displayName;
		public int value;
		public String name;
		public String type;
		EObject(String displayName,int value,String name,String type){
			this.displayName =displayName;
			this.value = value;
			this.name = name;
			this.type = type;
		}
	}
}
