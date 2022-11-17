package cap.wesantos.jali.core.configuration;

import cap.wesantos.jali.core.security.JwtAuthFilter;
import cap.wesantos.jali.core.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;


@Configuration
public class SecurityConfig {

    private static final String[] AUTH_WHITELIST = {
            "/",
            "/login",
            "/*.css",
            "/*.js",
            "/*.ico",
            "/*.map",
            "/api/auth/**",
            "/api/auth"
    };

    @Autowired
    private UserDetailsService userService;

    @Autowired
    private JwtService jwtService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        /*
            HttpSecurity configura cors, csrf, session management, e "rules" para proteger os recursos
         */
        http
                .csrf().disable()
                .authorizeHttpRequests((authorize) -> authorize
                        .antMatchers(AUTH_WHITELIST).permitAll()
                        .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                        .antMatchers("/api/usuarios/**")
                        .hasAnyRole("USER", "ADMIN")
                        .antMatchers("/api/usuarios/livros/**")
                        .hasAnyRole("USER", "ADMIN")
                        .antMatchers("/api/usuarios/perfil")
                        .hasAnyRole("USER", "ADMIN")
                        .antMatchers("/api/usuarios/{\\d+}/perfil")
                        .hasAnyRole("USER", "ADMIN")
                        .antMatchers("/api/livros/**")
                        .hasAnyRole("USER", "ADMIN")
                        .antMatchers("/home/**")
                        .hasAnyRole( "ADMIN")
                        .antMatchers("/perfil/**")
                        .hasAnyRole( "ADMIN")
                        .anyRequest().authenticated()
                )
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(jwtFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    public OncePerRequestFilter jwtFilter() {
        return new JwtAuthFilter(jwtService, userService);
    }
}
