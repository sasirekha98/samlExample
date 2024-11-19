package example.spring.saml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.spring")
public class SamlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SamlApplication.class, args);
	}

}
