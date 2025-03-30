package iticbcn.yeray.mvc.Controller;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import iticbcn.yeray.mvc.Model.Llibre;
import iticbcn.yeray.mvc.Service.LlibreService;

@Controller
public class BookController {

    @Autowired
    private LlibreService llibreService;

    @GetMapping("/")
    public String iniciar() {
        return "login";
    }

    @PostMapping("/index")
    public String login(
            @RequestParam String usuari,
            @RequestParam String password) {
        return (usuari.equals("toni") && password.equals("h3ll0!!")) 
                ? "redirect:/index" 
                : "redirect:/";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/consulta")
    public String consulta(Model model) {
        model.addAttribute("llibres", llibreService.findAll());
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
        return "cercaid";
    }

    @PostMapping("/inserir")
    public String inserir(
            @RequestParam String titol,
            @RequestParam String autor,
            @RequestParam String editorial,
            @RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate datapublicacio,
            @RequestParam String tematica,
            @RequestParam String isbn,
            Model model) {

        if (!llibreService.validateISBN(isbn)) {
            model.addAttribute("error", "ISBN invàlid");
            return "inserir";
        }

        Llibre llibre = new Llibre();
        llibre.setTitol(titol);
        llibre.setAutor(autor);
        llibre.setEditorial(editorial);
        llibre.setDatapublicacio(datapublicacio);
        llibre.setTematica(tematica);
        llibre.setIsbn(isbn);

        llibreService.save(llibre);
        return "redirect:/consulta";
    }

    @PostMapping("/cercaid")
    public String cercaId(
            @RequestParam int idLlibre,
            Model model) {

        Optional<Llibre> llibre = llibreService.findByIdLlibre(idLlibre);
        if (llibre.isPresent()) {
            model.addAttribute("llibre", llibre.get());
            model.addAttribute("llibreErr", false);
        } else {
            model.addAttribute("message", "No hi ha cap llibre amb aquesta id");
            model.addAttribute("llibreErr", true);
        }
        return "cercaid";
    }

    @PostMapping("/logout")
    public String logout() {
        return "redirect:/";
    }
}