package lu.cerberians.sollist.applications;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/applications")
public class ApplicationsController {
    private static Logger log = LoggerFactory.getLogger(ApplicationsController.class);

    @RequestMapping("")
    public String newProduct(Model model){
        ApplicationsForm form = new ApplicationsForm();
        model.addAttribute("applicationList", form.getApplications());
        return "applications/list";
    }

    @RequestMapping(value = "/update/soll/{id}")
    public String updateSoll(@PathVariable int id){
        log.info("UPDATE SOLL");
        return null;
    }


    @RequestMapping(value = "/create/soll/{assetID}")
    public String createSoll(@PathVariable int assetID){
        log.info("create soll for assetid:" + assetID);
        return null;
    }

}
