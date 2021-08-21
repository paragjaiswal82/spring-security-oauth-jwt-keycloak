package com.example.demo.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping("/hello")
	@PreAuthorize("hasScope('read')")
    public String helloSecured() {
        return "Hello - Secured";
    }
	
	
	@GetMapping("/token")
    public Map<String, Jwt> getToken(@AuthenticationPrincipal Jwt jwt) {
        return Collections.singletonMap("Principal", jwt);
    }
	
}
