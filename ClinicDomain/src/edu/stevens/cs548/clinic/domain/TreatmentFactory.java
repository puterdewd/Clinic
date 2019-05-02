package edu.stevens.cs548.clinic.domain;

import java.util.Date;
import java.util.List;

public class TreatmentFactory implements ITreatmentFactory {

	@Override
	public Treatment createDrugTreatment(String diagnosis, String drug, float dosage, Provider provider) {
		DrugTreatment treatment = new DrugTreatment();
		treatment.setDiagnosis(diagnosis);
		treatment.setDrug(drug);
		treatment.setDosage(dosage);
		treatment.setProvider(provider);
		treatment.setTreatmentType(TreatmentType.DRUG_TREATMENT.getTag());
		return treatment;
	}

	@Override
	public Treatment createRadiologyTreatment(String diagnosis,
			List<Date> dates, Provider provider) {
		RadiologyTreatment treatment = new RadiologyTreatment();
		treatment.setDiagnosis(diagnosis);
		treatment.setDates(dates);
		treatment.setProvider(provider);
		treatment.setTreatmentType(TreatmentType.RADIOLOGY.getTag());
		return treatment;
	}

	@Override
	public Treatment createSurgeryTreatment(String diagnosis, Date date, Provider provider) {
		SurgeryTreatment treatment = new SurgeryTreatment();
		treatment.setDiagnosis(diagnosis);
		treatment.setDate(date);
		treatment.setProvider(provider);
		treatment.setTreatmentType(TreatmentType.SURGERY.getTag());
		return null;
	}

}
