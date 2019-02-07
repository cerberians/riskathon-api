package lu.cerberians.sollist.main;

import lu.cerberians.sollist.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.inject.Inject;

@Controller
public class MainController {

    private ApplicationContext context;

    @Inject
    public MainController(ApplicationContext context) {
        this.context = context;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

}
