package models.suppliers;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;


@Entity
public class BusinessCommunicationModel extends Model{

	
	@Id
	public Long id;
	
	
	public String communicationEmail;
	public String reCommunicationEmail;
	public String communicationEmailCC;
	public String reCommunicationEmailCC;
	public String isCCRequired;
	
	@OneToOne(cascade=CascadeType.ALL)
	public Supplier supplierObject;
	
	public static BusinessCommunicationModel bySupplierId(Long id) {
        return find.where().eq("supplierObject.id", id).findUnique();
    }
	
	public static Finder<Long,BusinessCommunicationModel> find=new Finder<Long, BusinessCommunicationModel>(Long.class, BusinessCommunicationModel.class);
}
