package com.ypg.merchant.services.action.video;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ypg.merchant.services.action.ActionResult;
import com.ypg.merchant.services.actionframework.InvalidActionMethodException;
import com.ypg.merchant.services.controller.video.VideoActionController;
import com.ypg.merchant.services.controller.video.VideoActionControllerConfiguration;

public class TestVideoActionController {

	@Test
	public void test() throws InvalidActionMethodException {
		   ApplicationContext ctx = 
				   new AnnotationConfigApplicationContext(VideoActionControllerConfiguration.class);

		   VideoActionController videoActionCtrl = ctx.getBean(VideoActionController.class);
		   
		   VideoApproveClientAction videoApproveAction = new VideoApproveClientAction();
		   ActionResult obj =  videoActionCtrl.doAction(videoApproveAction);
		   System.out.println(obj);
		   VideoDeleteClientAction videoDeleteAction = new VideoDeleteClientAction();
		   ActionResult obj1 = videoActionCtrl.doAction(videoDeleteAction,videoActionCtrl);
		   System.out.println(obj1);


	}
	

}
