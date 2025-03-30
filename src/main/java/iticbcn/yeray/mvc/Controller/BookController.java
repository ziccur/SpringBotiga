package iticbcn.yeray.mvc.Controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import iticbcn.yeray.mvc.Model.Llibre;
import iticbcn.yeray.mvc.Repository.LlibreRepository;

@Controller
public class BookController {

    @Autowired
    private LlibreRepository llibreRepository;

    @GetMapping("/")
    public String iniciar() {
        return "login";
    }

    @PostMapping("/index")
    public String login(@RequestParam String usuari, 
                        @RequestParam String password, 
                        Model model) {

        if (usuari.equals("toni") && password.equals("h3ll0!!")) {
            return "index";
        } else {
            return "login";
        }
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/consulta")
    public String consulta(Model model) {
        model.addAttribute("llibres", llibreRepository.findAll());
        return "consulta";
    }

    @GetMapping("/inserir")
    public String inputInserir() {
        return "inserir";
    }

    @GetMapping("/cercaid")
    public String inputCerca(Model model) {
        model.addAttribute("llibreErr", true);
        model.addAttribute("message", "");
        model.addAttribute("llibre", new Llibre());
        return "cercaid";
    }

    @PostMapping("/inserir")
    public String inserir(
            @RequestParam(name = "titol") String titol,
            @RequestParam(name = "autor") String autor,
            @RequestParam(name = "editorial") String editorial,
            @RequestParam(name = "datapublicacio") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate datapublicacio,
            @RequestParam(name = "tematica") String tematica,
            @RequestParam(name = "isbn") String isbn,
            Model model) {

        Llibre llibre = new Llibre();
        llibre.setTitol(titol);
        llibre.setAutor(autor);
        llibre.setEditorial(editorial);
        llibre.setDatapublicacio(datapublicacio);
        llibre.setTematica(tematica);
        llibre.setIsbn(isbn);

        llibreRepository.save(llibre);
        model.addAttribute("llibres", llibreRepository.findAll());
        return "consulta";
    }

    @PostMapping("/cercaid")
    public String cercaId(
            @RequestParam(name = "idLlibre") int idLlibre,
            Model model) {

        String message = "";
        boolean llibreErr = false;

        Llibre llibre = llibreRepository.findById(idLlibre).orElse(null);
        if (llibre != null) {
            model.addAttribute("llibre", llibre);
        } else {
            message = "No hi ha cap llibre amb aquesta id";
            llibreErr = true;
        }

        model.addAttribute("message", message);
        model.addAttribute("llibreErr", llibreErr);
        return "cercaid";
    }

    @PostMapping("/logout")
    public String logout() {
        return "redirect:/";
    }
}