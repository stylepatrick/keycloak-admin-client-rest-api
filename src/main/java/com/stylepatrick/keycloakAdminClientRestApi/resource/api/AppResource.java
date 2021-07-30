package com.stylepatrick.keycloakAdminClientRestApi.resource.api;

import com.stylepatrick.keycloakAdminClientRestApi.config.AppConfig;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

@ApiRestController
@AllArgsConstructor
public class AppResource {

    private final AppConfig appConfig;

    @GetMapping(value = "properties")
    public AppProperties properties() {
        return new AppProperties(
                appConfig.getVersion(),
                appConfig.getEnvironment()
        );
    }

}
