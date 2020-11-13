package br.com.barbara.ErrorCenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.barbara.ErrorCenter.model.ServiceEvent;

public interface ServiceEventRepository extends JpaRepository <ServiceEvent, Long>{
	

}
