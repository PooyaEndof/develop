package ir.snappay.tax.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.Parameter;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {

    @Value("${spring.application.version:${app.version:0.0}}")
    private String appVersion;

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("APIs").version(appVersion).description("APIs' global header"));
    }

/*    @Bean
    public OpenApiCustomizer addGatewayServerOpenApiCustomizer() {
        return openApi ->
        {
            openApi.getServers().add(0, new Server().url(appGatewayUri + contextPath).description("Apisix Gateway Server"));
            openApi.getComponents().addSecuritySchemes("bearerAuth",
                    new SecurityScheme()
                            .name("bearerAuth")
                            .type(SecurityScheme.Type.HTTP)
                            .scheme("bearer")
                            .bearerFormat("JWT")
                            .description("Enter JWT token in format: Bearer <token>")
            );

            // Apply security globally (optional)
            openApi.addSecurityItem(
                    new SecurityRequirement().addList("bearerAuth"));
        };
    }*/

    @Bean
    public OpenApiCustomizer globalHeaderOpenApiCustomizer() {
        return openApi ->
                openApi.getPaths().values()
                        .forEach(pathItem -> pathItem.readOperations().forEach(operation -> {
                            Parameter globalHeader = new Parameter()
                                    .name("Accept-Language")
                                    .description("Choose language of error:")
                                    .required(false)
                                    .in("header")
                                    .schema(new StringSchema());
                            operation.addParametersItem(globalHeader);


                        }));
    }
}