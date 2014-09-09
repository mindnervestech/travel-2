package models.yieldmgmt;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;


@Entity
public class CancellationSection1 extends Model{
	
	
	@Id
	public Long id;

	
	public String cancellationTime1;
	public String penaltyCharge1;
	public String nights1;
	public String percentages1;

}
