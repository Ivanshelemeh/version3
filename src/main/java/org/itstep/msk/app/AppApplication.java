package org.itstep.msk.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories("org.itstep.msk.app.repository")
public class AppApplication {
	public static void main(String[] args)  {
		SpringApplication.run(AppApplication.class, args);
	}
}
