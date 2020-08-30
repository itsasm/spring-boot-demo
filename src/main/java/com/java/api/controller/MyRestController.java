package com.java.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.api.configuration.bean.Vehical;
import com.java.api.model.Employee;

@RestController
public class MyRestController {

	@Autowired
	private Employee employee;

	@Autowired
	private Vehical vehical;

	@GetMapping("/getBean")
	public Employee getBean() {
		return employee;
	}

	@RequestMapping(value = { "/getVehical/{speed}", "getVehical*" })
	public String getVehical(@PathVariable(required = false) Integer speed) {
		return vehical.run(speed == null ? 40 : speed);
	}

	@ExceptionHandler(NumberFormatException.class)
	public String exceptionHandler() {
		System.out.println("Error Occurred ...........");
		return "Error Occurred ...........";
	}

	@RequestMapping("*")
	private String defaultMethod() {
		return "Request being handled by defaultMethod.....";
	}

}
