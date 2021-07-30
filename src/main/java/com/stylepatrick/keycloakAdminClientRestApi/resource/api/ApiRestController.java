package com.stylepatrick.keycloakAdminClientRestApi.resource.api;

import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@RestController
@CrossOrigin
@RequestMapping("/api")
@interface ApiRestController {

    @AliasFor(annotation = RestController.class)
    String value() default "";

}
