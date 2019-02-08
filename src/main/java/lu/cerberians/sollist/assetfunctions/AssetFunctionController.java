package lu.cerberians.sollist.assetfunctions;

import lombok.extern.slf4j.Slf4j;
import lu.cerberians.sollist.entities.AssetFunction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;

@Slf4j
@Controller
@RequestMapping("/asset-functions")
public class AssetFunctionController {

    private AssetFunctionService assetFunctionService;

    @Inject
    public AssetFunctionController(AssetFunctionService assetFunctionService) {
        this.assetFunctionService = assetFunctionService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("assetFunctions", assetFunctionService.getAll());
        return "assetfunctions/list";
    }

    @GetMapping("create")
    public String createForm(Model model) {
        model.addAttribute("form", new AssetFunction());
        return "assetfunctions/form";
    }

    @PostMapping("create")
    public String create(AssetFunction assetFunction) {
        log.info("{}", assetFunction);
        assetFunctionService.create(assetFunction);
        return "redirect:/asset-functions";
    }

}
