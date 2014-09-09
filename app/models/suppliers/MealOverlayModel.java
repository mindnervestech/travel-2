package models.suppliers;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import models.yieldmgmt.YieldMgmtModel;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;


@Entity
public class MealOverlayModel extends Model{

	@Id
	public Long id;
	
	public String mealFromDate;
	public String mealToDate;
	public String mealType;
	public String mealName;
	public String mealAdultRate;
	public String isAdultIncludeTax;
	public String mealAdultTax;
	public String mealAdultTaxPercent;
	public String mealAdultDiscount;
	public String mealAdultDiscountPercent;
	
	@OneToOne(cascade=CascadeType.ALL)
	public Supplier supplierObject;
	
	
	@OneToMany(cascade={CascadeType.ALL})
	public List<RepeatChildMealRateSections> repeatChildMealRateSections;
	
	
	public static MealOverlayModel bySupplierId(Long id) {
        return find.where().eq("supplierObject.id", id).findUnique();
    }
	
	public static Finder<Long,MealOverlayModel> find=new Finder<Long, MealOverlayModel>(Long.class, MealOverlayModel.class);


}
