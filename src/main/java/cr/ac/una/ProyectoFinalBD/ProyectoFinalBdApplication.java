package cr.ac.una.ProyectoFinalBD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "cr.ac.una.ProyectoFinalBD.jpa")
@ComponentScan(basePackages = {"cr.ac.una.ProyectoFinalBD"})
public class ProyectoFinalBdApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoFinalBdApplication.class, args);
	}

}
