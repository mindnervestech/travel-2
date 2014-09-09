package models.suppliers;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import models.hotelimage.HotelImage;
import play.db.ebean.Model;

@Entity
public class Supplier extends Model{
	
	
	
	@Id
	public Long id;
	
	public String code;
	public String supplierStatus;
	
	@OneToOne(cascade=CascadeType.ALL)
	public AreaAttractionModel areaAttractionModel;
	
	@OneToOne(cascade=CascadeType.ALL)
	public BusinessCommunicationModel businessCommunicationModel;
	
	@OneToOne(cascade=CascadeType.ALL)
	public HotelAmenitiesModel hotelAmenitiesModel;
	
	@OneToOne(cascade=CascadeType.ALL)
	public HotelAdditionalInformation hotelAdditionalInformation;
	
	@OneToOne(cascade=CascadeType.ALL)
	public HotelAdditionalMandatoryInfo hotelAdditionalMandatoryInfo;
	
	@OneToOne(cascade=CascadeType.ALL)
	public HotelBillingInformationModel billingInformationModel;
	
	@OneToOne(cascade=CascadeType.ALL)
	public HotelBusinessAmenitiesModel hotelBusinessAmenitiesModel;
	
	@OneToOne(cascade=CascadeType.ALL)
	public HotelContactInformationModel hotelContactInformationModel;
	
	@OneToOne(cascade=CascadeType.ALL)
	public HotelDescriptionModal descriptionModal;
	
	@OneToOne(cascade=CascadeType.ALL)
	public HotelHealthSafetyModel hotelHealthSafetyModel;
	
	@OneToOne(cascade=CascadeType.ALL)
	public HotelInternalInformationModel hotelInternalInformationModel;
	
	@OneToOne(cascade=CascadeType.ALL)
	public HotelLeisureAmenitiesModel hotelLeisureAmenitiesModel;
	
	@OneToOne(cascade=CascadeType.ALL)
	public HotelLocationModel hotelLocationModel;
	
	@OneToOne(cascade=CascadeType.ALL)
	public HotelTransportationModel hotelTransportationModel;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	public ProfieGeneralInformationModel generalInformation;
	
	@OneToOne(cascade=CascadeType.ALL)
	public MealOverlayModel mealOverlayModel;

	@OneToOne(cascade=CascadeType.ALL)
	public HotelAdditionalInformation additionalInformation;
	
	@OneToOne(cascade=CascadeType.ALL)
	public HotelAdditionalMandatoryInfo additionalMandatoryInfo;
	
	@OneToMany(cascade=CascadeType.ALL)
	public List<HotelImage> hotelImages;
	
	public static Finder<Long,Supplier> find=new Finder<Long, Supplier>(Long.class, Supplier.class);
}
