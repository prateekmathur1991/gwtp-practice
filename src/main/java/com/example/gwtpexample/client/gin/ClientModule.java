package com.example.gwtpexample.client.gin;

import com.example.gwtpexample.client.application.ApplicationModule;
import com.example.gwtpexample.client.place.NameTokens;
import com.example.gwtpexample.client.resources.ResourceLoader;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;

public class ClientModule extends AbstractPresenterModule {
	@Override
	protected void configure() {
		install(new DefaultModule.Builder().defaultPlace(NameTokens.HOME).errorPlace(NameTokens.HOME)
				.unauthorizedPlace(NameTokens.HOME).build());
		install(new ApplicationModule());

		bind(ResourceLoader.class).asEagerSingleton();
	}
}
