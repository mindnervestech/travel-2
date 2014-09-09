package models.yieldmgmt;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class AllottmentMarket extends Model{
	
	@Id
	public Long id;
	
	public String isApplyToRates;
	public String isSpecifyAllotment;
	public String isFreeSell;
	public String isStopSellOnReq;
	public String isApplyToAllMarkets;
	public String isApplyToAllMarketsOccupancy;
	public String isFreeSellOccAdult1;
	public String isStopSellOnReqAdult1;
	public String isFreeSellOccAdult2;
	public String isStopSellOnReqAdult2;
	public String isFreeSellOccAdult3;
	public String isStopSellOnReqAdult3;
	public String releasePeriod1;
	public String releasePeriod2;
	public String releasePeriod3;
	public String releasePeriod4;
	public String cutoff_occupancy1;
	public String cutoff_occupancy2;
	public String cutoff_occupancy3;
	public String allotmentMarketRatesWithCommas;
	public String applyToAllMarketsWithCommas;
	public String applyToAllMarketsOccupancyWithCommas;

}
