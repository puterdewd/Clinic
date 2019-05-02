package edu.stevens.cs548.clinic.domain;

import java.util.Date;
import java.util.List;


public interface ITreatmentFactory {
	
	public Treatment createDrugTreatment (String diagnosis, String drug, float dosage, Provider provider);
	
	public Treatment createRadiologyTreatment (String diagnosis, List<Date> dates, Provider provider);
	
	public Treatment createSurgeryTreatment (String diagnosis, Date date, Provider provider);
	

}
