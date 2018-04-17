package pro.abacuspro.javatutor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication 
public class JavaTutorApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(JavaTutorApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(JavaTutorApplication.class, args);
	}

}