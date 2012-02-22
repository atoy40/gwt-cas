package fr.univpau.gwt.cas.shared;

import com.google.web.bindery.requestfactory.shared.ProxyForName;
import com.google.web.bindery.requestfactory.shared.ValueProxy;

@ProxyForName("fr.univpau.gwt.cas.server.CasUser")
public interface CasUserProxy extends ValueProxy {
	public String getLogin();
}
