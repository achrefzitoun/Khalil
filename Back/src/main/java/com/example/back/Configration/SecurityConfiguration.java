package com.example.back.Configration;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    private final LogoutHandler logoutHandler;

    private static final String[] WHITE_LIST_URL =
            {"/auth/**"
            };
    private static final  String ADMIN_LINK="/admin/**";
    private static final  String ADMIN_ROLE="ADMIN";

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers(WHITE_LIST_URL)
                        .permitAll()
                        .requestMatchers(HttpMethod.GET, ADMIN_LINK).hasAnyAuthority(ADMIN_ROLE)
                        .requestMatchers(HttpMethod.POST, ADMIN_LINK).hasAnyAuthority(ADMIN_ROLE)
                        .requestMatchers(HttpMethod.PUT, ADMIN_LINK).hasAnyAuthority(ADMIN_ROLE)
                        .requestMatchers(HttpMethod.DELETE, ADMIN_LINK).hasAnyAuthority(ADMIN_ROLE)
                        .anyRequest().authenticated())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .logout(logout -> logout
                        .logoutUrl("/auth/logout")
                        .addLogoutHandler(logoutHandler)
                        .logoutSuccessHandler(
                                (request, response, authentication) ->
                                        SecurityContextHolder.clearContext()))

        ;

        return http.build();
    }
}
