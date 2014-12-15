package com.ypg.merchant.services.concurrent.workmanager.ext;

import commonj.work.WorkEvent;

public class WorkEventHelper {

	static public String decode(WorkEvent we){
		switch(we.getType()){
		case 1:return "ACCEPTED";
		case 2: return "REJECTED";
		case 3: return "STARTED";
		case 4: return "COMPLETED";		
		default:return "UNKNOWN code" + we.getType();
		}
	}

}
