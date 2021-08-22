package com.example.demo.config;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;

@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@EnableWebSecurity
public class SecurityConfiguration 
  extends WebSecurityConfigurerAdapter {
	
	/*@Autowired
	@Qualifier("oauth2authSuucessHandler")
	private AuthenticationSuccessHandler oauth2authSuucessHandler;*/
	
	JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
		
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new AccessRolesConverter());
		
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/hello").
		//hasAuthority("SCOPE_profile").
		//hasRole("user").
		hasAuthority("ROLE_developer").
		anyRequest().authenticated().
		and().
		oauth2ResourceServer().jwt()
		.jwtAuthenticationConverter(jwtAuthenticationConverter);
		
	}
}
