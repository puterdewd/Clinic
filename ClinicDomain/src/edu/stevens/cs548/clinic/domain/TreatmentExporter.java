package edu.stevens.cs548.clinic.domain;

import java.util.Date;
import java.util.List;


public class TreatmentExporter<T> implements ITreatmentExporter<T> {


	@SuppressWarnings("unchecked")
	@Override
	public T exportDrugTreatment(long tid, String diagnosis, String drug,
			float dosage) {
		DrugTreatment treatment = new DrugTreatment();
		treatment.setId(tid);
		treatment.setDiagnosis(diagnosis);
		treatment.setDrug(drug);
		treatment.setDosage(dosage);
		return (T) treatment;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T exportRadiology(long tid, String diagnosis,
			List<Date> dates) {
		RadiologyTreatment treatment = new RadiologyTreatment();
		treatment.setId(tid);
		treatment.setDiagnosis(diagnosis);
		treatment.getDates();
		return (T) treatment;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T exportSurgery(long tid, String diagnosis, Date date) {
		SurgeryTreatment treatment = new SurgeryTreatment();
		treatment.setId(tid);
		treatment.setDiagnosis(diagnosis);
		treatment.setDate(date);
		return (T) treatment;
	}



}
