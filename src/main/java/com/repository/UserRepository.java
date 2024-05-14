package com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.model.entity.User;

/**
 * Repository User
 * 
 * @autor Raul Alonso Calvarro [raul.ac-97@hotmail.com]
 * @since 1.0.0
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	
	@Query("select u from User u where u.email = :email")
	Optional<User> findByEmail(@Param("email") String email);

	@Query("select u from User u where u.email = :email")
    boolean existsByEmail(String email);
	
	@Query("select u from User u where u.username = :username")
	Optional<User> findByUsername(String username);
	
	@Query("select u from User u where u.username = :username")
	boolean existsByUsername(String username);
}
