/**
* NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.2.1).
* https://openapi-generator.tech
* Do not edit the class manually.
*/
package com.github.jacekszymanski.realcamel.api;

import com.github.jacekszymanski.realcamel.model.CreateUserRequest;
import com.github.jacekszymanski.realcamel.model.Login200Response;
import com.github.jacekszymanski.realcamel.model.LoginRequest;
import com.github.jacekszymanski.realcamel.model.UpdateCurrentUserRequest;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestParamType;
import org.springframework.stereotype.Component;
import com.github.jacekszymanski.realcamel.model.*;

@Component
public class UserAndAuthenticationApi extends RouteBuilder {

    @Override
    public void configure() throws Exception {


        /**
        POST /users
        **/
        rest()
            .post("/users")
                .description("")
                .id("createUserApi")
                .produces("application/json")
                .outType(Login200Response.class)
                .consumes("application/json")
                .type(CreateUserRequest.class)

                .param()
                    .name("body")
                    .type(RestParamType.body)
                    .required(true)
                    .description("Details of the new user to register")
                .endParam()
                .to("direct:createUser");


        /**
        GET /user : Get current user
        **/
        rest()
            .securityDefinitions()
                .apiKey("Token")
                    .withHeader("Token")

            .endSecurityDefinition()
            .get("/user")
                .description("Get current user")
                .id("getCurrentUserApi")
                .produces("application/json")
                .outType(Login200Response.class)
                .to("direct:getCurrentUser");


        /**
        POST /users/login : Existing user login
        **/
        rest()
            .post("/users/login")
                .description("Existing user login")
                .id("loginApi")
                .produces("application/json")
                .outType(Login200Response.class)
                .consumes("application/json")
                .type(LoginRequest.class)

                .param()
                    .name("body")
                    .type(RestParamType.body)
                    .required(true)
                    .description("Credentials to use")
                .endParam()
                .to("direct:login");


        /**
        PUT /user : Update current user
        **/
        rest()
            .securityDefinitions()
                .apiKey("Token")
                    .withHeader("Token")

            .endSecurityDefinition()
            .put("/user")
                .description("Update current user")
                .id("updateCurrentUserApi")
                .produces("application/json")
                .outType(Login200Response.class)
                .consumes("application/json")
                .type(UpdateCurrentUserRequest.class)

                .param()
                    .name("body")
                    .type(RestParamType.body)
                    .required(true)
                    .description("User details to update. At least **one** field is required.")
                .endParam()
                .to("direct:updateCurrentUser");

    }
}
