package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class MarketRatePolicy  extends Model{
	
	@Id
	public Long id;
	
	@Column(unique=true)
	public String code;
	
	public String name;
	
	public static Finder<Long,MarketRatePolicy> find=new Finder<Long, MarketRatePolicy>(Long.class, MarketRatePolicy.class);
	
}