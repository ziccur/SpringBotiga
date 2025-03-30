package iticbcn.yeray.mvc.Service;

import java.util.List;
import java.util.Optional;

import iticbcn.yeray.mvc.Model.Llibre;

public interface LlibreService {
    List<Llibre> findAll();
    Llibre findByTitol(String titol);
    List<Llibre> findByTitolAndEditorial(String titol, String editorial);
    boolean validateISBN(String isbn);
    Optional<Llibre> findByIdLlibre(int id);
    void save(Llibre llibre);
}