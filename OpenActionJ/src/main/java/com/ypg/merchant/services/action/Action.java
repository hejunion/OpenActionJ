package com.ypg.merchant.services.action;

import java.io.Serializable;

public interface Action extends Serializable {
	
	//Modules
	public final static String MODULE_VIDEOS = "Videos";

	
	//Actions
	public final static String APPROVE ="Approve";
	//Actions
	public final static String DELETE ="Delete";
	
	//Parameter KEYS
    public final static String SUBJECT_VIDEO_APPROVE="SUBJECT_VIDEO_APPROVE";

    //Parameter Values
    public final static String Value_Video_Approve_Client_Reading="VALUE_VIDEO_APPROVE_CLIENT_READING";
    public final static String Value_Video_Approve_Client_Proof="VALUE_VIDEO_APPROVE_CLIENT_PROOF";

    public String getName();
    
    public String getParameter(String key);

    public ActionObject getActionObject(String key) ;
    
    public void actionPerformed(ActionCallBack actionCallBack);
}
