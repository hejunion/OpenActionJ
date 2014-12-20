package com.ypg.merchant.services.controller.video;


import com.ypg.merchant.services.action.ActionResult;
import com.ypg.merchant.services.action.video.VideoApproveClientAction;
import com.ypg.merchant.services.actionframework.ActionExecutor;
import com.ypg.merchant.services.actionframework.ActionHandle;


public class VideoApproveActionExecutor implements ActionExecutor {

	@ActionHandle(VideoApproveClientAction.class)
	public ActionResult handleAction(VideoApproveClientAction action, String str1, String str2){
		System.out.println(action);
		return new VideoApproveActionResult();
	}

}
