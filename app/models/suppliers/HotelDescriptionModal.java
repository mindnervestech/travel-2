package models.suppliers;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;


import play.db.ebean.Model;
import play.db.ebean.Model.Finder;


@Entity
public class HotelDescriptionModal extends Model{
	
	
	@Id
	public Long id;
	
	public String profileDescription;
	public String locationArea;
	public String shoppingFacility;
	public String nightLife;
	public String hotelDescriptionOptionWithCommas;
	
	@OneToOne(cascade=CascadeType.ALL)
	public Supplier supplierObject;
	
	public static HotelDescriptionModal bySupplierId(Long id) {
        return find.where().eq("supplierObject.id", id).findUnique();
    }
	
	public static Finder<Long,HotelDescriptionModal> find=new Finder<Long, HotelDescriptionModal>(Long.class, HotelDescriptionModal.class);
	

}
