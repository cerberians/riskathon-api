package lu.cerberians.sollist.constraints;

import lombok.extern.slf4j.Slf4j;
import lu.cerberians.sollist.assetfunctions.AssetFunctionService;
import lu.cerberians.sollist.businessroles.BusinessRoleService;
import lu.cerberians.sollist.entities.AssetFunction;
import lu.cerberians.sollist.entities.BusinessRole;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import java.util.*;

@Slf4j
@Controller
@RequestMapping("/constraint")
public class ConstraintController {

    private AssetFunctionService assetFunctionService;
    private BusinessRoleService businessRoleService;
    @Inject
    public ConstraintController(AssetFunctionService assetFunctionService,
                                BusinessRoleService businessRoleService) {
        this.assetFunctionService = assetFunctionService;
        this.businessRoleService = businessRoleService;
    }

    @GetMapping
    public String list(Model model) {
       List<AssetFunction> assetFunctions = assetFunctionService.getAll();
        List<BusinessRole> businessRoles =  businessRoleService.getAll();
        Map<AssetFunction, List<BusinessRole>> map = new HashMap<>();
        for(AssetFunction assetFunction: assetFunctions) {
            map.put(assetFunction, businessRoles);
        }
        List<Constraint> constraintList = new ArrayList<>();

        for(AssetFunction assetFunction : map.keySet()) {
            for (BusinessRole businessRole : map.get(assetFunction)){
                constraintList .add(Constraint.builder().id(UUID.randomUUID().toString())
                                        .fromEntity(assetFunction)
                                        .toEntity(businessRole)
                                        .whitelist(false)
                                        .build());

            }
        }
        model.addAttribute("constraints", constraintList);
        ConstraintForm constraintForm = new ConstraintForm();
        constraintForm.getConstraints().addAll(constraintList);
        model.addAttribute("constraintForm", constraintForm);
        return "matrix/list";
    }

    @GetMapping("create")
    public String createConstraint(Model model) {
        log.info("here ! ");
        return "/applications";
    }
}
