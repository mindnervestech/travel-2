package models.suppliers;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;


@Entity
public class RepeatTaxSections extends Model{

	
	@Id
	public Long id;
	
	public String taxPeriodFrom;
	public String taxPeriodTo;
	public String taxName;
	public String taxAmount;
	public String taxIs;
	public String currency;
	public String taxcurrency1;
	
	public static Finder<Long,RepeatTaxSections> find = new Finder<Long,RepeatTaxSections>(Long.class,RepeatTaxSections.class);
}
