package edu.stevens.cs548.clinic.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: RadiologyTreatment
 *
 */
@Entity
@DiscriminatorValue(value="RA")
public class RadiologyTreatment extends Treatment implements Serializable {

	
	private static final long serialVersionUID = 1L;

	private List<Date> dates = new ArrayList<Date>();

	public RadiologyTreatment() {
		super();
	}

	public List<Date> getDates() {
		return dates;
	}

	public void setDates(List<Date> dates) {
		this.dates = dates;
	}

	@Override
	public <T> T export(ITreatmentExporter<T> visitor) {
		return visitor.exportRadiology(this.getId(), this.getDiagnosis(), this.getDates());
		
	}
   
}
