package com.java.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.java.api.component.Student;

@SuppressWarnings("unused")
@SpringBootApplication
public class StringBootApp {

	public static void main(String[] args) {

		//SpringApplication app = new SpringApplication(StringBootApp.class);
		//app.setDefaultProperties(Collections.singletonMap("server.port", 8080)); // default port
		//app.run(args);

		//SpringApplication.run(StringBootApp.class, args);
		ConfigurableApplicationContext context = SpringApplication.run(StringBootApp.class, args);
		
		//Student s1 = context.getBean(Student.class);
		//s1.show();
		
		/*Student s2 = context.getBean(Student.class);
		s2.show();
		
		System.out.println(s1.hashCode()+" - "+s2.hashCode());*/
	}

}
