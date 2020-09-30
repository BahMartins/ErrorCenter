package br.com.barbara.ErrorCenter.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import com.sun.istack.NotNull;

@Entity
@Table(name = "service_event")
public class ServiceEvent {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@NotNull
	@Column(name = "log", length = 255, nullable = false)
	private String log;

	@NotNull
	@Column(name = "descriprion", length = 255, nullable = false)
	private String description;

	@NotNull
	@Column(name = "origin", length = 100, nullable = false)
	private String origin;

	@Column
	@Min(value = 0L)
	private Long quantity = 0L;

	@Column
	private Boolean isArchived;

	@Column(name = "updateat")
	private LocalDateTime updatedAt;

	@Column(name = "createat", updatable = false)
	@CreatedDate
	@CreationTimestamp
	private LocalDateTime createdAt;

	public ServiceEvent(Long id, String log, String description, String origin, String environment) {
	}

}
