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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<ConstraintDto> constraintList = new ArrayList<>();

        for(AssetFunction assetFunction : map.keySet()) {
            for (BusinessRole businessRole : map.get(assetFunction)){
                constraintList .add(ConstraintDto.builder().fromEntity(assetFunction)
                                        .toEntity(businessRole)
                                        .allowed(false)
                                        .build());

            }
        }
        model.addAttribute("constraintList", constraintList);
        return "matrix/list";
    }

    @GetMapping("create")
    public String createConstraint(Model model) {
        log.info("here ! ");
        return "/applications";
    }
}
