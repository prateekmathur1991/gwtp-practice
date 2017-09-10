package com.example.gwtpexample.client.security;

import com.google.gwt.core.client.GWT;
import com.gwtplatform.mvp.client.proxy.Gatekeeper;

public class AccessAllGatekeeper implements Gatekeeper {

	@Override
	public boolean canReveal() {
		GWT.log("Returing true from Gatekeeper");
		return true;
	}
}