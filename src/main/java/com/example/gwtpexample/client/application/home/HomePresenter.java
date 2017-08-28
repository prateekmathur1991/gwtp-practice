package com.example.gwtpexample.client.application.home;

import java.util.logging.Logger;

import com.example.gwtpexample.client.api.RestResource;
import com.example.gwtpexample.client.application.ApplicationPresenter;
import com.example.gwtpexample.client.place.NameTokens;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rest.delegates.client.ResourceDelegate;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

public class HomePresenter extends Presenter<HomePresenter.MyView, HomePresenter.MyProxy> {
	
	private static final Logger LOGGER = Logger.getLogger(HomePresenter.class.getName());
	
	private ResourceDelegate<RestResource> restResourceDelegate;
	
	interface MyView extends View {
	}

	@ProxyStandard
	@NameToken(NameTokens.HOME)
	interface MyProxy extends ProxyPlace<HomePresenter> {
	}

	@Inject
	HomePresenter(EventBus eventBus, MyView view, MyProxy proxy, ResourceDelegate<RestResource> restResourceDelegate) {
		super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);
		this.restResourceDelegate = restResourceDelegate;
	}

	@Override
	protected void onReveal() {
		super.onReveal();
		LOGGER.info(restResourceDelegate.toString());
	}
}