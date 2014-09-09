package com.mnt.custom.module.supplier.viewmodel;

import java.util.Date;
import java.util.List;

import com.google.common.collect.Lists;
import com.mnt.core.ui.annotation.Form;
import com.mnt.core.ui.annotation.UIFields;
import com.mnt.core.ui.annotation.UISelect;
import com.mnt.core.ui.annotation.UIVisibility;
import com.mnt.core.ui.annotation.Validation;
import com.mnt.core.ui.component.FieldType;
import com.mnt.custom.domain.BuilderFactory;
import com.mnt.custom.domain.BuilderFactory.KVMap;
import com.mnt.custom.module.supplier.viewmodel.HotelAdditionalInformation.RepeatTaxSections;

@Form(action="/save-supplier-hotel-additional-mandatory-info",
		  bindUrl="/supplier-hotel-additional-mandatory-as-json")
public class HotelAdditionalMandatoryInfo {

	

	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoMap")
	public String isAdditionalMandatoryService ="0";
	
	@UIVisibility(agents={"isAdditionalMandatoryService()==0"})
	@UIFields(type = FieldType.FType.control)
	public String additionalService;
	
	
	public List<KVMap> yesnoMap = BuilderFactory.me().getByKey("yesno");
	
	@UIFields(cssClass="casute3",type=FieldType.FType.repeat)
	public List<RepeatMandatorySections> repeatMandatorySections;
	
	@Form(name="repeatMandatorySections")
	public static class RepeatMandatorySections{
		
		@UIFields(cssClass="casute3")
		public String additionalMandatoryServiceName;
		
		@UIFields(cssClass="casute3")
		public String additionalMandatoryServiceValidityFrom;
		
		@UIFields(cssClass="casute3")
		public String additionalMandatoryServiceValidityTo;
		
		@UIFields(type = FieldType.FType.radio)
		@UISelect(seed="isApplyMap")
		public String additionalMandatoryServiceIsApply ="0";
		
		
		@UIFields(type = FieldType.FType.radio)
		@UISelect(seed="additionalMandatoryServiceCheckinMap")
		public String additionalMandatoryServiceisCheckin ="0";
		
		@UIFields(cssClass="casute3")
		public String additionalMandatoryServicePerRoomRate;
		
		@UIFields(cssClass="casute3")
		public String additionalMandatoryServicePerPersonAdultRate;
		
		@UIFields(cssClass="casute3")
		public String additionalMandatoryServicePerPersonChildRate;
		
		@UIFields(type = FieldType.FType.radio)
		@UISelect(seed="yesnoMap")
		public String isRelatedInfo ="1";
		
		@UIVisibility(agents={"isRelatedInfo() == 0"})
		@UIFields(type = FieldType.FType.control)
		public String displayRelatedInfo;
		
		
		@UIVisibility(agents={"additionalMandatoryServiceIsApply() == 1"})
		@UIFields(type = FieldType.FType.control)
		public String perPersonDisplay;
		
		@UIVisibility(agents={"additionalMandatoryServiceIsApply() == 0"})
		@UIFields(type = FieldType.FType.control)
		public String perRoomDisplay;
		
		public List<KVMap> isApplyMap= BuilderFactory.me().getByKey("isApplyMap");
		public List<KVMap> yesnoMap = BuilderFactory.me().getByKey("yesno");
		public List<KVMap> additionalMandatoryServiceCheckinMap= BuilderFactory.me().getByKey("additionalMandatoryServiceCheckinMap");
		
		
		@UIFields(cssClass="casute3", type=FieldType.FType.hidden)
		public String _key = String.valueOf(new Date().getTime() + (Math.random()*10));
		
		@UIFields(cssClass="casute3",type=FieldType.FType.repeat)
		public List<RepeatMandatorySections1> repeatMandatorySections1 = Lists.newArrayList(new RepeatMandatorySections1());
		
		
	}
	
	@Form(name="repeatMandatorySections1")
	public static class RepeatMandatorySections1{
		
		@UIFields(type = FieldType.FType.radio)
		@UISelect(seed="relatedSelectionMap")
		public String isRelatedSelection ="1";
		public List<KVMap> relatedSelectionMap= BuilderFactory.me().getByKey("relatedSelectionMap");
		
		
		@UIVisibility(agents={"isRelatedSelection() == 1"})
		@UIFields(type = FieldType.FType.control)
		public String multipleAnswer;
		
		@UIVisibility(agents={"isRelatedSelection() == 0"})
		@UIFields(type = FieldType.FType.control)
		public String answerOptions;
		
		@UIFields(cssClass="casute3")
		public String multipleSelectionAnswerChoice1;
		
		@UIFields(cssClass="casute3")
		public String multipleSelectionAnswerChoice2;
		
		@UIFields(cssClass="casute3")
		public String multipleSelectionAnswerChoice3;
		
		@UIFields(cssClass="casute3")
		public String multipleSelectionAnswerChoice4;
		
		@UIFields(cssClass="casute3")
		public String radioSelectionAnswerOptionYes;
		
		@UIFields(cssClass="casute3")
		public String radioSelectionAnswerOptionNo;
		
		@UIFields(cssClass="casute3")
		public String relatedSelectionInfo;
		
		
		
	}

}
