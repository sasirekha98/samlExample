/*
 * Copyright 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.spring.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import java.util.*;
import org.springframework.security.saml2.provider.service.authentication.Saml2AuthenticatedPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping("/")
	public String index(Model model, @AuthenticationPrincipal Saml2AuthenticatedPrincipal principal) {
		if(principal!=null) {
			model.addAttribute("userAttributes", principal.getAttributes());
			String emailAddress = (String)principal.getAttributes().get("http://schemas.xmlsoap.org/ws/2005/05/identity/claims/upn").get(0);
			model.addAttribute("emailAddress", emailAddress);
		}
		else {
			Map<String, List<Object>> map = new HashMap<String,List<Object>>();
			map.put("user", List.of("No user logged in"));
			model.addAttribute("emailAddress", "");
			model.addAttribute("userAttributes", "");
		}
		return "index";
	}

}
