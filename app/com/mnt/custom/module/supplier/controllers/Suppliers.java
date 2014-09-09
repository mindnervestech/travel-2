package com.mnt.custom.module.supplier.controllers;


import static play.data.Form.form;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Set;

import models.Country;
import models.suppliers.AreaAttractionModel;
import models.suppliers.BusinessCommunicationModel;
import models.suppliers.HotelAmenitiesModel;
import models.suppliers.HotelBillingInformationModel;
import models.suppliers.HotelBusinessAmenitiesModel;
import models.suppliers.HotelContactInformationModel;
import models.suppliers.HotelDescriptionModal;
import models.suppliers.HotelHealthSafetyModel;
import models.suppliers.HotelInternalInformationModel;
import models.suppliers.HotelLeisureAmenitiesModel;
import models.suppliers.HotelLocationModel;
import models.suppliers.HotelTransportationModel;
import models.suppliers.MealOverlayModel;
import models.suppliers.ProfieGeneralInformationModel;
import models.suppliers.Supplier;

import org.apache.commons.beanutils.BeanUtilsBean;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.mnt.core.helper.UIGeneratorHelper;
import com.mnt.custom.module.supplier.viewmodel.AreaAttractions;
import com.mnt.custom.module.supplier.viewmodel.BusinessCommunication;
import com.mnt.custom.module.supplier.viewmodel.HotelAdditionalInformation;
import com.mnt.custom.module.supplier.viewmodel.HotelAdditionalInformation.RepeatSupplementSections;
import com.mnt.custom.module.supplier.viewmodel.HotelAdditionalInformation.RepeatTaxSections;
import com.mnt.custom.module.supplier.viewmodel.HotelAdditionalMandatoryInfo;
import com.mnt.custom.module.supplier.viewmodel.HotelAdditionalMandatoryInfo.RepeatMandatorySections;
import com.mnt.custom.module.supplier.viewmodel.HotelAdditionalMandatoryInfo.RepeatMandatorySections1;
import com.mnt.custom.module.supplier.viewmodel.HotelAmenities;
import com.mnt.custom.module.supplier.viewmodel.HotelBillingInformation;
import com.mnt.custom.module.supplier.viewmodel.HotelBusinessAmenities;
import com.mnt.custom.module.supplier.viewmodel.HotelContactInformation;
import com.mnt.custom.module.supplier.viewmodel.HotelDescription;
import com.mnt.custom.module.supplier.viewmodel.HotelHealthSafety;
import com.mnt.custom.module.supplier.viewmodel.HotelInternalInformation;
import com.mnt.custom.module.supplier.viewmodel.HotelLeisureAmenities;
import com.mnt.custom.module.supplier.viewmodel.HotelLocation;
import com.mnt.custom.module.supplier.viewmodel.HotelTransportatin;
import com.mnt.custom.module.supplier.viewmodel.MealOverlay;
import com.mnt.custom.module.supplier.viewmodel.MealOverlay.RepeatChildMealRateSections;
import com.mnt.custom.module.supplier.viewmodel.ProfileGeneralInformation;

public class Suppliers extends Controller {

	// Profile Page Calling Function
	public static Result profile(){
		return ok(com.mnt.custom.module.supplier.views.html.profile.render(false));
	}
	
	public static Result showProfile(){
		return ok(com.mnt.custom.module.supplier.views.html.profile.render(true));
	}
	
	public static Result mealSection(){
		return ok(com.mnt.custom.module.supplier.views.html.mealSection9.render());
	}
	// Profile Page Calling Function End
	
	
	// Section 1 start
	
	public static Result getGeneralInformation(){
	
		UIGeneratorHelper helper = new UIGeneratorHelper(ProfileGeneralInformation.class);
		return ok(com.mnt.custom.module.supplier.views.html.general_profile.render(helper));
	}
	
	public static Result generateGeneralInformationScript(){
	
		UIGeneratorHelper helper = new UIGeneratorHelper(ProfileGeneralInformation.class);
		return ok(views.html.script.render(helper)).as("application/javascript");
	}
	
	public static Result getGeneralInformationJson() throws IllegalAccessException, InvocationTargetException{

		ProfileGeneralInformation generalInformationViewModel = new ProfileGeneralInformation();
		
		String supplierIdFromSession = session().get("id");
		ProfieGeneralInformationModel generalInformationModel = ProfieGeneralInformationModel.bySupplierId(Long.valueOf(supplierIdFromSession));
		
		if (generalInformationModel != null) {
		BeanUtilsBean.getInstance().copyProperties(generalInformationViewModel, generalInformationModel);
		
		if (generalInformationModel.country != null) {
			generalInformationViewModel.provinceMap = Country.find.byId(
					Long.valueOf(generalInformationModel.country)).myProvincesKVMap();
			}
		}
		
		return ok(play.libs.Json.toJson(generalInformationViewModel)).as("JSON");
	}
	
	public static Result saveSupplierGeneralInformation(){
		
		Form<ProfieGeneralInformationModel> profieGeneralInformationForm = form(ProfieGeneralInformationModel.class).bindFromRequest();
		String supplierIdFromSession = session().get("id");
		ProfieGeneralInformationModel profieGeneralInformationModal = ProfieGeneralInformationModel.bySupplierId(Long.valueOf(supplierIdFromSession));
		if (profieGeneralInformationModal == null) {
			profieGeneralInformationModal = new ProfieGeneralInformationModel();
			profieGeneralInformationModal = profieGeneralInformationForm.get();
			profieGeneralInformationModal.supplierObject = Supplier.find.byId(Long.valueOf(supplierIdFromSession));
			profieGeneralInformationModal.save();
			Supplier supplier = Supplier.find.byId(Long.valueOf(supplierIdFromSession));
			supplier.generalInformation = profieGeneralInformationModal;
			supplier.update();
		} else {
			profieGeneralInformationModal.update();
		}
		
		return ok("DATA IS SUCCESSFULLY UPDATED");
	}
	
	// Section 1 End
	
	// Section 2 Start
	
	public static Result getHotelDescriptionInformationPage(){
		UIGeneratorHelper helper = new UIGeneratorHelper(HotelDescription.class);
		return ok(com.mnt.custom.module.supplier.views.html.hotel_description_section2.render(helper));
	}
	
	public static Result generateHotelDescriptionScript(){
		UIGeneratorHelper helper = new UIGeneratorHelper(HotelDescription.class);
		return ok(views.html.script.render(helper)).as("application/javascript");
	}
	
	public static Result getHotelDescriptionJson() throws IllegalAccessException, InvocationTargetException{
		HotelDescription hotelDescriptionViewModel = new HotelDescription();
		hotelDescriptionViewModel.hotelDescriptionOptions = Lists.newArrayList();
		String supplierIdFromSession = session().get("id");
		HotelDescriptionModal hotelDescriptionModel = HotelDescriptionModal.bySupplierId(Long.valueOf(supplierIdFromSession));
		if (hotelDescriptionModel != null) {
			if(hotelDescriptionModel.hotelDescriptionOptionWithCommas != null ){
				Iterable<String> hotelDescriptionOptionsAsItr = Splitter.on(",").omitEmptyStrings().trimResults().split(hotelDescriptionModel.hotelDescriptionOptionWithCommas);
				Set<String> hotelDescriptionOptions = Sets.newHashSet(hotelDescriptionOptionsAsItr);
				hotelDescriptionViewModel.hotelDescriptionOptions.addAll(hotelDescriptionOptions);
			}
		BeanUtilsBean.getInstance().copyProperties(hotelDescriptionViewModel, hotelDescriptionModel);
		}
		return ok(play.libs.Json.toJson(hotelDescriptionViewModel)).as("JSON");
	}
	
	public static Result saveSupplierHotelDescription() throws IllegalAccessException, InvocationTargetException
	{
		Form<HotelDescription> hotelDescriptionVMForm = form(HotelDescription.class).bindFromRequest();
		System.out.println(hotelDescriptionVMForm.data());
		String supplierIdFromSession = session().get("id");
		HotelDescriptionModal hotelDescriptionModel = HotelDescriptionModal.bySupplierId(Long.valueOf(supplierIdFromSession));
		if (hotelDescriptionModel == null) {
			hotelDescriptionModel = new HotelDescriptionModal();
			BeanUtilsBean.getInstance().copyProperties(hotelDescriptionModel, hotelDescriptionVMForm.get());
			Object[] array = hotelDescriptionVMForm.get().hotelDescriptionOptions.toArray();
			hotelDescriptionModel.hotelDescriptionOptionWithCommas = Joiner.on(",").skipNulls().join(array);
			hotelDescriptionModel.supplierObject = Supplier.find.byId(Long.valueOf(supplierIdFromSession));
			hotelDescriptionModel.save();
			Supplier supplier = Supplier.find.byId(Long.valueOf(supplierIdFromSession));
			supplier.descriptionModal = hotelDescriptionModel;
			supplier.update();

		} else {
			BeanUtilsBean.getInstance().copyProperties(hotelDescriptionModel, hotelDescriptionVMForm.get());
			Object[] array = hotelDescriptionVMForm.get().hotelDescriptionOptions.toArray();
			hotelDescriptionModel.hotelDescriptionOptionWithCommas = Joiner.on(",").skipNulls().join(array);
			hotelDescriptionModel.update();
		}
		return ok("DATA IS SUCCESSFULLY UPDATED");
	}
	
	// Section 2 End
	
	// Section 3 Start

	public static Result getHotelLocationInformationPage()
	{
		UIGeneratorHelper helper = new UIGeneratorHelper(HotelLocation.class);
		return ok(com.mnt.custom.module.supplier.views.html.hotel_location_section3.render(helper));
	}
	
	public static Result generateHotelLocationScript(){
		UIGeneratorHelper helper = new UIGeneratorHelper(HotelLocation.class);
		return ok(views.html.script.render(helper)).as("application/javascript");
	}
	
	public static Result getHotelLocationJson() throws IllegalAccessException, InvocationTargetException{
		HotelLocation hotelLocationVM = new HotelLocation();
		String supplierIdFromSession = session().get("id");
		HotelLocationModel hotelLocationModel = HotelLocationModel.bySupplierId(Long.valueOf(supplierIdFromSession));
		if (hotelLocationModel != null) {
		BeanUtilsBean.getInstance().copyProperties(hotelLocationVM, hotelLocationModel);
		}
		return ok(play.libs.Json.toJson(hotelLocationVM)).as("JSON");
	}
	
	public static Result saveSupplierHotelLocation(){
		Form<HotelLocationModel> hotelLocationModelForm = form(HotelLocationModel.class).bindFromRequest();
		String supplierIdFromSession = session().get("id");
		HotelLocationModel hotelLocationModel = HotelLocationModel.bySupplierId(Long.valueOf(supplierIdFromSession));
		if (hotelLocationModel == null) {
			hotelLocationModel = new HotelLocationModel();
			hotelLocationModel = hotelLocationModelForm.get();
			hotelLocationModel.supplierObject = Supplier.find.byId(Long.valueOf(supplierIdFromSession));
			hotelLocationModel.save();
			Supplier supplier = Supplier.find.byId(Long.valueOf(supplierIdFromSession));
			supplier.hotelLocationModel = hotelLocationModel;
			supplier.update();
		} else {
			hotelLocationModel.update();
		}
		return ok("DATA IS SUCCESSFULLY UPDATED");
	}
	// Section 3 End
	
	// Section 4 Start
	
	public static Result getHotelInternalInformationPage(){
		UIGeneratorHelper helper = new UIGeneratorHelper(HotelInternalInformation.class);
		return ok(com.mnt.custom.module.supplier.views.html.hotel_internal_information_section4.render(helper));
	}
	
	public static Result generateHotelInternalInfoScript(){
		UIGeneratorHelper helper = new UIGeneratorHelper(HotelInternalInformation.class);
		return ok(views.html.script.render(helper)).as("application/javascript");
	}
	
	public static Result getHotelInternalInfoJson() throws IllegalAccessException, InvocationTargetException{
		HotelInternalInformation hotelInternalInformationVM = new HotelInternalInformation();
		String supplierIdFromSession = session().get("id");
		HotelInternalInformationModel hotelInternalInformationModel =HotelInternalInformationModel.bySupplierId(Long.valueOf(supplierIdFromSession));
		if (hotelInternalInformationModel != null) {
		BeanUtilsBean.getInstance().copyProperties(hotelInternalInformationVM, hotelInternalInformationModel);
		}
		
		return ok(play.libs.Json.toJson(hotelInternalInformationVM)).as("JSON");
	}

	public static Result saveSupplierHotelInternalInfo(){
		Form<HotelInternalInformationModel> hotelInternalInformationModelForm = form(HotelInternalInformationModel.class).bindFromRequest();
		String supplierIdFromSession = session().get("id");
		HotelInternalInformationModel hotelInternalInformationModel = HotelInternalInformationModel.bySupplierId(Long.valueOf(supplierIdFromSession));
		if (hotelInternalInformationModel == null) {
			hotelInternalInformationModel = new HotelInternalInformationModel();
			hotelInternalInformationModel = hotelInternalInformationModelForm.get();
			hotelInternalInformationModel.supplierObject = Supplier.find.byId(Long.valueOf(supplierIdFromSession));
			hotelInternalInformationModel.save();
			Supplier supplier = Supplier.find.byId(Long.valueOf(supplierIdFromSession));
			supplier.hotelInternalInformationModel = hotelInternalInformationModel;
			supplier.update();
		} else {
			hotelInternalInformationModel.update();
		}
		return ok("DATA IS SUCCESSFULLY UPDATED");
	}
	// Section 4 End
	
	// Section 5 Start
	
	public static Result getHotelContactInformationPage(){
		UIGeneratorHelper helper = new UIGeneratorHelper(HotelContactInformation.class);
		return ok(com.mnt.custom.module.supplier.views.html.hotel_contact_information_section5.render(helper));
	}
	
	public static Result generateHotelContactInfoScript(){
		UIGeneratorHelper helper = new UIGeneratorHelper(HotelContactInformation.class);
		return ok(views.html.script.render(helper)).as("application/javascript");
	}
	
	public static Result getHotelContactInfoJson() throws IllegalAccessException, InvocationTargetException{
		
		HotelContactInformation hotelContactInformationVM = new HotelContactInformation();
		String supplierIdFromSession = session().get("id");
		HotelContactInformationModel hotelContactInformationModel =HotelContactInformationModel.bySupplierId(Long.valueOf(supplierIdFromSession));
		if (hotelContactInformationModel != null) {
		BeanUtilsBean.getInstance().copyProperties(hotelContactInformationVM, hotelContactInformationModel);
		}
		return ok(play.libs.Json.toJson(hotelContactInformationVM)).as("JSON");
	}
	
	public static Result saveSupplierHotelContactInfo(){
		
		Form<HotelContactInformationModel> hotelContactInformationModelForm = form(HotelContactInformationModel.class).bindFromRequest();
		String supplierIdFromSession = session().get("id");
		HotelContactInformationModel hotelContactInformationModel = HotelContactInformationModel.bySupplierId(Long.valueOf(supplierIdFromSession));
		if (hotelContactInformationModel == null) {
			hotelContactInformationModel = new HotelContactInformationModel();
			hotelContactInformationModel = hotelContactInformationModelForm.get();
			hotelContactInformationModel.supplierObject = Supplier.find.byId(Long.valueOf(supplierIdFromSession));
			hotelContactInformationModel.save();
			Supplier supplier = Supplier.find.byId(Long.valueOf(supplierIdFromSession));
			supplier.hotelContactInformationModel = hotelContactInformationModel;
			supplier.update();
		} else {
			hotelContactInformationModel.update();
		}
		return ok("DATA IS SUCCESSFULLY UPDATED");
	}
	// Section 5 End
	
	// Section 6 Start
	
	public static Result getHotelBusinessContactInformationPage(){
		UIGeneratorHelper helper = new UIGeneratorHelper(BusinessCommunication.class);
		return ok(com.mnt.custom.module.supplier.views.html.hotel_business_communication_section6.render(helper));
	}
	
	public static Result generateHotelBusinessContactInfoScript(){
		UIGeneratorHelper helper = new UIGeneratorHelper(BusinessCommunication.class);
		return ok(views.html.script.render(helper)).as("application/javascript");
	}
	
	public static Result getHotelBusinessContactInfoJson() throws IllegalAccessException, InvocationTargetException{
		
		BusinessCommunication businessCommunicationVM = new BusinessCommunication();
		String supplierIdFromSession = session().get("id");
		BusinessCommunicationModel businessCommunicationModel = BusinessCommunicationModel.bySupplierId(Long.valueOf(supplierIdFromSession));
		if (businessCommunicationModel != null) {
		BeanUtilsBean.getInstance().copyProperties(businessCommunicationVM, businessCommunicationModel);
		}
		return ok(play.libs.Json.toJson(businessCommunicationVM)).as("JSON");
	}
	
	public static Result saveSupplierHotelBusinessContactInfo(){
		
		Form<BusinessCommunicationModel> businessCommunicationModelForm = form(BusinessCommunicationModel.class).bindFromRequest();
		String supplierIdFromSession = session().get("id");
		BusinessCommunicationModel businessCommunicationModel = BusinessCommunicationModel.bySupplierId(Long.valueOf(supplierIdFromSession));
		if (businessCommunicationModel == null) {
			businessCommunicationModel = new BusinessCommunicationModel();
			businessCommunicationModel = businessCommunicationModelForm.get();
			businessCommunicationModel.supplierObject = Supplier.find.byId(Long.valueOf(supplierIdFromSession));
			businessCommunicationModel.save();
			Supplier supplier = Supplier.find.byId(Long.valueOf(supplierIdFromSession));
			supplier.businessCommunicationModel = businessCommunicationModel;
			supplier.update();
		} else {
			businessCommunicationModel.update();
		}
		
		return ok("DATA IS SUCCESSFULLY UPDATED");
	}
	// Section 6 End
	
	// Section 7 Start
	
	public static Result getHotelBillingInformationPage(){
		UIGeneratorHelper helper = new UIGeneratorHelper(HotelBillingInformation.class);
		return ok(com.mnt.custom.module.supplier.views.html.hotel_billing_information_section7.render(helper));
	}
	
	public static Result generateHotelBillingInfoScript(){
		UIGeneratorHelper helper = new UIGeneratorHelper(HotelBillingInformation.class);
		return ok(views.html.script.render(helper)).as("application/javascript");
	}
	
	public static Result getHotelBillingInfoJson() throws IllegalAccessException, InvocationTargetException{
		
		HotelBillingInformation hotelBillingInformationVM = new HotelBillingInformation();
		String supplierIdFromSession = session().get("id");
		HotelBillingInformationModel hotelBillingInformationModel = HotelBillingInformationModel.bySupplierId(Long.valueOf(supplierIdFromSession));
		if (hotelBillingInformationModel != null) {
		BeanUtilsBean.getInstance().copyProperties(hotelBillingInformationVM, hotelBillingInformationModel);
		}
		
		return ok(play.libs.Json.toJson(hotelBillingInformationVM)).as("JSON");
	}
	
	public static Result saveSupplierHotelBillingInfo(){
		
		Form<HotelBillingInformationModel> hotelBillingInformationModelForm = form(HotelBillingInformationModel.class).bindFromRequest();
		String supplierIdFromSession = session().get("id");
		HotelBillingInformationModel hotelBillingInformationModel = HotelBillingInformationModel.bySupplierId(Long.valueOf(supplierIdFromSession));
		if (hotelBillingInformationModel == null) {
			hotelBillingInformationModel = new HotelBillingInformationModel();
			hotelBillingInformationModel = hotelBillingInformationModelForm.get();
			hotelBillingInformationModel.supplierObject = Supplier.find.byId(Long.valueOf(supplierIdFromSession));
			hotelBillingInformationModel.save();
			Supplier supplier = Supplier.find.byId(Long.valueOf(supplierIdFromSession));
			supplier.billingInformationModel = hotelBillingInformationModel;
			supplier.update();
		} else {
			hotelBillingInformationModel.update();
		}
		
		return ok("DATA IS SUCCESSFULLY UPDATED");
	}
	// Section 7 End
	
	//section 8 Start
	
	public static Result getHotelAdditionalInformationPage(){
		UIGeneratorHelper helper = new UIGeneratorHelper(HotelAdditionalInformation.class);
		return ok(com.mnt.custom.module.supplier.views.html.hotel_additional_information_section8.render(helper));
	}
	
	public static Result generateHotelAdditionalInfoScript(){
		UIGeneratorHelper helper = new UIGeneratorHelper(HotelAdditionalInformation.class);
		return ok(views.html.script.render(helper)).as("application/javascript");
	}
	
	public static Result getHotelAdditionalInfoJson() throws IllegalAccessException, InvocationTargetException{
		HotelAdditionalInformation hotelAdditionalInformation = new HotelAdditionalInformation();
		models.suppliers.HotelAdditionalInformation additionalInformation = new models.suppliers.HotelAdditionalInformation();
		String supplierIdFromSession = session().get("id");
		
		additionalInformation = models.suppliers.HotelAdditionalInformation.bySupplierId(Long.valueOf(supplierIdFromSession));
		
		BeanUtilsBean.getInstance().copyProperties(hotelAdditionalInformation, additionalInformation);
		hotelAdditionalInformation.repeatTaxSections = Lists.newArrayList();
		hotelAdditionalInformation.repeatSupplementSections = Lists.newArrayList();
		
		for(models.suppliers.RepeatTaxSections _r : additionalInformation.repeatTaxSections){
            RepeatTaxSections repeatTaxSections = new RepeatTaxSections();
            BeanUtilsBean.getInstance().copyProperties(repeatTaxSections, _r);
            //hotelAdditionalInformation.repeatTaxSections.add(repeatTaxSections);
            hotelAdditionalInformation.repeatTaxSections.add(repeatTaxSections);
      }
		for(models.suppliers.RepeatSupplementSections _r : additionalInformation.repeatSupplementSections){
            RepeatSupplementSections repeatSupplementSections = new RepeatSupplementSections();
            BeanUtilsBean.getInstance().copyProperties(repeatSupplementSections, _r);
            hotelAdditionalInformation.repeatSupplementSections.add(repeatSupplementSections);
      }
		
		
		return ok(play.libs.Json.toJson(hotelAdditionalInformation)).as("JSON");
	}
	public static Result saveSupplierHotelAdditionalInfo(){
		Form<HotelAdditionalInformation> dynamicForm = form(HotelAdditionalInformation.class).bindFromRequest();
		
		String supplierIdFromSession = session().get("id");
		models.suppliers.HotelAdditionalInformation hotelAdditionalInformation = models.suppliers.HotelAdditionalInformation.bySupplierId(Long.valueOf(supplierIdFromSession));
		
		List<models.suppliers.RepeatTaxSections> repeatTaxSections = Lists.newArrayList();
		List<models.suppliers.RepeatSupplementSections> repeatSupplementSections = Lists.newArrayList();
		
		try {
			if(hotelAdditionalInformation == null){
				hotelAdditionalInformation  = new models.suppliers.HotelAdditionalInformation();
			BeanUtilsBean.getInstance().copyProperties(hotelAdditionalInformation, dynamicForm.get());
			for(RepeatTaxSections _r : dynamicForm.get().repeatTaxSections){
				models.suppliers.RepeatTaxSections taxSections = new models.suppliers.RepeatTaxSections();
				BeanUtilsBean.getInstance().copyProperties(taxSections, _r);
				repeatTaxSections.add(taxSections);
			}
			for(RepeatSupplementSections _r : dynamicForm.get().repeatSupplementSections){
				models.suppliers.RepeatSupplementSections supplementSections = new models.suppliers.RepeatSupplementSections();
				BeanUtilsBean.getInstance().copyProperties(supplementSections, _r);
				repeatSupplementSections.add(supplementSections);
			}
			hotelAdditionalInformation.repeatSupplementSections = repeatSupplementSections;
			hotelAdditionalInformation.repeatTaxSections = repeatTaxSections;
			hotelAdditionalInformation.supplierObject = Supplier.find.byId(Long.valueOf(supplierIdFromSession));
			hotelAdditionalInformation.save();
			
			Supplier supplier = Supplier.find.byId(Long.valueOf(supplierIdFromSession));
			supplier.additionalInformation = hotelAdditionalInformation;
			supplier.update();
			
			}else{
			
				BeanUtilsBean.getInstance().copyProperties(hotelAdditionalInformation, dynamicForm.get());
				for(RepeatTaxSections _r : dynamicForm.get().repeatTaxSections){
					models.suppliers.RepeatTaxSections taxSections = new models.suppliers.RepeatTaxSections();
					BeanUtilsBean.getInstance().copyProperties(taxSections, _r);
					repeatTaxSections.add(taxSections);
				}
				for(RepeatSupplementSections _r : dynamicForm.get().repeatSupplementSections){
					models.suppliers.RepeatSupplementSections supplementSections = new models.suppliers.RepeatSupplementSections();
					BeanUtilsBean.getInstance().copyProperties(supplementSections, _r);
					repeatSupplementSections.add(supplementSections);
				}
				hotelAdditionalInformation.repeatSupplementSections = repeatSupplementSections;
				hotelAdditionalInformation.repeatTaxSections = repeatTaxSections;
				hotelAdditionalInformation.supplierObject = Supplier.find.byId(Long.valueOf(supplierIdFromSession));
				hotelAdditionalInformation.update();			
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ok("DATA IS SUCCESSFULLY UPDATED");
	}
	// Section 8 End
	
	// Section 9 Start
	
	public static Result getHotelAdditionalMandatoryInformationPage(){
		UIGeneratorHelper helper = new UIGeneratorHelper(HotelAdditionalMandatoryInfo.class);
		return ok(com.mnt.custom.module.supplier.views.html.hotel_additional_mandatory_service_section9.render(helper));
	}
	
	public static Result generateHotelAdditionalMandatoryInfoScript(){
		UIGeneratorHelper helper = new UIGeneratorHelper(HotelAdditionalMandatoryInfo.class);
		return ok(views.html.script.render(helper)).as("application/javascript");
	}
	
	public static Result getHotelAdditionalMandatoryInfoJson() throws IllegalAccessException, InvocationTargetException{
		HotelAdditionalMandatoryInfo hotelAdditionalMandatoryInfo= new HotelAdditionalMandatoryInfo();
		
		String supplierIdFromSession = session().get("id");
		models.suppliers.HotelAdditionalMandatoryInfo additionalMandatoryInfo = models.suppliers.HotelAdditionalMandatoryInfo.bySupplierId(Long.valueOf(supplierIdFromSession));
		
		BeanUtilsBean.getInstance().copyProperties(hotelAdditionalMandatoryInfo, additionalMandatoryInfo);
		hotelAdditionalMandatoryInfo.repeatMandatorySections = Lists.newArrayList();
		
		for(models.suppliers.RepeatMandatorySections _r : additionalMandatoryInfo.repeatMandatorySections){
            RepeatMandatorySections repeatMandatorySections = new RepeatMandatorySections();
             BeanUtilsBean.getInstance().copyProperties(repeatMandatorySections, _r);
             
             for(models.suppliers.RepeatMandatorySections1 _r1 : _r.repeatMandatorySections1s){
            	 RepeatMandatorySections1 repeatMandatorySections1 = new RepeatMandatorySections1();
            	 BeanUtilsBean.getInstance().copyProperties(repeatMandatorySections1, _r1);
            	 repeatMandatorySections.repeatMandatorySections1.add(repeatMandatorySections1);
             }
             hotelAdditionalMandatoryInfo.repeatMandatorySections.add(repeatMandatorySections);
      }
		
		return ok(play.libs.Json.toJson(hotelAdditionalMandatoryInfo)).as("JSON");
	}
	
	public static Result saveSupplierAdditionalMandatoryInfo() throws IllegalAccessException, InvocationTargetException{
		Form<HotelAdditionalMandatoryInfo> dynamicForm = form(HotelAdditionalMandatoryInfo.class).bindFromRequest();
		String supplierIdFromSession = session().get("id");
		models.suppliers.HotelAdditionalMandatoryInfo additionalMandatoryInfo = models.suppliers.HotelAdditionalMandatoryInfo.bySupplierId(Long.valueOf(supplierIdFromSession));
		List<models.suppliers.RepeatMandatorySections> repeatMandatorySections = Lists.newArrayList();
		
		if(additionalMandatoryInfo == null){
			additionalMandatoryInfo = new models.suppliers.HotelAdditionalMandatoryInfo();
			BeanUtilsBean.getInstance().copyProperties(additionalMandatoryInfo, dynamicForm.get());
			
			for(RepeatMandatorySections _r : dynamicForm.get().repeatMandatorySections){
				models.suppliers.RepeatMandatorySections mandatorySections = new models.suppliers.RepeatMandatorySections();
				BeanUtilsBean.getInstance().copyProperties(mandatorySections, _r);
				
				for(RepeatMandatorySections1 _r1 : _r.repeatMandatorySections1){
					models.suppliers.RepeatMandatorySections1 repeatMandatorySections1 = new models.suppliers.RepeatMandatorySections1();
					BeanUtilsBean.getInstance().copyProperties(repeatMandatorySections1, _r1);
					mandatorySections.repeatMandatorySections1s.add(repeatMandatorySections1);
				}
				repeatMandatorySections.add(mandatorySections);
			}
			additionalMandatoryInfo.repeatMandatorySections = repeatMandatorySections;
			additionalMandatoryInfo.supplierObject = Supplier.find.byId(Long.valueOf(supplierIdFromSession));
			additionalMandatoryInfo.save();
			
			Supplier supplier = Supplier.find.byId(Long.valueOf(supplierIdFromSession));
			supplier.additionalMandatoryInfo = additionalMandatoryInfo;
			supplier.update();
		
		}else{
			
			BeanUtilsBean.getInstance().copyProperties(additionalMandatoryInfo, dynamicForm.get());
			
			for(RepeatMandatorySections _r : dynamicForm.get().repeatMandatorySections){
				models.suppliers.RepeatMandatorySections mandatorySections = new models.suppliers.RepeatMandatorySections();
				BeanUtilsBean.getInstance().copyProperties(mandatorySections, _r);
				
				for(RepeatMandatorySections1 _r1 : _r.repeatMandatorySections1){
					models.suppliers.RepeatMandatorySections1 repeatMandatorySections1 = new models.suppliers.RepeatMandatorySections1();
					BeanUtilsBean.getInstance().copyProperties(repeatMandatorySections1, _r1);
					mandatorySections.repeatMandatorySections1s.add(repeatMandatorySections1);
				}
				repeatMandatorySections.add(mandatorySections);
			}
			additionalMandatoryInfo.repeatMandatorySections = repeatMandatorySections;
			additionalMandatoryInfo.supplierObject = Supplier.find.byId(Long.valueOf(supplierIdFromSession));
			additionalMandatoryInfo.save();
		}
		return ok("DATA IS SUCCESSFULLY UPDATED");
	}
	
	//section 9 End
	
	// Section 10 Start
	
	public static Result getHotelAmenitiesInformationPage(){
	
		UIGeneratorHelper helper = new UIGeneratorHelper(HotelAmenities.class);
		return ok(com.mnt.custom.module.supplier.views.html.hotel_amenities_section10.render(helper));
	}
	
	public static Result generateHotelAmenitiesInfoScript(){
		
		UIGeneratorHelper helper = new UIGeneratorHelper(HotelAmenities.class);
		return ok(views.html.script.render(helper)).as("application/javascript");
	}
	
	public static Result getHotelAmenitiesInfoJson() throws IllegalAccessException, InvocationTargetException{
		
		HotelAmenities hotelAmenitiesVM= new HotelAmenities();
		
		hotelAmenitiesVM.hotelAmenities = Lists.newArrayList();
		String supplierIdFromSession = session().get("id");
		
		HotelAmenitiesModel hotelAmenitiesModel = HotelAmenitiesModel.bySupplierId(Long.valueOf(supplierIdFromSession));
		if (hotelAmenitiesModel != null) {
			if(hotelAmenitiesModel.hotelAmenitiesWithCommas != null ){
				Iterable<String> hotelAmenitiesAsItr = Splitter.on(",").omitEmptyStrings().trimResults().split(hotelAmenitiesModel.hotelAmenitiesWithCommas);
				Set<String> hotelAmenities = Sets.newHashSet(hotelAmenitiesAsItr);
				hotelAmenitiesVM.hotelAmenities.addAll(hotelAmenities);
			}
		BeanUtilsBean.getInstance().copyProperties(hotelAmenitiesVM, hotelAmenitiesModel);
		}
		
		return ok(play.libs.Json.toJson(hotelAmenitiesVM)).as("JSON");
	}
	
	public static Result saveSupplierHotelAmenitiesInfo() throws IllegalAccessException, InvocationTargetException{
		
		Form<HotelAmenities> hotelAmenitiesVMForm = form(HotelAmenities.class).bindFromRequest();
		
		String supplierIdFromSession = session().get("id");
		HotelAmenitiesModel hotelAmenitiesModel = HotelAmenitiesModel.bySupplierId(Long.valueOf(supplierIdFromSession));
		
		if (hotelAmenitiesModel == null) {
			hotelAmenitiesModel = new HotelAmenitiesModel();
			BeanUtilsBean.getInstance().copyProperties(hotelAmenitiesModel, hotelAmenitiesVMForm.get());
		
			Object[] array = hotelAmenitiesVMForm.get().hotelAmenities.toArray();
			hotelAmenitiesModel.hotelAmenitiesWithCommas = Joiner.on(",").skipNulls().join(array);
			
			hotelAmenitiesModel.supplierObject = Supplier.find.byId(Long.valueOf(supplierIdFromSession));
			hotelAmenitiesModel.save();
			
			Supplier supplier = Supplier.find.byId(Long.valueOf(supplierIdFromSession));
			supplier.hotelAmenitiesModel = hotelAmenitiesModel;
			supplier.update();
		} else {
			BeanUtilsBean.getInstance().copyProperties(hotelAmenitiesModel, hotelAmenitiesVMForm.get());
			Object[] array = hotelAmenitiesVMForm.get().hotelAmenities.toArray();
			hotelAmenitiesModel.hotelAmenitiesWithCommas = Joiner.on(",").skipNulls().join(array);
			hotelAmenitiesModel.update();
		}
		return ok("DATA IS SUCCESSFULLY UPDATED");
	}
	
	// Section 10 End
	
	// Section 11 Start
	public static Result getHotelBusinessAmenitiesInformationPage(){
	
		UIGeneratorHelper helper = new UIGeneratorHelper(HotelBusinessAmenities.class);
		return ok(com.mnt.custom.module.supplier.views.html.hotel_business_amenities_section11.render(helper));
	}
	public static Result generateHotelBusinessAmenitiesInfoScript(){
		
		UIGeneratorHelper helper = new UIGeneratorHelper(HotelBusinessAmenities.class);
		return ok(views.html.script.render(helper)).as("application/javascript");
	}
	
	public static Result getHotelBusinessAmenitiesInfoJson() throws IllegalAccessException, InvocationTargetException{
		
		HotelBusinessAmenities hotelBusinessAmenitiesVM= new HotelBusinessAmenities();
		hotelBusinessAmenitiesVM.hotelBusinessAmenities = Lists.newArrayList();
		String supplierIdFromSession = session().get("id");
		HotelBusinessAmenitiesModel hotelBusinessAmenitiesModel = HotelBusinessAmenitiesModel.bySupplierId(Long.valueOf(supplierIdFromSession));
		if (hotelBusinessAmenitiesModel != null) {
			if(hotelBusinessAmenitiesModel.hotelBusinessAmenitiesWithCommas != null ){
				Iterable<String> hotelBusinessAmenitiesAsItr = Splitter.on(",").omitEmptyStrings().trimResults().split(hotelBusinessAmenitiesModel.hotelBusinessAmenitiesWithCommas);
				Set<String> hotelBusinessAmenities = Sets.newHashSet(hotelBusinessAmenitiesAsItr);
				hotelBusinessAmenitiesVM.hotelBusinessAmenities.addAll(hotelBusinessAmenities);
			}
		BeanUtilsBean.getInstance().copyProperties(hotelBusinessAmenitiesVM, hotelBusinessAmenitiesModel);
		}
		return ok(play.libs.Json.toJson(hotelBusinessAmenitiesVM)).as("JSON");
	}
	public static Result saveSupplierHotelBusinessAmenitiesInfo() throws IllegalAccessException, InvocationTargetException{
		
		Form<HotelBusinessAmenities> hotelBusinessAmenitiesVMForm = form(HotelBusinessAmenities.class).bindFromRequest();
		String supplierIdFromSession = session().get("id");
		HotelBusinessAmenitiesModel hotelBusinessAmenitiesModel = HotelBusinessAmenitiesModel.bySupplierId(Long.valueOf(supplierIdFromSession));
		if (hotelBusinessAmenitiesModel == null) {
			hotelBusinessAmenitiesModel = new HotelBusinessAmenitiesModel();
			BeanUtilsBean.getInstance().copyProperties(hotelBusinessAmenitiesModel, hotelBusinessAmenitiesVMForm.get());
			Object[] array = hotelBusinessAmenitiesVMForm.get().hotelBusinessAmenities.toArray();
			hotelBusinessAmenitiesModel.hotelBusinessAmenitiesWithCommas = Joiner.on(",").skipNulls().join(array);
			hotelBusinessAmenitiesModel.supplierObject = Supplier.find.byId(Long.valueOf(supplierIdFromSession));
			hotelBusinessAmenitiesModel.save();
			
			Supplier supplier = Supplier.find.byId(Long.valueOf(supplierIdFromSession));
			supplier.hotelBusinessAmenitiesModel = hotelBusinessAmenitiesModel;
			supplier.update();
		} else {
			BeanUtilsBean.getInstance().copyProperties(hotelBusinessAmenitiesModel, hotelBusinessAmenitiesVMForm.get());
			Object[] array = hotelBusinessAmenitiesVMForm.get().hotelBusinessAmenities.toArray();
			hotelBusinessAmenitiesModel.hotelBusinessAmenitiesWithCommas = Joiner.on(",").skipNulls().join(array);
			hotelBusinessAmenitiesModel.update();
		}
		return ok("DATA IS SUCCESSFULLY UPDATED");
	}
	// Section 11 End
	
	// Section 12 End
	
	public static Result getHotelLeisureAmenitiesInformationPage(){
		
		UIGeneratorHelper helper = new UIGeneratorHelper(HotelLeisureAmenities.class);
		return ok(com.mnt.custom.module.supplier.views.html.hotel_leisure_amenities_section12.render(helper));
	}
	public static Result generateHotelLeisureAmenitiesInfoScript(){
		
		UIGeneratorHelper helper = new UIGeneratorHelper(HotelLeisureAmenities.class);
		return ok(views.html.script.render(helper)).as("application/javascript");
	}

	
	public static Result getHotelLeisureAmenitiesInfoJson() throws IllegalAccessException, InvocationTargetException{
		
		HotelLeisureAmenities hotelLeisureAmenitiesVM = new HotelLeisureAmenities();
		hotelLeisureAmenitiesVM.hotelLeisureAmenities = Lists.newArrayList();
		String supplierIdFromSession = session().get("id");
		HotelLeisureAmenitiesModel hotelLeisureAmenitiesModel = HotelLeisureAmenitiesModel.bySupplierId(Long.valueOf(supplierIdFromSession));
		if (hotelLeisureAmenitiesModel != null) {
			if(hotelLeisureAmenitiesModel.hotelLeisureAmenitiesWithCommas != null ){
				Iterable<String> hotelLeisureAmenitiesAsItr = Splitter.on(",").omitEmptyStrings().trimResults().split(hotelLeisureAmenitiesModel.hotelLeisureAmenitiesWithCommas);
				Set<String> hotelLeisureAmenities = Sets.newHashSet(hotelLeisureAmenitiesAsItr);
				hotelLeisureAmenitiesVM.hotelLeisureAmenities.addAll(hotelLeisureAmenities);
			}
		BeanUtilsBean.getInstance().copyProperties(hotelLeisureAmenitiesVM, hotelLeisureAmenitiesModel);
		}
		
		return ok(play.libs.Json.toJson(hotelLeisureAmenitiesVM)).as("JSON");
	}
	
	public static Result saveSupplierHotelLeisureAmenitiesInfo() throws IllegalAccessException, InvocationTargetException{
		
		Form<HotelLeisureAmenities> hotelLeisureAmenitiesVMForm = form(HotelLeisureAmenities.class).bindFromRequest();
		String supplierIdFromSession = session().get("id");
		HotelLeisureAmenitiesModel hotelLeisureAmenitiesModel = HotelLeisureAmenitiesModel.bySupplierId(Long.valueOf(supplierIdFromSession));
		if (hotelLeisureAmenitiesModel == null) {
			hotelLeisureAmenitiesModel = new HotelLeisureAmenitiesModel();
			BeanUtilsBean.getInstance().copyProperties(hotelLeisureAmenitiesModel, hotelLeisureAmenitiesVMForm.get());
			Object[] array = hotelLeisureAmenitiesVMForm.get().hotelLeisureAmenities.toArray();
			hotelLeisureAmenitiesModel.hotelLeisureAmenitiesWithCommas = Joiner.on(",").skipNulls().join(array);
			hotelLeisureAmenitiesModel.supplierObject = Supplier.find.byId(Long.valueOf(supplierIdFromSession));
			hotelLeisureAmenitiesModel.save();
			
			Supplier supplier = Supplier.find.byId(Long.valueOf(supplierIdFromSession));
			supplier.hotelLeisureAmenitiesModel = hotelLeisureAmenitiesModel;
			supplier.update();
		} else {
			BeanUtilsBean.getInstance().copyProperties(hotelLeisureAmenitiesModel, hotelLeisureAmenitiesVMForm.get());
			Object[] array = hotelLeisureAmenitiesVMForm.get().hotelLeisureAmenities.toArray();
			hotelLeisureAmenitiesModel.hotelLeisureAmenitiesWithCommas = Joiner.on(",").skipNulls().join(array);
			hotelLeisureAmenitiesModel.update();
		}
		return ok("DATA IS SUCCESSFULLY UPDATED");
	}
	// Section 12 End
	
	// Section 13 Start
	public static Result getHotelAttractionsInformationPage(){
		
		UIGeneratorHelper helper = new UIGeneratorHelper(AreaAttractions.class);
		return ok(com.mnt.custom.module.supplier.views.html.hotel_area_attractions.render(helper));
	}
	public static Result generateHotelAttractionsInfoScript(){
		
		UIGeneratorHelper helper = new UIGeneratorHelper(AreaAttractions.class);
		return ok(views.html.script.render(helper)).as("application/javascript");
	}
	public static Result getHotelAttractionsInfoJson() throws IllegalAccessException, InvocationTargetException{
		
		AreaAttractions areaAttractionsVM = new AreaAttractions();
		String supplierIdFromSession = session().get("id");
		AreaAttractionModel areaAttractionModel = AreaAttractionModel.bySupplierId(Long.valueOf(supplierIdFromSession));
		if (areaAttractionModel != null) {
		BeanUtilsBean.getInstance().copyProperties(areaAttractionsVM, areaAttractionModel);
		}
		return ok(play.libs.Json.toJson(areaAttractionsVM)).as("JSON");
	}
	public static Result saveSupplierAttractionsInfo(){
		
		Form<AreaAttractionModel> areaAttractionModelForm = form(AreaAttractionModel.class).bindFromRequest();
		String supplierIdFromSession = session().get("id");
		AreaAttractionModel areaAttractionModel = AreaAttractionModel.bySupplierId(Long.valueOf(supplierIdFromSession));
		if (areaAttractionModel == null) {
			areaAttractionModel = new AreaAttractionModel();
			areaAttractionModel = areaAttractionModelForm.get();
			areaAttractionModel.supplierObject = Supplier.find.byId(Long.valueOf(supplierIdFromSession));
			areaAttractionModel.save();
			
			Supplier supplier = Supplier.find.byId(Long.valueOf(supplierIdFromSession));
			supplier.areaAttractionModel = areaAttractionModel;
			supplier.update();
		} else {
			areaAttractionModel.update();
		}
		
		return ok("DATA IS SUCCESSFULLY UPDATED");
	}
	// Section 13 End
	
	// Section 14 Start
	public static Result getHotelTransportationInformationPage(){
		
		UIGeneratorHelper helper = new UIGeneratorHelper(HotelTransportatin.class);
		return ok(com.mnt.custom.module.supplier.views.html.hotel_transportation_section14.render(helper));
	}

	public static Result generateHotelTransportationInfoScript(){
		
		UIGeneratorHelper helper = new UIGeneratorHelper(HotelTransportatin.class);
		return ok(views.html.script.render(helper)).as("application/javascript");
	}
	
	public static Result getHotelTransportationInfoJson() throws IllegalAccessException, InvocationTargetException{
		
		HotelTransportatin hotelTransportatinVM= new HotelTransportatin();
		String supplierIdFromSession = session().get("id");
		HotelTransportationModel hotelTransportationModel = HotelTransportationModel.bySupplierId(Long.valueOf(supplierIdFromSession));
		if (hotelTransportationModel != null) {
		BeanUtilsBean.getInstance().copyProperties(hotelTransportatinVM, hotelTransportationModel);
		}
		return ok(play.libs.Json.toJson(hotelTransportatinVM)).as("JSON");
	}
	public static Result saveSupplierTransportationInfo(){
		
		Form<HotelTransportationModel> hotelTransportationModelForm = form(HotelTransportationModel.class).bindFromRequest();
		String supplierIdFromSession = session().get("id");
		HotelTransportationModel hotelTransportationModel = HotelTransportationModel.bySupplierId(Long.valueOf(supplierIdFromSession));
		if (hotelTransportationModel == null) {
			hotelTransportationModel = new HotelTransportationModel();
			hotelTransportationModel = hotelTransportationModelForm.get();
			hotelTransportationModel.supplierObject = Supplier.find.byId(Long.valueOf(supplierIdFromSession));
			hotelTransportationModel.save();
			
			Supplier supplier = Supplier.find.byId(Long.valueOf(supplierIdFromSession));
			supplier.hotelTransportationModel = hotelTransportationModel;
			supplier.update();
		} else {
			hotelTransportationModel.update();
		}
		
		return ok("DATA IS SUCCESSFULLY UPDATED");
	}
	// Section 14 End
	
	// Section 15 Start
	public static Result getHotelHealthInformationPage(){
		UIGeneratorHelper helper = new UIGeneratorHelper(HotelHealthSafety.class);
		return ok(com.mnt.custom.module.supplier.views.html.hotel_health_safety_section15.render(helper));
	}
	public static Result generateHotelHealthInfoScript(){
		
		UIGeneratorHelper helper = new UIGeneratorHelper(HotelHealthSafety.class);
		return ok(views.html.script.render(helper)).as("application/javascript");
	}

	public static Result getHotelHealthInfoJson() throws IllegalAccessException, InvocationTargetException{
		
		HotelHealthSafety healthSafetyVM= new HotelHealthSafety();
		
		healthSafetyVM.cctvStatus = Lists.newArrayList();
		healthSafetyVM.isChildOperationalMonths = Lists.newArrayList();
		healthSafetyVM.isSwimmingHeatedPoolMonths = Lists.newArrayList();
		
		String supplierIdFromSession = session().get("id");
		
		HotelHealthSafetyModel healthSafetyModel = HotelHealthSafetyModel.bySupplierId(Long.valueOf(supplierIdFromSession));
		
		if (healthSafetyModel != null) {
			
			if(healthSafetyModel.cctvStatusWithCommas != null ){
				Iterable<String> cctvStatusAsItr = Splitter.on(",").omitEmptyStrings().trimResults().split(healthSafetyModel.cctvStatusWithCommas);
				Set<String> cctvStatus = Sets.newHashSet(cctvStatusAsItr);
				healthSafetyVM.cctvStatus.addAll(cctvStatus);
			}
			
			if(healthSafetyModel.isChildOperationalMonthsWithCommas != null ){
				Iterable<String> isChildOperationalMonthsAsItr = Splitter.on(",").omitEmptyStrings().trimResults().split(healthSafetyModel.isChildOperationalMonthsWithCommas);
				Set<String> isChildOperationalMonths = Sets.newHashSet(isChildOperationalMonthsAsItr);
				healthSafetyVM.isChildOperationalMonths.addAll(isChildOperationalMonths);
			}
			
			if(healthSafetyModel.isSwimmingHeatedPoolMonthsWithCommas != null ){
				Iterable<String> isSwimmingHeatedPoolMonthsAsItr = Splitter.on(",").omitEmptyStrings().trimResults().split(healthSafetyModel.isSwimmingHeatedPoolMonthsWithCommas);
				Set<String> isSwimmingHeatedPoolMonths = Sets.newHashSet(isSwimmingHeatedPoolMonthsAsItr);
				healthSafetyVM.isSwimmingHeatedPoolMonths.addAll(isSwimmingHeatedPoolMonths);
			}
		BeanUtilsBean.getInstance().copyProperties(healthSafetyVM, healthSafetyModel);
		}
		
		return ok(play.libs.Json.toJson(healthSafetyVM)).as("JSON");
	}
	
	public static Result saveSupplierHealthInfo() throws IllegalAccessException, InvocationTargetException{
		
		Form<HotelHealthSafety> hotelHealthSafetyVMForm = form(HotelHealthSafety.class).bindFromRequest();
		String supplierIdFromSession = session().get("id");
		HotelHealthSafetyModel hotelHealthSafetyModel = HotelHealthSafetyModel.bySupplierId(Long.valueOf(supplierIdFromSession));
		
		if (hotelHealthSafetyModel == null) {
			hotelHealthSafetyModel = new HotelHealthSafetyModel();
			BeanUtilsBean.getInstance().copyProperties(hotelHealthSafetyModel, hotelHealthSafetyVMForm.get());
			
			Object[] arrayCCTVStatus = hotelHealthSafetyVMForm.get().cctvStatus.toArray();
			hotelHealthSafetyModel.cctvStatusWithCommas = Joiner.on(",").skipNulls().join(arrayCCTVStatus);
			
			Object[] arrayIsChildOperationalMonths = hotelHealthSafetyVMForm.get().isChildOperationalMonths.toArray();
			hotelHealthSafetyModel.isChildOperationalMonthsWithCommas = Joiner.on(",").skipNulls().join(arrayIsChildOperationalMonths);
			
			Object[] arrayIsSwimmingHeatedPoolMonths = hotelHealthSafetyVMForm.get().isSwimmingHeatedPoolMonths.toArray();
			hotelHealthSafetyModel.isSwimmingHeatedPoolMonthsWithCommas = Joiner.on(",").skipNulls().join(arrayIsSwimmingHeatedPoolMonths);
			
			hotelHealthSafetyModel.supplierObject = Supplier.find.byId(Long.valueOf(supplierIdFromSession));
			hotelHealthSafetyModel.save();
			
			Supplier supplier = Supplier.find.byId(Long.valueOf(supplierIdFromSession));
			supplier.hotelHealthSafetyModel = hotelHealthSafetyModel;
			supplier.update();
		} else {
			BeanUtilsBean.getInstance().copyProperties(hotelHealthSafetyModel, hotelHealthSafetyVMForm.get());
			
			Object[] arrayCCTVStatus = hotelHealthSafetyVMForm.get().cctvStatus.toArray();
			hotelHealthSafetyModel.cctvStatusWithCommas = Joiner.on(",").skipNulls().join(arrayCCTVStatus);
			
			Object[] arrayIsChildOperationalMonths = hotelHealthSafetyVMForm.get().isChildOperationalMonths.toArray();
			hotelHealthSafetyModel.isChildOperationalMonthsWithCommas = Joiner.on(",").skipNulls().join(arrayIsChildOperationalMonths);
			
			Object[] arrayIsSwimmingHeatedPoolMonths = hotelHealthSafetyVMForm.get().isSwimmingHeatedPoolMonths.toArray();
			hotelHealthSafetyModel.isSwimmingHeatedPoolMonthsWithCommas = Joiner.on(",").skipNulls().join(arrayIsSwimmingHeatedPoolMonths);
			
			hotelHealthSafetyModel.update();
		}
		return ok("DATA IS SUCCESSFULLY UPDATED");
	}
	// Section 15 End
	
	// Meal Section Starts
	
	public static Result getHotelMealInformationPage(){
		
		UIGeneratorHelper helper = new UIGeneratorHelper(MealOverlay.class);
		return ok(com.mnt.custom.module.supplier.views.html.hotel_meal_section9.render(helper));
	}

	public static Result generateHotelMealInfoScript(){
		UIGeneratorHelper helper = new UIGeneratorHelper(MealOverlay.class);
		return ok(views.html.script.render(helper)).as("application/javascript");
	}
	
	public static Result getHotelMealInfoJson(){
		MealOverlay mealOverlayVM= new MealOverlay();
        MealOverlayModel overlayModel;
        String supplierIdFromSession = session().get("id");
        overlayModel = MealOverlayModel.bySupplierId(Long.valueOf(supplierIdFromSession));
       
        try {
               BeanUtilsBean.getInstance().copyProperties(mealOverlayVM, overlayModel);
               mealOverlayVM.repeatChildMealRateSections = Lists.newArrayList();
               for(models.suppliers.RepeatChildMealRateSections _r : overlayModel.repeatChildMealRateSections){
                     RepeatChildMealRateSections childMealRateSections = new RepeatChildMealRateSections();
                      BeanUtilsBean.getInstance().copyProperties(childMealRateSections, _r);
                      mealOverlayVM.repeatChildMealRateSections.add(childMealRateSections);
               }
        } catch (Exception e) {
               e.printStackTrace();
        }
        return ok(play.libs.Json.toJson(mealOverlayVM)).as("JSON");

	}
	
	public static Result saveSupplierMealInfo(){
		Form<MealOverlay> dynamicForm = form(MealOverlay.class).bindFromRequest();
		String supplierIdFromSession = session().get("id");
		MealOverlayModel overlayModel = MealOverlayModel.bySupplierId(Long.valueOf(supplierIdFromSession));
		List<models.suppliers.RepeatChildMealRateSections> repeatChildMealRateSections = Lists.newArrayList();
		try {
			if(overlayModel == null){
			overlayModel  = new MealOverlayModel();
			BeanUtilsBean.getInstance().copyProperties(overlayModel, dynamicForm.get());
			for(RepeatChildMealRateSections _r : dynamicForm.get().repeatChildMealRateSections){
				models.suppliers.RepeatChildMealRateSections childMealRateSections = new models.suppliers.RepeatChildMealRateSections();
				BeanUtilsBean.getInstance().copyProperties(childMealRateSections, _r);
				repeatChildMealRateSections.add(childMealRateSections);
			}
			overlayModel.repeatChildMealRateSections = repeatChildMealRateSections;
			overlayModel.supplierObject = Supplier.find.byId(Long.valueOf(supplierIdFromSession));
			overlayModel.save();
			
			Supplier supplier = Supplier.find.byId(Long.valueOf(supplierIdFromSession));
			supplier.mealOverlayModel = overlayModel;
			supplier.update();
			}else{
				BeanUtilsBean.getInstance().copyProperties(overlayModel, dynamicForm.get());
				for(RepeatChildMealRateSections _r : dynamicForm.get().repeatChildMealRateSections){
					models.suppliers.RepeatChildMealRateSections childMealRateSections = new models.suppliers.RepeatChildMealRateSections();
					BeanUtilsBean.getInstance().copyProperties(childMealRateSections, _r);
					repeatChildMealRateSections.add(childMealRateSections);
				}
				overlayModel.repeatChildMealRateSections = repeatChildMealRateSections;
				overlayModel.update();
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ok();
	}

	// Meal Section Ends
	

}
