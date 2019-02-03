package lu.cerberians.sollist;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloResource {

    private HelloService helloService;

    @Inject
    public HelloResource(HelloService helloService) {
        this.helloService = helloService;
    }

    @GET
    public Response greetings() {
        helloService.createNode();
        return Response.ok().build();
    }

}
