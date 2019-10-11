package br.com.machadowelton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringbootJpaGraphqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaGraphqlApplication.class, args);
	}

}
