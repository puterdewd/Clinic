package edu.stevens.cs548.clinic.domain;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


public class ProviderDAO implements IProviderDAO {
	
	private EntityManager em;
	private TreatmentDAO treatmentDAO;
	
	public ProviderDAO(EntityManager em) {
		this.em = em;
		this.treatmentDAO = new TreatmentDAO(em);
	}

	@Override
	public long addProvider(Provider provider) throws ProviderExn {
		long npi = provider.getNpi();
		Query query = em.createNamedQuery("CountProviderByProviderNpi").setParameter("npi", npi);
		Long numExisting = (Long) query.getSingleResult();
		if (numExisting < 1) {
			em.persist(provider);
			provider.setTreatmentDAO(treatmentDAO);
			em.flush();
			return(provider.getId());
		} else {
			throw new ProviderExn("addProvider: Provider with npi (" + npi + ") already exists.");
		}
	}


	@Override
	public Provider getProviderByNpi(long npi) throws ProviderExn {
		TypedQuery<Provider> query = em.createNamedQuery("SearchProviderByProviderNpi", Provider.class).setParameter("npi", npi);
		List<Provider> providers = query.getResultList();
		if (providers.size() > 1) {
			throw new ProviderExn("getProviderByNpi: More than one provider with npi (" + npi + ").");
		} else if (providers.isEmpty()) {
			throw new ProviderExn("getProviderByNpi: Provider with npi (" + npi + "). not found");
		}
		Provider provider = providers.get(0);
		provider.setTreatmentDAO(treatmentDAO);
		return provider;
	}


	@Override
	public Provider getProvider(long id) throws ProviderExn {
		Provider provider = em.find(Provider.class, id);
		if (provider == null) {
			throw new ProviderExn("getProvider: Provider with primary key (" + id + ") not found.");
		} 
		provider.setTreatmentDAO(treatmentDAO);
		return provider;
	
	}

	@Override
	public void deleteProviders() {
		TypedQuery<Provider> query = em.createNamedQuery("GetAllProviders", Provider.class);
		List<Provider> providers = query.getResultList();
		for (Provider p: providers) {
			em.remove(p);
		}
	}

}
