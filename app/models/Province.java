package models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class Province extends Model{

	
	@Id
	public Long id;
	
	@Column(unique=true)
	public String code;
	
	public String name;
	
	@ManyToOne(cascade=CascadeType.ALL)
	public Country country;
	
	
	public static Finder<Long,Province> find=new Finder<Long, Province>(Long.class, Province.class);
}
