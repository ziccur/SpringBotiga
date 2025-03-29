package iticbcn.yeray.mvc.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import iticbcn.yeray.mvc.Model.Llibre;
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

    @GetMapping("/index")
    public String index(@ModelAttribute("users") Usuaris users, Model model) {

            return "index";
        
    }

    @GetMapping("/consulta") 
    public String consulta(@ModelAttribute("users") Usuaris users,Model model) {

        ArrayList<Llibre> llibres = repoll.getAllLlibres();

        model.addAttribute("llibres", llibres);
        
        return "consulta";
    }

    @GetMapping("/inserir") 
    public String inputInserir(@ModelAttribute("users") Usuaris users,Model model) {
        
        return "inserir";
    }
    
        @GetMapping("/cercaid")
    public String inputCerca(@ModelAttribute("users") Usuaris users, Model model) {

        Llibre llibre = new Llibre();
        llibre.setIdLlibre(0);
        model.addAttribute("llibreErr", true);
        model.addAttribute("message", "");
        model.addAttribute("llibre", llibre);

        return "cercaid";

    }

        @PostMapping("/inserir")
    public String inserir(@ModelAttribute("users") Usuaris users, 
                          @RequestParam(name = "idLlibre") String idLlibre,
                          @RequestParam(name = "titol") String titol,  
                          @RequestParam(name = "autor") String autor,
                          @RequestParam(name = "editorial") String editorial,  
                          @RequestParam(name = "datapublicacio") String datapublicacio,
                          @RequestParam(name = "tematica") String tematica,
                          Model model) {

        String message = "";
        boolean llibreErr = false;

        if (idLlibre == null || !idLlibre.matches("\\d+")) {
            message = "La id de llibre ha de ser un nombre enter";
            llibreErr = true;
            model.addAttribute("message", message);
            model.addAttribute("llibreErr", llibreErr);
            return "inserir";
        } else {
            int idL = Integer.parseInt(idLlibre);
            Llibre llibre = new Llibre(idL,titol,autor,editorial,datapublicacio,tematica);
            repoll.InsertaLlibre(llibre);
            ArrayList<Llibre> llibres = repoll.getAllLlibres();
            model.addAttribute("llibres", llibres);
            return "consulta";            
        }
    }

    @PostMapping("/cercaid")
    public String cercaId(@ModelAttribute("users") Usuaris users,
                          @RequestParam(name = "idLlibre", required = false) String idLlibre, 
                          Model model) {
        
        int idLlib = 0;
        String message = "";
        boolean llibreErr = false;

        try {
            idLlib = Integer.parseInt(idLlibre);
            Llibre llibre = repoll.getLlibreID(idLlib);
            if(llibre !=null) {
                model.addAttribute("llibre", llibre);
            } else {
                message = "No hi ha cap llibre amb aquesta id";
                llibreErr = true;
            }

        } catch (Exception e) {
            message = "La id de llibre ha de ser un nombre enter";
            llibreErr = true;
        } 
        
        model.addAttribute("message", message);
        model.addAttribute("llibreErr",llibreErr);

        return "cercaid";

    }
}