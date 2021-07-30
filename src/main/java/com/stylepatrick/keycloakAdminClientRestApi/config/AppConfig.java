package com.stylepatrick.keycloakAdminClientRestApi.config;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter(AccessLevel.PROTECTED)
public class AppConfig {

    public final static String SITE_PARAM = "site";

    @Value("${app.version}")
    private String version;

    @Value("${app.environment}")
    private String environment;

    @Value("${keycloakAdminApi.realm}")
    private String keycloakAdminApiRealm;

    @Value("${keycloakAdminApi.resource}")
    private String keycloakAdminApiResource;

    @Value("${keycloakAdminApi.auth-server-url}")
    private String keycloakAdminUrl;

    @Value("${keycloakAdminApi.username}")
    private String keycloakAdminApiUsername;

    @Value("${keycloakAdminApi.password}")
    private String keycloakAdminApiPassword;

    @Value("${keycloakAdminApi.secret}")
    private String keycloakAdminApiSecret;

    @Value("${keycloak.realm}")
    private String realm;

    @Value("${keycloak.auth-server-url}")
    private String url;

    @Value("${keycloak.resource}")
    private String clientId;

}
