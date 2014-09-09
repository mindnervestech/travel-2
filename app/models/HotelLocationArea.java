package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class HotelLocationArea extends Model {

	
	@Id
	public Long id;
	
	@Column(unique=true)
	public String code;
	
	public String name;
	
	public static Finder<Long,HotelLocationArea> find=new Finder<Long, HotelLocationArea>(Long.class, HotelLocationArea.class);
}
