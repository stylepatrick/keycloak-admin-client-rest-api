package com.stylepatrick.keycloakAdminClientRestApi.resource.api;

import com.stylepatrick.keycloakAdminClientRestApi.service.KeycloakAdminApiService;
import lombok.AllArgsConstructor;
import org.keycloak.representations.idm.GroupRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@ApiRestController
@AllArgsConstructor
public class KeycloakAdminApiResource {

    private final KeycloakAdminApiService keycloakAdminApiService;

    @GetMapping(value = "keycloak/admin/users")
    public List<UserRepresentation> getUsers(
            @RequestParam(required = false) String search
    ) {
        if (search != null) {
            return keycloakAdminApiService.searchUser(search);
        } else {
            return keycloakAdminApiService.getUsers();
        }
    }

    @GetMapping(value = "keycloak/admin/users/{userId}")
    public UserRepresentation getUser(
            @PathVariable(name = "userId") String userId
    ) {
        return keycloakAdminApiService.getUser(userId);
    }

    @GetMapping(value = "keycloak/admin/users/{userId}/groups")
    public Map<String, String> getUserGroups(
            @PathVariable(name = "userId") String userId
    ) {
        return keycloakAdminApiService.getUserGroups(userId);
    }

    @GetMapping(value = "keycloak/admin/groups")
    public List<GroupRepresentation> getGroups(
    ) {
        return keycloakAdminApiService.getGroups();
    }

    @PutMapping(value = "keycloak/admin/users/{userId}/groups/{groupId}")
    public ResponseEntity addGroupToUser(
            @PathVariable(name = "userId") String userId,
            @PathVariable(name = "groupId") String groupId
    ) {
        keycloakAdminApiService.addGroupToUser(userId, groupId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "keycloak/admin/users/{userId}/groups/{groupId}")
    public ResponseEntity removeGroupFromUser(
            @PathVariable(name = "userId") String userId,
            @PathVariable(name = "groupId") String groupId
    ) {
        keycloakAdminApiService.removeGroupfromUser(userId, groupId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "keycloak/admin/users/{userId}/attributes/site/{siteId}/application/{appId}")
    public ResponseEntity addUserAttributeSiteToApp(
            @PathVariable(name = "userId") String userId,
            @PathVariable(name = "siteId") String siteId,
            @PathVariable(name = "appId") String appId
    ) {
        keycloakAdminApiService.addUserAttributeSiteToApp(userId, siteId, appId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "keycloak/admin/users/{userId}/attributes/site/{siteId}/application/{appId}")
    public ResponseEntity removeUserAttributeSiteFromApp(
            @PathVariable(name = "userId") String userId,
            @PathVariable(name = "siteId") String siteId,
            @PathVariable(name = "appId") String appId
    ) {
        keycloakAdminApiService.removeUserAttributeSiteFromApp(userId, siteId, appId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "keycloak/admin/roles")
    public List<RoleRepresentation> getRoles(
    ) {
        return keycloakAdminApiService.getRoles();
    }

    @PutMapping(value = "keycloak/admin/users/{userId}/roles/{roleName}")
    public ResponseEntity addRoleToUser(
            @PathVariable(name = "userId") String userId,
            @PathVariable(name = "roleName") String roleName
    ) {
        keycloakAdminApiService.addRoleToUser(userId, roleName);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "keycloak/admin/users/{userId}/roles/{roleName}")
    public ResponseEntity removeRoleFromUser(
            @PathVariable(name = "userId") String userId,
            @PathVariable(name = "roleName") String roleName
    ) {
        keycloakAdminApiService.removeRoleFromUser(userId, roleName);
        return ResponseEntity.noContent().build();
    }
}
