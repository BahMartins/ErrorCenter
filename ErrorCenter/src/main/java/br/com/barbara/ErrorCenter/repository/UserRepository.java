package br.com.barbara.ErrorCenter.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.barbara.ErrorCenter.model.UserAccount;

public interface UserRepository extends JpaRepository<UserAccount, Long>{
	
	Optional<UserAccount> findById(Long id);
	
	UserAccount findByEmail(String email);
	
}
