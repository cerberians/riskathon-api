package lu.cerberians.sollist.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

    public String index() {
        return "index";
    }

}
