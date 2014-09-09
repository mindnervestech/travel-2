package models.suppliers.roomtype;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import models.suppliers.Supplier;
import play.db.ebean.Model;

@Entity
public class RoomTypeModel extends Model {
	
	@Id
	public Long id;
	
	public String roomName;
	public String maxOccupancy;
	public String maxAdultOccupancy;
	public String maxAdultChildOccupancy;
	public String isTwinBeds;
	public String childSharingWithAdult;
	public String isChildChargeable;
	public String isExtraBed;
	public String isExtraBedCharge;
	public String extraBedAmount;
	public String netRate;
	public String isRoomSuite = "0";
	public String roomAmenitiesWithCommas;
	
	@OneToOne(cascade=CascadeType.ALL)
	public Supplier supplierObject;
	
	public static RoomTypeModel bySupplierId(Long id){
		return find.where().eq("supplierObject.id", id).findUnique();
	}
	
	public static Finder<Long, RoomTypeModel> find = new Finder<Long, RoomTypeModel>(Long.class, RoomTypeModel.class);
}
