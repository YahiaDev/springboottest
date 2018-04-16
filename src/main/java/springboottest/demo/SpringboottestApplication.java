package springboottest.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableJpaRepositories("springboottest.demo.repository")
@EntityScan("springboottest.demo.model")
@ComponentScan({ "springboottest.demo.controller", "springboottest.demo.service" })
@RestController
public class SpringboottestApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringboottestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

	}

}
