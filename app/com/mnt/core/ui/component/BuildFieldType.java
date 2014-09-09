package com.mnt.core.ui.component;

import com.custom.domain.DomainEnum;
import com.mnt.core.ui.annotation.UIFields;
import com.mnt.core.ui.annotation.UIVisibility;
import com.mnt.core.ui.annotation.Validation;

public class BuildFieldType implements FieldType {

	private BuildFieldType(){}
	public static BuildFieldType  me(){
		return new BuildFieldType();
	}
	public BuildFieldType withAnnotation(UIFields field){
		this.cssClass = field.cssClass();
		this.htmlAttrib = field.htmlAttrib();
		this.label = field.label();
		this.type = Type.valueOf(field.type());
		this.name = field.name();
		this.computerOn = field.computedOn();
		this.databind = field.databind();
		return this;
	}
	private Type type;
	@Override
	public Type ctype() {
		return type;
	}
	public BuildFieldType withType(Type type){
		this.type = type;
		return this;
	}

	String label;
	@Override
	public String label() {
		return label;
	}
	public BuildFieldType withLabel(String label){
		this.label = label;
		return this;
	}

	String name;
	@Override
	public String name() {
		return name;
	}
	public BuildFieldType withName(String name){
		this.name = name;
		return this;
	}

	
	private JQValidation validation; 
	@Override
	public JQValidation validation() {
		return validation;
	}
	public BuildFieldType withValidation(JQValidation validation){
		this.validation = validation;
		return this;
	}

	
	private String cssClass;
	@Override
	public String cssClass() {
		return cssClass;
	}
	public BuildFieldType withCssClass(String cssClass){
		this.cssClass = cssClass;
		return this;
	}

	private UISelect select;
	@Override
	public UISelect select() {
		return this.select;
	}
	public BuildFieldType withUISelect(UISelect select){
		this.select = select;
		return this;
	}
	private String htmlAttrib;
	private String[] computerOn;
	
	@Override
	public String htmlAttrib() {
		return htmlAttrib;
	}
	public BuildFieldType withHtmlAttrib(String htmlAttrib){
		this.htmlAttrib =htmlAttrib;
		return this;
	}
	
	public static class BuildUISelect implements UISelect{

		private String dataSourceURL;
		private String[] params;
		private String seed;
		private boolean remote;
		private String[] depends;

		private BuildUISelect(){}
		
		public static BuildUISelect me(){
			return new BuildUISelect();
		}
		
		public BuildUISelect withAnnotation(com.mnt.core.ui.annotation.UISelect select){
			this.dataSourceURL = select.dataSourceURL();
			this.params = select.params();
			this.seed = select.seed();
			this.remote = select.remote();
			this.depends = select.depends();
			return this;
		}	
		
		@Override
		public String dataSourceURL() {
			return this.dataSourceURL;
		}

		@Override
		public String[] params() {
			return this.params;
		}

		@Override
		public String seed() {
			return this.seed;
		}

		@Override
		public boolean remote(){
			return this.remote;
		}

		@Override
		public String[] depends() {
			return this.depends;
		}
		
	}
	
	public static class BuildJQValidation implements JQValidation{
		
		private BuildJQValidation(){}
		
		public BuildJQValidation withAnnotation(Validation validation){
			this.date = validation.date();
			this.digits = validation.digits();
			this.email = validation.email();
			this.maxlength = validation.maxlength();
			this.message = validation.messages();
			this.minlength = validation.minlength();
			this.required = validation.required();
			this.remote = validation.remote();
			this.number = validation.number();
			
			return this;
		}
		public static BuildJQValidation me(){
			return new BuildJQValidation();
		}
		private boolean required;
		@Override
		public boolean required() {
			return required;
		}
		public BuildJQValidation withRequired(boolean required){
			this.required =required;
			return this;
		}

		private int minlength;
		@Override
		public int minlength() {
			return minlength;
		}
		public BuildJQValidation withMin(int minlength){
			this.minlength = minlength;
			return this;
		}

		private int maxlength;
		
		@Override
		public int maxlength() {
			return maxlength;
		}
		public BuildJQValidation withMax(int maxlength){
			this.maxlength =maxlength;
			return this;
		}

		private boolean email;
		@Override
		public boolean email() {
			return email;
		}
		public BuildJQValidation withEmail(boolean email){
			this.email = email;
			return this;
		}

		private boolean date;
		@Override
		public boolean date() {
			return date;
		}
		public BuildJQValidation withDate(boolean date){
			this.date =date;
			return this;
		}

		
		private String message;
		@Override
		public String messages() {
			return message;
		}
		public BuildJQValidation withMessage(String message){
			this.message = message;
			return this;
		}

		private boolean number;
		@Override
		public boolean number() {
			return number;
		}
		public BuildJQValidation withNumber(boolean number){
			this.number = number;
			return this;
		}

		private boolean digits;
		@Override
		public boolean digits() {
			return digits;
		}
		public BuildJQValidation withDigits(boolean digits){
			this.digits = digits;
			return this;
		}

		private String remote;
		@Override
		public String remote() {
			return remote;
		}
		public BuildJQValidation withRemote(String remote){
			this.remote = remote;
			return this;
		}
		
	}

	@Override
	public String[] computedOn() {
		return this.computerOn;
	}
	@Override
	public int compareTo(FieldType arg0) {
		return 0;
	}
	@Override
	public DomainEnum[] options() {
		return null;
	}
	@Override
	public int order() {
		return 0;
	}
	@Override
	public boolean hidden() {
		return false;
	}
	@Override
	public boolean autocomplete() {
		return false;
	}
	@Override
	public boolean multiselect() {
		return false;
	}
	@Override
	public boolean isSearchable() {
		return false;
	}
	@Override
	public boolean mandatory() {
		return false;
	}
	@Override
	public ValueWrapper value() {
		return null;
	}
	@Override
	public int row() {
		return 0;
	}
	@Override
	public int col() {
		return 0;
	}
	
	private UIControl controls;
	
	public void withUIControls(final UIVisibility uiVisibility){
		controls = new UIControl() {
			
			@Override
			public String control() {
				return uiVisibility.control();
			}
			
			@Override
			public String[] agents() {
				return uiVisibility.agents();
			}
			
			@Override
			public String[] actors() {
				return uiVisibility.actors();
			}
		};
	}
	
	@Override
	public UIControl controls() {
		return controls;
	}
	
	private String databind;
	@Override
	public String databind() {
		return databind;
	}
	
	public void withDatabind(String databind){
		this.databind = databind;
	}
	
	

}
