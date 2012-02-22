package fr.univpau.gwt.cas.server;

public class CasUser {
	private String login;

	public CasUser() {
	}
	
	public CasUser(String login) {
		this.login = login;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}	
}
