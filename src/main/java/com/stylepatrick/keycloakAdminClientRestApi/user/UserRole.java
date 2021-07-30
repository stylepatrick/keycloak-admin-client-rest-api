package com.stylepatrick.keycloakAdminClientRestApi.user;

import java.util.Arrays;

public enum UserRole {

    OPERATOR("APP_OPERATOR");

    private final String value;

    UserRole(String value) {
        this.value = value;
    }

    public static boolean isValidRole(String s) {
        return Arrays.stream(UserRole.values())
                .anyMatch(r -> r.value.equals(s));
    }

}
