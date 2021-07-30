package com.stylepatrick.keycloakAdminClientRestApi.resource.api;

import lombok.*;

@Getter
@Setter(AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class AppProperties {

    private String version;
    private String environment;

}
