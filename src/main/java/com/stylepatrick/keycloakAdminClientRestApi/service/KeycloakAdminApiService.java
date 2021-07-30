package com.stylepatrick.keycloakAdminClientRestApi.service;

import com.stylepatrick.keycloakAdminClientRestApi.config.AppConfig;
import lombok.AllArgsConstructor;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.RoleResource;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.representations.idm.GroupRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class KeycloakAdminApiService {

    private final Keycloak keycloak;
    private final AppConfig appConfig;

    public List<UserRepresentation> getUsers() {
        return keycloak.realm(appConfig.getKeycloakAdminApiRealm()).users().list();
    }

    public List<UserRepresentation> searchUser(String search) {
        return keycloak.realm(appConfig.getKeycloakAdminApiRealm()).users().search(search);
    }

    public UserRepresentation getUser(String userId) {
        return keycloak.realm(appConfig.getKeycloakAdminApiRealm()).users().get(userId).toRepresentation();
    }

    public Map<String, String> getUserGroups(String userId) {
        UserResource userResource = keycloak.realm(appConfig.getKeycloakAdminApiRealm()).users().get(userId);
        Map<String, String> existingGroups = new HashMap<>();
        userResource.groups().forEach(groupRepresentation -> existingGroups.put(groupRepresentation.getId(), groupRepresentation.getName()));
        return existingGroups;
    }

    public void addGroupToUser(String userId, String groupId) {
        UserResource userResource = keycloak.realm(appConfig.getKeycloakAdminApiRealm()).users().get(userId);
        userResource.joinGroup(groupId);
    }

    public void removeGroupfromUser(String userId, String groupId) {
        UserResource userResource = keycloak.realm(appConfig.getKeycloakAdminApiRealm()).users().get(userId);
        userResource.leaveGroup(groupId);
    }

    public void addUserAttributeSiteToApp(String userId, String siteId, String appId) {
        UserResource userResource = keycloak.realm(appConfig.getKeycloakAdminApiRealm()).users().get(userId);
        UserRepresentation userRepresentation = userResource.toRepresentation();
        Map<String, List<String>> map = userRepresentation.getAttributes();
        List<String> list = new ArrayList<>();
        if (map.containsKey(appId)) {
            list = map.get(appId);
            if (!list.contains(siteId)) {
                list.add(siteId);
            }
        } else {
            list.add(siteId);
        }
        map.put(appId, list);
        userRepresentation.setAttributes(map);
        userResource.update(userRepresentation);
    }

    public void removeUserAttributeSiteFromApp(String userId, String siteId, String appId) {
        UserResource userResource = keycloak.realm(appConfig.getKeycloakAdminApiRealm()).users().get(userId);
        UserRepresentation userRepresentation = userResource.toRepresentation();
        Map<String, List<String>> map = userRepresentation.getAttributes();
        List<String> list = new ArrayList<>();
        if (map.containsKey(appId)) {
            list = map.get(appId);
            if (list.contains(siteId)) {
                list.remove(siteId);
            }
        }
        map.put(appId, list);
        userRepresentation.setAttributes(map);
        userResource.update(userRepresentation);
    }

    public List<GroupRepresentation> getGroups() {
        return keycloak.realm(appConfig.getKeycloakAdminApiRealm()).groups().groups();
    }

    public List<RoleRepresentation> getRoles() {
        return keycloak.realm(appConfig.getKeycloakAdminApiRealm()).roles().list();
    }

    public void addRoleToUser(String userId, String roleName) {
        RoleResource roleResource = keycloak.realm(appConfig.getKeycloakAdminApiRealm()).roles().get(roleName);
        List<RoleRepresentation> roleToAdd = new LinkedList<>();
        roleToAdd.add(roleResource.toRepresentation());
        keycloak.realm(appConfig.getKeycloakAdminApiRealm()).users().get(userId).roles().realmLevel().add(roleToAdd);
    }

    public void removeRoleFromUser(String userId, String roleName) {
        RoleResource roleResource = keycloak.realm(appConfig.getKeycloakAdminApiRealm()).roles().get(roleName);
        List<RoleRepresentation> roleToRemove = new LinkedList<>();
        roleToRemove.add(roleResource.toRepresentation());
        keycloak.realm(appConfig.getKeycloakAdminApiRealm()).users().get(userId).roles().realmLevel().remove(roleToRemove);
    }

}
