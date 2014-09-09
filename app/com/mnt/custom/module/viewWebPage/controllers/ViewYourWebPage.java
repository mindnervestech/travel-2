package com.mnt.custom.module.viewWebPage.controllers;

import java.util.List;
import java.util.Set;

import models.hotelimage.HotelImage;
import models.suppliers.AreaAttractionModel;
import models.suppliers.HotelAmenitiesModel;
import models.suppliers.HotelBusinessAmenitiesModel;
import models.suppliers.HotelDescriptionModal;
import models.suppliers.HotelLeisureAmenitiesModel;
import models.suppliers.HotelTransportationModel;
import models.suppliers.ProfieGeneralInformationModel;

import org.apache.commons.beanutils.BeanUtilsBean;

import play.mvc.Controller;
import play.mvc.Result;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.mnt.core.helper.UIGeneratorHelper;
import com.mnt.custom.domain.BuilderFactory;
import com.mnt.custom.module.viewWebPage.viewmodel.ViewPageVM;

public class ViewYourWebPage extends Controller{
	
	public static Result profile(){
		return ok(com.mnt.custom.module.viewWebPage.views.html.viewYourPage.render());
	}
	
	public static Result getViewWebPageInformationPage(){
		
		UIGeneratorHelper helper = new UIGeneratorHelper(ViewPageVM.class);
		return ok(com.mnt.custom.module.viewWebPage.views.html.viewPage.render(helper));
	}
	
	public static Result generateViewWebPageInfoScript(){
	
		UIGeneratorHelper helper = new UIGeneratorHelper(ViewPageVM.class);
		return ok(views.html.script.render(helper)).as("application/javascript");
	}
	
	public static Result getViewWebPageInfoJson() throws NoSuchFieldException, SecurityException, Exception{
		ViewPageVM viewPageVM = new ViewPageVM();
		String supplierIdFromSession = session().get("id");
		
		viewPageVM.hotelAmenities = Lists.newArrayList();
		viewPageVM.hotelBusinessAmenities = Lists.newArrayList();
		viewPageVM.hotelLeisureAmenities = Lists.newArrayList();
		
		ProfieGeneralInformationModel generalInformationModel = ProfieGeneralInformationModel.bySupplierId(Long.valueOf(supplierIdFromSession));
		if (generalInformationModel != null) {
			BeanUtilsBean.getInstance().copyProperties(viewPageVM, generalInformationModel);
		}
		
		HotelDescriptionModal hotelDescriptionModel = HotelDescriptionModal.bySupplierId(Long.valueOf(supplierIdFromSession));
		if (hotelDescriptionModel != null) {
			BeanUtilsBean.getInstance().copyProperties(viewPageVM, hotelDescriptionModel);
			String nightLife = BuilderFactory.getNameByCodeFrom(hotelDescriptionModel.nightLife, "nightLife");
			viewPageVM.nightLife = nightLife;
			String locationArea = BuilderFactory.getNameByCodeFrom(hotelDescriptionModel.locationArea, "locationArea");
			viewPageVM.locationArea = locationArea;
			String shoppingFacility = BuilderFactory.getNameByCodeFrom(hotelDescriptionModel.shoppingFacility, "shoppingFacility");
			viewPageVM.shoppingFacility = shoppingFacility;
		}
		
		HotelAmenitiesModel hotelAmenitiesModel = HotelAmenitiesModel.bySupplierId(Long.valueOf(supplierIdFromSession));
		if (hotelAmenitiesModel != null) {
			if(hotelAmenitiesModel.hotelAmenitiesWithCommas != null ){
				Iterable<String> hotelAmenitiesAsItr = Splitter.on(",").omitEmptyStrings().trimResults().split(hotelAmenitiesModel.hotelAmenitiesWithCommas);
				Set<String> hotelAmenities = Sets.newHashSet(hotelAmenitiesAsItr);
				hotelAmenities = BuilderFactory.getNamesByCodesFrom(hotelAmenities,"hotelAmenitiesMap");
				viewPageVM.hotelAmenities.addAll(hotelAmenities);
			}
		BeanUtilsBean.getInstance().copyProperties(viewPageVM, hotelAmenitiesModel);
		}
		
		HotelBusinessAmenitiesModel hotelBusinessAmenitiesModel = HotelBusinessAmenitiesModel.bySupplierId(Long.valueOf(supplierIdFromSession));
		if (hotelBusinessAmenitiesModel != null) {
			if(hotelBusinessAmenitiesModel.hotelBusinessAmenitiesWithCommas != null ){
				Iterable<String> hotelBusinessAmenitiesAsItr = Splitter.on(",").omitEmptyStrings().trimResults().split(hotelBusinessAmenitiesModel.hotelBusinessAmenitiesWithCommas);
				Set<String> hotelBusinessAmenities = Sets.newHashSet(hotelBusinessAmenitiesAsItr);
				hotelBusinessAmenities = BuilderFactory.getNamesByCodesFrom(hotelBusinessAmenities,"hotelBusinessAmenitiesMap");
				viewPageVM.hotelBusinessAmenities.addAll(hotelBusinessAmenities);
			}
		BeanUtilsBean.getInstance().copyProperties(viewPageVM, hotelBusinessAmenitiesModel);
		}
		
		HotelLeisureAmenitiesModel hotelLeisureAmenitiesModel = HotelLeisureAmenitiesModel.bySupplierId(Long.valueOf(supplierIdFromSession));
		if (hotelLeisureAmenitiesModel != null) {
			if(hotelLeisureAmenitiesModel.hotelLeisureAmenitiesWithCommas != null ){
				Iterable<String> hotelLeisureAmenitiesAsItr = Splitter.on(",").omitEmptyStrings().trimResults().split(hotelLeisureAmenitiesModel.hotelLeisureAmenitiesWithCommas);
				Set<String> hotelLeisureAmenities = Sets.newHashSet(hotelLeisureAmenitiesAsItr);
				try {
					hotelLeisureAmenities  = BuilderFactory.getNamesByCodesFrom(hotelLeisureAmenities,"hotelLeisureAmenitiesMap");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				viewPageVM.hotelLeisureAmenities.addAll(hotelLeisureAmenities);
			}
		BeanUtilsBean.getInstance().copyProperties(viewPageVM, hotelLeisureAmenitiesModel);
		}
		
		AreaAttractionModel areaAttractionModel = AreaAttractionModel.bySupplierId(Long.valueOf(supplierIdFromSession));
		if (areaAttractionModel != null) {
		BeanUtilsBean.getInstance().copyProperties(viewPageVM, areaAttractionModel);
		String areaParameter = BuilderFactory.getNameByCodeFrom(areaAttractionModel.areaParameter1, "parameterMap");
		viewPageVM.areaParameter1 = areaParameter;
		}
		
		HotelTransportationModel hotelTransportationModel = HotelTransportationModel.bySupplierId(Long.valueOf(supplierIdFromSession));
		if (hotelTransportationModel != null) {
		BeanUtilsBean.getInstance().copyProperties(viewPageVM, hotelTransportationModel);
		String airportParameter1 = BuilderFactory.getNameByCodeFrom(hotelTransportationModel.airportParameter1, "parameterMap");
		viewPageVM.airportParameter1 = airportParameter1;
		}
		
		List<HotelImage> hotelImage = HotelImage.find.where().eq("supplier.id",Long.parseLong(supplierIdFromSession)).findList();
		if(hotelImage.get(0).imageBytes != null)
				viewPageVM.imageId1 = "/getImageById/"+hotelImage.get(0).id.toString();
		if(hotelImage.get(1).imageBytes != null)
				viewPageVM.imageId2 = "/getImageById/"+hotelImage.get(1).id.toString();		
		if(hotelImage.get(2).imageBytes != null)
				viewPageVM.imageId3 = "/getImageById/"+hotelImage.get(2).id.toString();
		if(hotelImage.get(3).imageBytes != null)
				viewPageVM.imageId4 = "/getImageById/"+hotelImage.get(3).id.toString();
		
		return ok(play.libs.Json.toJson(viewPageVM)).as("JSON");
	}
	
	public static Result saveSupplierViewWebPageInfo(){
			return ok("/");
	}


}
