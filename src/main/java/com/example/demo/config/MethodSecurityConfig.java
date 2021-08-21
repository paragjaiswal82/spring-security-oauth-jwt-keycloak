package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableGlobalMethodSecurity(
  prePostEnabled = true, 
  securedEnabled = true, 
  jsr250Enabled = true)
public class MethodSecurityConfig 
  extends GlobalMethodSecurityConfiguration {
	
	/*@Autowired
	@Qualifier("oauth2authSuucessHandler")
	private AuthenticationSuccessHandler oauth2authSuucessHandler;*/
	
	/*@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/","/myapp/login").permitAll()
		.anyRequest().authenticated().and().csrf().disable()
		//.formLogin().loginPage("/login").defaultSuccessUrl("/success")
		.oauth2Login().successHandler(oauth2authSuucessHandler);
		
	}*/
}
