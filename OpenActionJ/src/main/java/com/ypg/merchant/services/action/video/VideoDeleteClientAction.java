package com.ypg.merchant.services.action.video;

import com.ypg.merchant.services.action.ActionCallBack;
import com.ypg.merchant.services.action.ClientAction;

public class VideoDeleteClientAction extends ClientAction {

	private static final long serialVersionUID = 2399510011628788331L;

	public VideoDeleteClientAction() {
		super(MODULE_VIDEOS, "", DELETE);
	}

	@Override
	public void actionPerformed(ActionCallBack actionCallBack) {
		actionCallBack.afterExection(this);
		
	}

}
