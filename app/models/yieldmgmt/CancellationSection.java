package models.yieldmgmt;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class CancellationSection extends Model{

	@Id
	public Long id;
	

	public String cancellationTime;
	public String penaltyCharge;
	public String nights;
	public String percentages;

}
