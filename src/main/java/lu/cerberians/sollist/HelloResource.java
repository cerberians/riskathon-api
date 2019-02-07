package lu.cerberians.sollist;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloResource {

    private HelloService helloService;

    private PrivilegeMapper mapper;

    @Inject
    public HelloResource(HelloService helloService, PrivilegeMapper mapper) {
        this.helloService = helloService;
        this.mapper = mapper;
    }

//    @GET
//    public Response greetings() {
//        helloService.createNode();
//        return Response.ok().build();
//    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response greetings() {
        return Response.ok().entity(mapper.selectAll()).build();
    }

}
