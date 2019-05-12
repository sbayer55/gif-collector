package com.tesseractus.gifcollector.config;

import com.tesseractus.gifcollector.service.TesseractusUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    private static final String CLIENT_ID = "admin";
    private static final String CLIENT_SECRET = "password";

    private TokenStore tokenStore;
    private UserApprovalHandler userApprovalHandler;
    private AuthenticationManager authenticationManager;
    private TesseractusUserDetailsService userDetailsService;

    @Autowired
    public AuthorizationServerConfig(TokenStore tokenStore,
                                     UserApprovalHandler userApprovalHandler,
                                     @Qualifier("authenticationManagerBean") AuthenticationManager authenticationManager,
                                     TesseractusUserDetailsService userDetailsService) {
        this.tokenStore = tokenStore;
        this.userApprovalHandler = userApprovalHandler;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {
        configurer.inMemory()
                .withClient(CLIENT_ID)
                .secret(CLIENT_SECRET)
                .authorizedGrantTypes("password", "refresh_token")
                .authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
                .scopes("read", "write", "trust")
                .accessTokenValiditySeconds(300)
                .refreshTokenValiditySeconds(2592000);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer configurer) {
        configurer.tokenStore(tokenStore)
                .userApprovalHandler(userApprovalHandler)
                .authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer configurer) {
        configurer.realm("CRM_REALM");
    }
}
