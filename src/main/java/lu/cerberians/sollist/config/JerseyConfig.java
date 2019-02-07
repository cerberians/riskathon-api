package lu.cerberians.sollist.config;

import io.swagger.v3.jaxrs2.integration.JaxrsOpenApiContextBuilder;
import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import io.swagger.v3.oas.integration.OpenApiConfigurationException;
import io.swagger.v3.oas.integration.SwaggerConfiguration;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import lu.cerberians.sollist.HelloResource;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.message.GZipEncoder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.EncodingFilter;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import java.util.Collections;

@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig(@Context ServletConfig servletConfig) {
        super();

        register(HelloResource.class);

        EncodingFilter.enableFor(this, GZipEncoder.class);
        register(RolesAllowedDynamicFeature.class);
        register(MultiPartFeature.class);
        register(OpenApiResource.class);

        OpenAPI oas = new OpenAPI();
        Info info = new Info()
                .title("Cerberians SOLL/IST API")
                .description("Cerberians SOLL/IST API")
                .version("1.0.0")
                .termsOfService("https://riskathon.seventythree.io/")
                .contact(new Contact()
                        .email("florian.sey+cerberians@gmail.com"))
                .license(new License()
                        .name("Cerberians")
                        .url("https://riskathon.seventythree.io"));
        oas.info(info);

        final Server server = new Server()
                .description("Default")
                .url("/api");
        oas.servers(Collections.singletonList(server));

        oas.components(new Components()
                .addSecuritySchemes("accessToken", new SecurityScheme()
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT")));

        oas.security(Collections.singletonList(new SecurityRequirement()
                .addList("accessToken")));
        SwaggerConfiguration oasConfig = new SwaggerConfiguration()
                .openAPI(oas)
                .prettyPrint(true);

        try {
            new JaxrsOpenApiContextBuilder()
                    .application(this)
                    .servletConfig(servletConfig)
                    .openApiConfiguration(oasConfig)
                    .buildContext(true);
        } catch (OpenApiConfigurationException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
