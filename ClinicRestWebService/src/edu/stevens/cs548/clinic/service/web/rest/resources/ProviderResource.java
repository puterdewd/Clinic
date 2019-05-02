package edu.stevens.cs548.clinic.service.web.rest.resources;

import java.net.URI;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import edu.stevens.cs548.clinic.service.dto.ProviderDto;
import edu.stevens.cs548.clinic.service.dto.util.ProviderDtoFactory;
import edu.stevens.cs548.clinic.service.ejb.IProviderService.ProviderServiceExn;
import edu.stevens.cs548.clinic.service.ejb.IPatientServiceLocal;
import edu.stevens.cs548.clinic.service.ejb.IProviderServiceLocal;
import edu.stevens.cs548.clinic.service.representations.ProviderRepresentation;
import edu.stevens.cs548.clinic.service.representations.TreatmentRepresentation;

@Path("/provider")
@RequestScoped
public class ProviderResource {
	
	final static Logger logger = Logger.getLogger(ProviderResource.class.getCanonicalName());
	
	/*
	 * TODO inject using HK2 (not CDI)
	 */
	@Context
    private UriInfo uriInfo;
    
    private ProviderDtoFactory providerDtoFactory;

    /**
     * Default constructor. 
     */
    public ProviderResource() {
		/*
		 * TODO finish this
		 */
    	providerDtoFactory = new ProviderDtoFactory();
    }
    
	/*
	 * TODO inject using CDI
	 */
    @Inject
    private IProviderServiceLocal providerService;
    
    
    @GET
    @Path("site")
    @Produces("application/xml")
    public String getSiteInfo() {
    	return providerService.siteInfo();
    }

	/*
	 * TODO input should be application/xml
	 */
    @POST
    @Consumes("application/xml")
    public Response addProvider(ProviderRepresentation providerRep) {
    	try {
    		ProviderDto dto = providerDtoFactory.createProviderDto();
    		dto.setNpi(providerRep.getNpi());
    		dto.setName(providerRep.getName());
    		dto.setSpecialization(providerRep.getSpecialization());
    		long id = providerService.addProvider(dto);
    		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path("{id}");
    		URI url = ub.build(Long.toString(id));
    		return Response.created(url).build();
    	} catch (ProviderServiceExn e) {
    		throw new WebApplicationException();
    	}
    }
    
	/**
	 * Query methods for patient resources.
	 */
	/*
	 * TODO output should be application/xml
	 */
    @GET
    @Path("{id}")
    @Produces("application/xml")
	public ProviderRepresentation getProvider(@PathParam("id") String id) {
		try {
			long key = Long.parseLong(id);
			ProviderDto providerDTO = providerService.getProvider(key);
			ProviderRepresentation providerRep = new ProviderRepresentation(providerDTO, uriInfo);
			return providerRep;
		} catch (ProviderServiceExn e) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
	}
    
	/*
	 * TODO output should be application/xml
	 */
    @GET
    @Path("byNpi")
    @Produces("application/xml")
	public ProviderRepresentation getProviderByProviderId(@QueryParam("id") String npi) {
		try {
			long key = Long.parseLong(npi);
			ProviderDto providerDTO = providerService.getProviderByNpi(key);
			ProviderRepresentation patientRep = new ProviderRepresentation(providerDTO, uriInfo);
			return patientRep;
		} catch (ProviderServiceExn e) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
	}
    
    
    //POST    /clinic-­‐rest/resources/provider/id/treatments
    
    @POST
    @Path("{id}/treatments")
    @Consumes("application/xml")
    public Response addTreatment(@HeaderParam("X-Patient") URI patient,  @PathParam("id") String id, TreatmentRepresentation treatmentRep) {
    	try {
    		long providerKey = Long.parseLong(id);
			ProviderDto providerDTO = providerService.getProvider(providerKey);
			String path = patient.getPath();
			long patientKey = Long.parseLong(path.substring(path.lastIndexOf('/') + 1));
    		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path("{id}/treatments");
    		//TODO create the stuff we need here for add treatment.
    		long treatmentId = 0;
    		URI url = ub.build(Long.toString(treatmentId));
    		return Response.created(url).build();
    	} catch (ProviderServiceExn e) {
    		throw new WebApplicationException();
    	}
    }


}