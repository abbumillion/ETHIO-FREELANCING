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
public class EFASecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * Author Million Sharbe
     * Application security with spring security core
     * Securing all rest end points with and  roles
     * date july 13 , 2022
     */
    public final UserServiceImpl userDetailsService;
    public final PasswordEncoder passwordEncoder;

    /**
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                /**
                 * permit all those end point for everyone
                 */
                .authorizeRequests()
                .antMatchers("/console/**", "/", "/signup","/register", "/about","/resources/**").permitAll()
                /**
                 * those end points should be authenticated
                 * not accessable without login
                 */
                .antMatchers("/customer/home","customer/freelancers", "/customer/myjobs", "/customer/jobapplication","/customer/postjob",
                        "/freelancer/home","/freelancer/skills","/freelancer/jobs","freelancer/jobapplications",
                         "/profile","/contactus").authenticated()
                /**
                 * authority's  for all rest end points
                 */

                /**
                 * customer authority's
                 */
//                .antMatchers("/customer/home/**","/customer/postjob").hasAuthority(ROLE.CUSTOMER.name())
//                /**
//                 * freelancer authority's
//                 */
//                .antMatchers("/freelancer/home/**","/freelancer/jobs/**").hasAuthority(ROLE.FREELANCER.name())
//                /**
//                 * admin authority's
//                 */
                .antMatchers("/getAllUser/**", "/removeAll/**").hasAuthority(ROLE.ADMIN.name())
                .antMatchers("/getAllUser/**", "/removeAll/**").hasAuthority(ROLE.ADMIN.name())
                .antMatchers("/removeAll/**", "/addNewUser/**", "/save/**", "/delete/**", "/page/**").hasAuthority(ROLE.ADMIN.name())
                .anyRequest().permitAll()
                .and()
                /**
                 * login page url
                 */
                .formLogin().loginPage("/login")
                /**
//                 * default success page for customer
//                 */
//                .defaultSuccessUrl("/customer/home")
//                /**
//                 * default success page for freelancer
//                 */
//                .defaultSuccessUrl("/freelancer/home")
                /**
                 * login parameter email
                 */
                .usernameParameter("email")
                /**
                 * login parameter password
                 */
                .passwordParameter("password")
                .and()
                /**
                 * logout success page for all users
                 */
                .logout().logoutSuccessUrl("/login")
                .and()
                /**
                 * access denied page
                 */
                .exceptionHandling().accessDeniedPage("/403")
                .and()
                /**
                 * cross site request forgery
                 */
                .csrf();
        /**
         * session management
         */
        http.sessionManagement()
                /**
                 * max session time period
                 */
                .maximumSessions(1)
                /**
                 * max session time period prevents login
                 */
                .maxSessionsPreventsLogin(true)
                /**
                 * expired url
                 */
                .expiredUrl("/login?error=You are already logged in from somewhere");
    }

    /**
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /**
         *  configuring authentication manager with dao Authentication Provider
         */
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    /**
     *
     * DaoAuthenticationProvider with userDetailsService and
     *  Password Encoder
     * @return
     */
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider =
                new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder.bCryptPasswordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        return daoAuthenticationProvider;
    }

    /**
     * Servlet Session Bean
     * @return
     */
    @Bean
    public ServletListenerRegistrationBean<HttpSessionEventPublisher> httpSessionEventPublisher() {
        return new ServletListenerRegistrationBean<HttpSessionEventPublisher>(new HttpSessionEventPublisher());
    }
    /**
     * exclude this end points from any access
     * @param web
     * @throws EthioFreelancingApplication
     */
    @Override
    public void configure(WebSecurity web) throws EthioFreelancingApplication {
        web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }

}
