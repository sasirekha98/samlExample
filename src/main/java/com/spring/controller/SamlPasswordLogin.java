package com.spring.controller;


import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.saml2.provider.service.authentication.Saml2AuthenticatedPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SamlPasswordLogin {
    
	@GetMapping("/samlPasswordLogin")
	private String run(@AuthenticationPrincipal Saml2AuthenticatedPrincipal principal) {
		StringBuilder builder = new StringBuilder();
		Map<String, List<Object>> attributes = principal.getAttributes();
		attributes.forEach((key, values) -> 
		    builder.append(key).append(" -> ").append(values).append("; ")
		);
		return builder.toString();
	}

}
