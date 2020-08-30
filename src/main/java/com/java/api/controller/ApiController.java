package com.java.api.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.java.api.model.Address;
import com.java.api.model.Employee;
import com.java.api.service.ApiService;

@RestController
@RequestMapping(value = "api")
public class ApiController {

	@Autowired
	private ApiService apiService;

	@RequestMapping("/home")
	public ModelAndView home(
			@RequestParam(value = "name", required = false, defaultValue = "Ajay Singh Meena") String name) {
		ModelAndView map = new ModelAndView();
		map.addObject("name", name);
		map.setViewName("home");
		return map;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getRequest() {

		String msg = "Welcome to Spring Boot - " + new Date();
		msg += "<br>";
		msg += "<br> @Author - Ajay Singh Meena";
		msg += "<br> @Since - 24th Jun 2020";
		msg += "<br> @Email - MEENAAJAY1992@GMAIL.COM";

		return msg;
	}

	@GetMapping(value = "/emp/add")
	public Employee addEmpUI(Employee emp) {
		return apiService.addEmp(emp);
	}

	@RequestMapping(value = "/emp", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView getEmpList() {

		List<Employee> list = apiService.getEmpList();
		ModelAndView mv = new ModelAndView("viewemp");
		mv.addObject("list", list);
		return mv;
	}

	@RequestMapping(value = "/emp/sortByAge", method = RequestMethod.GET)
	@ResponseBody
	public List<Employee> getEmpListSortByAge() {

		return apiService.getEmpListSortByAge();
	}

	@RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
	public Employee getEmpById(@PathVariable(required = true) Integer id) {

		return apiService.getEmpById(id);
	}

	@RequestMapping(value = "/emp", method = RequestMethod.POST)
	public Employee addEmp(@RequestBody Employee emp) {

		return apiService.addEmp(emp);
	}

	@RequestMapping(value = "/emp/{id}", method = RequestMethod.PUT)
	public Employee updateEmp(@RequestBody Employee emp, @PathVariable Integer id) {

		return apiService.updateEmp(id, emp);
	}

	@RequestMapping(value = "/emp/{id}", method = RequestMethod.DELETE)
	public String deleteEmpById(@PathVariable(required = true) Integer id) {

		return apiService.deleteEmpById(id);
	}

	@RequestMapping(value = "/emp/{id}/addresses", method = RequestMethod.GET)
	public List<Address> getAddressByEmpId(@PathVariable(required = true) Integer id) {

		return apiService.getAddressByEmpId(id);
	}

	@RequestMapping(value = "/emp/age/{age}", method = RequestMethod.GET)
	public List<Employee> getEmpByAge(@PathVariable(required = true) Integer age) {

		return apiService.getEmpByAge(age);
	}

	@RequestMapping(value = "/emp/address/{id}", method = RequestMethod.GET)
	public List<Employee> getEmpByAddId(@PathVariable(required = true) Integer id) {

		return apiService.getEmpByAddId(id);
	}

	@RequestMapping(value = "/emp/address/HNo/{HNo}", method = RequestMethod.GET)
	public List<Employee> getEmpByAddHNo(@PathVariable(required = true) Integer HNo) {

		return apiService.getEmpByAddHNo(HNo);
	}

}
