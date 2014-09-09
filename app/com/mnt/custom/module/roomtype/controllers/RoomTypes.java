package com.mnt.custom.module.roomtype.controllers;

import static play.data.Form.form;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

import models.suppliers.Supplier;
import models.suppliers.roomtype.RoomTypeModel;

import org.apache.commons.beanutils.BeanUtilsBean;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.mnt.core.helper.UIGeneratorHelper;
import com.mnt.custom.module.roomtype.viewmodel.RoomType;
import com.mnt.custom.module.roomtype.viewmodel.RoomType.RepeatChildrenPolicy;
import com.mnt.custom.module.roomtype.views.html.addRoomType;
import com.mnt.custom.module.roomtype.views.html.roomTypes;

public class RoomTypes extends Controller {
	
	public static Result profile(){
		return ok(roomTypes.render(true));
	}
	
	public static Result saveRoomTypes() throws IllegalAccessException, InvocationTargetException{
		Form<RoomType> roomTypeVMForm = form(RoomType.class).bindFromRequest();
		System.out.println(roomTypeVMForm.data());
		String supplierIdFromSession = session().get("id");
		RoomTypeModel roomTypeModel = RoomTypeModel.bySupplierId(Long.valueOf(supplierIdFromSession));
		/*if (roomTypeModel == null) {
			roomTypeModel = new RoomTypeModel();
			BeanUtilsBean.getInstance().copyProperties(roomTypeModel, roomTypeVMForm.get());
			Object[] array = roomTypeVMForm.get().roomAmenities.toArray();
			roomTypeModel.roomAmenitiesWithCommas = Joiner.on(",").skipNulls().join(array);
			roomTypeModel.supplierObject = Supplier.find.byId(Long.valueOf(supplierIdFromSession));
			roomTypeModel.save();
		} else {
			BeanUtilsBean.getInstance().copyProperties(roomTypeModel, roomTypeVMForm.get());
			Object[] array = roomTypeVMForm.get().roomAmenities.toArray();
			roomTypeModel.roomAmenitiesWithCommas = Joiner.on(",").skipNulls().join(array);
			roomTypeModel.supplierObject = Supplier.find.byId(Long.valueOf(supplierIdFromSession));
			roomTypeModel.update();
		}*/
		return ok("DATA IS SUCCESSFULLY UPDATED");
	}
	
	public static Result getRoomTypesJson() throws IllegalAccessException, InvocationTargetException{
		RoomType roomType = new RoomType();
		roomType.roomAmenities = Lists.newArrayList();
		roomType.repeatChildrenPolicy = Lists.newArrayList(new RepeatChildrenPolicy());
		String supplierIdFromSession = session().get("id");
		RoomTypeModel roomTypeModel = RoomTypeModel.bySupplierId(Long.valueOf(supplierIdFromSession));
		if (roomTypeModel != null) {
			if(roomTypeModel.roomAmenitiesWithCommas != null ){
				Iterable<String> roomAmenitiesOptionsAsItr = Splitter.on(",").omitEmptyStrings().trimResults().split(roomTypeModel.roomAmenitiesWithCommas);
				Set<String> roomAmenitiesOptions = Sets.newHashSet(roomAmenitiesOptionsAsItr);
				roomType.roomAmenities.addAll(roomAmenitiesOptions);
			}
		BeanUtilsBean.getInstance().copyProperties(roomType, roomTypeModel);
		}
		return ok(play.libs.Json.toJson(roomType)).as("JSON");
	}
	
	public static Result generateRoomTypesScript(){
		UIGeneratorHelper helper = new UIGeneratorHelper(RoomType.class);
		return ok(views.html.script.render(helper)).as("application/javascript");
	}
	
	public static Result getRoomTypes(){
		UIGeneratorHelper helper = new UIGeneratorHelper(RoomType.class);
		return ok(addRoomType.render(helper));
	}
	
}
