package com.java.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.java.api.model.Employee;

@Repository
public interface ApiRepository extends JpaRepository<Employee, Integer> {

	public List<Employee> findByAge(Integer age);

	public List<Employee> findByAgeGreaterThanEqual(Integer age);

	public List<Employee> findByAddressesId(Integer id);

	public List<Employee> findByAddressesHNo(Integer HNo);

	@Query("from Employee order by age desc")
	public List<Employee> getEmpListSortByAge();
}
