package br.com.barbara.ErrorCenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class ServiceEventController {
	
	@Autowired
	private ServiceEventController serviceEventController;
	
	

}
