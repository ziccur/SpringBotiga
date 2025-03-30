package iticbcn.yeray.mvc.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import iticbcn.yeray.mvc.Model.Llibre;

public interface LlibreRepository extends JpaRepository<Llibre, Integer> {
    
    @Override
    @NonNull
    List findAll();     

    Llibre findByTitol(String titol); 
    
    List<Llibre> findByTitolAndEditorial(String titol, String editorial);
}