package com.stylepatrick.keycloakAdminClientRestApi.resource;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN, reason = "Not allowed!")
public class SiteCheckException extends RuntimeException {
}
