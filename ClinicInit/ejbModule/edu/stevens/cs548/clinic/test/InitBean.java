package edu.stevens.cs548.clinic.test;

import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import edu.stevens.cs548.clinic.domain.IPatientDAO.PatientExn;
import edu.stevens.cs548.clinic.domain.IProviderDAO.ProviderExn;
import edu.stevens.cs548.clinic.domain.Patient;
import edu.stevens.cs548.clinic.domain.PatientFactory;
import edu.stevens.cs548.clinic.domain.Provider;
import edu.stevens.cs548.clinic.domain.ProviderFactory;
import edu.stevens.cs548.clinic.domain.Treatment;
import edu.stevens.cs548.clinic.domain.TreatmentFactory;
import edu.stevens.cs548.clinic.service.dto.DrugTreatment;
import edu.stevens.cs548.clinic.service.dto.PatientDto;
import edu.stevens.cs548.clinic.service.dto.ProviderDto;
import edu.stevens.cs548.clinic.service.dto.TreatmentDto;
import edu.stevens.cs548.clinic.service.dto.util.PatientDtoFactory;
import edu.stevens.cs548.clinic.service.dto.util.ProviderDtoFactory;
import edu.stevens.cs548.clinic.service.dto.util.TreatmentDtoFactory;
import edu.stevens.cs548.clinic.service.ejb.IPatientService.PatientServiceExn;
import edu.stevens.cs548.clinic.service.ejb.IPatientServiceLocal;
import edu.stevens.cs548.clinic.service.ejb.ClinicDomainProducer.ClinicDomain;
import edu.stevens.cs548.clinic.service.ejb.IProviderService.ProviderServiceExn;
import edu.stevens.cs548.clinic.service.ejb.IProviderServiceLocal;
import edu.stevens.cs548.clinic.service.ejb.PatientService.TreatmentExporter;

/**
 * Session Bean implementation class TestBean
 */
@Singleton
@LocalBean
@Startup
public class InitBean {

	private static Logger logger = Logger.getLogger(InitBean.class
			.getCanonicalName());

	/**
	 * Default constructor.
	 */
	public InitBean() {
	}

	@Inject
	private IPatientServiceLocal patientService;

	@Inject
	private IProviderServiceLocal providerService;

	@Inject
	@ClinicDomain
	private EntityManager em;

	@PostConstruct
	private void init() {
		/*
		 * Put your testing logic here. Use the logger to display testing output
		 * in the server logs.
		 */
		logger.info("Your name here: Brad Senetza");

		Calendar calendar = Calendar.getInstance();
		calendar.set(1984, 9, 4);

		PatientFactory patientFactory = new PatientFactory();
		PatientDtoFactory patientDtoFactory = new PatientDtoFactory();
		TreatmentFactory treatmentFactory = new TreatmentFactory();

		ProviderFactory providerFactory = new ProviderFactory();
		ProviderDtoFactory providerDtoFactory = new ProviderDtoFactory();
		TreatmentDtoFactory treatmentDtoFactory = new TreatmentDtoFactory();
		

		logger.info("Init service");

		try {

			Patient john = patientFactory.createPatient(12345678L, "John Doe",
					calendar.getTime(), 30);

			Provider hopkins = providerFactory.createProvider(11111111L,
					"Hopkins", "Surgery");
			
			//***

			Treatment treatment = treatmentFactory.createDrugTreatment("headache", "aspirin", 2.0f, hopkins);
			//logger.info("adding treatment type " + treatment.getTreatmentType() + " with diagnosis " + treatment.getDiagnosis());
//			TreatmentDto treatmentDto = treatmentDtoFactory.createDrugTreatmentDto();
//			DrugTreatment drugTreatment = new DrugTreatment();
//
//			treatmentDto.setDiagnosis(treatment.getDiagnosis());
//			drugTreatment.setDosage(2);
//			drugTreatment.setDrug("aspirin");
//			treatmentDto.setProvider(treatment.getProvider().getId());
			
			//****
			PatientDto johnDto = patientDtoFactory.createPatientDto(john);
			ProviderDto hopkinsDto = providerDtoFactory.createProviderDto(hopkins);
			
			
			PatientDto dbJohnDto;
			ProviderDto dbHopkinsDto;

			long johnId, hopkinsId = 0;
			final long bogusId = 999L;
			final long bogusPid = 666L;
			final long bogusNpi = 555L;

			logger.info("patientService siteInfo: " + patientService.siteInfo());

			logger.info("providerService siteInfo: " + providerService.siteInfo());
/*
			logger.info("delete patients");
			patientService.deletePatients();

			logger.info("delete providers");
			providerService.deleteProviders();

			try {
				logger.info("add patient" + johnDto.getName());
				johnDto.getName();
				logger.info("Attempting to add " + johnDto.getName()
						+ " with id " + johnDto.getId() + " with pid "
						+ johnDto.getPatientId());

				johnId = patientService.addPatient(johnDto);
				johnDto.setId(johnId);

				logger.info("Added " + johnDto.getName() + " with id "
						+ johnDto.getId() + " with pid "
						+ johnDto.getPatientId());

			} catch (PatientServiceExn e) {
				logger.severe(e.getMessage());
			}

			try {
				logger.info("Attempting to re-add " + johnDto.getName()
						+ " with id " + johnDto.getId());

				patientService.addPatient(johnDto);
			} catch (PatientServiceExn e) {
				logger.severe(e.getMessage());
			}

			try {
				logger.info("Attempting to retrieve " + johnDto.getName()
						+ " with id " + johnDto.getId());

				dbJohnDto = patientService.getPatient(johnDto.getId());
				logger.info("Found " + dbJohnDto.getName() + " with id "
						+ dbJohnDto.getId() + " with pid "
						+ dbJohnDto.getPatientId());
			} catch (PatientServiceExn e) {
				logger.severe(e.getMessage());
			}

			try {
				logger.info("Attempting to retrieve " + johnDto.getName()
						+ " with pid " + johnDto.getPatientId());

				dbJohnDto = patientService.getPatientByPatId(johnDto
						.getPatientId());

				logger.info("Found " + dbJohnDto.getName() + " with id "
						+ dbJohnDto.getId() + " with pid "
						+ dbJohnDto.getPatientId());
			} catch (PatientServiceExn e) {
				logger.severe(e.getMessage());
			}
			try {

				logger.info("Attempting to retrieve " + johnDto.getName()
						+ " with bogus id " + bogusId);

				dbJohnDto = patientService.getPatient(bogusId);
			} catch (PatientServiceExn e) {
				logger.severe(e.getMessage());
			}

			try {

				logger.info("Attempting to retrieve " + johnDto.getName()
						+ " with bogus pid " + bogusPid);

				dbJohnDto = patientService.getPatientByPatId(bogusPid);
			} catch (PatientServiceExn e) {
				logger.severe(e.getMessage());
			}

			//
			//
			//
			try {
				logger.info("Attempting to add " + hopkinsDto.getName()
						+ " with id " + hopkinsDto.getId() + " with npi "
						+ hopkinsDto.getNpi() + " with specilization "
						+ hopkinsDto.getSpecialization());

				hopkinsId = providerService.addProvider(hopkinsDto);
				hopkinsDto.setId(hopkinsId);

				logger.info("Added " + hopkinsDto.getName() + " with id "
						+ hopkinsDto.getId() + " with npi " + hopkins.getNpi()
						+ " with specilization "
						+ hopkinsDto.getSpecialization());

				logger.info("Attempting to re-add " + hopkinsDto.getName()
						+ " with id " + hopkinsDto.getId() + " with npi "
						+ hopkinsDto.getNpi() + " with specilization "
						+ hopkinsDto.getSpecialization());

				providerService.addProvider(hopkinsDto);

			} catch (ProviderServiceExn e) {
				logger.severe(e.getMessage());
			}

			try {

				logger.info("Attempting to retrieve " + hopkinsDto.getName()
						+ " with id " + hopkinsDto.getId());

				dbHopkinsDto = providerService.getProvider(hopkinsDto.getId());

				logger.info("Found " + dbHopkinsDto.getName() + " with id "
						+ dbHopkinsDto.getId() + " with npi "
						+ dbHopkinsDto.getNpi() + " with specilization "
						+ dbHopkinsDto.getSpecialization());

				logger.info("Attempting to retrieve " + hopkinsDto.getName()
						+ " with bogus id " + bogusId);
				dbHopkinsDto = providerService.getProvider(bogusId);

			} catch (ProviderServiceExn e) {
				logger.severe(e.getMessage());
			}

			try {

				logger.info("Attempting to retrieve " + hopkinsDto.getName()
						+ " with npi " + hopkinsDto.getId());

				dbHopkinsDto = providerService.getProviderByNpi(hopkinsDto.getNpi());

				logger.info("Found " + dbHopkinsDto.getName() + " with id "
						+ dbHopkinsDto.getId() + " with npi "
						+ dbHopkinsDto.getNpi() + " with specilization "
						+ dbHopkinsDto.getSpecialization());

				logger.info("Attempting to retrieve " + hopkinsDto.getName()
						+ " with bogus npi " + bogusNpi);
				dbHopkinsDto = providerService.getProviderByNpi(bogusNpi);

			} catch (ProviderServiceExn e) {
				logger.severe(e.getMessage());
			}*/

//			logger.info("adding treatment type " + treatment.getTreatmentType() + " with diagnosis " + treatment.getDiagnosis());
//			john.addTreatment(treatment);
			

			
		} catch (PatientExn e) {
			logger.severe(e.getMessage());
		} catch (ProviderExn e) {
			logger.severe(e.getMessage());
		}

	}

}
