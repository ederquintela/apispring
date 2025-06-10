package br.caixa.gov.apisisra.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.*;
import io.swagger.v3.oas.models.security.OAuthFlow;
import io.swagger.v3.oas.models.security.Scopes;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("SISRA API")
                .version("v1")
                .description("""
                    This is a sample Pet Store Server based on the OpenAPI 3.0 specification.
                    You can find out more about Swagger at [swagger.io](https://swagger.io).
                    In the third iteration of the pet store, we've switched to the design-first approach!
                    You can now help us improve the API, whether it's by making changes to the definition itself or to the code.
                    That way, with time, we can improve the API in general and expose some of the new features in OAS3.
                
                    If you're looking for the Swagger 2.0/OAS 2.0 version of Petstore, then click
                    [here](https://editor.swagger.io/?url=https://petstore.swagger.io/v2/swagger.yaml).
                    Alternatively, you can load it via the `Edit > Load Petstore OAS 2.0` menu option.
                
                    Some useful links:
                    - [The Pet Store repository](https://github.com/swagger-api/swagger-petstore)
                    - [The source API definition for the Pet Store](https://github.com/swagger-api/swagger-petstore/blob/master/src/main/resources/openapi.yaml)
                    """)
                .termsOfService("http://swagger.io/terms/")
                .license(new License().name("Apache 2.0").url("http://springdoc.org"))
                .contact(new Contact().name("Eder Quintela").email("email@exemplo.com"))
            )
            .servers(List.of(
                new Server().url("http://localhost:8080/sisra/api/v1").description("Servidor de Produção")
            ))
            .tags(List.of(
                new Tag().name("Tasks").description("Operações de CRUD para Tasks"),
                new Tag().name("Clients").description("Operações de CRUD para Clients")
            ))
                .components(new Components()
                        .addSecuritySchemes("api_key", new SecurityScheme()
                                .type(SecurityScheme.Type.APIKEY)
                                .in(SecurityScheme.In.HEADER)
                                .name("api_key"))
                        .addSecuritySchemes("petstore_auth", new SecurityScheme()
                                .type(SecurityScheme.Type.OAUTH2)
                                .flows(new io.swagger.v3.oas.models.security.OAuthFlows()
                                        .implicit(new OAuthFlow()
                                                .authorizationUrl("https://petstore3.swagger.io/oauth/authorize")
                                                .scopes(new Scopes()
                                                        .addString("read:pets", "read your pets")
                                                        .addString("write:pets", "modify pets in your account"))))))
                .addSecurityItem(new SecurityRequirement().addList("api_key"))
                .addSecurityItem(new SecurityRequirement().addList("petstore_auth", List.of("read:pets", "write:pets")));
    }

}


/*
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API SISRA")
                        .version("v1")
                        .description("Documentação da API SISRA"))
                .addTagsItem(new Tag()
                        .name("Gerenciamento de Tarefas")
                        .description("Operações relacionadas a tarefas"))
                .addTagsItem(new Tag()
                        .name("Cadastro de Clientes")
                        .description("Operações de CRUD para clientes"));
    }

    @Bean
    public GroupedOpenApi taskApi() {
        return GroupedOpenApi.builder()
                .group("tasks")
                .pathsToMatch("/api/tasks/**")
                .addOpenApiCustomiser(openApi -> {
                    openApi.getPaths().forEach((path, pathItem) -> {
                        pathItem.readOperations().forEach(operation -> {
                            operation.addTagsItem("Gerenciamento de Tarefas");
                        });
                    });
                })
                .build();
    }

    @Bean
    public GroupedOpenApi clientApi() {
        return GroupedOpenApi.builder()
                .group("clientes")
                .pathsToMatch("/api/clientes/**")
                .addOpenApiCustomiser(openApi -> {
                    openApi.getPaths().forEach((path, pathItem) -> {
                        pathItem.readOperations().forEach(operation -> {
                            operation.addTagsItem("Cadastro de Clientes");
                        });
                    });
                })
                .build();
    }
    */

