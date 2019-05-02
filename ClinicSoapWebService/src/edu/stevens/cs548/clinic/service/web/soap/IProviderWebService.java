package edu.stevens.cs548.clinic.service.web.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import edu.stevens.cs548.clinic.service.dto.ProviderDto;
import edu.stevens.cs548.clinic.service.ejb.IProviderService.ProviderServiceExn;

@WebService(name = "IProviderWebPort", targetNamespace = "http://cs548.stevens.edu/clinic/service/web/soap")
/*
 * Endpoint interface for the provider Web service.
 */
public interface IProviderWebService {

	@WebMethod
	public long addProvider(
			@WebParam(name = "provider-dto", targetNamespace = "http://cs548.stevens.edu/clinic/dto") ProviderDto dto)
			throws ProviderServiceExn;

	@WebMethod
	@WebResult(name = "provider-dto", targetNamespace = "http://cs548.stevens.edu/clinic/dto")
	public ProviderDto getProviderByNpi(long npi) throws ProviderServiceExn;

	@WebMethod
	@WebResult(name = "provider-dto", targetNamespace = "http://cs548.stevens.edu/clinic/dto")
	public ProviderDto getProvider(long id) throws ProviderServiceExn;

	@WebMethod
	@WebResult(name = "provider-dto", targetNamespace = "http://cs548.stevens.edu/clinic/dto")
	public void deleteProviders();

	@WebMethod
	public String siteInfo();
}
