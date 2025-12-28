// // package com.example.demo.config;

// // import org.springframework.context.annotation.Bean;
// // import org.springframework.context.annotation.Configuration;
// // import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// // import org.springframework.security.crypto.password.PasswordEncoder;
// // import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// // import org.springframework.security.web.SecurityFilterChain;

// // @Configuration
// // public class SecurityConfig {

   
// //     @Bean
// //     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

// //         http.csrf().disable()
// //             .authorizeHttpRequests()
// //             .requestMatchers(
// //                 "/auth/**",
// //                 "/swagger-ui/**",
// //                 "/v3/api-docs/**"
// //             ).permitAll()
// //             .anyRequest().authenticated()
// //             .and()
// //             .httpBasic();

// //         return http.build();
// //     }
// // }

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;

// @Configuration
// public class SecurityConfig {

//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }
// }

package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf().disable()
            .authorizeHttpRequests(auth -> auth

                // ✅ VERY IMPORTANT (FOR AMYPO / CLOUD)
                .requestMatchers("/").permitAll()

                // ✅ SWAGGER ENDPOINTS
                .requestMatchers(
                    "/swagger-ui/**",
                    "/swagger-ui.html",
                    "/v3/api-docs/**"
                ).permitAll()

                // ✅ AUTH ENDPOINTS
                .requestMatchers("/auth/**").permitAll()

                // 🔒 EVERYTHING ELSE
                .anyRequest().authenticated()
            )
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        return http.build();
    }
}
