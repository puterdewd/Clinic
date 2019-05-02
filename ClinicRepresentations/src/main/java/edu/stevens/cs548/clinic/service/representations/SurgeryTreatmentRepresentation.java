package edu.stevens.cs548.clinic.service.representations;

import edu.stevens.cs548.clinic.service.dto.SurgeryTreatment;
import edu.stevens.cs548.clinic.service.dto.TreatmentDto;
import edu.stevens.cs548.clinic.service.web.rest.data.SurgeryTreatmentType;

public class SurgeryTreatmentRepresentation extends SurgeryTreatmentType {
	
	public SurgeryTreatmentRepresentation() {
		super();
	}
	
	public SurgeryTreatmentRepresentation(TreatmentDto treatmentDto) {
		this();
		this.date = treatmentDto.getSurgery().getDate();
	}

	public SurgeryTreatment getSurgeryTreatment() {
		SurgeryTreatment treatment = new SurgeryTreatment();
		treatment.setDate(this.date);
		return treatment;
	}


}
