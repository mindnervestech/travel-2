package models.hotelimage;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import models.suppliers.HotelTransportationModel;
import models.suppliers.Supplier;
import models.user.User;

import play.db.ebean.Model;

@Entity
public class HotelImage extends Model {

	@Id
	public Long id;
	
	public String code;
	
	@Lob	
	public byte[] imageBytes;
	
	@ManyToOne(cascade=CascadeType.ALL)
	public Supplier supplier;
	
	public static HotelImage bySupplierId(Long id) {
        return find.where().eq("supplier.id", id).findUnique();
    }
	
	public static Finder<Long,HotelImage> find=new Finder<Long, HotelImage>(Long.class, HotelImage.class);
}
