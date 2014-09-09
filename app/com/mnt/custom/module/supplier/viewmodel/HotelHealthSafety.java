package com.mnt.custom.module.supplier.viewmodel;

import java.util.List;

import com.google.common.collect.Lists;
import com.mnt.core.ui.annotation.Form;
import com.mnt.core.ui.annotation.UIFields;
import com.mnt.core.ui.annotation.UISelect;
import com.mnt.core.ui.annotation.Validation;
import com.mnt.core.ui.component.FieldType;
import com.mnt.custom.domain.BuilderFactory;
import com.mnt.custom.domain.BuilderFactory.KVMap;

@Form(action="/save-supplier-hotel-health-info",
		  bindUrl="/supplier-hotel-health-as-json")
public class HotelHealthSafety {

	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoMap")
	public String isDocumetationPublicLiability;
	
	@UIFields(cssClass="casute3")
	public String documetationPublicLiabilityExpiryDate;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoMap")
	public String isDocumetationFireAssesment;
	
	@UIFields(cssClass="casute3")
	public String documetationFireAssesmentExpiryDate;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoMap")
	public String isDocumetationAuthorityLicense;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoMap")
	public String isDocumetationInternalFireAlarm;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoMap")
	public String isDocumetationHACCP;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoMap")
	public String isDocumetationStaffTrainingForFire;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoMap")
	public String isDocumetationStaffTrainingForHealth;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isFirePrecautionWorkingAlarm;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isFirePrecautionSmokeDetectorinPublicArea;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isFirePrecautionSmokeDetectorinGuestRoom;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isFirePrecautionSmokeDetectorinAppartment;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isFirePrecautionServiceAnnually;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isFirePrecautionInternalFireAlarmTest;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isFirePrecautionExtinguisherinPublicArea;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isFirePrecautionEmergencyLighting;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isFirePrecautionForPWD;
	
	@UIFields(cssClass="casute3")
	public String noOfExits;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isExitUnlocked;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isExitClearlySigned;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isExitRoutesIlluminated;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isExitMoreStaircase;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isACCentral;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isACIndependent;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isLiftAllFloor ;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isLiftInternalClosingDoor ;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isLiftRelevantSign ;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isLiftNoSmoking ;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isLiftNoUnaccompaniedChildren ;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isLiftEventOfFire ;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isBedRoomFireSafetyInstruction ;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isBedRoomElectricDisconnect ;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isBedRoomBalcony ;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isBedRoomBalconyHeight ;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isBedRoomBalconyGaps ;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isBedRoomAdjoiningRooms ;
	
	@UIFields(cssClass="casute3")
	public String adjoiningRoomsNumber;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isKitchenSelfCatering ;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isKitchenRegularlyServiced ;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isKitchenSelfCateringUsageInstruction ;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isMainKitchen ;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isKitchenTemperatureCheck ;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isKitchenPestsProofed ;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isChildInternalPlayArea ;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isChildExternalPlayArea ;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isChildSupervise ;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isChildEquipmentCheck ;
	
	@UIFields(type = FieldType.FType.checkbox)
	@UISelect(seed="monthsMap")
	public List<String> isChildOperationalMonths;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isSwimmingRules ;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isSwimmingTiming ;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isSwimmingDepth ;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isSwimmingDiving ;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isSwimmingUnaccompaniedChildren ;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isSwimmingLifeGuardInfo ;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isSwimmingNoGlass ;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isSwimmingLifeGuardAtOpeningTime ;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isChildrenPool ;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isChildrenPoolSeperated ;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isSwimmingDepthMarking ;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isSwimmingPoolCleaned ;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isSwimmingPoolCleanedRecords ;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isSwimmingHeatedPool ;
	
	@UIFields(type = FieldType.FType.checkbox)
	@UISelect(seed="monthsMap")
	public List<String> isSwimmingHeatedPoolMonths;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isGasHeaters ;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isInternalGasHeaters ;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isExternalGasHeaters ;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isServicingDocumentation ;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoNAMap")
	public String isMaintainanceDocumentation ;
	
	@UIFields(type = FieldType.FType.checkbox)
	@UISelect(seed="cctvStatusMap")
	public List<String> cctvStatus = Lists.newArrayList("2","4");
	
	@UIFields(cssClass="casute3",type=FieldType.FType.textarea)
	public String additionalInformationCommnets;
	
	@UIFields(cssClass="casute3")
	public String additionalInformationName;
	
	@UIFields(cssClass="casute3")
	public String additionalInformationDesignation;
	
	public String cctvStatusWithCommas;
	public String isChildOperationalMonthsWithCommas;
	public String isSwimmingHeatedPoolMonthsWithCommas;
	
	public List<KVMap> yesnoMap = BuilderFactory.me().getByKey("yesno");
	public List<KVMap> yesnoNAMap = BuilderFactory.me().getByKey("yesnoNAMap");
	public List<KVMap> monthsMap = BuilderFactory.me().getByKey("monthsMap");
	public List<KVMap> cctvStatusMap = BuilderFactory.me().getByKey("cctvStatusMap");
	
}
