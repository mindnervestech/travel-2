var supplierProfileSection2Model = {
	self : this,
	
	update:function(){
			_this = this;
			$.ajax({
				url:'/getSupplierJsonData',
				datatype:"json",
				data:{mode:$('#mode').val()},
				
				success: function(data){
					console.log(data);
					var parsed = JSON.parse(data);
					_this.renderHotelTypes(parsed);
					_this.renderHotelAmenities(parsed);
					_this.renderHotelBusinessAmenities(parsed);
					_this.renderHotelLeisureSports(parsed);
					_this.renderDocumentationTypes(parsed);
					_this.renderFirePPTypes(parsed);
					self = ko.mapping.fromJS(parsed);
					ko.applyBindings(self);
					_this.postBind(parsed);
				}
			});
	},
	postBind:function(parsed){
		
		$('[name^=hotelAmenities]').each(function(){
			if( $.inArray(parseInt($(this).val()),JSON.parse(parsed.seltecedHotelAmenities))!= -1 ){
				$(this).prop("checked", true);
			}
		});
		
		$('[name^=hotelBusinessFeature]').each(function(){
			if( $.inArray(parseInt($(this).val()),JSON.parse(parsed.seltecedHotelBusinessFeature))!= -1 ){
				$(this).prop("checked", true);
			}
		});
		
		$('[name^=hotelLeisureSport]').each(function(){
			if( $.inArray(parseInt($(this).val()),JSON.parse(parsed.seltecedHotelLeisureSport))!= -1 ){
				$(this).prop("checked", true);
			}
		});
		
		$('[name^=hotelTypes]').each(function(){
			if( $.inArray(parseInt($(this).val()),JSON.parse(parsed.seltecedHotelTypes))!= -1 ){
				$(this).prop("checked", true);
			}
		});
		$('[name^=firePP]').each(function(){
			if(JSON.parse(parsed.seltecedHotelFirePP)!=null){
				option = JSON.parse(parsed.seltecedHotelFirePP)[parseInt($(this).attr('id'))];
				if($(this).val() == option){
					$(this)[0].checked = true;
				}
			}
		});
		
		if(parsed.country != null){
		}
			
	},
	renderFirePPTypes:function(parsed){
		var source   = $("#hotelFirePPTypes-template").html();
		var template = Handlebars.compile(source);
		$("#hotelFirePPTypes_rb").html(template(parsed));
	},
	renderDocumentationTypes:function(parsed){
		var source   = $("#documentationTypes-template").html();
		var template = Handlebars.compile(source);
		$("#documentationTypes_rb").html(template(parsed));
	},
	renderHotelTypes:function(parsed){
		var source   = $("#hotelTypes-template").html();
		var template = Handlebars.compile(source);
		$("#hotel_type_cb").html(template(parsed));
	},
	renderHotelAmenities:function(parsed){
		var source   = $("#hotelAmenities-template").html();
		var template = Handlebars.compile(source);
		$("#hotel_amenities_cb").html(template(parsed));
	},
	renderHotelBusinessAmenities:function(parsed){
		var source   = $("#hotel_businessAminities-template").html();
		var template = Handlebars.compile(source);
		$("#hotel_businessAminities_cb").html(template(parsed));
	},
	renderHotelLeisureSports:function(parsed){
		var source   = $("#hotelleisure_sports-template").html();
		var template = Handlebars.compile(source);
		$("#hotel_leisure_sports_cb").html(template(parsed));
	}
};

Handlebars.registerHelper('radio-documentation_json', function(hotelTypes, options) {
	var out = "";
	
	for(i=0; i<hotelTypes.length; i++) {
		out = out + "<tr>";
		out = out + "<td style='padding-left: 0px; color: rbg(43,91,139)'>" + hotelTypes[i].displayName +
					"</td>" +
					"<td style='padding-left:10px;vertical-align:bottom' colspan='1'>" +
						"<div>";
							types = hotelTypes[i].type.split(',');
							for(j=0; j<types.length; j++) {
								out = out + "<input type='radio' value='"+j+"' id='"+hotelTypes[i].value+"' name='"+hotelTypes[i].name+"["+hotelTypes[i].value+"]'>" +
								"<label> <font class='normal'>"+types[j]+"</font></label>" ; 
							}
			out = out + "</div>" ;
		out = out +	"</td>";
		out = out + "</tr>";
	} 

	
	return out;
});

Handlebars.registerHelper('checkbox-hotelLeisureSport_json', function(hotelTypes, options) {
	var out = "<table border=2>";
	out = out + "<tr>";
	for(i=0; i<hotelTypes.length; i++) {
		if(i%5==0){
			out = out + "</tr>";
			out = out + "<tr>";
		}
		out = out + "<td><font class='normal'>" +
						"<label>" +
							"<input type='checkbox' value="+hotelTypes[i].value+"  name='hotelLeisureSport[]'>" +
							hotelTypes[i].displayName +
						"</label>" +
						"</font></td>";
	} 

	out = out + "</tr>";
	return out + "</table>";
});

Handlebars.registerHelper('checkbox-hotelBusinessFeature_json', function(hotelTypes, options) {
	var out = "<table border=2>";
	out = out + "<tr>";
	for(i=0; i<hotelTypes.length; i++) {
		if(i%5==0){
			out = out + "</tr>";
			out = out + "<tr>";
		}
		out = out + "<td><font class='normal'>" +
						"<label>" +
							"<input type='checkbox' value="+hotelTypes[i].value+"  name='hotelBusinessFeature[]'>" +
							hotelTypes[i].displayName +
						"</label>" +
						"</font></td>";
	} 

	out = out + "</tr>";
	return out + "</table>";
});

Handlebars.registerHelper('checkbox-hotelTypes_json', function(hotelTypes, options) {
	var out = "<table border=2>";
	out = out + "<tr>";
	for(i=0; i<hotelTypes.length; i++) {
		if(i%5==0){
			out = out + "</tr>";
			out = out + "<tr>";
		}
		out = out + "<td><font class='normal'>" +
						"<label>" +
							"<input type='checkbox' value="+hotelTypes[i].value+"  name='hotelTypes[]'>" +
							hotelTypes[i].displayName +
						"</label>" +
						"</font></td>";
	} 

	out = out + "</tr>";
	return out + "</table>";
});

Handlebars.registerHelper('checkbox-hotelAmenities_json', function(hotelTypes, options) {
	var out = "<table border=2>";
	out = out + "<tr>";
	
	//var json = JSON.parse($('#supplier_seltecedHotelAmenities').val());
	for(i=0; i<hotelTypes.length; i++) {
		if(i%5==0){
			out = out + "</tr>";
			out = out + "<tr>";
		}
		out = out + "<td><font class='normal'>" +
						"<label>" +
							"<input type='checkbox' value="+hotelTypes[i].value+"  name='hotelAmenities[]'>" +
							hotelTypes[i].displayName +
						"</label>" +
						"</font></td>";
	} 

	out = out + "</tr>";
	return out + "</table>";
});	



supplierProfileSection2Model.update();
