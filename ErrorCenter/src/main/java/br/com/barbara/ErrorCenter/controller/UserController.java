package br.com.barbara.ErrorCenter.controller;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.barbara.ErrorCenter.dto.UserAccountDto;
import br.com.barbara.ErrorCenter.model.UserAccount;
import br.com.barbara.ErrorCenter.repository.UserRepository;
import br.com.barbara.ErrorCenter.service.UserService;
import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/api")
@Api(value = "User Controller")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public Page<UserAccount> getUsers(Pageable pageable) {

		return userRepository.findAll(pageable);
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<UserAccount> getUser(@PathVariable(value = "id") Long id) {

		Optional<UserAccount> userOpt = userRepository.findById(id);

		if (userOpt.isPresent()) {
			return new ResponseEntity<UserAccount>(userOpt.get(), HttpStatus.OK);
		}

		return ResponseEntity.notFound().build();

	}

	@PostMapping("/user")
	public ResponseEntity<UserAccountDto> createUser(@Valid @RequestBody UserAccount userAccount,
			UriComponentsBuilder uriBuilder) {
		@Valid
		UserAccount saveUser = userRepository.save(userAccount);

		URI uri = uriBuilder.path("/api/{id}").buildAndExpand(saveUser.getId()).toUri();

		return ResponseEntity.created(uri).body(new UserAccountDto(userAccount));
	}

	@PutMapping("/user/{id}")
	public ResponseEntity<UserAccount> updateUser(@PathVariable Long id, @Valid @RequestBody UserAccount userUpdate) {

		Optional<UserAccount> user = userRepository.findById(id);

		if (user.isPresent()) {

			userUpdate.setId(user.get().getId());
			userUpdate.setCreateAt(user.get().getCreateAt());

			return new ResponseEntity<UserAccount>(userRepository.save(userUpdate), HttpStatus.OK);
		}

		return ResponseEntity.notFound().build();
	}

	@PatchMapping("/user/{id}")
	public ResponseEntity<UserAccount> updateOneData(@PathVariable Long id, @RequestBody UserAccount parcialUserUpdate) {
		
		Optional<UserAccount> user = userRepository.findById(id);

		if (user.isPresent()) {
			
			userService.updateUser(user, parcialUserUpdate);
			return new ResponseEntity<UserAccount>(userRepository.save(parcialUserUpdate), HttpStatus.OK);
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Long id) {

		Optional<UserAccount> user = userRepository.findById(id);

		if (user.isPresent()) {
			userRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();

	}

}
