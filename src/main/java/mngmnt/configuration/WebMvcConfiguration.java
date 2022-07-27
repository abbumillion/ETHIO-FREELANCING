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
		//-----------------landing page-----------------------------------------------------------------------------//
		registry.addViewController("/").setViewName("index");
		//-----------------login page--------------------------------------------------------------------------------//
		registry.addViewController("/login").setViewName("login");
		//-----------------freelancer home page----------------------------------------------------------------------//
		registry.addViewController("/freelancerhome").setViewName("freelancerhome");
		//-----------------customer home page------------------------------------------------------------------------//
		registry.addViewController("/customerhome").setViewName("customerhome");
		//-----------------about page--------------------------------------------------------------------------------//
		registry.addViewController("/about").setViewName("about");
		//-----------------contact us page---------------------------------------------------------------------------//
		registry.addViewController("/contactus").setViewName("contactus");
		//-----------------profile page------------------------------------------------------------------------------//
		registry.addViewController("/profile").setViewName("profile");
		//-----------------jobs page---------------------------------------------------------------------------------//
		registry.addViewController("/jobs").setViewName("jobs");
		//-----------------job page---------------------------------------------------------------------------------//
		registry.addViewController("/job").setViewName("job");
		//-----------------jobs page---------------------------------------------------------------------------------//
		registry.addViewController("/freelancer").setViewName("freelancer");
		//-----------------jobs page---------------------------------------------------------------------------------//
		registry.addViewController("/customer").setViewName("customer");
		//-----------------job applications page---------------------------------------------------------------------//
		registry.addViewController("/jobapplications").setViewName("jobapplications");
		//---------------- my jobs page------------------------------------------------------------------------------//
		registry.addViewController("/myjobs").setViewName("myjobs");
		//----------------feedbacks page-----------------------------------------------------------------------------//
		registry.addViewController("/feedbacks").setViewName("feedbacks");
		//---------------sign up page--------------------------------------------------------------------------------//
		registry.addViewController("/signup").setViewName("create-user");
		//----------------logout page--------------------------------------------------------------------------------//
		registry.addViewController("/logout").setViewName("logout");
		//----------------post job-----------------------------------------------------------------------------------//
		registry.addViewController("/jobform").setViewName("jobform");
        //registry.addViewController("/login").setViewName("login");
		//----------------------------------------------------------------------------------------------------------//
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//------------------------------------------------------------------------------------------------------------//
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		//-----------------------------------------------------------------------------------------------------------//
	}

	@Bean
	public InternalResourceViewResolver viewResolver() {
		/**
		 * adding suffix and prefix of the view location
		 * for View Resolver
		 */
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/view/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

}
