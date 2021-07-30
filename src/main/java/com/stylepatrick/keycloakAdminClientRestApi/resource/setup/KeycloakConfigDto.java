package com.stylepatrick.keycloakAdminClientRestApi.resource.setup;

import lombok.*;

@Getter
@Setter(AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class KeycloakConfigDto {

    private String url;
    private String clientId;
    private String realm;

}
