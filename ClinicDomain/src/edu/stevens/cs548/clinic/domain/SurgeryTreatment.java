package edu.stevens.cs548.clinic.domain;

import java.util.Date;
import java.io.Serializable;

import javax.persistence.*;


@Entity
@DiscriminatorValue(value="SU")
public class SurgeryTreatment  extends Treatment implements Serializable {


	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	private Date date;

	public SurgeryTreatment() {
		super();
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public <T> T export(ITreatmentExporter<T> visitor) {
		return visitor.exportSurgery(this.getId(), this.getDiagnosis(), this.getDate());
	}
   
}