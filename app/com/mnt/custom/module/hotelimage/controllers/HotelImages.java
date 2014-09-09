package com.mnt.custom.module.hotelimage.controllers;

import helpers.ImageFormatter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import models.hotelimage.HotelImage;
import models.suppliers.Supplier;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import play.mvc.Result;

import com.mnt.custom.module.hotelimage.views.html.sampleImageUpload;

public class HotelImages extends Controller {
	
	public static Result profile(){
		List<String> imageIdList = new ArrayList<String>(6);
		List<HotelImage> hotelImages = HotelImage.find.all();
		
		for(int i=0;i<6;i++){
			imageIdList.add("0");
		}
		for(int j=0;j<6;j++){
			for(int k=0;k<hotelImages.size();k++){
				if((j+1) == hotelImages.get(k).id){
					imageIdList.add(j,hotelImages.get(k).code);
				}
			}
		}
		
		return ok(sampleImageUpload.render(imageIdList));
	}
	
	public static Result saveHotelImage() throws IOException{
		DynamicForm form = DynamicForm.form().bindFromRequest();
		MultipartFormData body = request().body().asMultipartFormData();
		FilePart picture = body.getFile("img1");
		
		String supplierIdFromSession = session().get("id");
    	Supplier supplier = Supplier.find.byId(Long.parseLong(supplierIdFromSession));
		
		String imgcode = form.get("imgcode");
		HotelImage image = HotelImage.find.where().eq("code", imgcode).findUnique();
		
		if (image == null && picture != null) {
		    HotelImage image1 = new HotelImage();
		    image1.id = Long.parseLong(form.get("imgid"));
		    image1.code = imgcode;
		    image1.imageBytes = ImageFormatter.image(picture);
		    image1.supplier = supplier;
		    image1.save();
		    return ok();
		} else {
			deleteHotelImage(imgcode);
			HotelImage image1 = new HotelImage();
			image1.id = Long.parseLong(form.get("imgid"));
			image1.code = imgcode;
		    image1.imageBytes = ImageFormatter.image(picture);
		    image1.supplier = supplier;
		    image1.save();
		    flash("error", "Missing file");
		    return ok();    
		}
	}
	
	public static Result getHotelImage(String code) throws IOException{
        HotelImage image = HotelImage.find.where().eq("code", code).findUnique();
        return ok(image.imageBytes).as("image/jpg");
	}
	
	public static Result getWebPageImage(String id) throws IOException{
        HotelImage image = HotelImage.find.where().eq("id", id).findUnique();
        return ok(image.imageBytes).as("image/jpg");
	}
	
	private static void deleteHotelImage(String code){
		HotelImage.find.where().eq("code" , code).findUnique().delete();
	}
}
