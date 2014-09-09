import java.util.List;
import java.util.Map;

import models.CCTVStatus;
import models.Currency;
import models.Day;
import models.HotelAmenities;
import models.HotelBusinessAmenities;
import models.HotelDescriptionOptions;
import models.HotelLeisureAmenities;
import models.HotelLocationArea;
import models.MarketRatePolicy;
import models.Months;
import models.NightLife;
import models.RoomAmenity;
import models.Salutation;
import models.ShoppingFacility;
import models.Time;
import models.Year;
import play.Application;
import play.GlobalSettings;
import play.libs.Yaml;

import com.avaje.ebean.Ebean;


public class Global extends GlobalSettings{

	@Override
	public void onStart(Application arg0) {
		//Ebean.execute(Ebean.createCallableSql("TRUNCATE TABLE PROVINCE"));
		//Ebean.execute(Ebean.createCallableSql("TRUNCATE TABLE COUNTRY"));
		Map<String, List<Object>> all = (Map<String, List<Object>>)Yaml.load("countries.yml");
        Ebean.save(all.get("countries"));
        Ebean.save(all.get("provinces"));
        Ebean.delete(MarketRatePolicy.find.all());
        all = (Map<String, List<Object>>)Yaml.load("marketRatePolicies.yml");
        Ebean.save(all.get("marketRatePolicies"));
		
		Ebean.delete(HotelDescriptionOptions.find.all());
		all = (Map<String, List<Object>>)Yaml.load("hotelDescriptionOptions.yml");
		Ebean.save(all.get("hotelDescriptionOptions"));
		
		Ebean.delete(HotelLocationArea.find.all());
		all = (Map<String, List<Object>>)Yaml.load("hotelLocationAreas.yml");
		Ebean.save(all.get("hotelLocationAreas"));
		
		Ebean.delete(NightLife.find.all());
		all = (Map<String, List<Object>>)Yaml.load("nightLife.yml");
		Ebean.save(all.get("nightLife"));
		
		Ebean.delete(ShoppingFacility.find.all());
		all = (Map<String, List<Object>>)Yaml.load("shoppingFacility.yml");
		Ebean.save(all.get("shoppingFacility"));
		
		Ebean.delete(Salutation.find.all());
		all = (Map<String, List<Object>>)Yaml.load("salutation.yml");
		Ebean.save(all.get("salutation"));
		
		Ebean.delete(Currency.find.all());
		all = (Map<String, List<Object>>)Yaml.load("currency.yml");
		Ebean.save(all.get("currency"));
		
		Ebean.delete(Day.find.all());
		all = (Map<String, List<Object>>)Yaml.load("day.yml");
		Ebean.save(all.get("day"));
		
		Ebean.delete(Months.find.all());
		all = (Map<String, List<Object>>)Yaml.load("months.yml");
		Ebean.save(all.get("month"));
		
		Ebean.delete(Time.find.all());
		all = (Map<String, List<Object>>)Yaml.load("time.yml");
		Ebean.save(all.get("time"));
		
		Ebean.delete(Year.find.all());
		all = (Map<String, List<Object>>)Yaml.load("year.yml");
		Ebean.save(all.get("year"));
		
		Ebean.delete(HotelAmenities.find.all());
		all = (Map<String, List<Object>>)Yaml.load("hotelAmenities.yml");
		Ebean.save(all.get("hotelAmenities"));
		
		Ebean.delete(HotelBusinessAmenities.find.all());
		all = (Map<String, List<Object>>)Yaml.load("hotelBusinessAmenities.yml");
		Ebean.save(all.get("hotelBusinessAmenities"));
		
		Ebean.delete(HotelLeisureAmenities.find.all());
		all = (Map<String, List<Object>>)Yaml.load("hotelLeisureAmenities.yml");
		Ebean.save(all.get("hotelLeisureAmenities"));
		
		Ebean.delete(CCTVStatus.find.all());
		all = (Map<String, List<Object>>)Yaml.load("cctvStatus.yml");
		Ebean.save(all.get("cctvStatus"));
		
		Ebean.delete(RoomAmenity.find.all());
		all = (Map<String, List<Object>>)Yaml.load("roomAmenities.yml");
        Ebean.save(all.get("roomAmenities"));
        
		super.onStart(arg0);
	}
	
}
