package com.mnt.custom.module.commons.controllers;

import java.util.ArrayList;
import java.util.List;

import com.mnt.custom.domain.BuilderFactory.KVMap;

import models.Country;
import play.data.DynamicForm;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class Commons extends Controller {
	
	public static Result getProvince(Long country){
		
		return ok(Json.toJson(Country.find.byId(country).myProvincesKVMap())).as("JSON");
	}
	
	public static Result getAdultOccupancy(){
		DynamicForm form = DynamicForm.form().bindFromRequest();
		System.out.println(form.data());
		Integer counter = Integer.parseInt(form.get("maxOccupancy"));
		List<KVMap> adultOccAsKVMap = new ArrayList<KVMap>();
		
		for(Integer i=0;i<=counter;i++){
			if(i==0){
				adultOccAsKVMap.add(new KVMap("0", "Please select"));
			}
			else
				adultOccAsKVMap.add(new KVMap(i.toString(), i.toString()));
		}
		return ok(Json.toJson(adultOccAsKVMap)).as("JSON");
	}

	public static Result getAdultChildOccupancy(){
		DynamicForm form = DynamicForm.form().bindFromRequest();
		System.out.println(form.data());
		Integer counter = Integer.parseInt(form.get("maxOccupancy"));
		List<KVMap> adultChildOccAsKVMap = new ArrayList<KVMap>();
		
		for(Integer i=0;i<=counter;i++){
			if(i==0){
				adultChildOccAsKVMap.add(new KVMap("0", "Please select"));
			}
			else
				adultChildOccAsKVMap.add(new KVMap(i.toString(), i.toString()));
		}
		return ok(Json.toJson(adultChildOccAsKVMap)).as("JSON");
	}
}
