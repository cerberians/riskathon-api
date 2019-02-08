package lu.cerberians.sollist.applications;

import lu.cerberians.sollist.ApplicationContext;
import lu.cerberians.sollist.entities.Entitlement;
import lu.cerberians.sollist.mapper.ApplicationMapper;
import lu.cerberians.sollist.mapper.AssetMapper;
import lu.cerberians.sollist.mapper.PrivilegeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.Collectors;

@Controller
@RequestMapping("/applications")
public class ApplicationsController {
    private static Logger log = LoggerFactory.getLogger(ApplicationsController.class);
    private ApplicationsConverter converter;
    private ApplicationMapper applicationMapper;
    private AssetMapper assetMapper;
    private ApplicationContext applicationContext;
    private PrivilegeMapper privilegeMapper;

    @Autowired
    public ApplicationsController(ApplicationsConverter converter,
                                  ApplicationMapper applicationMapper,
                                  ApplicationContext applicationContext,
                                  AssetMapper assetMapper,
                                  PrivilegeMapper privilegeMapper) {
        this.converter = converter;
        this.applicationMapper = applicationMapper;
        this.applicationContext = applicationContext;
        this.assetMapper = assetMapper;
        this.privilegeMapper = privilegeMapper;
    }

    @RequestMapping("")
    public String newProduct(Model model){
        model.addAttribute("applicationList",
                applicationMapper.selectAll().stream()
                        .flatMap(converter::convert).collect(Collectors.toList()));
        return "applications/list";
    }

    @RequestMapping(value = "/update/soll/{id}")
    public String updateSoll(@PathVariable int id){
        log.debug("UPDATE SOLL");
        return null;
    }


    @RequestMapping(value = "/create/soll/{assetID}")
    public String createSoll(@PathVariable int assetID, Model model){
        log.debug("CREATE SOLL FOR assetid:" + assetID);
        applicationContext.setAsset(assetMapper.selectById(Integer.toString(assetID)));
        model.addAttribute("privileges", privilegeMapper.selectAll());
        model.addAttribute("form", new Entitlement());
        return "sollcreation/entitlements";
    }

}
