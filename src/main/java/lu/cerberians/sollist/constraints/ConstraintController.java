package lu.cerberians.sollist.constraints;

import lombok.extern.slf4j.Slf4j;
import lu.cerberians.sollist.ApplicationContext;
import lu.cerberians.sollist.assetfunctions.AssetFunctionService;
import lu.cerberians.sollist.businessroles.BusinessRoleService;
import lu.cerberians.sollist.entities.AssetFunction;
import lu.cerberians.sollist.entities.BusinessRole;
import lu.cerberians.sollist.entities.Entitlement;
import lu.cerberians.sollist.entitlements.EntitlementsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import java.util.*;

@Slf4j
@Controller
@RequestMapping("/constraint")
public class ConstraintController {

    private ApplicationContext applicationContext;

    private AssetFunctionService assetFunctionService;
    private BusinessRoleService businessRoleService;
    private EntitlementsService entitlementsService;

    @Inject
    public ConstraintController(AssetFunctionService assetFunctionService,
                                BusinessRoleService businessRoleService
                                , EntitlementsService entitlementsService
                                , ApplicationContext applicationContext
                                ) {
        this.assetFunctionService = assetFunctionService;
        this.businessRoleService = businessRoleService;
        this.entitlementsService = entitlementsService;
        this.applicationContext = applicationContext;
    }

    @GetMapping(value = "/{combinationId}")
    public String list(Model model,@PathVariable String combinationId) {
        List<Constraint> constraintList = new ArrayList<>();

        if("BA".equals(combinationId)) {
            List<AssetFunction> assetFunctions = assetFunctionService.getAll();

            List<BusinessRole> businessRoles =  businessRoleService.getAll();
            Map<AssetFunction, List<BusinessRole>> map = new HashMap<>();
            for(AssetFunction assetFunction: assetFunctions) {
                map.put(assetFunction, businessRoles);
            }
            for(AssetFunction assetFunction : map.keySet()) {
                for (BusinessRole businessRole : map.get(assetFunction)){
                    constraintList .add(Constraint.builder().id(UUID.randomUUID().toString())
                            .fromEntity(assetFunction)
                            .toEntity(businessRole)
                            .whitelist(false)
                            .build());

                }
            }
            model.addAttribute("title", "Business Roles - Asset Functions");

        } else if("EA".equals(combinationId)) {
            List<AssetFunction> assetFunctions = assetFunctionService.getAll();

            List<Entitlement> entitlements =  entitlementsService.getAll(applicationContext.getAsset());
            Map<AssetFunction, List<Entitlement>> map = new HashMap<>();
            for(AssetFunction assetFunction: assetFunctions) {
                map.put(assetFunction, entitlements);
            }
            for(AssetFunction assetFunction : map.keySet()) {
                for (Entitlement entitlement : map.get(assetFunction)){
                    constraintList .add(Constraint.builder().id(UUID.randomUUID().toString())
                            .fromEntity(assetFunction)
                            .toEntity(entitlement)
                            .whitelist(false)
                            .build());

                }
            }
            model.addAttribute("title", "Asset Functions - Entitlments");

        }
        else if("EE".equals(combinationId)) {
            List<Entitlement> entitlements = entitlementsService.getAll(applicationContext.getAsset());

            Map<Entitlement, List<Entitlement>> map = new HashMap<>();
            for(Entitlement entitlement: entitlements) {
                map.put(entitlement, entitlements);
            }
            for(Entitlement ent : map.keySet()) {
                for (Entitlement entitlement : map.get(ent)){
                    constraintList .add(Constraint.builder().id(UUID.randomUUID().toString())
                            .fromEntity(ent)
                            .toEntity(entitlement)
                            .whitelist(false)
                            .build());

                }
            }
            model.addAttribute("title", "Entitlments - Toxic");

        }else if("AA".equals(combinationId)) {
            List<AssetFunction> assetFunctions = assetFunctionService.getAll();

            Map<AssetFunction, List<AssetFunction>> map = new HashMap<>();
            for(AssetFunction assetFunction: assetFunctions) {
                map.put(assetFunction, assetFunctions);
            }
            for(AssetFunction assetfc : map.keySet()) {
                for (AssetFunction assetFunction : map.get(assetfc)){
                    constraintList .add(Constraint.builder().id(UUID.randomUUID().toString())
                            .fromEntity(assetfc)
                            .toEntity(assetFunction)
                            .whitelist(false)
                            .build());

                }
            }
            model.addAttribute("title", "Asset Functions - Toxic");
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
