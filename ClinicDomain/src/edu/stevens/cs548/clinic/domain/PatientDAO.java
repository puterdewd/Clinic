package edu.stevens.cs548.clinic.domain;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class PatientDAO implements IPatientDAO {

	private EntityManager em;
	private TreatmentDAO treatmentDAO;
	
	public PatientDAO(EntityManager em) {
		this.em = em;
		this.treatmentDAO = new TreatmentDAO(em);
	}

	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(PatientDAO.class.getCanonicalName());

	@Override
	public long addPatient(Patient patient) throws PatientExn {
		long pid = patient.getPatientId();
		Query query = em.createNamedQuery("CountPatientByPatientID").setParameter("pid", pid);
		Long numExisting = (Long) query.getSingleResult();
		if (numExisting < 1) {
			em.persist(patient);
			patient.setTreatmentDAO(treatmentDAO);
			em.flush();
			return(patient.getId());
		} else {
			throw new PatientExn("addPatient: Patient with patient id (" + pid + ") already exists.");
		}
	}

	@Override
	public Patient getPatient(long id) throws PatientExn {
		Patient patient = em.find(Patient.class, id);
		if (patient == null) {
			throw new PatientExn("getPatient: Patient with primary key (" + id + ") not found.");
		} 
		patient.setTreatmentDAO(treatmentDAO);
		return patient;
	
	}

	@Override
	public Patient getPatientByPatientId(long pid) throws PatientExn {
		TypedQuery<Patient> query = em.createNamedQuery("SearchPatientByPatientID", Patient.class).setParameter("pid", pid);
		List<Patient> patients = query.getResultList();
		if (patients.size() > 1) {
			throw new PatientExn("getPatientByPatientId: More than one patient with patientId (" + pid + ").");
		} else if (patients.isEmpty()) {
			throw new PatientExn("getPatientByPatientId: Patient with patientId (" + pid + "). not found");
		}
		Patient patient = patients.get(0);
		patient.setTreatmentDAO(treatmentDAO);
		return patient;
	}
	
	@Override
	public void deletePatients() {
//			Query update = em.createQuery("RemoveAllPatients");
//			update.executeUpdate();
		TypedQuery<Patient> query = em.createNamedQuery("GetAllPatients", Patient.class);
		List<Patient> patients = query.getResultList();
		for (Patient p: patients) {
			em.remove(p);
		}
	}
	
	public void deletePatient(Patient patient) {
		em.remove(patient);
	}

}
