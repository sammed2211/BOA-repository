package com.boa.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.boa.config.AppConfig;
import com.boa.model.CustomerModel;
import com.boa.service.CustomerService;
import com.boa.service.HelloWorld;

@SpringBootApplication
public class BoaSpringCoreDemoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(BoaSpringCoreDemoApplication.class, args);
		//System.out.println("My first spring boot app-->");
		
ApplicationContext context=SpringApplication.run(AppConfig.class);
        
        HelloWorld lookup=(HelloWorld) context.getBean("helloBean");
        
        // look up the Method by the lookup Reference 
        
        System.out.println(lookup.printDetails("BOA Microservice Session"));
        
        
        CustomerService customerService = (CustomerService) context.getBean("customerBean");
		 CustomerModel customer1 = new CustomerModel(1, "Rama","Delhi");
			CustomerModel customer2 = new CustomerModel(2, "Radhika","Chennai" );
			
			customerService.createCustomer(customer1);
			customerService.createCustomer(customer2);
			System.out.println("AllCustomer :");
			customerService.listAllCustomers();
	}

}
