package br.com.barbara.ErrorCenter.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.barbara.ErrorCenter.controller.dto.UserAccountDto;
import br.com.barbara.ErrorCenter.model.UserAccount;
import br.com.barbara.ErrorCenter.repository.UserRepository;

@RestController
@RequestMapping(value = "/api")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	
	@GetMapping("/users")
	public List<UserAccount> getUsers(){
		return userRepository.findAll();
	}
	
	
	@GetMapping("/user/{id}")
	public UserAccount getUser(@PathVariable(value = "id") Long id) {
		Optional<UserAccount> findById = userRepository.findById(id);
		
		return findById.get();
	}
	
	@PostMapping("/user")
	public ResponseEntity<UserAccountDto> createUser(@RequestBody @Valid UserAccount userAccount,
			UriComponentsBuilder uriBuilder){
		@Valid
		UserAccount saveUser = userRepository.save(userAccount);
		
		URI uri = uriBuilder.path("/api/{id}").buildAndExpand(saveUser.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new UserAccountDto(userAccount));
	}

	@PutMapping("/user/{id}")
	public ResponseEntity<UserAccount> updateUser (@PathVariable Long id, 
												@RequestBody @Valid UserAccount userUpdate){
		
		Optional<UserAccount> user = userRepository.findById(id);
		
		if(user.isPresent()) {
			userUpdate.setId(user.get().getId());
			userUpdate.setCreateAt(user.get().getCreateAt());
			return new ResponseEntity<UserAccount>(userRepository.save(userUpdate), HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> deleteUser (@PathVariable Long id){
		
		Optional<UserAccount> user = userRepository.findById(id);
		
		if(user.isPresent()) {
			userRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
