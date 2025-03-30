package iticbcn.yeray.mvc.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iticbcn.yeray.mvc.Model.Llibre;
import iticbcn.yeray.mvc.Repository.LlibreRepository;

@Service
public class LlibreServiceImpl implements LlibreService {

    @Autowired
    private LlibreRepository llibreRepository;

    @Override
    public List<Llibre> findAll() {
        return llibreRepository.findAll();
    }

    @Override
    public Llibre findByTitol(String titol) {
        return llibreRepository.findByTitol(titol);
    }

    @Override
    public List<Llibre> findByTitolAndEditorial(String titol, String editorial) {
        return llibreRepository.findByTitolAndEditorial(titol, editorial);
    }

    @Override
    public boolean validateISBN(String isbn) {
        // Validación básica de ISBN (10 o 13 dígitos, sin guiones)
        String cleanedISBN = isbn.replaceAll("-", "");
        return cleanedISBN.matches("^(\\d{10}|\\d{13})$");
    }

    @Override
    public Optional<Llibre> findByIdLlibre(int id) {
        return llibreRepository.findById(id);
    }

    @Override
    public void save(Llibre llibre) {
        llibreRepository.save(llibre);
    }
}
