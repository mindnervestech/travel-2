package models.suppliers;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class HotelAdditionalInformation extends Model {

	@Id
	public Long id;
	
	public String roomTax;
	public String currencyMandatory;
	public String isMandatoryCharges;
	public String surchargePerRoom;
	public String surchargePerRoomPerctntage;
	public String tariffNotes;
	public String isMandatoryTransfers;
	public String guestAgeValidity;
	public String checkInTime;
	public String checkOutTime;
	public String isMandatorySupplement;
	public String taxContainer;
	public String AdditioanlM;
	public String supplementPeriod;
	
	@OneToOne(cascade=CascadeType.ALL)
	public Supplier supplierObject;
	
	
	@OneToMany(cascade={CascadeType.ALL})
	public List<RepeatTaxSections> repeatTaxSections;
	
	@OneToMany(cascade={CascadeType.ALL})
	public List<RepeatSupplementSections> repeatSupplementSections;
	
	
	public static HotelAdditionalInformation bySupplierId(Long id) {
        return find.where().eq("supplierObject.id", id).findUnique();
    }
	
	public static Finder<Long,HotelAdditionalInformation> find=new Finder<Long, HotelAdditionalInformation>(Long.class, HotelAdditionalInformation.class);
	
}
