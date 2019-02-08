package lu.cerberians.sollist.discrepancy;

import lu.cerberians.sollist.entities.Loop;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/discrepancies")
public class DiscrepancyResource {

    private DiscrepancyService discrepancyService;

    @Inject
    public DiscrepancyResource(DiscrepancyService discrepancyService) {
        this.discrepancyService = discrepancyService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Loop> getApplications() {
        return discrepancyService.getDiscrepancies();
    }

}
