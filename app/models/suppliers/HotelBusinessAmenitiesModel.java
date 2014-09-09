package models.suppliers;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

import com.google.common.collect.Lists;

@Entity
public class HotelBusinessAmenitiesModel extends Model{

	@Id
	public Long id;
	
	public String hotelBusinessAmenitiesWithCommas;
	
	@OneToOne(cascade=CascadeType.ALL)
	public Supplier supplierObject;
	
	public static HotelBusinessAmenitiesModel bySupplierId(Long id) {
        return find.where().eq("supplierObject.id", id).findUnique();
    }
	
	public static Finder<Long,HotelBusinessAmenitiesModel> find=new Finder<Long, HotelBusinessAmenitiesModel>(Long.class, HotelBusinessAmenitiesModel.class);
}
