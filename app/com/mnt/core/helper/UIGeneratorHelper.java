package com.mnt.core.helper;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.mnt.core.ui.annotation.Form;
import com.mnt.core.ui.annotation.UIFields;
import com.mnt.core.ui.annotation.UISelect;
import com.mnt.core.ui.annotation.UIVisibility;
import com.mnt.core.ui.annotation.Validation;
import com.mnt.core.ui.component.BuildFieldType;
import com.mnt.core.ui.component.FieldType;
import com.mnt.core.ui.component.FieldType.Type;

public class UIGeneratorHelper {
	
	private final Class ctx;
	
	
	
	public UIGeneratorHelper(Class clazz){
		this.ctx = clazz;
		try {
			build();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean isPrefix;
	public String formAction;
	public String formName;
	public String formUniqueKeys;
	public String bindUrl;
	public Map<String,UIGeneratorHelper> repeatMap = new HashMap<String,UIGeneratorHelper>();
	public Map<String,FieldType> fieldMap = new HashMap<String,FieldType>();
	public Map<String,List<String>> actorMap = new HashMap<String,List<String>>();
	
	private UIGeneratorHelper withPrefix(boolean value){
		this.isPrefix = value;
		return this;
	}
	
	private UIGeneratorHelper build() throws SecurityException, NoSuchFieldException{
		if(ctx.isAnnotationPresent(Form.class)){
			Form form = (Form) ctx.getAnnotation(Form.class);
			formAction = form.action();
			bindUrl = form.bindUrl();
			formUniqueKeys = form.uniqueKey();
			formName = form.name().equals("")?ctx.getSimpleName():form.name();
			
		}
		
		for(Field f :ctx.getFields()){
			if(f.isAnnotationPresent(UIVisibility.class)){
				if(!f.isAnnotationPresent(UIFields.class)){
					String js = visibilityJS(f.getAnnotation(UIVisibility.class),f);
					actorMap.put(f.getName(), Lists.newArrayList(js));
				}
			}
			if(f.isAnnotationPresent(UIFields.class)){
				UIFields uiFields = f.getAnnotation(UIFields.class);
				
				if(Type.valueOf(uiFields.type()) == Type.repeat){
					ParameterizedType listType = (ParameterizedType)f.getGenericType();
					Class<?> listClass = (Class<?>) listType.getActualTypeArguments()[0];
					System.out.println(listClass.getName());
					repeatMap.put(f.getName(), new UIGeneratorHelper(listClass).build());
				}
					BuildFieldType fieldType = BuildFieldType.me().withAnnotation(uiFields);
					fieldType.withName(isPrefix?formName+"."+f.getName():f.getName());
					if(f.isAnnotationPresent(Validation.class)){
						fieldType.withValidation(BuildFieldType.BuildJQValidation.me().
								withAnnotation(f.getAnnotation(Validation.class)));
					}
					if(f.isAnnotationPresent(UISelect.class)){
						fieldType.withUISelect(BuildFieldType.BuildUISelect.me().
								withAnnotation(f.getAnnotation(UISelect.class)));
					}
					if(f.isAnnotationPresent(UIVisibility.class)){
						fieldType.withUIControls(f.getAnnotation(UIVisibility.class));
					}
					fieldMap.put(fieldType.name(),fieldType);
			}
		}
		return this;
	}
	
	private String visibilityJS(UIVisibility visibility, Field f) throws SecurityException, NoSuchFieldException{
			StringBuilder builder = new StringBuilder();
			
			for(String agent: visibility.agents()){
				String[] _a = agent.split(":");
				
				builder.
				append("$(\'[name="+_a[0].trim()+"]').click(function(){ \n").
					append(visibilityHelper(_a,visibility,f)).
				append("}); \n");
				
				builder.
				append("$(\'[name="+_a[0].trim()+"]').each(function(){ \n").
					append(visibilityHelper(_a,visibility,f)).
				append("}); \n");
				
			}
			
			return builder.toString();
	}
	
	 private String visibilityHelper(String[] agent,UIVisibility visibility, Field f) throws SecurityException, NoSuchFieldException{
		 StringBuilder builder = new StringBuilder();
		 
		 if(Type.valueOf(ctx.getField(agent[0]).getAnnotation(UIFields.class).type()) == Type.radio){
			 builder.append("\t if( $(this).val()" +agent[1].trim()+ " && $(this).is(':checked')){ \n");
		 }
		 		 
		 else{
			 builder.append("\t if( $(this).val()" +agent[1].trim()+ "){ \n");
		 }
			
		 	if("visibility".equals(visibility.control())){
		 		for(String actor: visibility.actors()){
					builder.append("\t\t $('[id="+("this".equals(actor)?f.getName():actor)+"]').show();\n");
				}
					builder.append("\t } \n");
					builder.append("\t else{ \n");
				for(String actor: visibility.actors()){
					builder.append("\t\t $('[id="+("this".equals(actor)?f.getName():actor)+"]').hide();\n");
				}	
					builder.append("\t } \n");
		 	}
		 	
		 	if("disable".equals(visibility.control())){
		 		for(String actor: visibility.actors()){
		 			builder.append("\t\t $('#"+("this".equals(actor)?f.getName():"_field_"+formName+"_"+actor)+"').attr('readonly', true);\n");
				}
					builder.append("\t } \n");
					builder.append("\t else{ \n");
				for(String actor: visibility.actors()){
					builder.append("\t\t $('#"+("this".equals(actor)?f.getName():"_field_"+formName+"_"+actor)+"').removeAttr('readonly');\n");
				}	
					builder.append("\t } \n");
		 	}
		 	
			return builder.toString();	
	 }
	
	
}
