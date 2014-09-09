package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;


@Entity
public class HotelLeisureAmenities extends Model{
	
	@Id
	public Long id;
	
	@Column(unique=true)
	public String code;
	
	public String name;
	
	
	public static Finder<Long,HotelLeisureAmenities> find=new Finder<Long, HotelLeisureAmenities>(Long.class, HotelLeisureAmenities.class);
}
