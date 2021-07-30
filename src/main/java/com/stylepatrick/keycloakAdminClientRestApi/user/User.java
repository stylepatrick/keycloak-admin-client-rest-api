package com.stylepatrick.keycloakAdminClientRestApi.user;

import lombok.*;

import java.util.List;

@Getter
@Setter(AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User {

    private String login;
    private List<String> roles;

}
