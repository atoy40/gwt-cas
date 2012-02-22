package fr.univpau.gwt.cas.server;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jasig.cas.client.util.AssertionHolder;
import org.jasig.cas.client.util.CommonUtils;

public class CasFilter implements Filter {

	private String casServerLoginUrl;

	private String serverName;

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		if (AssertionHolder.getAssertion() == null) {			
			response.setHeader("login", CommonUtils.constructRedirectUrl(
					this.casServerLoginUrl, "service", this.serverName, false,
					false));
			
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
			return;
		}

		filterChain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		casServerLoginUrl = config.getInitParameter("casServerLoginUrl");
		serverName = config.getInitParameter("serverName");
	}

}
