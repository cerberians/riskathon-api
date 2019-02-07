package lu.cerberians.sollist;

import lu.cerberians.sollist.mapper.ApplicationMapper;
import lu.cerberians.sollist.mapper.BusinessRoleMapper;
import lu.cerberians.sollist.mapper.PrivilegeMapper;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloResource {

    private HelloService helloService;

    private PrivilegeMapper privilegeMapper;

    private BusinessRoleMapper businessRoleMapper;

    private ApplicationMapper applicationMapper;

    @Inject
    public HelloResource(HelloService helloService, PrivilegeMapper privilegeMapper, BusinessRoleMapper businessRoleMapper, ApplicationMapper applicationMapper) {
        this.helloService = helloService;
        this.privilegeMapper = privilegeMapper;
        this.businessRoleMapper = businessRoleMapper;
        this.applicationMapper = applicationMapper;
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

    @GET
    @Path("/apps")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getApplications() {
        return Response.ok().entity(applicationMapper.selectAll()).build();
    }

}
