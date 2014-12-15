package com.ypg.merchant.services.controller.video;

import org.springframework.stereotype.Component;

import com.ypg.merchant.services.action.Action;
import com.ypg.merchant.services.action.ActionResult;
import com.ypg.merchant.services.actionframework.AbstractActionController;
import com.ypg.merchant.services.actionframework.InvalidActionMethodException;
import com.ypg.merchant.services.actionframework.profile.ProfileExecution;

@Component
public class VideoActionController extends AbstractActionController{



	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onRemove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	@ProfileExecution
	public ActionResult doAction(Action action, Object... args)
			throws InvalidActionMethodException {
		return super.doAction(action, args);
	}

	
}
