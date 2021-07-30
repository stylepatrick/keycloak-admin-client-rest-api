package com.stylepatrick.keycloakAdminClientRestApi.user;

import lombok.AllArgsConstructor;
import org.keycloak.representations.AccessToken;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    private final AccessToken accessToken;

    public User getCurrentUser() {
        List<String> roles = accessToken.getRealmAccess().getRoles().stream()
                .filter(UserRole::isValidRole).collect(Collectors.toList());
        return new User(accessToken.getPreferredUsername(), roles);
    }

}
