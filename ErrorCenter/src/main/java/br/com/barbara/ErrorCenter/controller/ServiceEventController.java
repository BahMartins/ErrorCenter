package br.com.barbara.ErrorCenter.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.barbara.ErrorCenter.model.ServiceEvent;
import br.com.barbara.ErrorCenter.repository.ServiceEventRepository;
import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/api")
@Api(value = "Error Controller")
public class ServiceEventController {
	
	@Autowired
	private ServiceEventRepository serviceEventRepository;
	
	@GetMapping("/errors")
	public Page<ServiceEvent> getErros(Pageable pageable){
		
		return serviceEventRepository.findAll(pageable);
	}
	
	@GetMapping("/error/{id}")
	public ResponseEntity<ServiceEvent> getError(@PathVariable(value = "id") Long id){
		
		Optional<ServiceEvent> eventOpt = serviceEventRepository.findById(id);
		
		if(eventOpt.isPresent()) {
			return new ResponseEntity<ServiceEvent>(eventOpt.get(), HttpStatus.OK);
		}
		
		return ResponseEntity.notFound().build();
	}

}
