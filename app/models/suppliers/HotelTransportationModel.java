package models.suppliers;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import play.db.ebean.Model;

@Entity
public class HotelTransportationModel extends Model{
	
	
	@Id
	public Long id;
	
	public String airportName1;
	public String airportDirection1;
	public String airportDistance1;
	public String airportMinutes1;
	public String airportParameter1;
	
	public String airportName2;
	public String airportDirection2;
	public String airportDistance2;
	public String airportMinutes2;
	public String airportParameter2;

	public String railWayStationName1;
	public String railWayStationDirection1;
	public String railWayStationDistance1;
	public String railWayStationMinutes1;
	public String railWayStationParameter1;
	
	public String railWayStationName2;
	public String railWayStationDirection2;
	public String railWayStationDistance2;
	public String railWayStationMinutes2;
	public String railWayStationParameter2;
	
	public String subwayName1;
	public String subwayDirection1;
	public String subwayDistance1;
	public String subwayMinutes1;
	public String subwayParameter1;
	
	public String subwayName2;
	public String subwayDirection2;
	public String subwayDistance2;
	public String subwayMinutes2;
	public String subwayParameter2;
	
	public String cruisePortName1;
	public String cruisePortDirection1;
	public String cruisePortDistance1;
	public String cruisePortMinutes1;
	public String cruisePortParameter1;
	
	public String cruisePortName2;
	public String cruisePortDirection2;
	public String cruisePortDistance2;
	public String cruisePortMinutes2;
	public String cruisePortParameter2;
	
	@OneToOne(cascade=CascadeType.ALL)
	public Supplier supplierObject;
	
	public static HotelTransportationModel bySupplierId(Long id) {
        return find.where().eq("supplierObject.id", id).findUnique();
    }
	
	public static Finder<Long,HotelTransportationModel> find=new Finder<Long, HotelTransportationModel>(Long.class, HotelTransportationModel.class);
}
