package br.edu.ufape.housing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.housing.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>, 
 BookingRepositoryCustom {
    
}
