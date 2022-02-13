package no.ntnu.crudrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@SpringBootApplication (exclude = DataSourceAutoConfiguration.class)
public class CrudrestApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudrestApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("no.ntnu.crudrest"))
				.build()
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails(){
		return new ApiInfo(
				"Adress book API",
				"Sample API for jvaBrains Turtorial",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Håkon", "http://javabrains.io", "123@.com"),
				"API License",
				"http://javabrains.io",
				Collections.emptyList());
	}

}
