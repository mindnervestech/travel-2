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
public class HotelContactInformationModel extends Model{

	
	@Id
	public Long id;
	
	public String mainContactName;
	public String title;
	public String directTelCode;
	public String directTelNumber;
	public String directFaxCode;
	public String directFaxNumber;
	public String extension;
	public String directEmail;
	public String tollFreeCode;
	public String tollFreeNumber;
	public String reservationContactName;
	public String reservationtitle;
	public String reservationDirectTelCode;
	public String reservationDirectTelNumber;
	public String reservationDirectEmail;
	public String reservationExtension;
	public String reservationDeptDirectTelCode;
	public String reservationDeptDirectTelNumber;
	public String reservationDeptFaxCode;
	public String reservationDeptFaxNumber;
	public String reservationDeptExtension;
	public String salutation;
	public String isSameAddress ="0";
	public String faxRecieve ="0";

	@OneToOne(cascade=CascadeType.ALL)
	public Supplier supplierObject;
	
	public static HotelContactInformationModel bySupplierId(Long id) {
        return find.where().eq("supplierObject.id", id).findUnique();
    }
	
	public static Finder<Long,HotelContactInformationModel> find=new Finder<Long, HotelContactInformationModel>(Long.class, HotelContactInformationModel.class);
	
}
