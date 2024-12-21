package com.tayssir.livre.security;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import jakarta.servlet.http.HttpServletRequest;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	KeycloakRoleConverter keycloakRoleConverter;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.csrf(csrf -> csrf.disable())

				.cors(cors -> cors.configurationSource(new CorsConfigurationSource() {
					@Override
					public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
						CorsConfiguration cors = new CorsConfiguration();
						cors.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
						cors.setAllowedMethods(Collections.singletonList("*"));
						cors.setAllowedHeaders(Collections.singletonList("*"));
						cors.setExposedHeaders(Collections.singletonList("Authorization"));

						return cors;
					}
<<<<<<< HEAD:src/main/java/com/tayssir/cosmetique/security/SecurityConfig.java
				}))
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/api/all/**").hasAnyAuthority("ADMIN", "USER")
							.requestMatchers(HttpMethod.GET, "/api/getbyid/**").hasAnyAuthority("ADMIN", "USER")
							.requestMatchers(HttpMethod.POST, "/api/addcos/**").hasAuthority("ADMIN")
							.requestMatchers(HttpMethod.PUT, "/api/updatecos/**").hasAuthority("ADMIN")
							.requestMatchers(HttpMethod.DELETE, "/api/delcos/**").hasAuthority("ADMIN")
							.requestMatchers(HttpMethod.DELETE, "/api/image**").hasAuthority("ADMIN")
							.requestMatchers(HttpMethod.GET, "/api/cosmetiqueClas/**").hasAnyAuthority("ADMIN", "USER")
							.requestMatchers("/clas/**").hasAnyAuthority("ADMIN", "USER").anyRequest().authenticated())
						.oauth2ResourceServer(ors -> ors.jwt(jwt -> jwt.jwtAuthenticationConverter(keycloakRoleConverter)));

=======
				}).and()
                .authorizeHttpRequests()
                .requestMatchers("/api/all/**").hasAnyAuthority("ADMIN", "USER")
                .requestMatchers(HttpMethod.GET, "/api/getbyid/**").hasAnyAuthority("ADMIN", "USER")
                .requestMatchers(HttpMethod.POST, "/api/addbiblio/**").hasAnyAuthority("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/api/updatebiblio/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/api/delbiblio/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.GET,"/api/bibliothequeeClas/**").hasAnyAuthority("ADMIN","USER")
    		    .requestMatchers("/biblio/**").hasAnyAuthority("ADMIN","USER")
                .anyRequest().authenticated().and()
                .addFilterBefore(new JWTAuthorizationFilter(), BasicAuthenticationFilter.class);
>>>>>>> a81a6481b2a22ddb8f69c59b677cf944dabc1875:src/main/java/com/tayssir/livre/security/SecurityConfig.java
		return http.build();
	}
}
