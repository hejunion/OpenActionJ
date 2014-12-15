package com.ypg.merchant.services.action;


import java.io.Serializable;

public class ActionObject implements Serializable {

	private static final long serialVersionUID = -9207778897255497139L;

	private String key;
    private String value;
    
    
    
	public ActionObject(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	
	public String getValueOfString()
	{
		return this.getValue();
	}

}
