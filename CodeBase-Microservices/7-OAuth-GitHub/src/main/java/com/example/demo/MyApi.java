package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyApi {
	@GetMapping("/hello")
	public String test() {
		return "Success ";
	}
	
	@Autowired
	private OAuth2AuthorizedClientService clientService;

	//To get the access Token
	@GetMapping("/token")
	public String getToken(@AuthenticationPrincipal OAuth2User user) {

	    OAuth2AuthorizedClient client =
	            clientService.loadAuthorizedClient("github", user.getName());

	    return client.getAccessToken().getTokenValue();
	}
}
