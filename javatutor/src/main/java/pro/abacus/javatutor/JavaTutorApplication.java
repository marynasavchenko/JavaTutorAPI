package pro.abacus.javatutor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication 
public class JavaTutorApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(JavaTutorApplication.class);
	}

    /**
     * Main method, used to run the application.
     *
     * @param args the command line arguments
     */
	public static void main(String[] args) {
		SpringApplication.run(JavaTutorApplication.class, args);
	}

}