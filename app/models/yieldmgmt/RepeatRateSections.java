package models.yieldmgmt;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import play.db.ebean.Model;


@Entity
public class RepeatRateSections extends Model{
	
	@Id
	public Long id;
	
	public String generalRateAdult1;
	public String generalRateAdult2;
	public String generalRateAdult3;
	public String generalRateAdultInclude1;
	public String generalRateAdultInclude2;
	public String generalRateAdultInclude3;
	public String generalAdultRateBasis1;
	public String generalAdultRateBasis2;
	public String generalAdultRateBasis3;
	public String generalAdultRateType1;
	public String generalAdultRateType2;
	public String generalAdultRateType3;
	public String differentNetRates;
	public String differentRateAdult1;
	public String differentRateAdult2;
	public String differentRateAdult3;
	public String differentRateAdultInclude1;
	public String differentRateAdultInclude2;
	public String differentRateAdultInclude3;
	public String differentAdultRateBasis1;
	public String differentAdultRateBasis2;
	public String differentAdultRateBasis3;
	public String differentAdultRateType1;
	public String differentAdultRateType2;
	public String differentAdultRateType3;
	public String isPassengerNationality;
	public String noOfMinNights;
	public String minimumStayDaysWithCommas;
	public String applicableDaysWithCommas;
	public String rateMarketTypeWithCommas;
	
	@OneToMany(cascade={CascadeType.ALL})
	public List<CancellationSection> repeatCancellations;
	
	@OneToMany(cascade={CascadeType.ALL})
	public List<CancellationSection1> repeatCancellations1;
	
	
	}
