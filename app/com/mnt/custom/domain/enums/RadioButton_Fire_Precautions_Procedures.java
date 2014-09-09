package com.mnt.custom.domain.enums;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonNode;

import play.libs.Json;

public enum RadioButton_Fire_Precautions_Procedures {
	firePP_1("Does the hotel have a working fire alarm:",11,"Yes,No,NA"),
	firePP_2("Are there smoke detectors in public areas:",12,"Yes,No,NA"),
	firePP_3("Are there smoke detectors in guest bedrooms:",13,"Yes,No,NA"),
	firePP_4("Are there smoke detectors in apartments (where applicable):",4,"Yes,No,NA"),
	firePP_5("Does the supplier service the system at least annually:",5,"Yes,No,NA"),
	firePP_6("Do you carry out regular internal fire alarm tests:",16,"Yes,No,NA"),
	firePP_7("Are there fire extinguishers in all public areas:",7,"Yes,No,NA"),
	firePP_8("Is emergency lighting installed in the property:",8,"Yes,No,NA"),
	firePP_9("Can a person of limited walking abilities access the hotel and grounds",9,"Yes,No,NA");
	
	private String displayName;
	private int value;
	private String type;
	
	RadioButton_Fire_Precautions_Procedures(String displayName, int value, String type){
		this.displayName = displayName;
		this.value = value;
		this.type = type;
	}
	public static List<EObject> enumObject = null; 
	
	public static JsonNode toJSON(){
		if(enumObject ==null){
			enumObject = new ArrayList<EObject>();
			for(RadioButton_Fire_Precautions_Procedures cb : RadioButton_Fire_Precautions_Procedures.values()){
				enumObject.add(new EObject(cb.displayName,cb.value,"firePP",cb.type));
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
