package fr.univpau.gwt.cas.client;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.web.bindery.requestfactory.gwt.client.DefaultRequestTransport;
import com.google.gwt.user.client.Window.Location;

public class CasRequestTransport extends DefaultRequestTransport {

	@Override
	protected RequestCallback createRequestCallback(TransportReceiver receiver) {
		
		final RequestCallback superRequestCallback = super.createRequestCallback(receiver);
		
		return new RequestCallback() {
			
			@Override
			public void onResponseReceived(Request request, Response response) {
				if (Response.SC_UNAUTHORIZED == response.getStatusCode()) {
					String loginUrl = response.getHeader("login");
					
				
					Location.replace(loginUrl);
					return;
				}
				superRequestCallback.onResponseReceived(request, response);
			}
			
			@Override
			public void onError(Request request, Throwable exception) {
				superRequestCallback.onError(request, exception);
			}
		};
	}

}
