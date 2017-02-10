package com.tistory.heowc.auth.jwt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class JwtSecurityHandler implements AuthenticationSuccessHandler, AuthenticationFailureHandler {

//	@Autowired
//	JwtFactory JwtFactory;
//	
//	@Autowired ObjectMapper objectMapper;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		System.out.println("success");
//		Member member = (Member)((AjaxAuthenticationToken)authentication).getPrincipal();
//		String jsonToMember = objectMapper.writeValueAsString(member);
//		response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
//		response.setHeader(JwtInfo.HEADER_NAME, JwtFactory.createToken(jsonToMember));
	}
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {
		System.out.println("success");
		throw new IllegalStateException(exception.getMessage());
	}
}
