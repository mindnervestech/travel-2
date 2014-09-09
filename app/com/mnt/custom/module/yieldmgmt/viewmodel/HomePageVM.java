package com.mnt.custom.module.yieldmgmt.viewmodel;

import java.util.List;

import com.mnt.core.ui.annotation.Form;
import com.mnt.core.ui.annotation.UIFields;
import com.mnt.core.ui.annotation.UISelect;
import com.mnt.core.ui.component.FieldType;
import com.mnt.custom.domain.BuilderFactory;
import com.mnt.custom.domain.BuilderFactory.KVMap;


@Form(action="/save-supplier-yeild-home-info",
		  bindUrl="/supplier-yeild-home-as-json")
public class HomePageVM {

	@UIFields(type=FieldType.FType.select)
	@UISelect(seed="roomMap")
	public String roomType;
	
	@UIFields(type=FieldType.FType.select)
	@UISelect(seed="monthsMap")
	public String fromMonth;
	
	@UIFields(type=FieldType.FType.select)
	@UISelect(seed="dayMap")
	public String fromDay;
	
	@UIFields(type=FieldType.FType.select)
	@UISelect(seed="yearMap")
	public String fromYear;
	
	@UIFields(type=FieldType.FType.select)
	@UISelect(seed="monthsMap")
	public String toMonth;
	
	@UIFields(type=FieldType.FType.select)
	@UISelect(seed="dayMap")
	public String toDay;
	
	@UIFields(type=FieldType.FType.select)
	@UISelect(seed="yearMap")
	public String toYear;
	
	@UIFields(type=FieldType.FType.select)
	@UISelect(seed="currencyMap")
	public String currency;
	
	public List<KVMap> roomMap = BuilderFactory.me().getByKey("ratingMap");
	public List<KVMap> monthsMap = BuilderFactory.me().getByKey("monthsMap");
	public List<KVMap> dayMap = BuilderFactory.me().getByKey("dayMap");
	public List<KVMap> yearMap = BuilderFactory.me().getByKey("yearMap");
	public List<KVMap> currencyMap = BuilderFactory.me().getByKey("currencyMap");
	
	
}
