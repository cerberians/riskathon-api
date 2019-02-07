package lu.cerberians.sollist;

import lu.cerberians.sollist.entities.*;
import lu.cerberians.sollist.mapper.*;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Path("/hello")
public class HelloResource {

    private HelloService helloService;

    private PrivilegeMapper privilegeMapper;

    private BusinessRoleMapper businessRoleMapper;

    private ConstraintMapper constraintMapper;

    private AssetFunctionMapper assetFunctionMapper;

    private EntitlementMapper entitlementMapper;

    @Inject
    public HelloResource(HelloService helloService, PrivilegeMapper privilegeMapper, BusinessRoleMapper businessRoleMapper,
                         ConstraintMapper constraintMapper, AssetFunctionMapper assetFunctionMapper, EntitlementMapper entitlementMapper) {
        this.helloService = helloService;
        this.privilegeMapper = privilegeMapper;
        this.businessRoleMapper = businessRoleMapper;
        this.constraintMapper = constraintMapper;
        this.assetFunctionMapper = assetFunctionMapper;
        this.entitlementMapper = entitlementMapper;
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
    @Path("/constraintTest")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getApplications() {
        Privilege p1 = new Privilege();
        p1.setId("p1");
        p1.setName("p1");
        privilegeMapper.create(p1);


        Entitlement e1 = new Entitlement();
        e1.setId("e1");
        e1.setName("e1");
        e1.setPrivilege(p1);
        entitlementMapper.create(e1);


        AssetFunction af1 = new AssetFunction();
        af1.setId("af1");
        af1.setName("af1");
        assetFunctionMapper.create(af1);

        constraintMapper.create(new Constraint().setA(af1).setB(e1).setIsWhitelist(true).setId(UUID.randomUUID().toString()));
        return Response.ok().build();
    }

}
