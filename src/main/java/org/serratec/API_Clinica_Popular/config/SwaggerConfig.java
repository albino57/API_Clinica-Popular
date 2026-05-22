package org.serratec.API_Clinica_Popular.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
	
	private String title = "API Clínica Popular";
	private String description = "API RESTful desenvolvida para o sistema de gestão de Clínica Popular.\nContempla o cadastro de Especialidades, Pacientes, Médicos e o agendamento de Consultas.";
	private String version = "1.0";
	private String name = "Rafael Albino";
	private String URL = "https://github.com/Albino57";
	private String Email = "rafael.albino@API.com.br";
	
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().info(new Info().title(this.title).description(this.description).version(this.version).contact(new Contact().name(this.name).url(this.URL).email(this.Email)));
	}
}