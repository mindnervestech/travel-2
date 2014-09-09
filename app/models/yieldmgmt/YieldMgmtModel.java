package models.yieldmgmt;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import models.suppliers.Supplier;
import play.db.ebean.Model;



@Entity
public class YieldMgmtModel extends Model{
	
	@Id
	public Long id;
	
	@OneToOne(cascade=CascadeType.ALL)
	public Supplier supplierObject;
	
	@OneToMany(cascade={CascadeType.ALL})
	public List<RepeatRateSections> repeatRateSections;
	
	@OneToMany(cascade={CascadeType.ALL})
	public List<AllottmentMarket> allottmentMarkets;
	
	
	public static YieldMgmtModel bySupplierId(Long id) {
        return find.where().eq("supplierObject.id", id).findUnique();
    }
	
		
	public static Finder<Long,YieldMgmtModel> find=new Finder<Long, YieldMgmtModel>(Long.class, YieldMgmtModel.class);

}
