package com.example.ReservationSystem.cors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

public class corsConfig {
    @Configuration
    public class CorsConfig {

        @Bean
        public CorsFilter corsFilter() {
            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            CorsConfiguration config = new CorsConfiguration();

            // Permitir solicitudes desde todos los dominios. Puedes ajustar esto según tus necesidades.
            config.addAllowedOrigin("*");
            config.addAllowedHeader("*");
            config.addAllowedMethod("GET");
            config.addAllowedMethod("POST");
            config.addAllowedMethod("PUT");
            config.addAllowedMethod("DELETE");

            source.registerCorsConfiguration("/**", config);
            return new CorsFilter(source);
        }
    }
}
