package com.gunmer.alfred.api.config

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.security.SecurityRequirement
import io.swagger.v3.oas.models.security.SecurityScheme
import org.springdoc.core.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfiguration {

    @Bean
    fun publicApi(): GroupedOpenApi? {
        return GroupedOpenApi.builder()
            .group("com.gunmer")
            .packagesToScan("com.gunmer.alfred.api")
            .pathsToMatch("/**")
            .build()
    }

    @Bean
    fun springShopOpenAPI(): OpenAPI? {
        val securityRequirement = SecurityRequirement()
            .addList("bearer-jwt", listOf("read", "write"))
            .addList("bearer-key", listOf())
        val info = Info()
            .title("Alfred API")
            .description("An API")
            .version("v0.1.0")
        val securityScheme = SecurityScheme()
            .type(SecurityScheme.Type.HTTP)
            .scheme("bearer").bearerFormat("JWT")
        val securityComponent = Components()
            .addSecuritySchemes("bearer-key", securityScheme)

        return OpenAPI()
            .components(securityComponent)
            .info(info)
            .addSecurityItem(securityRequirement)
    }
}
