package br.com.barbara.ErrorCenter.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;



@Entity
@Table(name = "user_account")
public class UserAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	
	
	@Size(max = 100)
	@NotBlank(message = "Please enter name")
	private String name;
	
	@NotNull
	@Column(name = "password", length = 100, nullable = false)
	@Size(min = 6, max = 10)
	@NotEmpty(message = "Please enter password")
	private String password;
	
	@Column(name = "email", length = 100, nullable = false)
	@Size(max = 100)
	@Email(message = "E-mail isn't valid")
	@NotBlank(message = "Please enter email")
	private String email;
	
	@Column(name = "createAt", length = 100, nullable = false)
	@CreatedDate
	@CreationTimestamp
	private LocalDateTime createAt;

	public UserAccount(String name, String password,String email) {
		this.name = name;
		this.password = password;
		this.email = email;
	}
	
	

	public UserAccount() {	}



	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}



	public void setId(Long id) {
		this.id = id;
	}


	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}



	public void setName(String name) {
		this.name = name;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
	
	
	

}
