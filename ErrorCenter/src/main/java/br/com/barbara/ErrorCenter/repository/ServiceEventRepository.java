package br.com.barbara.ErrorCenter.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.barbara.ErrorCenter.model.ServiceEvent;

public interface ServiceEventRepository extends JpaRepository <ServiceEvent, Long>{
	
	Optional<ServiceEvent> findById(Long id);
	
	Page<ServiceEvent> findAll(Pageable pageable);

}
