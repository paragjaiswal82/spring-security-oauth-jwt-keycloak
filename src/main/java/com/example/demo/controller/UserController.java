package com.example.demo.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;

@RestController
public class UserController {

	@GetMapping("/hello")
	//@PreAuthorize("hasScope('profile')")
	//@RolesAllowed({ "ROLE_VIEWER", "ROLE_EDITOR" })
	//@PreFilter("filterObject != authentication.principal.username")
	//@PostFilter("hasPermission(filterObject, 'read')")
    public String helloSecured() {
        return "Hello - Secured";
    }
	
	
	@GetMapping("/token")
    public Map<String, Jwt> getToken(@AuthenticationPrincipal Jwt jwt) {
        return Collections.singletonMap("Principal", jwt);
    }
	
	//@Secured("ROLE_developer")
	@PreAuthorize("hasRole('ROLE_user') or #id == #jwt.subject")
	@DeleteMapping("/users/{id}")
	public String getDeletedUser(@PathVariable String id, @AuthenticationPrincipal Jwt jwt) {
		return "Deleted user "+id+" and subject is - "+jwt.getSubject();
	}
	
	@PostAuthorize("returnObject.userId == #jwt.subject ")
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable String id, @AuthenticationPrincipal Jwt jwt) {
		return new User(id,"Parag");
		
	}
}
