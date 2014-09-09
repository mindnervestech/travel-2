package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Query;

import com.avaje.ebean.Ebean;
import com.mnt.custom.domain.BuilderFactory.KVMap;

import play.db.ebean.Model;

@Entity
public class Country extends Model{
	
	@Id
	public Long id;
		
	@Column(unique=true)
	public String code;
	
	public String name;
	
	List<Province> provinces;
	
	public static Finder<Long,Country> find=new Finder<Long, Country>(Long.class, Country.class);
	
	public List<Province> myProvinces() {
		List<Province> provinces = Ebean.find(Province.class).where().eq("country",id).findList();
	    return provinces;
    }
	
	public  List<KVMap> myProvincesKVMap(){
		List<Province> provinces = Ebean.find(Province.class).select("name").where().eq("country",this).findList();
		List<KVMap> provincesAsKVMap = new ArrayList<KVMap>();
		for(Province c : provinces){
			provincesAsKVMap.add(new KVMap(String.valueOf(c.id),c.name));
		}
		return provincesAsKVMap;
	}
	
}
