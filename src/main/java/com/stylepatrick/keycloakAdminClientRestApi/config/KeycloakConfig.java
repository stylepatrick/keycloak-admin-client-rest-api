package com.stylepatrick.keycloakAdminClientRestApi.config;

import lombok.AllArgsConstructor;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.OAuth2Constants;
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class KeycloakConfig {

    private final AppConfig appConfig;

    @Bean
    public KeycloakSpringBootConfigResolver keycloakConfigResolver() {
        return new KeycloakSpringBootConfigResolver();
    }

    @Bean
    public Keycloak generateKeycloakClient() {
        return KeycloakBuilder.builder()
                .serverUrl(appConfig.getKeycloakAdminUrl())
                .grantType(OAuth2Constants.PASSWORD)
                .realm(appConfig.getKeycloakAdminApiRealm())
                .clientId(appConfig.getKeycloakAdminApiResource())
                .username(appConfig.getKeycloakAdminApiUsername())
                .password(appConfig.getKeycloakAdminApiPassword())
                .clientSecret(appConfig.getKeycloakAdminApiSecret())
                .resteasyClient(
                        new ResteasyClientBuilder()
                                .connectionPoolSize(10).build()
                ).build();
    }

}