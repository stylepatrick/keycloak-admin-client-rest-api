### Keycloak Admin Client
The goal of this backend is to provide a API where you can login with the Keycloak Account (OAuth2/OIDC) to manager users which are present in the Keycloak-Realm without having the manage-user role.
The user which login doesnt need the manage-user privilege because the backend use a own user to make the changes on Keycloak (this special user has the mange-user privilege).

![Alt text](pictures/keycloak-admin-client-concept.png?raw=true)

### Setup:
Two clients are needed in Keycloak.
One for the application itself (user logins; Access Type: public) and an other client for the access to manage the users (Access Type should be confidential to provide more secure).
The APP_OPERATOR role is needed for the login to the application. It needs to get assigned to the user via the Role-Mapping Tab.

#CLIENTS
![Alt text](pictures/api-client.png?raw=true)

![Alt text](pictures/app-client.png?raw=true)

#ROLES
![Alt text](pictures/app-operator-role.png?raw=true)

#USERS
![Alt text](pictures/api-user.png?raw=true)

![Alt text](pictures/app-user.png?raw=true)

### REST Keycloak API:

GET: keycloak/admin/users (Optional with /?search param)
GET: keycloak/admin/users/{userId}
GET: keycloak/admin/users/{userId}/groups
GET: keycloak/admin/groups
PUT: keycloak/admin/users/{userId}/groups/{groupId}
DELETE: keycloak/admin/users/{userId}/groups/{groupId}
PUT: keycloak/admin/users/{userId}/attributes/site/{siteId}/application/{appId}
DELETE: keycloak/admin/users/{userId}/attributes/site/{siteId}/application/{appId}
GET: keycloak/admin/roles
PUT: keycloak/admin/users/{userId}/roles/{roleName}
DELETE:keycloak/admin/users/{userId}/roles/{roleName}

### How to use it with Postman:
Get the Access-Token from: http://localhost:8180/auth/realms/REALM/protocol/openid-connect/token

![Alt text](pictures/access-token-from-postman.png?raw=true)

Copy the Access-Token to the Header of the request:

![Alt text](pictures/get-users.png?raw=true)
