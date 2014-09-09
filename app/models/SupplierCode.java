package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class SupplierCode extends Model{

	@Id
	public Long id;
	
	public Long code;
	
	public static Finder<Long,SupplierCode> find=new Finder<Long, SupplierCode>(Long.class, SupplierCode.class);
}
