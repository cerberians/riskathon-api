package lu.cerberians.sollist.sollcreation;

import lu.cerberians.sollist.ApplicationContext;
import lu.cerberians.sollist.applications.ApplicationsController;
import lu.cerberians.sollist.applications.ApplicationsConverter;
import lu.cerberians.sollist.mapper.ApplicationMapper;
import lu.cerberians.sollist.mapper.AssetMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.Collectors;

@Controller
@RequestMapping("/soll/create")
public class SollController {
    private static Logger log = LoggerFactory.getLogger(ApplicationsController.class);
    private ApplicationContext applicationContext;

    public SollController(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @RequestMapping(value = "/af")
    public String createAssetFunctions(){
        log.debug("CREATE SOLL FOR AF");
        return "sollcreation/assetfunctions";
    }

    @RequestMapping(value = "/en")
    public String createEntitlements(){
        log.debug("CREATE SOLL FOR EN");
        return "sollcreation/entitlements";
    }

    @RequestMapping(value = "/toxic/en")
    public String createToxicEntitlements(){
        log.debug("CREATE TOXIC SOLL FOR EN");
        return "sollcreation/toxic_entitlements";
    }

    @RequestMapping(value = "/toxic/af")
    public String createToxicassetFunctinons(){
        log.debug("CREATE TOXIC SOLL FOR AF");
        return "sollcreation/toxic_asset_functions";
    }
}
