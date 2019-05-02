package edu.stevens.cs548.clinic.service.web.soap;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import edu.stevens.cs548.clinic.service.dto.ProviderDto;
import edu.stevens.cs548.clinic.service.ejb.IProviderService;
import edu.stevens.cs548.clinic.service.ejb.IProviderServiceLocal;

@WebService(
		endpointInterface = "edu.stevens.cs548.clinic.service.web.soap.IProviderWebService", 
		targetNamespace = "http://cs548.stevens.edu/clinic/service/web/soap", 
		serviceName = "ProviderWebService", portName = "ProviderWebPort")


public class ProviderWebService implements IProviderService {

	//@EJB(beanName="ProviderServiceBean")
	@Inject IProviderServiceLocal service;
	
	@Override
	public long addProvider(ProviderDto dto) throws ProviderServiceExn {
		return service.addProvider(dto);
	}

	@Override
	public ProviderDto getProviderByNpi(long npi) throws ProviderServiceExn {
		return service.getProviderByNpi(npi);
	}

	@Override
	public ProviderDto getProvider(long id) throws ProviderServiceExn {
		return service.getProvider(id);
	}

	@Override
	public void deleteProviders() {
		service.deleteProviders();

	}

	@Override
	public String siteInfo() {
		return service.siteInfo();
	}

}
