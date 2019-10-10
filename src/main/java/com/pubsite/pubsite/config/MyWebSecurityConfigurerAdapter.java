package com.pubsite.pubsite.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MyWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }

    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return super.userDetailsService();
    }

    @Bean
    public AuthenticationSuccessHandler successHandler() {
        MyAuthenticationSuccessHandler handler = new MyAuthenticationSuccessHandler();
        return handler;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers("/admin/**").hasAuthority("admin")
                .antMatchers("/author/**").hasAuthority("author")
                .antMatchers("/standard/**").hasAuthority("standard")
                .antMatchers("/profile/**").hasAnyAuthority("admin", "author", "standard")
                .antMatchers("/**").anonymous()
                .anyRequest().fullyAuthenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .successHandler(successHandler())
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .rememberMe()
                .tokenValiditySeconds(1209600)
                .rememberMeCookieName("pub_account_password")
                .userDetailsService(userDetailsService)
                .and()
                .csrf().disable()
        ;

    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery("SELECT username, password, enabled FROM user WHERE username=?")
//                .authoritiesByUsernameQuery("SELECT u.username, ur.roles FROM user u INNER JOIN user_role ur ON u.user_id = ur.user_id WHERE u.username=?");
//    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

}
