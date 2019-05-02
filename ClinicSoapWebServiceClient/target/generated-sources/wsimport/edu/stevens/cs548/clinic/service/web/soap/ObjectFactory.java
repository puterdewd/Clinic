
package edu.stevens.cs548.clinic.service.web.soap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the edu.stevens.cs548.clinic.service.web.soap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetProvider_QNAME = new QName("http://cs548.stevens.edu/clinic/service/web/soap", "getProvider");
    private final static QName _GetProviderByNpi_QNAME = new QName("http://cs548.stevens.edu/clinic/service/web/soap", "getProviderByNpi");
    private final static QName _DeleteProviders_QNAME = new QName("http://cs548.stevens.edu/clinic/service/web/soap", "deleteProviders");
    private final static QName _GetProviderResponse_QNAME = new QName("http://cs548.stevens.edu/clinic/service/web/soap", "getProviderResponse");
    private final static QName _SiteInfo_QNAME = new QName("http://cs548.stevens.edu/clinic/service/web/soap", "siteInfo");
    private final static QName _GetProviderByNpiResponse_QNAME = new QName("http://cs548.stevens.edu/clinic/service/web/soap", "getProviderByNpiResponse");
    private final static QName _AddProvider_QNAME = new QName("http://cs548.stevens.edu/clinic/service/web/soap", "addProvider");
    private final static QName _ProviderServiceExn_QNAME = new QName("http://cs548.stevens.edu/clinic/service/web/soap", "ProviderServiceExn");
    private final static QName _SiteInfoResponse_QNAME = new QName("http://cs548.stevens.edu/clinic/service/web/soap", "siteInfoResponse");
    private final static QName _AddProviderResponse_QNAME = new QName("http://cs548.stevens.edu/clinic/service/web/soap", "addProviderResponse");
    private final static QName _DeleteProvidersResponse_QNAME = new QName("http://cs548.stevens.edu/clinic/service/web/soap", "deleteProvidersResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: edu.stevens.cs548.clinic.service.web.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ProviderServiceExn }
     * 
     */
    public ProviderServiceExn createProviderServiceExn() {
        return new ProviderServiceExn();
    }

    /**
     * Create an instance of {@link AddProvider }
     * 
     */
    public AddProvider createAddProvider() {
        return new AddProvider();
    }

    /**
     * Create an instance of {@link AddProviderResponse }
     * 
     */
    public AddProviderResponse createAddProviderResponse() {
        return new AddProviderResponse();
    }

    /**
     * Create an instance of {@link SiteInfoResponse }
     * 
     */
    public SiteInfoResponse createSiteInfoResponse() {
        return new SiteInfoResponse();
    }

    /**
     * Create an instance of {@link DeleteProvidersResponse }
     * 
     */
    public DeleteProvidersResponse createDeleteProvidersResponse() {
        return new DeleteProvidersResponse();
    }

    /**
     * Create an instance of {@link GetProviderByNpi }
     * 
     */
    public GetProviderByNpi createGetProviderByNpi() {
        return new GetProviderByNpi();
    }

    /**
     * Create an instance of {@link GetProvider }
     * 
     */
    public GetProvider createGetProvider() {
        return new GetProvider();
    }

    /**
     * Create an instance of {@link DeleteProviders }
     * 
     */
    public DeleteProviders createDeleteProviders() {
        return new DeleteProviders();
    }

    /**
     * Create an instance of {@link SiteInfo }
     * 
     */
    public SiteInfo createSiteInfo() {
        return new SiteInfo();
    }

    /**
     * Create an instance of {@link GetProviderResponse }
     * 
     */
    public GetProviderResponse createGetProviderResponse() {
        return new GetProviderResponse();
    }

    /**
     * Create an instance of {@link GetProviderByNpiResponse }
     * 
     */
    public GetProviderByNpiResponse createGetProviderByNpiResponse() {
        return new GetProviderByNpiResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProvider }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cs548.stevens.edu/clinic/service/web/soap", name = "getProvider")
    public JAXBElement<GetProvider> createGetProvider(GetProvider value) {
        return new JAXBElement<GetProvider>(_GetProvider_QNAME, GetProvider.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProviderByNpi }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cs548.stevens.edu/clinic/service/web/soap", name = "getProviderByNpi")
    public JAXBElement<GetProviderByNpi> createGetProviderByNpi(GetProviderByNpi value) {
        return new JAXBElement<GetProviderByNpi>(_GetProviderByNpi_QNAME, GetProviderByNpi.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteProviders }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cs548.stevens.edu/clinic/service/web/soap", name = "deleteProviders")
    public JAXBElement<DeleteProviders> createDeleteProviders(DeleteProviders value) {
        return new JAXBElement<DeleteProviders>(_DeleteProviders_QNAME, DeleteProviders.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProviderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cs548.stevens.edu/clinic/service/web/soap", name = "getProviderResponse")
    public JAXBElement<GetProviderResponse> createGetProviderResponse(GetProviderResponse value) {
        return new JAXBElement<GetProviderResponse>(_GetProviderResponse_QNAME, GetProviderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SiteInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cs548.stevens.edu/clinic/service/web/soap", name = "siteInfo")
    public JAXBElement<SiteInfo> createSiteInfo(SiteInfo value) {
        return new JAXBElement<SiteInfo>(_SiteInfo_QNAME, SiteInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProviderByNpiResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cs548.stevens.edu/clinic/service/web/soap", name = "getProviderByNpiResponse")
    public JAXBElement<GetProviderByNpiResponse> createGetProviderByNpiResponse(GetProviderByNpiResponse value) {
        return new JAXBElement<GetProviderByNpiResponse>(_GetProviderByNpiResponse_QNAME, GetProviderByNpiResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddProvider }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cs548.stevens.edu/clinic/service/web/soap", name = "addProvider")
    public JAXBElement<AddProvider> createAddProvider(AddProvider value) {
        return new JAXBElement<AddProvider>(_AddProvider_QNAME, AddProvider.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProviderServiceExn }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cs548.stevens.edu/clinic/service/web/soap", name = "ProviderServiceExn")
    public JAXBElement<ProviderServiceExn> createProviderServiceExn(ProviderServiceExn value) {
        return new JAXBElement<ProviderServiceExn>(_ProviderServiceExn_QNAME, ProviderServiceExn.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SiteInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cs548.stevens.edu/clinic/service/web/soap", name = "siteInfoResponse")
    public JAXBElement<SiteInfoResponse> createSiteInfoResponse(SiteInfoResponse value) {
        return new JAXBElement<SiteInfoResponse>(_SiteInfoResponse_QNAME, SiteInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddProviderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cs548.stevens.edu/clinic/service/web/soap", name = "addProviderResponse")
    public JAXBElement<AddProviderResponse> createAddProviderResponse(AddProviderResponse value) {
        return new JAXBElement<AddProviderResponse>(_AddProviderResponse_QNAME, AddProviderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteProvidersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cs548.stevens.edu/clinic/service/web/soap", name = "deleteProvidersResponse")
    public JAXBElement<DeleteProvidersResponse> createDeleteProvidersResponse(DeleteProvidersResponse value) {
        return new JAXBElement<DeleteProvidersResponse>(_DeleteProvidersResponse_QNAME, DeleteProvidersResponse.class, null, value);
    }

}
