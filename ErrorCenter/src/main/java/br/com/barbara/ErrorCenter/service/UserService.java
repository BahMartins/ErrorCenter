package br.com.barbara.ErrorCenter.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import br.com.barbara.ErrorCenter.model.UserAccount;

@Service
public class UserService {

	public UserAccount updateUser(Optional<UserAccount> user, UserAccount parcialUserUpdate) {
		
		
		
		System.out.println("entrou no service");
		parcialUserUpdate.setId(user.get().getId());
		parcialUserUpdate.setCreateAt(user.get().getCreateAt());
		
		if(parcialUserUpdate.getName().isBlank() || parcialUserUpdate.getName().isEmpty()) {
			parcialUserUpdate.setName(user.get().getName());			
		}
		
		if(parcialUserUpdate.getPassword().isBlank() || parcialUserUpdate.getPassword().isEmpty()) {
			parcialUserUpdate.setPassword(user.get().getPassword());
		}
		
		if(parcialUserUpdate.getEmail().isBlank() || parcialUserUpdate.getEmail().isEmpty()) {
			parcialUserUpdate.setEmail(user.get().getEmail());
		}
		
		return parcialUserUpdate;
	}

	
	
	
	

}
