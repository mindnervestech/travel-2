package models.suppliers;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;


@Entity
public class RepeatSupplementSections extends Model{
	
	@Id
	public Long id;
	
	public String supplementFromMonth;
	public String supplementToMonth;
	public String supplementFromDay;
	public String supplementToDay;
	public String supplementFromYear;
	public String supplementToYear;
	public String supplementName;
	public String supplementDescription;
	public String isApply;
	public String supplementPerRoomRate;
	public String isPerRoomRate;
	public String perRoomRateTax;
	public String perRoomRateTaxPercent;
	public String perRoomRateDiscount;
	public String perRoomRateDiscountPercent;
	public String supplementPerPersonAdultRate;
	public String supplementPerPersonChildRate;
	public String isPerPersonAdultRate;
	public String isPerPersonChildRate;
	public String perPersonAdultRateTax;
	public String perPersonAdultRateTaxPercent;
	public String perPersonAdultRateDiscount;
	public String perPersonAdultRateDiscountPercent;
	public String perPersonChildRateTax;
	public String perPersonChildRateTaxPercent;
	public String perPersonChildRateDiscount;
	public String perPersonChildRateDiscountPercent;

	
	public static Finder<Long,RepeatSupplementSections> find = new Finder<Long,RepeatSupplementSections>(Long.class,RepeatSupplementSections.class);

}
