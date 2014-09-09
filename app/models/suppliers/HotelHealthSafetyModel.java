package models.suppliers;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import play.db.ebean.Model;

@Entity
public class HotelHealthSafetyModel extends Model{

	@Id
	public Long id;
	
	public String isDocumetationPublicLiability;
	public String documetationPublicLiabilityExpiryDate;
	public String isDocumetationFireAssesment;
	public String documetationFireAssesmentExpiryDate;
	public String isDocumetationAuthorityLicense;
	public String isDocumetationInternalFireAlarm;
	public String isDocumetationHACCP;
	public String isDocumetationStaffTrainingForFire;
	public String isDocumetationStaffTrainingForHealth;
	public String isFirePrecautionWorkingAlarm;
	public String isFirePrecautionSmokeDetectorinPublicArea;
	public String isFirePrecautionSmokeDetectorinGuestRoom;
	public String isFirePrecautionSmokeDetectorinAppartment;
	public String isFirePrecautionServiceAnnually;
	public String isFirePrecautionInternalFireAlarmTest;
	public String isFirePrecautionExtinguisherinPublicArea;
	public String isFirePrecautionEmergencyLighting;
	public String isFirePrecautionForPWD;
	public String noOfExits;
	public String isExitUnlocked;
	public String isExitClearlySigned;
	public String isExitRoutesIlluminated;
	public String isExitMoreStaircase;
	public String isACCentral;
	public String isACIndependent;
	public String isLiftAllFloor;
	public String isLiftInternalClosingDoor;
	public String isLiftRelevantSign;
	public String isLiftNoSmoking;
	public String isLiftNoUnaccompaniedChildren;
	public String isLiftEventOfFire;
	public String isBedRoomFireSafetyInstruction;
	public String isBedRoomElectricDisconnect;
	public String isBedRoomBalcony;
	public String isBedRoomBalconyHeight;
	public String isBedRoomBalconyGaps;
	public String isBedRoomAdjoiningRooms;
	public String adjoiningRoomsNumber;
	public String isKitchenSelfCatering;
	public String isKitchenRegularlyServiced;
	public String isKitchenSelfCateringUsageInstruction;
	public String isMainKitchen;
	public String isKitchenTemperatureCheck;
	public String isKitchenPestsProofed;
	public String isChildInternalPlayArea;
	public String isChildExternalPlayArea;
	public String isChildSupervise;
	public String isChildEquipmentCheck;
	public String isChildOperationalMonthsWithCommas;
	public String isSwimmingRules;
	public String isSwimmingTiming;
	public String isSwimmingDepth;
	public String isSwimmingDiving;
	public String isSwimmingUnaccompaniedChildren;
	public String isSwimmingLifeGuardInfo;
	public String isSwimmingNoGlass;
	public String isSwimmingLifeGuardAtOpeningTime;
	public String isChildrenPool;
	public String isChildrenPoolSeperated;
	public String isSwimmingDepthMarking;
	public String isSwimmingPoolCleaned;
	public String isSwimmingPoolCleanedRecords;
	public String isSwimmingHeatedPool;
	public String isSwimmingHeatedPoolMonthsWithCommas;
	public String isGasHeaters;
	public String isInternalGasHeaters;
	public String isExternalGasHeaters;
	public String isServicingDocumentation;
	public String isMaintainanceDocumentation;
	public String cctvStatusWithCommas;
	public String additionalInformationCommnets;
	public String additionalInformationName;
	public String additionalInformationDesignation;

	@OneToOne(cascade=CascadeType.ALL)
	public Supplier supplierObject;
	
	public static HotelHealthSafetyModel bySupplierId(Long id) {
        return find.where().eq("supplierObject.id", id).findUnique();
    }
	
	public static Finder<Long,HotelHealthSafetyModel> find=new Finder<Long, HotelHealthSafetyModel>(Long.class, HotelHealthSafetyModel.class);

}
