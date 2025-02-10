package br.edu.ufape.housing.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.edu.ufape.housing.model.Location;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class LocationRepositoryImpl implements LocationRepositoryCustom {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Location> findByAvailableUnitsRange(Integer minUnits, Integer maxUnits) {
        String jpql = "SELECT l FROM Location l WHERE l.availableUnits BETWEEN :min AND :max";
        TypedQuery<Location> query = entityManager.createQuery(jpql, Location.class);
        query.setParameter("min", minUnits);
        query.setParameter("max", maxUnits);
        
        return query.getResultList();
    }
}
