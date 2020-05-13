package com.employeesecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	
	@Value("${oAuth.client_id}")
	private String Client_id;
	
	@Value("${oAuth.client_secret}")
	private String Client_secret;
	
	@Value("${oAuth.grant_type_password}")
	private String Grant_Type_Password;
	
	@Value("${oAuth.authorization_code}")
	private String Authorization_code;
	
	@Value("${oAuth.refresh_token}")
	private String Refresh_Token;
	
	@Value("${oAuth.implicit}")
	private String Implicit;
	
	@Value("${oAuth.scope_read}")
	private String Scope_Read;
	
	@Value("${oAuth.scope_write}")
	private String scope_write;
	
	@Value("${oAuth.trust}")
	private String trust;
	
	@Value("${oAuth.access.token.validity.seconds}")
	public int Access_Token_Valid_Seconds;
	
	@Value("${oAuth.refresh.token.validity.seconds}")
	public int Refresh_Token_Valid_Seconds;
	
	
	@Autowired
	private TokenStore tokenStore;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {
		
		configurer
				.inMemory()
				.withClient(Client_id)
				.secret(Client_secret)
				.authorizedGrantTypes(Grant_Type_Password, Authorization_code, Refresh_Token, Implicit )
				.scopes(Scope_Read, scope_write, trust)
				.accessTokenValiditySeconds(Access_Token_Valid_Seconds).
				refreshTokenValiditySeconds(Refresh_Token_Valid_Seconds);
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(tokenStore)
				.authenticationManager(authenticationManager);
	}
}