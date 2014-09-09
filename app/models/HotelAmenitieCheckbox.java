package models;

import java.util.List;

import play.db.ebean.Model.Finder;

public class HotelAmenitieCheckbox {

	public List<String> hotelAmenities;
	
	public static Finder<Long,HotelAmenitieCheckbox> find=new Finder<Long, HotelAmenitieCheckbox>(Long.class, HotelAmenitieCheckbox.class);
}
