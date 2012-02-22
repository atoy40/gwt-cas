package fr.univpau.gwt.cas.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import fr.univpau.gwt.cas.shared.CasRequest;
import fr.univpau.gwt.cas.shared.CasUserProxy;
import fr.univpau.gwt.cas.shared.MakesCasRequest;

/**
 * A simple widget which displays info about the user and a logout link. In real
 * life you'd probably blow this up into MVP parts.
 * <p>
 * On the other hand, it's pleasant that this widget is completely self
 * contained, taking care of its own RPC needs when awoken by being attached to
 * the dom. Hopefully that's not too magical.
 */
public class LoginWidget extends Composite {
  interface Binder extends UiBinder<Widget, LoginWidget> {
  }

  private static final Binder BINDER = GWT.create(Binder.class);

  private final MakesCasRequest requests;

  @UiField
  SpanElement name;
  @UiField
  Anchor logoutLink;

  public LoginWidget(MakesCasRequest requests) {
    this.requests = requests;
    initWidget(BINDER.createAndBindUi(this));
  }

  @Override
  protected void onLoad() {
	  CasRequest request = requests.casRequest();

    /*request.createLogoutURL(Location.getHref()).to(new Receiver<String>() {
      public void onSuccess(String response) {
        setLogoutUrl(response);
      }
    });*/
    request.getCurrentUser().to(new Receiver<CasUserProxy>() {
      @Override
      public void onSuccess(CasUserProxy response) {
        setUserName(response.getLogin());
      }
    });
    request.fire();
  }

  public void setUserName(String userName) {
    name.setInnerText(userName);
  }

  public void setLogoutUrl(String url) {
    logoutLink.setHref(url);
  }

  /**
   * Squelch clicks of the logout link if no href has been set.
   */
  @UiHandler("logoutLink")
  void handleClick(ClickEvent e) {
    if ("".equals(logoutLink.getHref())) {
      e.stopPropagation();
    }
  }
}
