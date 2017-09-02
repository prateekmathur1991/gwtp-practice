package com.example.gwtpexample.client.application.home;

import com.example.gwtpexample.client.api.RestResource;
import com.example.gwtpexample.client.application.ApplicationPresenter;
import com.example.gwtpexample.client.place.NameTokens;
import com.example.gwtpexample.shared.dto.RestResponseDto;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rest.client.RestDispatch;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;

public class HomePresenter extends Presenter<HomePresenter.MyView, HomePresenter.MyProxy> {

	private RestDispatch restDispatch;
	private RestResource restResource;

	interface MyView extends View {
	}

	@ProxyStandard
	@NameToken(NameTokens.HOME)
	interface MyProxy extends ProxyPlace<HomePresenter> {
	}

	@Inject
	HomePresenter(EventBus eventBus, MyView view, MyProxy proxy, RestDispatch restDispatch, RestResource restResource) {
		super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);
		this.restDispatch = restDispatch;
		this.restResource = restResource;
	}

	@Override
	public boolean useManualReveal() {
		return true;
	}

	@Override
	public void prepareFromRequest(PlaceRequest request) {
		super.prepareFromRequest(request);

		restDispatch.execute(restResource.getRestResponse(), new AsyncCallback<RestResponseDto>() {

			@Override
			public void onFailure(Throwable caught) {
				GWT.log(caught.getLocalizedMessage());
				revealPrenster();
			}

			@Override
			public void onSuccess(RestResponseDto result) {
				GWT.log(result.getToken());
				GWT.log(result.getRefreshToken());
				revealPrenster();
			}
		});
	}

	private void revealPrenster() {
		getProxy().manualReveal(this);
	}
}