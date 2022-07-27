package mngmnt.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

	/**
	 *
	 * @param registry
	 * view registration methods
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/freelancer/home").setViewName("freelancerhome");
		registry.addViewController("/customer/home").setViewName("customerhome");
		registry.addViewController("/about").setViewName("about");
		registry.addViewController("/contactus").setViewName("contactus");
		registry.addViewController("/profile").setViewName("profile");
		registry.addViewController("/jobs").setViewName("jobs");
		registry.addViewController("/job").setViewName("job");
		registry.addViewController("/freelancer").setViewName("freelancer");
		registry.addViewController("/freelancer/myjobapplications").setViewName("myjobapplications");
		registry.addViewController("/customer").setViewName("customer");
		registry.addViewController("/customer/jobapplications").setViewName("jobapplications");
		registry.addViewController("/customer/myjobs").setViewName("myjobs");
		registry.addViewController("/feedbacks").setViewName("feedbacks");
		registry.addViewController("/signup").setViewName("create-user");
		registry.addViewController("/logout").setViewName("logout");
		registry.addViewController("/jobform").setViewName("jobform");
	}

	/**
	 *
	 * @param registry
	 * excluding all resources from access
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	/**
	 * adding suffix and prefix of the view location
	 * for View Resolver
	 * @return
	 */
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/view/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

}
