package com.mnt.custom.module.admin.controllers;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Lists.transform;
import static play.data.Form.form;

import java.util.List;

import models.suppliers.Supplier;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import utils.GridViewModel;
import utils.GridViewModel.PageData;
import utils.GridViewModel.RowViewModel;

import com.google.common.base.Function;
import com.google.gson.Gson;
import com.mnt.custom.module.admin.viewmodel.SupplierSearchBean;

public class Status extends Controller{

	public static Result supplierIndex()
	{
		return ok(com.mnt.custom.module.admin.views.html.supplierSearchMain.render());
	}
	
	public static Result supplierSearch()
	{
		
		DynamicForm searchBean = DynamicForm.form().bindFromRequest();
		
		GridViewModel.PageData pageData = new PageData(Integer.valueOf(searchBean.get("rows")),
				Integer.valueOf(searchBean.get("page")));
				int page = Integer.parseInt(searchBean.get("page"));
				int limit = Integer.parseInt(searchBean.get("rows"));
				double min = Double.parseDouble(searchBean.get("rows"));
				String sidx = searchBean.get("sidx");
				String sord = searchBean.get("sord");
				List<Supplier> results = null;
				int count =0;
				
				if(searchBean.get("name") == null && searchBean.get("code") == null)
				{
					results = Supplier.find.where().isNotNull("supplierStatus").findList();
				}
				
				else if(searchBean.get("name").equals("") && searchBean.get("code").equals("")){
					results = Supplier.find.where().isNotNull("supplierStatus").findList();
				}
				else if(searchBean.get("name") != null)
				{
					results = Supplier.find.where().eq("supplierName", searchBean.get("name")).findList();
				}
				else if(searchBean.get("code") != null)
				{
					results = Supplier.find.where().eq("code", searchBean.get("code")).findList();
				}
			List<GridViewModel.RowViewModel> rows = transform(results, toJqGridFormat()) ;
			GridViewModel gridViewModel = new GridViewModel(pageData, count, rows);
			Gson g = new Gson();
			return ok(g.toJson(gridViewModel));			
	}
	private static Function<Supplier,RowViewModel> toJqGridFormat() {
		return new Function<Supplier, RowViewModel>() {
		
			@Override
			public RowViewModel apply(Supplier supplier) {
				return new GridViewModel.RowViewModel((supplier.id).intValue(), newArrayList(
					supplier.code,
					supplier.generalInformation.name,
					supplier.supplierStatus,
					Long.toString(supplier.id)));
			}
		};
	}
	
}
