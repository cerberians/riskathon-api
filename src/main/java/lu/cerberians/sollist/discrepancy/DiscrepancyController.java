package lu.cerberians.sollist.discrepancy;

import lu.cerberians.sollist.entities.Loop;
import org.apache.commons.lang3.text.WordUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/discrepancies")
public class DiscrepancyController {

    private DiscrepancyService discrepancyService;

    @Inject
    public DiscrepancyController(DiscrepancyService discrepancyService) {
        this.discrepancyService = discrepancyService;
    }

    @GetMapping
    public String index(Model model) {
        final List<Loop> discrepancies = discrepancyService.getDiscrepancies().stream()
                .peek((item)-> item.setBr(WordUtils.capitalizeFully(item.getBr())))
                .collect(Collectors.toList());

        final DiscrepanciesDto discrepanciesDto = new DiscrepanciesDto();
        discrepanciesDto.setDiscrepancies(discrepancies);

        model.addAttribute("form", discrepanciesDto);
        return "discrepancies/index";
    }

    @PostMapping
    public String fix(@ModelAttribute DiscrepanciesDto form) {

        return "redirect:/discrepancies";
    }

}
