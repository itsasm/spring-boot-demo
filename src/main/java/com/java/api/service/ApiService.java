package com.java.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.api.model.Address;
import com.java.api.model.Employee;
import com.java.api.repository.ApiRepository;

@Service
public class ApiService {

	@Autowired
	private ApiRepository apiRepository;

	public List<Employee> getEmpList() {

		List<Employee> list = new ArrayList<>();
		apiRepository.findAll().forEach(list::add);
		return list;
	}

	public List<Employee> getEmpListSortByAge() {

		return apiRepository.getEmpListSortByAge();
	}

	public Employee getEmpById(Integer id) {

		return apiRepository.findById(id).orElse(null);
	}

	public Employee addEmp(Employee emp) {
		return apiRepository.save(emp);
	}

	public Employee updateEmp(Integer id, Employee emp) {
		emp.setId(id);
		return apiRepository.save(emp);
	}

	public String deleteEmpById(Integer id) {
		try {
			apiRepository.deleteById(id);
		} catch (Exception e) {
			return "Record Not Found !!";
		}
		return "Record Deleted Successfully";
	}

	public List<Address> getAddressByEmpId(Integer id) {
		return apiRepository.findById(id).orElse(null).getAddresses();
	}

	public List<Employee> getEmpByAge(Integer age) {
		return apiRepository.findByAgeGreaterThanEqual(age);
	}

	public List<Employee> getEmpByAddId(Integer id) {
		return apiRepository.findByAddressesId(id);
	}

	public List<Employee> getEmpByAddHNo(Integer HNo) {
		return apiRepository.findByAddressesHNo(HNo);
	}

}
