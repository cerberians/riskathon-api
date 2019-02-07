package lu.cerberians.sollist;

import lu.cerberians.sollist.mapper.*;
import lu.cerberians.sollist.matrix.MatrixService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloResource {

    private PrivilegeMapper privilegeMapper;

    private BusinessRoleMapper businessRoleMapper;

    @Inject
    public HelloResource(PrivilegeMapper privilegeMapper, BusinessRoleMapper businessRoleMapper) {
        this.privilegeMapper = privilegeMapper;
        this.businessRoleMapper = businessRoleMapper;
    }

    @GET
    @Path("/privileges")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPrivileges() {
        return Response.ok().entity(privilegeMapper.selectAll()).build();
    }

    @GET
    @Path("/businessRoles")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBusinessRoles() {
        return Response.ok().entity(businessRoleMapper.selectAll()).build();
    }

}
