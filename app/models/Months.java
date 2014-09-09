package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class Months extends Model{
	
	@Id
	public Long id;
	
	@Column(unique=true)
	public String code;
	
	public String name;
	
	public static Finder<Long,Months> find=new Finder<Long, Months>(Long.class, Months.class);

}
