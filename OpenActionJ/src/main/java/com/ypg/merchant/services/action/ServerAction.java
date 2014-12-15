package com.ypg.merchant.services.action;


@SuppressWarnings("serial")
public abstract class ServerAction extends  AbstractAction {
    public ServerAction(String module, String subModule, String name) {
        super(module, subModule, name);
    }
}
