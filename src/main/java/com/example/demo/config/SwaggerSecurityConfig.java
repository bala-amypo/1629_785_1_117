package com.example.demo.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
        name = "BearerAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        bearerFormat = "JWT"
)
public class SwaggerSecurityConfig {}








// package com.example.demo.config;

// import io.swagger.v3.oas.annotations.security.SecurityScheme;
// import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
// import org.springframework.context.annotation.Configuration;

// @Configuration
// @SecurityScheme(
//         name = "BearerAuth",
//         type = SecuritySchemeType.HTTP,
//         scheme = "bearer",
//         bearerFormat = "JWT"
// )
// public class SwaggerSecurityConfig {
//     // No code needed here. Annotation only.
// }
