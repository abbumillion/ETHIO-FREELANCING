package mngmnt.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		//landing page
		registry.addViewController("/").setViewName("index");
		//login page
		registry.addViewController("/login").setViewName("login");
		//home page
		registry.addViewController("/home").setViewName("home");
		//about page
		registry.addViewController("/about").setViewName("about");
		//contact us page
		registry.addViewController("/contactus").setViewName("contactus");
		//profile page
		registry.addViewController("/profile").setViewName("profile");
		//jobs page
		registry.addViewController("/jobs").setViewName("jobs");
		//job applications page
		registry.addViewController("/jobapplications").setViewName("jobapplications");
		// my jobs page
		registry.addViewController("/myjobs").setViewName("myjobs");
		//feedbacks page
		registry.addViewController("/feedbacks").setViewName("feedbacks");
		//sign up page
		registry.addViewController("/signup").setViewName("create-user");
		//logout page
		registry.addViewController("/logout").setViewName("logout");
		//post job
		registry.addViewController("/jobform").setViewName("jobform");
        //registry.addViewController("/login").setViewName("login");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/view/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

}
