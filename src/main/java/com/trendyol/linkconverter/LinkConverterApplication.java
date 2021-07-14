package com.trendyol.linkconverter;

import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(value = ("com.trendyol.linkconverter.data.repository"))
@OpenAPIDefinition(info = @Info(title = "Link Converter API", version = "1.0", description = "Convert Links between platforms"))
public class LinkConverterApplication {

	public static void main(String[] args) {
		SpringApplication.run(LinkConverterApplication.class, args);
	}

}
