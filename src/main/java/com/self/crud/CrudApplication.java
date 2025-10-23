package com.self.crud;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Employee Management API",
				version = "1.0",
				description = "API for managing employee records",
				contact = @Contact(
						name = "Mohd Waseem",
						email = "mohd.waseem@comviva.com",
						url = "https://www.comviva.com/"
				),
				license = @License(
						name = "Apache 2.0",
						url = "http://www.apache.org/licenses/LICENSE-2.0.html"
				)

		),
		externalDocs = @ExternalDocumentation(
				description = "Employee Management API Documentation",
				url = "https://www.comviva.com/employeeManagement.html"
		)
)
public class CrudApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

}
