package com.mnt.custom.module.specials.controllers;

import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;

import com.google.common.collect.Lists;
import com.mnt.core.helper.UIGeneratorHelper;
import com.mnt.custom.module.specials.viewmodel.Special;
import com.mnt.custom.module.specials.viewmodel.Special.RepeatPeriodSection;
import com.mnt.custom.module.specials.viewmodel.Special.RepeatPeriodSection.RepeatMarket;
import com.mnt.custom.module.specials.views.html.createSpecials;
import com.mnt.custom.module.specials.views.html.specials;

public class Specials extends Controller {
	
	public static Result profile(){
		return ok(specials.render(false));
	}
	
	public static Result saveSpecials(){
		DynamicForm dynamicForm = new DynamicForm().bindFromRequest();
		System.out.println(dynamicForm.data());
		return ok();
	}
	
	public static Result getSpecialsJson(){
		Special special = new Special();
		special.repeatPeriodSection = Lists.newArrayList(new RepeatPeriodSection());
		special.repeatPeriodSection.get(0).repeatMarkets = Lists.newArrayList(new RepeatMarket());
		return ok(play.libs.Json.toJson(special)).as("JSON");
	}
	
	public static Result generateSpecialsScript(){
		UIGeneratorHelper helper = new UIGeneratorHelper(Special.class);
		return ok(views.html.script.render(helper)).as("application/javascript");
	}
	
	public static Result getSpecials(){
		UIGeneratorHelper helper = new UIGeneratorHelper(Special.class);
		return ok(createSpecials.render(helper));
	}
}
