package edu.stevens.cs548.clinic.service.representations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.stevens.cs548.clinic.service.dto.RadiologyTreatment;
import edu.stevens.cs548.clinic.service.dto.TreatmentDto;
import edu.stevens.cs548.clinic.service.web.rest.data.RadiologyTreatmentType;

public class RadiologyTreatmentRepresentation extends RadiologyTreatmentType {
	public List<Date> dates = new ArrayList<Date>();

	public RadiologyTreatmentRepresentation() {
		super();
	}
	
	public RadiologyTreatmentRepresentation(TreatmentDto treatmentDto) {
		this();
		this.date = treatmentDto.getRadiology().getDate();
	}

	public RadiologyTreatment getRadiologyTreatment() {
		RadiologyTreatment treatment = new RadiologyTreatment();
		return treatment;
	}

}
