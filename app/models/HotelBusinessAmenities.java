package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;


@Entity
public class HotelBusinessAmenities extends Model{
	
	@Id
	public Long id;
	
	@Column(unique=true)
	public String code;
	
	public String name;
	
	
	public static Finder<Long,HotelBusinessAmenities> find=new Finder<Long, HotelBusinessAmenities>(Long.class, HotelBusinessAmenities.class);
}
