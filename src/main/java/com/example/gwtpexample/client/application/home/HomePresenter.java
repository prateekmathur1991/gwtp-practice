package com.example.gwtpexample.client.application.home;

import com.example.gwtpexample.client.api.RestResource;
import com.example.gwtpexample.client.application.ApplicationPresenter;
import com.example.gwtpexample.client.place.NameTokens;
import com.example.gwtpexample.shared.dto.RestResponseDto;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rest.delegates.client.ResourceDelegate;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;

public class HomePresenter extends Presenter<HomePresenter.MyView, HomePresenter.MyProxy> {

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
	public boolean useManualReveal() {
		return true;
	}

	@Override
	public void prepareFromRequest(PlaceRequest request) {
		super.prepareFromRequest(request);

		restResourceDelegate.withCallback(new AsyncCallback<RestResponseDto>() {

			@Override
			public void onFailure(Throwable caught) {
				GWT.log("REST request failure");
				GWT.log(caught.getLocalizedMessage());
				revealPresenter();
			}

			@Override
			public void onSuccess(RestResponseDto result) {
				GWT.log(result.getToken());
				GWT.log(result.getRefreshToken());
				revealPresenter();
			}
		});
	}

	private void revealPresenter() {
		getProxy().manualReveal(this);
	}
}