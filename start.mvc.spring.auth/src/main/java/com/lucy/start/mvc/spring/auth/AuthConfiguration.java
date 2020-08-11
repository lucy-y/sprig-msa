package com.lucy.start.mvc.spring.auth;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

@Configuration
@EnableAuthorizationServer
@SpringBootApplication
public class AuthConfiguration extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private ClientDetailsService clientDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private ResourceServerProperties resourceServerProperties;
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		// ���� ���� endpoint�� ���� ������ ���ݴϴ�. 
		super.configure(endpoints);
		endpoints.accessTokenConverter(jwtAccessTokenConverter()).authenticationManager(authenticationManager);
	}
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		// oauth_client_details ���̺��� ��ϵ� ����ڷ� ��ȸ�մϴ�.
		clients.withClientDetails(clientDetailsService);
	}

	@Bean
	@Primary
	public JdbcClientDetailsService JdbcClientDetailsService(DataSource dataSource) {
    	// Jdbc(H2 �����ͺ��̽�)�� �̿��� Oauth client ��������� ���� �����Դϴ�.
		return new JdbcClientDetailsService(dataSource);
	}
	
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
    	// JWT key-value ����� ����ϱ� ���� �����Դϴ�.
        JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
        accessTokenConverter.setSigningKey(resourceServerProperties.getJwt().getKeyValue());
       
        return accessTokenConverter;
    }
	
}