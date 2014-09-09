package models.suppliers;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.mnt.core.ui.annotation.UIFields;
import com.mnt.core.ui.annotation.Validation;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;


@Entity
public class HotelLocationModel extends Model{

	
	@Id
	public Long id;
	
	public String hotelLocation1;
	public String hotelLocation2;
	public String hotelLocation3;
	
	@OneToOne(cascade=CascadeType.ALL)
	public Supplier supplierObject;
	
	public static HotelLocationModel bySupplierId(Long id) {
        return find.where().eq("supplierObject.id", id).findUnique();
    }
	
	public static Finder<Long,HotelLocationModel> find=new Finder<Long, HotelLocationModel>(Long.class, HotelLocationModel.class);
	
}
