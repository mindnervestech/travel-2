package com.mnt.custom.module.yieldmgmt.controllers;

import static play.data.Form.form;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Set;

import models.suppliers.Supplier;
import models.yieldmgmt.YieldMgmtModel;

import org.apache.commons.beanutils.BeanUtilsBean;

import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.mnt.core.helper.UIGeneratorHelper;
import com.mnt.custom.module.yieldmgmt.viewmodel.HomePageVM;
import com.mnt.custom.module.yieldmgmt.viewmodel.YieldMgmt;
import com.mnt.custom.module.yieldmgmt.viewmodel.YieldMgmt.AllottmentMarket;
import com.mnt.custom.module.yieldmgmt.viewmodel.YieldMgmt.RepeatRateSections.CancellationSection1;
import com.mnt.custom.module.yieldmgmt.viewmodel.YieldMgmt.RepeatRateSections;
import com.mnt.custom.module.yieldmgmt.viewmodel.YieldMgmt.RepeatRateSections.CancellationSection;
import com.mnt.custom.module.yieldmgmt.views.html.yieldDataBinder;
import com.mnt.custom.module.yieldmgmt.views.html.yieldmgmt;

public class YieldMgmts extends Controller {

	public static Result profile(){
		return ok(yieldDataBinder.render(false));
	}
	// Yield Management Starts
	public static Result getYieldMgmt(){
		UIGeneratorHelper helper = new UIGeneratorHelper(YieldMgmt.class);
		return ok(yieldmgmt.render(helper));
	}
	
	public static Result generateYieldMgmtScript(){
		UIGeneratorHelper helper = new UIGeneratorHelper(YieldMgmt.class);
		return ok(views.html.script.render(helper)).as("application/javascript");
	}
	
	public static Result getYieldMgmtJson() throws IllegalAccessException, InvocationTargetException{
		YieldMgmt yieldmgmt = new YieldMgmt();
		String supplierIdFromSession = session().get("id");
		YieldMgmtModel yieldMgmtModel = YieldMgmtModel.bySupplierId(Long.valueOf(supplierIdFromSession));
		
		if(yieldMgmtModel == null){
		yieldmgmt.repeatRateSections = Lists.newArrayList(new RepeatRateSections());
		yieldmgmt.allottmentMarkets = Lists.newArrayList(new AllottmentMarket());
		yieldmgmt.repeatRateSections.get(0).repeatCancellations = Lists.newArrayList(new RepeatRateSections.CancellationSection());
		yieldmgmt.repeatRateSections.get(0).repeatCancellations1 = Lists.newArrayList(new RepeatRateSections.CancellationSection1());

		}else{
		
		BeanUtilsBean.getInstance().copyProperties(yieldmgmt, yieldMgmtModel);
		yieldmgmt.repeatRateSections = Lists.newArrayList();
		yieldmgmt.allottmentMarkets = Lists.newArrayList();
		
		for(models.yieldmgmt.RepeatRateSections _r : yieldMgmtModel.repeatRateSections){
            RepeatRateSections repeatRateSections = new RepeatRateSections();
             BeanUtilsBean.getInstance().copyProperties(repeatRateSections, _r);
             repeatRateSections.repeatCancellations = Lists.newArrayList();
             repeatRateSections.repeatCancellations1 = Lists.newArrayList();
             
             
             for(models.yieldmgmt.CancellationSection _r1 : _r.repeatCancellations){
            	 CancellationSection cancellationSection = new CancellationSection();
            	 BeanUtilsBean.getInstance().copyProperties(cancellationSection, _r1);
            	 repeatRateSections.repeatCancellations.add(cancellationSection);
             }
             for(models.yieldmgmt.CancellationSection1 _r1 : _r.repeatCancellations1){
            	 CancellationSection1 cancellationSection1 = new CancellationSection1();
            	 BeanUtilsBean.getInstance().copyProperties(cancellationSection1, _r1);
            	 repeatRateSections.repeatCancellations1.add(cancellationSection1);
             }
             
             Iterable<String> minimumStayDays = Splitter.on(",").omitEmptyStrings().trimResults().split(_r.minimumStayDaysWithCommas);
			 Set<String> minimumDays = Sets.newHashSet(minimumStayDays);
			 repeatRateSections.minimumStayDays.addAll(minimumDays);
			 
			 Iterable<String> rateMarketType = Splitter.on(",").omitEmptyStrings().trimResults().split(_r.rateMarketTypeWithCommas);
			 Set<String> rateType = Sets.newHashSet(rateMarketType);
			 repeatRateSections.rateMarketType.addAll(rateType);
			 
			 Iterable<String> applicableDays = Splitter.on(",").omitEmptyStrings().trimResults().split(_r.applicableDaysWithCommas);
			 Set<String> applicableDaysType = Sets.newHashSet(applicableDays);
			 repeatRateSections.applicableDays.addAll(applicableDaysType);
             
			 yieldmgmt.repeatRateSections.add(repeatRateSections);
		}
		
		for(models.yieldmgmt.AllottmentMarket _r : yieldMgmtModel.allottmentMarkets){
            AllottmentMarket allottmentMarket = new AllottmentMarket();
            
             BeanUtilsBean.getInstance().copyProperties(allottmentMarket, _r);
	     
         Iterable<String> allotmentMarketRates = Splitter.on(",").omitEmptyStrings().trimResults().split(_r.allotmentMarketRatesWithCommas);
		 Set<String> allotmentRates = Sets.newHashSet(allotmentMarketRates);
		 allottmentMarket.allotmentMarketRates.addAll(allotmentRates);
		 
		 Iterable<String> applyToAllMarkets = Splitter.on(",").omitEmptyStrings().trimResults().split(_r.applyToAllMarketsWithCommas);
		 Set<String> applyToMarkets = Sets.newHashSet(applyToAllMarkets);
		 allottmentMarket.applyToAllMarkets.addAll(applyToMarkets);
		 
		 Iterable<String> applyToAllMarketsOccupancy = Splitter.on(",").omitEmptyStrings().trimResults().split(_r.applyToAllMarketsOccupancyWithCommas);
		 Set<String> applyToAllOccupancy = Sets.newHashSet(applyToAllMarketsOccupancy);
		 allottmentMarket.applyToAllMarketsOccupancy.addAll(applyToAllOccupancy);
         
		 yieldmgmt.allottmentMarkets.add(allottmentMarket);
		}
	}	
		return ok(play.libs.Json.toJson(yieldmgmt)).as("JSON");
		
	}
	
	public static Result saveYieldMgmt() throws IllegalAccessException, InvocationTargetException{
		Form<YieldMgmt> dynamicForm = form(YieldMgmt.class).bindFromRequest();
		String supplierIdFromSession = session().get("id");
		
		YieldMgmtModel yieldMgmtModel = YieldMgmtModel.bySupplierId(Long.valueOf(supplierIdFromSession));
		List<models.yieldmgmt.RepeatRateSections> repeatRateSections = Lists.newArrayList();
		List<models.yieldmgmt.AllottmentMarket> allottmentMarkets = Lists.newArrayList();
		
		if(yieldMgmtModel == null){
			yieldMgmtModel = new YieldMgmtModel();
			BeanUtilsBean.getInstance().copyProperties(yieldMgmtModel, dynamicForm.get());
			
			for(RepeatRateSections _r : dynamicForm.get().repeatRateSections){
				models.yieldmgmt.RepeatRateSections rateSections = new models.yieldmgmt.RepeatRateSections();
				BeanUtilsBean.getInstance().copyProperties(rateSections, _r);
				rateSections.repeatCancellations = Lists.newArrayList();
				rateSections.repeatCancellations1 = Lists.newArrayList();
				
				for(CancellationSection _r1 : _r.repeatCancellations){
					models.yieldmgmt.CancellationSection cancellationSection = new models.yieldmgmt.CancellationSection();
					BeanUtilsBean.getInstance().copyProperties(cancellationSection, _r1);
					rateSections.repeatCancellations.add(cancellationSection);
				}
				for(CancellationSection1 _r2 : _r.repeatCancellations1){
					models.yieldmgmt.CancellationSection1 cancellationSection1 = new models.yieldmgmt.CancellationSection1();
					BeanUtilsBean.getInstance().copyProperties(cancellationSection1, _r2);
					rateSections.repeatCancellations1.add(cancellationSection1);
				}
				
				Object[] array1 = _r.minimumStayDays.toArray();
				rateSections.minimumStayDaysWithCommas = Joiner.on(",").skipNulls().join(array1);
				
				Object[] array2 = _r.applicableDays.toArray();
				rateSections.applicableDaysWithCommas = Joiner.on(",").skipNulls().join(array2);
				
				Object[] array3 = _r.rateMarketType.toArray();
				rateSections.rateMarketTypeWithCommas = Joiner.on(",").skipNulls().join(array3);
				
				repeatRateSections.add(rateSections);
			}
			for(AllottmentMarket _r : dynamicForm.get().allottmentMarkets){
				models.yieldmgmt.AllottmentMarket allottmentMarket = new models.yieldmgmt.AllottmentMarket();
				BeanUtilsBean.getInstance().copyProperties(allottmentMarket, _r);
				
				Object[] array1 = _r.allotmentMarketRates.toArray();
				allottmentMarket.allotmentMarketRatesWithCommas = Joiner.on(",").skipNulls().join(array1);
				
				Object[] array2 = _r.applyToAllMarkets.toArray();
				allottmentMarket.applyToAllMarketsWithCommas = Joiner.on(",").skipNulls().join(array2);
				
				Object[] array3 = _r.applyToAllMarketsOccupancy.toArray();
				allottmentMarket.applyToAllMarketsOccupancyWithCommas = Joiner.on(",").skipNulls().join(array3);
				
				allottmentMarkets.add(allottmentMarket);
			}
			
			yieldMgmtModel.repeatRateSections = repeatRateSections;
			yieldMgmtModel.allottmentMarkets = allottmentMarkets;
			yieldMgmtModel.supplierObject = Supplier.find.byId(Long.valueOf(supplierIdFromSession));
			yieldMgmtModel.save();
			
		}else{
			
			BeanUtilsBean.getInstance().copyProperties(yieldMgmtModel, dynamicForm.get());
			
			for(RepeatRateSections _r : dynamicForm.get().repeatRateSections){
				models.yieldmgmt.RepeatRateSections rateSections = new models.yieldmgmt.RepeatRateSections();
				BeanUtilsBean.getInstance().copyProperties(rateSections, _r);
				rateSections.repeatCancellations = Lists.newArrayList();
				rateSections.repeatCancellations1 = Lists.newArrayList();
				
				for(CancellationSection _r1 : _r.repeatCancellations){
					models.yieldmgmt.CancellationSection cancellationSection = new models.yieldmgmt.CancellationSection();
					BeanUtilsBean.getInstance().copyProperties(cancellationSection, _r1);
					rateSections.repeatCancellations.add(cancellationSection);
				}
				for(CancellationSection1 _r2 : _r.repeatCancellations1){
					models.yieldmgmt.CancellationSection1 cancellationSection1 = new models.yieldmgmt.CancellationSection1();
					BeanUtilsBean.getInstance().copyProperties(cancellationSection1, _r2);
					rateSections.repeatCancellations1.add(cancellationSection1);
				}
				
				Object[] array1 = _r.minimumStayDays.toArray();
				rateSections.minimumStayDaysWithCommas = Joiner.on(",").skipNulls().join(array1);
				
				Object[] array2 = _r.applicableDays.toArray();
				rateSections.applicableDaysWithCommas = Joiner.on(",").skipNulls().join(array2);
				
				Object[] array3 = _r.rateMarketType.toArray();
				rateSections.rateMarketTypeWithCommas = Joiner.on(",").skipNulls().join(array3);
				
				repeatRateSections.add(rateSections);
			}
			for(AllottmentMarket _r : dynamicForm.get().allottmentMarkets){
				models.yieldmgmt.AllottmentMarket allottmentMarket = new models.yieldmgmt.AllottmentMarket();
				BeanUtilsBean.getInstance().copyProperties(allottmentMarket, _r);
				
				Object[] array1 = _r.allotmentMarketRates.toArray();
				allottmentMarket.allotmentMarketRatesWithCommas = Joiner.on(",").skipNulls().join(array1);
				
				Object[] array2 = _r.applyToAllMarkets.toArray();
				allottmentMarket.applyToAllMarketsWithCommas = Joiner.on(",").skipNulls().join(array2);
				
				Object[] array3 = _r.applyToAllMarketsOccupancy.toArray();
				allottmentMarket.applyToAllMarketsOccupancyWithCommas = Joiner.on(",").skipNulls().join(array3);
				
				allottmentMarkets.add(allottmentMarket);
			}
			
			yieldMgmtModel.repeatRateSections = repeatRateSections;
			yieldMgmtModel.allottmentMarkets = allottmentMarkets;
			yieldMgmtModel.supplierObject = Supplier.find.byId(Long.valueOf(supplierIdFromSession));
			yieldMgmtModel.update();
		}
		
		return ok();
	}
	
	// Yield Management Ends
	
	public static Result index(){
		return ok(com.mnt.custom.module.yieldmgmt.views.html.yeildManagementHomePage.render());
	}
	
	public static Result getYeildHomeInformationPage(){
		UIGeneratorHelper helper = new UIGeneratorHelper(HomePageVM.class);
		return ok(com.mnt.custom.module.yieldmgmt.views.html.yeildManagementHome.render(helper));
	}
	
	public static Result generateYeildHomeInfoScript(){
	
		UIGeneratorHelper helper = new UIGeneratorHelper(HomePageVM.class);
		return ok(views.html.script.render(helper)).as("application/javascript");
	}
	
	public static Result getYeildHomeInfoJson(){
		HomePageVM homePageVM = new HomePageVM();
		return ok(play.libs.Json.toJson(homePageVM)).as("JSON");
	}
	
	public static Result saveSupplierYeildHomeInfo(){
		DynamicForm dynamicForm = new DynamicForm().bindFromRequest();
		return ok("/yield");
	}

}
