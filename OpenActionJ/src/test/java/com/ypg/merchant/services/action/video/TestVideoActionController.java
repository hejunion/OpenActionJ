package com.ypg.merchant.services.action.video;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ypg.merchant.services.action.ActionResult;
import com.ypg.merchant.services.actionframework.InvalidActionMethodException;
import com.ypg.merchant.services.controller.video.VideoActionController;
import com.ypg.merchant.services.controller.video.VideoActionControllerConfiguration;
import com.ypg.merchant.services.controller.video.VideoRunner;

public class TestVideoActionController {

	@Test
	public void test() throws InvalidActionMethodException {
		   ApplicationContext ctx = 
				   new AnnotationConfigApplicationContext(VideoActionControllerConfiguration.class);

		   //VideoActionController videoActionCtrl = ctx.getBean(VideoActionController.class);
		   VideoRunner runner = ctx.getBean(VideoRunner.class);
		   
		   VideoApproveClientAction videoApproveAction = new VideoApproveClientAction();
		   ActionResult obj =  runner.run(videoApproveAction);
		   System.out.println("Result="+obj);
		   VideoDeleteClientAction videoDeleteAction = new VideoDeleteClientAction();
		   ActionResult obj1 = runner.run(videoDeleteAction);
		   System.out.println("Result="+obj1);


	}
	

}
