package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class Day extends Model{
	
	@Id
	public Long id;
	
	@Column(unique=true)
	public String code;
	
	public String name;

	
	public static Finder<Long,Day> find=new Finder<Long, Day>(Long.class, Day.class);
}
