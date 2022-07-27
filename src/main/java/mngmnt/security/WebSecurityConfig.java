package mngmnt.security;

import lombok.AllArgsConstructor;
import mngmnt.ServiceImp.UserServiceImpl;
import mngmnt.exception.EthioFreelancingApplication;
import mngmnt.helpers.ROLE;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.session.HttpSessionEventPublisher;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserServiceImpl userDetailsService;
    private final PasswordEncoder passwordEncoder;
//    @Override
//    public void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
//                .csrf().disable()
//                .authorizeRequests().antMatchers("/register/**").permitAll()
//                .anyRequest().authenticated().and()
//                .formLogin();
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /**
         * Author Million Sharbe
         * Securing all rest end points with and  roles
         * date july 13 , 2022
         */
        http
                .authorizeRequests()
                .antMatchers("/console/**", "/", "/signup","/register", "/about","/login").permitAll()
                .antMatchers("/jobs", "/myjobs", "/jobapplication", "/home", "/postjob", "/profile","/contactus").authenticated()
                .antMatchers("/customerhome/**", "/freelancers/**","/postjob/**").hasAuthority(ROLE.CUSTOMER.name())
                .antMatchers("/freelancerhome/**", "/customers/**","/job/**").hasAuthority(ROLE.FREELANCER.name())
                .antMatchers("/getAllUser/**", "/removeAll/**").hasAuthority(ROLE.ADMIN.name())
                .antMatchers("/getAllUser/**", "/removeAll/**").hasAuthority(ROLE.ADMIN.name())
                .antMatchers("/removeAll/**", "/addNewUser/**", "/save/**", "/delete/**", "/page/**").hasAuthority(ROLE.ADMIN.name())
                .anyRequest().permitAll()
                .and()
                .formLogin().loginPage("/login")
                .defaultSuccessUrl("/home")
                .usernameParameter("email")
                .passwordParameter("password")
                .and()
                .logout().logoutSuccessUrl("/login")
                .and()
                .exceptionHandling().accessDeniedPage("/403")
                .and()
                .csrf().disable();
        http.sessionManagement()
                .maximumSessions(1)
                .maxSessionsPreventsLogin(true)
                .expiredUrl("/login?error=You are already logged in from somewhere");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /**
         *  configuring authentication manager with dao Authentication Provider
         */
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        /**
         * DaoAuthenticationProvider with userDetailsService and
         * Password Encoder
         */
        DaoAuthenticationProvider daoAuthenticationProvider =
                new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder.bCryptPasswordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        return daoAuthenticationProvider;
    }

    @Bean
    public ServletListenerRegistrationBean<HttpSessionEventPublisher> httpSessionEventPublisher() {
        /**
         * Servlet Session Bean
         */
        return new ServletListenerRegistrationBean<HttpSessionEventPublisher>(new HttpSessionEventPublisher());
    }

    @Override
    public void configure(WebSecurity web) throws EthioFreelancingApplication {
        /**
         * exclude this end points from any access
         */
        web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }

}
