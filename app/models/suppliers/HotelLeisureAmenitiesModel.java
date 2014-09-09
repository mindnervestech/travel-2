package models.suppliers;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;


@Entity
public class HotelLeisureAmenitiesModel extends Model{

	@Id
	public Long id;
	
	public String hotelLeisureAmenitiesWithCommas;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	public Supplier supplierObject;
	
	public static HotelLeisureAmenitiesModel bySupplierId(Long id) {
        return find.where().eq("supplierObject.id", id).findUnique();
    }
	
	public static Finder<Long,HotelLeisureAmenitiesModel> find=new Finder<Long, HotelLeisureAmenitiesModel>(Long.class, HotelLeisureAmenitiesModel.class);
}
