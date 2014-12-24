package com.ypg.merchant.services.controller.video;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ypg.merchant.services.action.Action;
import com.ypg.merchant.services.action.ActionResult;
import com.ypg.merchant.services.actionframework.InvalidActionMethodException;

@Component
public class VideoRunner {

	@Autowired VideoActionController controller; 
	
	public VideoRunner() {
		// TODO Auto-generated constructor stub
	}

	public ActionResult run(Action action) throws InvalidActionMethodException{
		return controller.doAction(action,null);
	}
}
