package br.edu.ufape.housing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import br.edu.ufape.housing.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    UserDetails findByEmail(String email);
    
}
