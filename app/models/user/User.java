package models.user;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import models.suppliers.Supplier;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class User extends Model{

	
	@Id
	public Long id;
	
	public String code;
	public String userName;
	public String password;
	public String userType;
	
	@OneToOne(cascade=CascadeType.ALL)
	public Supplier supplierObject;
	
	public static Finder<Long,User> find=new Finder<Long, User>(Long.class, User.class);
}
