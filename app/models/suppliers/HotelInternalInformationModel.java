package models.suppliers;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.mnt.core.ui.annotation.UIFields;
import com.mnt.core.ui.annotation.UISelect;
import com.mnt.core.ui.annotation.Validation;
import com.mnt.core.ui.component.FieldType;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;


@Entity
public class HotelInternalInformationModel extends Model{

	
	@Id
	public Long id;
	
	public String builtYear;
	public String lastRenovateYear;
	public String noOfFloors;
	public String noOfRooms;
	public String guestTelCityCode;
	public String guestTelCityNumber;
	public String guestFaxCityCode;
	public String guestFaxCityNumber;
	public String hotelWebsite;
	public String hotelEmail;
	public String directTelCityCode;
	public String directTelCityNumber;
	public String directFaxCityCode;
	public String directFaxCityNumber;
	public String generalManagerName;
	public String generalManagerEmail;
	public String isSafetyComplaint;
	
	@OneToOne(cascade=CascadeType.ALL)
	public Supplier supplierObject;
	
	public static HotelInternalInformationModel bySupplierId(Long id) {
        return find.where().eq("supplierObject.id", id).findUnique();
    }
	
	public static Finder<Long,HotelInternalInformationModel> find=new Finder<Long, HotelInternalInformationModel>(Long.class, HotelInternalInformationModel.class);
}
