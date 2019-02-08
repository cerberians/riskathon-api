package lu.cerberians.sollist.sollcreation;

import lu.cerberians.sollist.ApplicationContext;
import lu.cerberians.sollist.applications.ApplicationsController;
import lu.cerberians.sollist.applications.ApplicationsConverter;
import lu.cerberians.sollist.constraints.Constraint;
import lu.cerberians.sollist.entities.AssetFunction;
import lu.cerberians.sollist.entities.Entitlement;
import lu.cerberians.sollist.entities.Entity;
import lu.cerberians.sollist.mapper.ApplicationMapper;
import lu.cerberians.sollist.mapper.AssetMapper;
import lu.cerberians.sollist.mapper.EntitlementMapper;
import lu.cerberians.sollist.mapper.PrivilegeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.util.ListUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/soll/create")
public class SollController {
    private static Logger log = LoggerFactory.getLogger(SollController.class);
    private ApplicationContext applicationContext;
    private PrivilegeMapper privilegeMapper;
    private EntitlementMapper entitlementMapper;

    public SollController(ApplicationContext applicationContext
            , PrivilegeMapper privilegeMapper
            , EntitlementMapper entitlementMapper) {
        this.applicationContext = applicationContext;
        this.privilegeMapper = privilegeMapper;
        this.entitlementMapper = entitlementMapper;
    }

    @RequestMapping(value = "/af")
    public String createAssetFunctions(Model model){
        log.debug("CREATE SOLL FOR AF");
        model.addAttribute("form", new AssetFunction());
        return "sollcreation/assetfunctions";
    }

    @RequestMapping(value = "/en")
    public String createEntitlements(Model model){
        log.debug("CREATE SOLL FOR EN");
        log.debug(applicationContext.getAsset().getName());
        model.addAttribute("privileges", privilegeMapper.selectAll());
        model.addAttribute("form", new Entitlement());
        return "sollcreation/entitlements";
    }

    @RequestMapping(value = "/toxic/en")
    public String createToxicEntitlements(Model model){
        log.debug("CREATE TOXIC SOLL FOR EN");
        List<Entitlement> entitlements1 = entitlementMapper.getAll(applicationContext.getAsset());
        List<Entitlement> entitlements2 = new ArrayList<>();
        entitlements2.addAll(entitlements1);

        List<Constraint> constraints = new ArrayList<>();
        for (Entitlement entitlement1: entitlements1) {
            Entity entity1 = new Entity(entitlement1.getId(), entitlement1.getName());
            for (Entitlement entitlement2: entitlements2) {
                Entity entity2 = new Entity(entitlement2.getId(), entitlement2.getName());
                constraints.add(Constraint.builder()
                        .fromEntity(entity1)
                        .toEntity(entity2).build());
            }
        }
        model.addAttribute("form", new ToxicEntitlementsForm(constraints));
        return "sollcreation/toxic_entitlements";
    }

    @RequestMapping(value = "/toxic/af")
    public String createToxicassetFunctinons(){
        log.debug("CREATE TOXIC SOLL FOR AF");
        log.debug(applicationContext.getAsset().getName());
        return "sollcreation/toxic_asset_functions";
    }
}
