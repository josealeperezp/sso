package io.curity.example.democlient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

//@Configuration
public class OAuth2SecurityConfig {
    @Bean
    SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
//        http
//            .authorizeExchange(exchanges ->
//                exchanges
//                    .pathMatchers("/", "/error").permitAll()
//                    .anyExchange().authenticated()
//              )
//              .oauth2Login(Customizer.withDefaults());
        
        http
        .authorizeExchange(exchanges ->
            exchanges
            .pathMatchers("/user").authenticated()
            .anyExchange().permitAll()
          )
          .oauth2Login(Customizer.withDefaults());
        return http.build();
    }
}

