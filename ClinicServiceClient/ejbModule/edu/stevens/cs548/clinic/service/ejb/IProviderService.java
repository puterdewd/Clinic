package edu.stevens.cs548.clinic.service.ejb;

import edu.stevens.cs548.clinic.service.dto.ProviderDto;


public interface IProviderService {
	
	public class ProviderServiceExn extends Exception {
		private static final long serialVersionUID = 1L;
		public ProviderServiceExn (String m) {
			super(m);
		}
	}
	
	public class ProviderNotFoundExn extends ProviderServiceExn {
		private static final long serialVersionUID = 1L;
		public ProviderNotFoundExn (String m) {
			super(m);
		}
	}
	public class TreatmentNotFoundExn extends ProviderServiceExn {
		private static final long serialVersionUID = 1L;
		public TreatmentNotFoundExn (String m) {
			super(m);
		}
	}
	public long addProvider (ProviderDto dto) throws ProviderServiceExn;
	
	public ProviderDto getProviderByNpi(long npi) throws ProviderServiceExn;
	
	public ProviderDto getProvider (long id) throws ProviderServiceExn;
	
	public void deleteProviders();
	
	public String siteInfo();
}
