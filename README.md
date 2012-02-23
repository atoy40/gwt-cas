# Usage

### Server
Add the CAS filters in you web.xml except the AuthenticationFilter.

<pre>
&lt;filter&gt;
  &lt;filter-name&gt;CAS Validation Filter&lt;/filter-name&gt;
  &lt;filter-class&gt;org.jasig.cas.client.validation.Cas10TicketValidationFilter&lt;/filter-class&gt;
  &lt;init-param&gt;
    &lt;param-name&gt;casServerUrlPrefix&lt;/param-name&gt;
    &lt;param-value&gt;&lt;/param-value&gt;
  &lt;/init-param&gt;
&lt;/filter&gt;
&lt;filter&gt;
  &lt;filter-name&gt;CAS HttpServletRequest Wrapper Filter&lt;/filter-name&gt;
  &lt;filter-class&gt;org.jasig.cas.client.util.HttpServletRequestWrapperFilter&lt;/filter-class&gt;
&lt;/filter&gt;
&lt;filter&gt;
  &lt;filter-name&gt;CAS Assertion Thread Local Filter&lt;/filter-name&gt;
  &lt;filter-class&gt;org.jasig.cas.client.util.AssertionThreadLocalFilter&lt;/filter-class&gt;
&lt;/filter&gt;
&lt;filter&gt;
  &lt;filter-name&gt;GWT RequestFactory CAS Auth Filter&lt;/filter-name&gt;
  &lt;filter-class&gt;fr.univpau.gwt.cas.server.CasFilter&lt;/filter-class&gt;
  &lt;init-param&gt;
    &lt;param-name&gt;casServerUrlPrefix&lt;/param-name&gt;
    &lt;param-value&gt;&lt;/param-value&gt;
  &lt;/init-param&gt;
&lt;/filter&gt;

&lt;filter-mapping&gt;
   &lt;filter-name&gt;CAS Validation Filter&lt;/filter-name&gt;
   &lt;url-pattern&gt;/*&lt;/url-pattern&gt;
&lt;/filter-mapping&gt;
&lt;filter-mapping&gt;
    &lt;filter-name&gt;CAS HttpServletRequest Wrapper Filter&lt;/filter-name&gt;
    &lt;url-pattern&gt;/*&lt;/url-pattern&gt;
&lt;/filter-mapping&gt;
&lt;filter-mapping&gt;
    &lt;filter-name&gt;CAS Assertion Thread Local Filter&lt;/filter-name&gt;
    &lt;url-pattern&gt;/*&lt;/url-pattern&gt;
&lt;/filter-mapping&gt;
&lt;filter-mapping&gt;
    &lt;filter-name&gt;GWT RequestFactory CAS Auth Filter&lt;/filter-name&gt;
    &lt;url-pattern&gt;/gwtRequest&lt;/url-pattern&gt;
&lt;/filter-mapping&gt;
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
