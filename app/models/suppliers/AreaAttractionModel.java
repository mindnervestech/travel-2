package models.suppliers;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class AreaAttractionModel extends Model{

	
	@Id
	public Long id;
	
	public String areaName1;
	public String areaDistance1;
	public String areaMinutes1;
	public String areaParameter1;
	
	public String areaName2;
	public String areaDistance2;
	public String areaMinutes2;
	public String areaParameter2;
	
	public String areaName3;
	public String areaDistance3;
	public String areaMinutes3;
	public String areaParameter3;
	
	public String areaName4;
	public String areaDistance4;
	public String areaMinutes4;
	public String areaParameter4;
	
	public String areaName5;
	public String areaDistance5;
	public String areaMinutes5;
	public String areaParameter5;
	
	public String areaName6;
	public String areaDistance6;
	public String areaMinutes6;
	public String areaParameter6;
	
	public String areaName7;
	public String areaDistance7;
	public String areaMinutes7;
	public String areaParameter7;
	
	public String areaName8;
	public String areaDistance8;
	public String areaMinutes8;
	public String areaParameter8;
	
	public String areaName9;
	public String areaDistance9;
	public String areaMinutes9;
	public String areaParameter9;
	
	public String areaName10;
	public String areaDistance10;
	public String areaMinutes10;
	public String areaParameter10;
	
	@OneToOne(cascade=CascadeType.ALL)
	public Supplier supplierObject;
	
	public static AreaAttractionModel bySupplierId(Long id) {
        return find.where().eq("supplierObject.id", id).findUnique();
    }
	
	public static Finder<Long,AreaAttractionModel> find=new Finder<Long, AreaAttractionModel>(Long.class, AreaAttractionModel.class);
}
