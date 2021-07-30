package com.stylepatrick.keycloakAdminClientRestApi.resource.api;

import com.stylepatrick.keycloakAdminClientRestApi.user.User;
import com.stylepatrick.keycloakAdminClientRestApi.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

@ApiRestController
@AllArgsConstructor
public class UserResource {

    private final UserService userService;

    @GetMapping("user")
    public User getUser() {
        return userService.getCurrentUser();
    }

}
