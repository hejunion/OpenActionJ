package com.ypg.merchant.services.action.video;


import com.ypg.merchant.services.action.ActionCallBack;
import com.ypg.merchant.services.action.ClientAction;

public final class VideoApproveClientAction extends ClientAction {

	private static final long serialVersionUID = 2255616371561953609L;

	public VideoApproveClientAction() {
		super(MODULE_VIDEOS, "", APPROVE);
	}

	@Override
	public void actionPerformed(ActionCallBack actionCallBack) {
		actionCallBack.afterExection(this);
		
	}
	

}
