package com.ypg.merchant.services.controller.video;

import com.ypg.merchant.services.action.video.VideoDeleteClientAction;
import com.ypg.merchant.services.actionframework.ActionExecutor;
import com.ypg.merchant.services.actionframework.ActionHandle;

public class VideoDeleteActionExector implements ActionExecutor {

	@ActionHandle(VideoDeleteClientAction.class)
	public void handle(VideoDeleteClientAction action,VideoActionController controller){
		System.out.println(action);
	}
}
