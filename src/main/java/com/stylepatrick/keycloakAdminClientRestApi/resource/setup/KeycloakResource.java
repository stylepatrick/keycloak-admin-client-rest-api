package com.stylepatrick.keycloakAdminClientRestApi.resource.setup;

import com.stylepatrick.keycloakAdminClientRestApi.config.AppConfig;
import org.springframework.web.bind.annotation.GetMapping;

@SetupRestController
public class KeycloakResource {

    private final AppConfig appConfig;

    public KeycloakResource(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    @GetMapping("/keycloak")
    public KeycloakConfigDto getConfig() {
        return new KeycloakConfigDto(
                appConfig.getUrl(),
                appConfig.getClientId(),
                appConfig.getRealm()
        );
    }

}
