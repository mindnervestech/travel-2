package models.suppliers;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import play.db.ebean.Model;

@Entity
public class ProfieGeneralInformationModel extends Model{

	@Id
	public Long id;
	
	public String code;
	public String propertyName;
	public String name;
	public String address;
	public String country;
	public String province;
	public String city;
	public String pin;
	public String rating;
	public String password;
	
	public String marketRatePolicy;
	public String isChain;
	public String isHealthComplaint;
	public String affiliatedChain;
	public String currency;
	
	@OneToOne(cascade=CascadeType.ALL)
	public Supplier supplierObject;
	
	public static ProfieGeneralInformationModel bySupplierId(Long id) {
        return find.where().eq("supplierObject.id", id).findUnique();
    }
	
	public static Finder<Long,ProfieGeneralInformationModel> find=new Finder<Long, ProfieGeneralInformationModel>(Long.class, ProfieGeneralInformationModel.class);
}