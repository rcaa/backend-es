package br.edu.ufape.housing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.housing.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long>, 
 LocationRepositoryCustom {

    List<Location> findByNameIgnoreCase(String name);

    List<Location> findByCityIgnoreCase(String city);
    
}