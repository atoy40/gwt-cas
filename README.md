# Usage

### Server
Add the CAS filters in you web.xml except the AuthenticationFilter.

<pre>
<filter>
  <filter-name>CAS Validation Filter</filter-name>
  <filter-class>org.jasig.cas.client.validation.Cas10TicketValidationFilter</filter-class>
  <init-param>
    <param-name>casServerUrlPrefix</param-name>
    <param-value></param-value>
  </init-param>
</filter>
<filter>
  <filter-name>CAS HttpServletRequest Wrapper Filter</filter-name>
  <filter-class>org.jasig.cas.client.util.HttpServletRequestWrapperFilter</filter-class>
</filter>
<filter>
  <filter-name>CAS Assertion Thread Local Filter</filter-name>
  <filter-class>org.jasig.cas.client.util.AssertionThreadLocalFilter</filter-class>
</filter>
<filter>
  <filter-name>GWT RequestFactory CAS Auth Filter</filter-name>
  <filter-class>fr.univpau.gwt.cas.server.CasFilter</filter-class>
  <init-param>
    <param-name>casServerUrlPrefix</param-name>
    <param-value></param-value>
  </init-param>
</filter>

<filter-mapping>
   <filter-name>CAS Validation Filter</filter-name>
   <url-pattern>/*</url-pattern>
</filter-mapping>
<filter-mapping>
    <filter-name>CAS HttpServletRequest Wrapper Filter</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>
<filter-mapping>
    <filter-name>CAS Assertion Thread Local Filter</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>
<filter-mapping>
    <filter-name>GWT RequestFactory CAS Auth Filter</filter-name>
    <url-pattern>/gwtRequest</url-pattern>
</filter-mapping>
</pre>

### Client
Add `<inherits name="fr.univpau.gwt.cas.Cas"/>` to your GWT XML module descriptor.
Extends your own RequestFactory interface with MakeCasRequest :
<pre>
public interface MyRequestFactory extends MakeCasRequest {
}
</pre>
Use the when as RequestTransport when you initialize your RF instance :
<pre>
MyRequestFactory rf = GWT.create(MyRequestFactory.class);
rf.initialize(bus, new CasRequestTransport());
</pre>

# Maven repositories

Latest release (for GWT 2.4):
