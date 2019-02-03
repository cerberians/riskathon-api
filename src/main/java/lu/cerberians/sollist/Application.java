package lu.cerberians.sollist;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableEncryptableProperties
@EnableWebMvc
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
