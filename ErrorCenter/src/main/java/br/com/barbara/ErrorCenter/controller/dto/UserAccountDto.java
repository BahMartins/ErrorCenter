package br.com.barbara.ErrorCenter.controller.dto;

import java.time.LocalDateTime;

import br.com.barbara.ErrorCenter.model.UserAccount;

public class UserAccountDto {
	
	private Long id;
	private String nome;
	private String email;
	private LocalDateTime createAt;
	
	
	public UserAccountDto(UserAccount userAccount) {
		super();
		this.id = userAccount.getId();
		this.nome = userAccount.getName();
		this.email = userAccount.getEmail();
		this.createAt = userAccount.getCreateAt();
	}


	public Long getId() {
		return id;
	}


	public String getNome() {
		return nome;
	}


	public String getEmail() {
		return email;
	}


	public LocalDateTime getCreateAt() {
		return createAt;
	}
	
	
	
	

}
