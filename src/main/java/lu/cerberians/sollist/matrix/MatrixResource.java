package lu.cerberians.sollist.matrix;

import lu.cerberians.sollist.entities.*;
import lu.cerberians.sollist.mapper.*;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/matrix")
public class MatrixResource {

    private PrivilegeMapper privilegeMapper;
    private BusinessRoleMapper businessRoleMapper;
    private ConstraintMapper constraintMapper;
    private AssetFunctionMapper assetFunctionMapper;
    private EntitlementMapper entitlementMapper;
    private MatrixService matrixService;

    @Inject
    public MatrixResource(PrivilegeMapper privilegeMapper, BusinessRoleMapper businessRoleMapper,
                          ConstraintMapper constraintMapper, AssetFunctionMapper assetFunctionMapper,
                          EntitlementMapper entitlementMapper, MatrixService matrixService) {
        this.privilegeMapper = privilegeMapper;
        this.businessRoleMapper = businessRoleMapper;
        this.constraintMapper = constraintMapper;
        this.assetFunctionMapper = assetFunctionMapper;
        this.entitlementMapper = entitlementMapper;
        this.matrixService = matrixService;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getPrivileges(List<Constraint> constraints) {
        matrixService.createMatrix(constraints);
        return Response.ok().build();
    }

    @GET
    @Path("/prep")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getApplications() {
        final Asset asset = new Asset();
        asset.setId("1");

        Privilege p1 = new Privilege();
        p1.setId("p1");
        p1.setName("p1");
        privilegeMapper.create(p1);

        Entitlement e1 = new Entitlement();
        e1.setId("e1");
        e1.setName("e1");
        e1.setPrivilege(p1);
        entitlementMapper.create(asset, e1);

        Entitlement e2 = new Entitlement();
        e2.setId("e2");
        e2.setName("e2");
        e2.setPrivilege(p1);
        entitlementMapper.create(asset, e2);

        AssetFunction af1 = new AssetFunction();
        af1.setId("af1");
        af1.setName("af1");
        assetFunctionMapper.create(asset, af1);

        AssetFunction af2 = new AssetFunction();
        af2.setId("af2");
        af2.setName("af2");
        assetFunctionMapper.create(asset, af2);

//        matrixService.createMatrix(Arrays.asList(
//                new Constraint().setFrom(af1.getId()).setTo(e1.getId()).setIsWhitelist(true),
//                new Constraint().setFrom(af1.getId()).setTo(e2.getId()).setIsWhitelist(true),
//                new Constraint().setFrom(af2.getId()).setTo(e2.getId()).setIsWhitelist(true)
//        ));
        return Response.ok().build();
    }

}