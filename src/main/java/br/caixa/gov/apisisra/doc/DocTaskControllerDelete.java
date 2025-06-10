package br.caixa.gov.apisisra.doc;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Operation(
        summary = "Deletar Task",
        description = "Remove uma Task do sistema pelo ID",
        parameters = {
                @Parameter(name = "id", description = "ID da Task", required = true, in = ParameterIn.PATH),
                @Parameter(name = "id2", description = "ID da Task", required = true, in = ParameterIn.QUERY)
        },
        security = @SecurityRequirement(name = "petstore_auth")
)
@ApiResponses({
        @ApiResponse(responseCode = "204", description = "Task deletada com sucesso."),
        @ApiResponse(responseCode = "404", description = "Task não encontrado.")
})
public @interface DocTaskControllerDelete {

}
