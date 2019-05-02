package edu.stevens.cs548.clinic.domain;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import edu.stevens.cs548.clinic.domain.ITreatmentDAO.TreatmentExn;
import static javax.persistence.CascadeType.PERSIST;

/**
 * Entity implementation class for Entity: Provider
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(
		name="SearchProviderByProviderNpi",
		query="select p from Provider p where p.npi = :npi"),
	@NamedQuery(
		name="CountProviderByProviderNpi",
		query="select count(p) from Provider p where p.npi = :npi"),
	@NamedQuery(
			name = "RemoveAllProviders", 
			query = "delete from Provider p"),
	@NamedQuery(
			name = "GetAllProviders", 
			query = "select p from Provider p")
})
public class Provider implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long id;
	
	private long npi;

	private String name;
	private String specialization;
	
	@OneToMany(mappedBy = "provider", cascade = PERSIST)
	private List<Treatment> treatments;
	
	public Provider() {
		super();
		treatments = new ArrayList<Treatment>();
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public long getNpi() {
		return npi;
	}

	public void setNpi(long npi) {
		this.npi = npi;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}


	public List<Treatment> getTreatments() {
		return treatments;
	}
	
	public void setTreatments(List<Treatment> treatments) {
		this.treatments = treatments;
	}
   
	@Transient
	private ITreatmentDAO treatmentDAO;
	
	public void setTreatmentDAO (ITreatmentDAO tdao) {
		this.treatmentDAO = tdao;
	}
	
	public long addTreatment (Treatment t) {
		this.getTreatments().add(t);
		if (t.getProvider() != this) {
				t.setProvider(this);
			}
		return t.getId();
		}

	
	public List<Long> getTreatmentIds() {
		List<Long> treatmentIds = new ArrayList<Long>();
		for (Treatment t : this.getTreatments()) {
			treatmentIds.add(t.getId());
		}
		return treatmentIds;
	}
	
	public <T> T exportTreatment(long tid, ITreatmentExporter<T> visitor) throws TreatmentExn {
		Treatment t = treatmentDAO.getTreatment(tid);
		if (t.getProvider() != this) {
			throw new TreatmentExn("Treatment id " + tid + "  is not for this provider " + id);
		}
		return t.export(visitor);
	}
	
}
