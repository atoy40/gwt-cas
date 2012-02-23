# Usage

### Server
Add the CAS filters in you web.xml.

### Client
Add `<inherits name="fr.univpau.gwt.cas.Cas.gwt.xml"/>` to your GWT XML module descriptor.
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
<pre>
    &lt;dependency&gt;
        &lt;groupId&gt;com.teklabs.gwt-i18n-server&lt;/groupId&gt;
        &lt;artifactId&gt;gwt-i18n-server&lt;/artifactId&gt;
        &lt;version&gt;0.7&lt;/version&gt;
    &lt;/dependency&gt;
</pre>
