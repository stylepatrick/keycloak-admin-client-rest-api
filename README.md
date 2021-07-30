## Keycloak Admin Client
The goal of this project is to provide an API to manager users which are present in the Keycloak-Realm without having the "manage-users" role.
The project should help to manage users externally without the Keycloak UI. Not all users are able to manage users only users which have special permissions (APP_OPERATOR).

The user which login doesnt need the "manage-users" privilege because the backend use a own user (api-user) to make the changes on Keycloak triggered from the API calls from the "normal" users which have the APP_OPERATOR role.
The special user "api-user" has the "mange-users" privilege.

![Alt text](pictures/keycloak-admin-client-concept.png?raw=true)

### Setup:
Two Keycloak clients are needed:
- app-client: for the application itself (Access Type: public). Users needs to have the APP_OPERATOR role to login.
- api-client: for the backend api to execute the changes on Keycloak. (Access Type should be confidential).

### Clients

![Alt text](pictures/api-client.png?raw=true)

![Alt text](pictures/app-client.png?raw=true)

### Roles

![Alt text](pictures/app-operator-role.png?raw=true)

### Users

![Alt text](pictures/api-user.png?raw=true)

![Alt text](pictures/app-user.png?raw=true)

### REST Keycloak API Endpoints:

- GET: keycloak/admin/users (Optional with /?search param)
- GET: keycloak/admin/users/{userId}
- GET: keycloak/admin/users/{userId}/groups
- GET: keycloak/admin/groups
- PUT: keycloak/admin/users/{userId}/groups/{groupId}
- DELETE: keycloak/admin/users/{userId}/groups/{groupId}
- PUT: keycloak/admin/users/{userId}/attributes/site/{siteId}/application/{appId}
- DELETE: keycloak/admin/users/{userId}/attributes/site/{siteId}/application/{appId}
- GET: keycloak/admin/roles
- PUT: keycloak/admin/users/{userId}/roles/{roleName}
- DELETE:keycloak/admin/users/{userId}/roles/{roleName}

### How to use it in Postman:

Get the Access-Token from:
http://localhost:8180/auth/realms/REALM/protocol/openid-connect/token

![Alt text](pictures/access-token-from-postman.png?raw=true)

Copy the Access-Token to the Header of the request:

![Alt text](pictures/get-users.png?raw=true)
