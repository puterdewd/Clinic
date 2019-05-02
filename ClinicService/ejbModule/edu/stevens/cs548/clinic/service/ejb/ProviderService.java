package edu.stevens.cs548.clinic.service.ejb;


import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import edu.stevens.cs548.clinic.domain.IProviderDAO;
import edu.stevens.cs548.clinic.domain.IProviderDAO.ProviderExn;
import edu.stevens.cs548.clinic.domain.IProviderFactory;
import edu.stevens.cs548.clinic.domain.Provider;
import edu.stevens.cs548.clinic.domain.ProviderDAO;
import edu.stevens.cs548.clinic.domain.ProviderFactory;
import edu.stevens.cs548.clinic.service.dto.ProviderDto;
import edu.stevens.cs548.clinic.service.dto.util.ProviderDtoFactory;
import edu.stevens.cs548.clinic.service.ejb.ClinicDomainProducer.ClinicDomain;

@Stateless(name="ProviderServiceBean")
public class ProviderService implements IProviderServiceLocal,
    IProviderServiceRemote
    {

	private IProviderFactory providerFactory;
	
	private ProviderDtoFactory providerDtoFactory;

	private IProviderDAO providerDAO;
	
	@Inject
	@ClinicDomain
	private EntityManager em;
	
	
	public ProviderService() {
		providerFactory = new ProviderFactory();
		providerDtoFactory = new ProviderDtoFactory();
	}


	@PostConstruct
	private void initialize() {
		providerDAO = new ProviderDAO(em);
	}
	
	@Override
	public long addProvider(ProviderDto dto) throws ProviderServiceExn {
		try {
			Provider provider = providerFactory.createProvider(dto.getNpi(), dto.getName(), dto.getSpecialization());
			providerDAO.addProvider(provider);
			return provider.getId();
		} catch (ProviderExn e) {
			throw new ProviderServiceExn(e.getMessage());
		}

	}

	@Override
	public ProviderDto getProviderByNpi(long npi) throws ProviderServiceExn {
		try {
			Provider provider = providerDAO.getProviderByNpi(npi);
			return providerDtoFactory.createProviderDto(provider);
		} catch (ProviderExn e) {
			throw new ProviderServiceExn(e.getMessage());
		}
	}

	@Override
	public ProviderDto getProvider(long id) throws ProviderServiceExn {
		try {
			Provider provider = providerDAO.getProvider(id);
			return providerDtoFactory.createProviderDto(provider);
		} catch (ProviderExn e) {
			throw new ProviderServiceExn(e.getMessage());
		}
	}

	@Override
	public void deleteProviders() {
		providerDAO.deleteProviders();

	}
	
	@Resource(name="SiteInfo")
	private String siteInformation;
	

	@Override
	public String siteInfo() {
		return siteInformation;
	}

}
