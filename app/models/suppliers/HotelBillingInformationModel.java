package models.suppliers;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class HotelBillingInformationModel extends Model{

	
	@Id
	public Long id;
	
	
	public String name;
	public String accountingCntctFirstName;
	public String accountingCntctLastName;
	public String accountingCntctTitle;
	public String accountingCntctEmail;
	public String accountingCntctTelCode;
	public String accountingCntctTelNumber;
	public String accountingCntctFaxCode;
	public String accountingCntctFaxNumber;
	public String accountingCntctExt;
	public String isInvoicesWillGo;
	public String isWireService;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	public Supplier supplierObject;
	
	public static HotelBillingInformationModel bySupplierId(Long id) {
        return find.where().eq("supplierObject.id", id).findUnique();
    }
	
	public static Finder<Long,HotelBillingInformationModel> find=new Finder<Long, HotelBillingInformationModel>(Long.class, HotelBillingInformationModel.class);
}
