package br.edu.ufape.housing.repository;

import java.util.List;

import br.edu.ufape.housing.model.Location;

public interface LocationRepositoryCustom {
    
    List<Location> findByAvailableUnitsRange(Integer minUnits, Integer maxUnits);
}
