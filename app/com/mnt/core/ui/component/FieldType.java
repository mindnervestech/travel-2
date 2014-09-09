package com.mnt.core.ui.component;

import java.util.List;

import com.custom.domain.DomainEnum;



public interface FieldType extends Comparable<FieldType>{
	Type ctype();
	DomainEnum[] options();
	
	String label();
	String name();
	int order();
	boolean hidden();
	boolean autocomplete();
	boolean multiselect();
	boolean isSearchable();
	boolean mandatory();
	String databind();
	ValueWrapper value();
	JQValidation validation();
	UIControl controls();
	int row();
	int col();
	String cssClass();
	String htmlAttrib();
	UISelect select();
	//TODO UILink link();
	String[] computedOn();
	
	public interface UISelect{
		String dataSourceURL();
		String[] params();
		String seed();
		boolean remote();
		String[] depends();
	}
	
	public interface UILink{
		String dataSourceURL();
		String[] params();
		boolean remote();
		String target();
		String[] depends();
	}
	
	public interface JQValidation{
		boolean required() ;
		int minlength() ;
		int maxlength() ; 
		boolean email() ;
		boolean date() ;
		String messages() ;
		boolean number();
		boolean digits();
		String remote();
	}
	
	public interface UIControl {
		String[] actors();
		String[] agents();
		String control();
	}
	
	enum Type{
		text,
		password,
		select,
		file,
		checkbox,
		hidden,
		radio,
		textarea,
		email,
		button,
		repeat,
		multiselect,
		label,
		repeatlabel,
		INPUT,
		SELECT_OPTION,
		LIST,
		SEARCH,
		DATE,
		control,
		image
		
	}
	
	
	
	public static String makeMeEnableWhen = ",enable:";
	public static String makeMeVisibleWhen = ",visible:";
	
	public interface FType{
		String text = "text";
		String password = "password";
		String select = "select";
		String file = "file";
		String checkbox = "checkbox";
		String hidden = "hidden";
		String radio = "radio";
		String textarea = "textarea";
		String button = "button";
		String repeat = "repeat";
		String multiselect = "multiselect";
		String label = "label";
		String repeatlabel = "repeatlabel";
		String email = "email";
		String control = "control";
		String image = "image";
		
	}
	
}
