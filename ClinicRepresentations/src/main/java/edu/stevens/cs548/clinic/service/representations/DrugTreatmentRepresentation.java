package edu.stevens.cs548.clinic.service.representations;

import edu.stevens.cs548.clinic.service.dto.TreatmentDto;
import edu.stevens.cs548.clinic.service.dto.DrugTreatment;
import edu.stevens.cs548.clinic.service.web.rest.data.DrugTreatmentType;



public class DrugTreatmentRepresentation extends DrugTreatmentType {
	
	
	public DrugTreatmentRepresentation() {
		super();
	}
	
	public DrugTreatmentRepresentation(TreatmentDto treatmentDto) {
		this();
		this.dosage=treatmentDto.getDrugTreatment().getDosage();
		this.drug = treatmentDto.getDrugTreatment().getDrug();
	}

	public DrugTreatment getDrugTreatment() {
		DrugTreatment treatment = new DrugTreatment();
		treatment.setDosage(this.dosage);
		treatment.setDrug(this.drug);
		return treatment;
	}
}
