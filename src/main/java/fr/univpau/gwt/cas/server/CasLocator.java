package fr.univpau.gwt.cas.server;

import org.jasig.cas.client.util.AssertionHolder;

import com.google.web.bindery.requestfactory.shared.ServiceLocator;

public class CasLocator implements ServiceLocator {

	@Override
	public Object getInstance(Class<?> clazz) {
		return new CasWrapper() {
			
			@Override
			public CasUser getCurrentUser() {
				return new CasUser(AssertionHolder.getAssertion().getPrincipal().getName());
			}
		};
	}

}
