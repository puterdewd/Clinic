package edu.stevens.cs548.clinic.service.dto.util;

import edu.stevens.cs548.clinic.service.dto.DrugTreatment;
import edu.stevens.cs548.clinic.service.dto.ObjectFactory;
import edu.stevens.cs548.clinic.service.dto.PatientDto;
import edu.stevens.cs548.clinic.service.dto.RadiologyTreatment;
import edu.stevens.cs548.clinic.service.dto.SurgeryTreatment;
import edu.stevens.cs548.clinic.service.dto.TreatmentDto;

public class TreatmentDtoFactory {
	
	ObjectFactory factory;
	
	public TreatmentDtoFactory() {
		factory = new ObjectFactory();
	}
	
	public TreatmentDto createDrugTreatmentDto () {
		return factory.createTreatmentDto();
	}
	
	public PatientDto createTreatmentDto (DrugTreatment t) {
		PatientDto d = factory.createPatientDto();
		/*
		 * TODO: Initialize the DTO from the drug treatment.
		 */
		return null;
	}
	
	public TreatmentDto createDrugTreatmentDto (DrugTreatment t) {
		TreatmentDto treatmentDto = factory.createTreatmentDto();
		treatmentDto.setDrugTreatment(t);
		return treatmentDto;
	}
	
	public TreatmentDto createRadiologyTreatmentDto (RadiologyTreatment t) {
		TreatmentDto treatmentDto = factory.createTreatmentDto();
		treatmentDto.setRadiology(t);
		return treatmentDto;
	}
	
	public TreatmentDto createSurgeryTreatmentDto (SurgeryTreatment t) {
		TreatmentDto treatmentDto = factory.createTreatmentDto();
		treatmentDto.setSurgery(t);
		return treatmentDto;
	}
	/*
	 * TODO: Repeat for other treatments.
	 */

}
