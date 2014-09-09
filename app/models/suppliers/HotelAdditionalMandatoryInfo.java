package models.suppliers;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import play.db.ebean.Model;

@Entity
public class HotelAdditionalMandatoryInfo extends Model{

	@Id
	public Long id;
	
	public String isAdditionalMandatoryService;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	public Supplier supplierObject;
	
	
	@OneToMany(cascade={CascadeType.ALL})
	public List<RepeatMandatorySections> repeatMandatorySections;
	
	
	public static HotelAdditionalMandatoryInfo bySupplierId(Long id) {
        return find.where().eq("supplierObject.id", id).findUnique();
    }
	
	public static Finder<Long,HotelAdditionalMandatoryInfo> find=new Finder<Long, HotelAdditionalMandatoryInfo>(Long.class, HotelAdditionalMandatoryInfo.class);
	
}
