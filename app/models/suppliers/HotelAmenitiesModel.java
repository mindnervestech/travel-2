package models.suppliers;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class HotelAmenitiesModel extends Model{

	@Id
	public Long id;
	
	public String hotelAmenitiesWithCommas;
	
	@OneToOne(cascade=CascadeType.ALL)
	public Supplier supplierObject;
	
	public static HotelAmenitiesModel bySupplierId(Long id) {
        return find.where().eq("supplierObject.id", id).findUnique();
    }
	
	public static Finder<Long,HotelAmenitiesModel> find=new Finder<Long, HotelAmenitiesModel>(Long.class, HotelAmenitiesModel.class);
}
