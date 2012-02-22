package fr.univpau.gwt.cas.shared;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;

@ServiceName(value="fr.univpau.gwt.cas.server.CasWrapper", locator="fr.univpau.gwt.cas.server.CasLocator")
public interface CasRequest extends RequestContext {
	public Request<CasUserProxy> getCurrentUser();
}
