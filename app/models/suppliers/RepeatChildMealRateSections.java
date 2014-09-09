package models.suppliers;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public  class RepeatChildMealRateSections extends Model{
	
	
	@Id
	public Long id;
	
	
	public String childFromAge;
	public String childToAge;
	public String mealChildRate;
	public String isChildIncludeTax;
	public String mealChildTax;
	public String mealChildTaxPercent;
	public String mealChildDiscount;
	public String mealChildDiscountPercent;
	
	public static Finder<Long,RepeatChildMealRateSections> find = new Finder<Long,RepeatChildMealRateSections>(Long.class,RepeatChildMealRateSections.class);

}