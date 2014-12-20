package com.ypg.merchant.services.controller.video;

import com.ypg.merchant.services.action.ActionResult;
import com.ypg.merchant.services.action.video.VideoDeleteClientAction;
import com.ypg.merchant.services.actionframework.ActionExecutor;
import com.ypg.merchant.services.actionframework.ActionHandle;

public class VideoDeleteActionExector implements ActionExecutor {

	@ActionHandle(VideoDeleteClientAction.class)
	public ActionResult handle(VideoDeleteClientAction action,String str1, String str2){
		System.out.println(action);
		System.out.println(str1 + str2);
		return new VideoApproveActionResult(); 
	}
}
