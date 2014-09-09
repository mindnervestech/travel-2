package com.mnt.custom.module.supplier.viewmodel;

import java.util.List;

import com.mnt.core.ui.annotation.Form;
import com.mnt.core.ui.annotation.UIFields;
import com.mnt.core.ui.annotation.UISelect;
import com.mnt.core.ui.annotation.Validation;
import com.mnt.core.ui.component.FieldType;
import com.mnt.custom.domain.BuilderFactory;
import com.mnt.custom.domain.BuilderFactory.KVMap;


@Form(action="/save-supplier-hotel-attractions-info",
		  bindUrl="/supplier-hotel-attractions-as-json")
public class AreaAttractions {

	@Validation(required=true)
	@UIFields(cssClass="casute3")
	public String areaName1;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3")
	public String areaDistance1;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3")
	public String areaMinutes1;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3",type=FieldType.FType.select)
	@UISelect(seed="parameterMap")
	public String areaParameter1;
	
	@UIFields(cssClass="casute3")
	public String areaName2;
	
	@UIFields(cssClass="casute3")
	public String areaDistance2;
	
	@UIFields(cssClass="casute3")
	public String areaMinutes2;
	
	@UIFields(cssClass="casute3",type=FieldType.FType.select)
	@UISelect(seed="parameterMap")
	public String areaParameter2;
	
	@UIFields(cssClass="casute3")
	public String areaName3;
	
	@UIFields(cssClass="casute3")
	public String areaDistance3;
	
	@UIFields(cssClass="casute3")
	public String areaMinutes3;
	
	@UIFields(cssClass="casute3",type=FieldType.FType.select)
	@UISelect(seed="parameterMap")
	public String areaParameter3;
	
	@UIFields(cssClass="casute3")
	public String areaName4;
	
	@UIFields(cssClass="casute3")
	public String areaDistance4;
	
	@UIFields(cssClass="casute3")
	public String areaMinutes4;
	
	@UIFields(cssClass="casute3",type=FieldType.FType.select)
	@UISelect(seed="parameterMap")
	public String areaParameter4;
	
	@UIFields(cssClass="casute3")
	public String areaName5;
	
	@UIFields(cssClass="casute3")
	public String areaDistance5;
	
	@UIFields(cssClass="casute3")
	public String areaMinutes5;
	
	@UIFields(cssClass="casute3",type=FieldType.FType.select)
	@UISelect(seed="parameterMap")
	public String areaParameter5;
	
	@UIFields(cssClass="casute3")
	public String areaName6;
	
	@UIFields(cssClass="casute3")
	public String areaDistance6;
	
	@UIFields(cssClass="casute3")
	public String areaMinutes6;
	
	@UIFields(cssClass="casute3",type=FieldType.FType.select)
	@UISelect(seed="parameterMap")
	public String areaParameter6;
	
	@UIFields(cssClass="casute3")
	public String areaName7;
	
	@UIFields(cssClass="casute3")
	public String areaDistance7;
	
	@UIFields(cssClass="casute3")
	public String areaMinutes7;
	
	@UIFields(cssClass="casute3",type=FieldType.FType.select)
	@UISelect(seed="parameterMap")
	public String areaParameter7;
	
	@UIFields(cssClass="casute3")
	public String areaName8;
	
	@UIFields(cssClass="casute3")
	public String areaDistance8;
	
	@UIFields(cssClass="casute3")
	public String areaMinutes8;
	
	@UIFields(cssClass="casute3",type=FieldType.FType.select)
	@UISelect(seed="parameterMap")
	public String areaParameter8;
	
	@UIFields(cssClass="casute3")
	public String areaName9;
	
	@UIFields(cssClass="casute3")
	public String areaDistance9;
	
	@UIFields(cssClass="casute3")
	public String areaMinutes9;
	
	@UIFields(cssClass="casute3",type=FieldType.FType.select)
	@UISelect(seed="parameterMap")
	public String areaParameter9;
	
	@UIFields(cssClass="casute3")
	public String areaName10;
	
	@UIFields(cssClass="casute3")
	public String areaDistance10;
	
	@UIFields(cssClass="casute3")
	public String areaMinutes10;
	
	@UIFields(cssClass="casute3",type=FieldType.FType.select)
	@UISelect(seed="parameterMap")
	public String areaParameter10;
	
	
	public List<KVMap> parameterMap = BuilderFactory.me().getByKey("parameterMap");
}
