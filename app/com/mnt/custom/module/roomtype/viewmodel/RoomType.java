package com.mnt.custom.module.roomtype.viewmodel;

import java.util.Date;
import java.util.List;

import com.google.common.collect.Lists;
import com.mnt.core.ui.annotation.Form;
import com.mnt.core.ui.annotation.UIFields;
import com.mnt.core.ui.annotation.UISelect;
import com.mnt.core.ui.annotation.UIVisibility;
import com.mnt.core.ui.annotation.Validation;
import com.mnt.core.ui.component.FieldType;
import com.mnt.custom.domain.BuilderFactory;
import com.mnt.custom.domain.BuilderFactory.KVMap;


@Form(action="/save-room-type",
		bindUrl="/room-type-as-json")
public class RoomType{

	@Validation(unique=true)
	@UIFields(cssClass="casute3")
	public String roomName;
	
	public List<KVMap> maxOccupancyMap = BuilderFactory.me().getByKey("maxOccupancy");
	
	@UIFields(cssClass="casute3",type=FieldType.FType.select)
	@UISelect(seed="maxOccupancyMap")
	public String maxOccupancy;
	
	@UIFields(cssClass="casute3",type=FieldType.FType.select)
	@UISelect(remote=true,depends={"maxOccupancy"},params={"maxOccupancy"},dataSourceURL="/get-adult-occupancy",seed="adultChildOccupancyMap")
	public String maxAdultOccupancy;
	
	public List<KVMap> adultChildOccupancyMap = BuilderFactory.me().getByKey("maxOccupancy");
	@Validation()
	@UIFields(cssClass="casute3",type=FieldType.FType.select)
	@UISelect(remote=true,depends={"maxOccupancy"},params={"maxOccupancy"},dataSourceURL="/get-adult-child-occupancy",seed="adultChildOccupancyMap")
	public String maxAdultChildOccupancy;
	
	public List<KVMap> yesnoMap = BuilderFactory.me().getByKey("yesno");
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(remote=true,depends={"maxOccupancy"},params={"maxOccupancy"},dataSourceURL="/get-adult-occupancy",seed="yesnoMap")
	public String isTwinBeds;
	
	@UIVisibility(agents={"maxAdultOccupancy:>1"})
	public String twinBedDiv;
	
	public List<KVMap> childSharingMap = BuilderFactory.me().getByKey("childSharing");
	
	@UIFields(cssClass="casute3",type=FieldType.FType.select)
	@UISelect(seed="childSharingMap")
	public String childSharingWithAdult;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoMap")
	public String isChildChargeable="0";
	
	@UIVisibility(agents={"maxAdultChildOccupancy:>0"})
	public String childrenpolicy;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoMap")
	public String isExtraBed;
	
	@UIVisibility(agents={"isExtraBed:!=0"})
	public String extrachargediv;
	
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoMap")
	public String isExtraBedCharge;
	
	@Validation(unique=true)
	@UIFields(cssClass="casute3")
	public String extraBedAmount;

	public List<KVMap> netRateMap = BuilderFactory.me().getByKey("netRate");
	
	@Validation(unique=true)
	@UIFields(type = FieldType.FType.select)
	@UISelect(seed="netRateMap")
	public String netRate;
	
	@UIVisibility(agents={"isExtraBedCharge:!=0"})
	public String extrachargediv2;
	
	@Validation(unique=true)
	@UIFields(type = FieldType.FType.radio)
	@UISelect(seed="yesnoMap")
	public String isRoomSuite = "0";
	
	public List<KVMap> roomAmenityMap = BuilderFactory.me().getByKey("roomAmenityMap");
	
	@UIFields(type = FieldType.FType.checkbox)
	@UISelect(seed="roomAmenityMap")
	public List<String> roomAmenities = Lists.newArrayList("2","4");
	
	@UIFields(type = FieldType.FType.control)
	@UIVisibility(agents={"isChildChargeable()==1"})
	public String childrenPolicyDisplay;
	
	@UIFields(type = FieldType.FType.repeat)
	public List<RepeatChildrenPolicy> repeatChildrenPolicy;
	
	@Form(name="repeatChildrenPolicy")
	public static class RepeatChildrenPolicy{
		
		@UIFields(cssClass="casute3",type = FieldType.FType.select)
		@UISelect(seed="ageMap")
		public String fromAge;
		
		@UIFields(cssClass="casute3",type = FieldType.FType.select)
		@UISelect(seed="ageMap")
		public String toAge;
		
		@UIFields(cssClass="casute3",type = FieldType.FType.text)
		public String childtext;
		
		@UIFields(cssClass="casute3",type = FieldType.FType.select)
		@UISelect(seed="netRateMap")
		public String netRate;
		
		public List<KVMap> ageMap = BuilderFactory.me().getByKey("age");
		public List<KVMap> netRateMap = BuilderFactory.me().getByKey("netRate");
		
		@UIFields(cssClass="casute3", type=FieldType.FType.hidden)
		public String _key = String.valueOf(new Date().getTime() + (Math.random()*10));
			
	}
}
