package me.wangj.chat.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wj
 * @date 2024/7/4
 */
@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customizeOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("chat API info")
                        .version("0.0.1")
                        .description("chat using spring and websocket")
                        .termsOfService("https://wangj.fun")
                        .license(new License().name("Apache 2.0")));
    }
}
