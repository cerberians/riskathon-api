package lu.cerberians.sollist.endpoints;

import lu.cerberians.sollist.forms.ApplicationListForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/applications")
public class ApplicationListController {
    private static Logger log = LoggerFactory.getLogger(ApplicationListController.class);

    @RequestMapping("")
    public String newProduct(Model model){
        ApplicationListForm form = new ApplicationListForm();
        model.addAttribute("applicationList", form.getApplications());
        return "application_list_form";
    }

    @RequestMapping(value = "/update/soll/{id}")
    public String updateSoll(@PathVariable Long id){
        log.info("the selected soll is ");
        return null;
    }


    @RequestMapping(value = "/create/soll/{appID}/{assetID}")
    public String createSoll(@PathVariable int appID, @PathVariable int assetID){
        log.info("create soll for appid:" + appID + "assetid:" + assetID);
        return null;
    }

}
