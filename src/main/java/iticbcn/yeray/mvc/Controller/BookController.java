package iticbcn.yeray.mvc.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import iticbcn.yeray.mvc.Model.Usuaris;
import iticbcn.yeray.mvc.Repository.RepoLlibre;

@Controller
@SessionAttributes("users")
public class BookController {

    @Autowired
    RepoLlibre repoll = new RepoLlibre();

    @GetMapping("/")
    public String iniciar(Model model) {
        return "login";
    }

    @PostMapping("/index")
    public String login(@ModelAttribute("users") Usuaris users, Model model) {

        model.addAttribute("users", users);

        if (users.getUsuari().equals("toni") 
        && users.getPassword().equals("h3ll0!!")) {
            return "index";
        } else {
            return "login";
        }        
    }

}