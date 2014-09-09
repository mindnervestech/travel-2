YieldMgmt.customPostBind = function(){
	$('#_field_YieldMgmt_allotmentMarketRates').multiSelect();
	$('#_field_YieldMgmt_applyToAllMarkets').multiSelect();
	$('#_field_YieldMgmt_applyToAllMarketsOccupancy').multiSelect();
	$('#_field_YieldMgmt_rateMarketType').multiSelect();
	$('body').on ('[id^=_field_repeatRateSections_rateMarketType]' , function(){
		alert("here");
		$(this).multiSelect()
	});
	
}
