package com.ypg.merchant.services.action;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
public abstract class AbstractAction implements Action, Serializable{

    private String module;
    private String subModule;

    private String source;
    
    private String name;

    private Map<String,String> parameters = new HashMap<String,String>();

    private Map<String, ActionObject> attributes = new HashMap<String,ActionObject>();

    public AbstractAction(String module, String subModule, String name) {
		super();
		this.module = module;
		this.subModule = subModule;
		this.name = name;
	}



	public String getModule() {
		return module;
	}


	public void setModule(String module) {
		this.module = module;
	}


	public String getSubModule() {
		return subModule;
	}


	public void setSubModule(String subModule) {
		this.subModule = subModule;
	}


	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Map<String, ? extends ActionObject> getAttributes() {
		return attributes;
	}

	
	public void putActionObject(ActionObject actionObject){
		this.attributes.put(actionObject.getKey(), actionObject);
	}
	
	public ActionObject getActionObject(String key)	{
		return this.attributes.get(key);
	}



	public Map<String, String> getParameters() {
		return parameters;
	}
	
	public void setParameter(String key, String value){
		this.parameters.put(key, value);
	}

	public String getParameter(String key){

		return this.parameters.get(key);
	}
	
	
}
