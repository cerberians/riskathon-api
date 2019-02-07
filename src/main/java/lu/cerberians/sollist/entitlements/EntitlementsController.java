package lu.cerberians.sollist.entitlements;

import lombok.extern.slf4j.Slf4j;
import lu.cerberians.sollist.entities.Entitlement;
import lu.cerberians.sollist.mapper.PrivilegeMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;

@Slf4j
@Controller
@RequestMapping("/entitlements")
public class EntitlementsController {

    private PrivilegeMapper privilegeMapper;
    private EntitlementsService entitlementsService;

    @Inject
    public EntitlementsController(PrivilegeMapper privilegeMapper,
                                  EntitlementsService entitlementsService) {
        this.privilegeMapper = privilegeMapper;
        this.entitlementsService = entitlementsService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("entitlements", entitlementsService.getAll());
        return "entitlements/list";
    }

    @GetMapping("create")
    public String createForm(Model model) {
        model.addAttribute("privileges", privilegeMapper.selectAll());
        model.addAttribute("form", new Entitlement());
        return "entitlements/form";
    }

    @PostMapping("create")
    public String create(Entitlement entitlement) {
        log.info("{}", entitlement);
        entitlementsService.create(entitlement);
        return "redirect:/entitlements";
    }

}
