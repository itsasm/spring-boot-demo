package com.java.api.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.java.api.model.Address;
import com.java.api.model.Employee;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class ControllerTest extends AbstractTest {

	@Test
	@Order(1)
	public void testWelcome() throws Exception {
		String uri = "/api";

		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		String content = mvcResult.getResponse().getContentAsString();

		Assert.assertEquals(200, status);
		Assert.assertEquals("Welcome to Spring Boot", content);
	}

	@Test
	@Order(2)
	public void testGetEmployeeList() throws Exception {
		String uri = "/api/emp";

		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		String content = mvcResult.getResponse().getContentAsString();

		Employee[] list = mapFromJson(content, Employee[].class);

		Assert.assertEquals(200, status);
		Assert.assertEquals(3, list.length);
	}

	@Test
	@Order(3)
	public void testGetEmpById() throws Exception {
		String uri = "/api/emp/7";

		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		String content = mvcResult.getResponse().getContentAsString();

		Employee emp = mapFromJson(content, Employee.class);

		Assert.assertEquals(200, status);
		Assert.assertEquals(27, emp.getAge());
	}

	@Test
	@Order(4)
	public void testAddEmp() throws Exception {
		String uri = "/api/emp";

		List<Address> address = new ArrayList<>();
		address.add(new Address(0, 123, "Street", 56));
		Employee emp = new Employee(0, "Ajay New", 26, address);

		MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(mapToJson(emp)))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		int count = Integer.parseInt(mvcResult.getResponse().getContentAsString());

		Assert.assertEquals(200, status);
		Assert.assertTrue(count > 3);
	}

	@Test
	@AfterAll
	public void testDeleteEmp() throws Exception {
		String uri = "/api/emp/1";

		MvcResult mvcResult = mockMvc
				.perform(MockMvcRequestBuilders.delete(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		boolean isDeleted = Boolean.valueOf(mvcResult.getResponse().getContentAsString());

		Assert.assertEquals(200, status);
		Assert.assertFalse(isDeleted);
	}

}
