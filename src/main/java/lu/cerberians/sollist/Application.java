package lu.cerberians.sollist;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import lu.cerberians.sollist.entities.Asset;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

@SpringBootApplication
@EnableEncryptableProperties
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    @Bean
    @Scope(value = WebApplicationContext.SCOPE_SESSION,
            proxyMode = ScopedProxyMode.TARGET_CLASS)
    public ApplicationContext applicationContext() {
        // By default, assume the asset "1" is selected
        final ApplicationContext applicationContext = new ApplicationContext();
        final Asset asset = new Asset();
        asset.setId("16");
        applicationContext.setAsset(asset);
        return applicationContext;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
