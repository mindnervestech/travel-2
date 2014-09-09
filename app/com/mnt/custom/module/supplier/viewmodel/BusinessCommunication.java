package com.mnt.custom.module.supplier.viewmodel;

import java.util.List;

import com.mnt.core.ui.annotation.Form;
import com.mnt.core.ui.annotation.UIFields;
import com.mnt.core.ui.annotation.UISelect;
import com.mnt.core.ui.annotation.UIVisibility;
import com.mnt.core.ui.annotation.Validation;
import com.mnt.core.ui.component.FieldType;
import com.mnt.custom.domain.BuilderFactory;
import com.mnt.custom.domain.BuilderFactory.KVMap;


@Form(action="/save-supplier-hotel-business-contact-info",
		  bindUrl="/supplier-hotel-business-contact-info-as-json")
public class BusinessCommunication {
	
	@Validation(required=true)
	@UIFields(cssClass="casute3")
	public String communicationEmail;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3")
	public String reCommunicationEmail;

	@Validation(required=true)
	@UIFields(cssClass="casute3")
	public String communicationEmailCC;
	
	@Validation(required=true)
	@UIFields(cssClass="casute3")
	public String reCommunicationEmailCC;
	
	@Validation(required=true)
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoMap")
	public String isCCRequired ="0";

	@UIVisibility(agents={"isCCRequired()==1"})
	@UIFields(type = FieldType.FType.control)
	public String IDReqCCEmail;
	
	
	public List<KVMap> yesnoMap = BuilderFactory.me().getByKey("yesno");
}
