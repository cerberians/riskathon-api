package lu.cerberians.sollist.endpoints;

import lu.cerberians.sollist.forms.UserForm;
import lu.cerberians.sollist.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {
    private static Logger log = LoggerFactory.getLogger(UserController.class);
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("")
    public String newProduct(Model model){
        model.addAttribute("userForm", new UserForm());
        return "userform";
    }

    @RequestMapping(value="/create", method = RequestMethod.POST)
    public String create(UserForm userForm){
        log.debug("create user:" + userForm.toString());
        userService.saveOrUpdate(userForm);
        return "redirect:/user";
    }

    @RequestMapping("/reset")
    public String reset(){
        log.debug("Resetting Neo4j");
        userService.deleteAll();
        return "redirect:/user";
    }

}
