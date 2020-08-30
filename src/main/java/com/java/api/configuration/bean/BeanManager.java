package com.java.api.configuration.bean;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

import com.java.api.model.Address;
import com.java.api.model.Employee;

@Configuration
@Lazy
public class BeanManager {

	private static List<Address> addresses = new ArrayList<>();

	static {
		System.out.println("BeanManager.static block.....");
		addresses.add(new Address(321, 44, "Boriya Khamkheda Vidisha MP IN", 464226));
	}

	@Bean(name="employee")
	public Employee getAjayEmployee() {
		System.out.println("Creating Ajay Employee Bean.........");
		return new Employee(123, "Ajay Singh Meena", 28, null);
	}

	@Bean
	@Primary
	public Employee getRiyuEmployee() {
		return new Employee(123, "Riyu Meena", 2, addresses);
	}
}
