package mngmnt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
/**************************************************************************************
 * ETHIO-FREELANCING APPLICATION
 * AUTHORS
 * MILLION SHARBE
 * THOMAS FASIL
 * YORDANOS DAMTEW
 * Created Date: 22 jun, 2022
 * Version     : v1.0.0
 *************************************************************************************/
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
