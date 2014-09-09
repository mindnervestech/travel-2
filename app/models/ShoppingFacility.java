package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;


@Entity
public class ShoppingFacility extends Model{

	
	@Id
	public Long id;
	
	@Column(unique=true)
	public String code;
	
	public String name;
	
	public static Finder<Long,ShoppingFacility> find=new Finder<Long, ShoppingFacility>(Long.class, ShoppingFacility.class);
}
