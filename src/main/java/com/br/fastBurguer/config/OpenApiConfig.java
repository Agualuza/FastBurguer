package com.br.fastBurguer.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
    info = @Info(
        title = "FastBurguer",
        version = "1.0.0",
        description = "Fast Food Software"
    ),
    servers = {
        @Server(
            description = "Local Env",
            url = "http://localhost:9080"
        )
    }
)
public class OpenApiConfig {
    
}
