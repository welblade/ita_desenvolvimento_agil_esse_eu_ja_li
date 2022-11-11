package cap.wesantos.jali.core.security;


import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthFilter extends OncePerRequestFilter {
/*
   OncePerRequestFilter é executado uma vez a cara requisição feita à API.
   Ela tem um método doFilterInternal() onde o jwt vai ser decodificado e validado
   e então carregar o Userdetails (usando UserDetailsService),
   verificando Authorization (usando UsernamePasswordAuthenticationToken).
 */
    private final JwtService jwtService;
    private final UserDetailsService usuarioService;

    public JwtAuthFilter(JwtService jwtService, UserDetailsService usuarioService) {
        this.jwtService = jwtService;
        this.usuarioService = usuarioService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorization = request.getHeader("Authorization");

        if (authorization != null && authorization.startsWith("Bearer")) {
            String token = authorization.split(" ")[1];

            if (jwtService.isTokenValido(token)) {
                String loginUsuario = jwtService.obterLoginUsuario(token);
                UserDetails usuario = usuarioService.loadUserByUsername(loginUsuario);
                /*
                 UsernamePasswordAuthenticationToken recebe {username, password}
                 vindo da requisição, o "AuthenticationManager" usará isso para autenticar
                 uma conta de login.
                 */
                UsernamePasswordAuthenticationToken userToken = new UsernamePasswordAuthenticationToken(
                        usuario,
                        null,
                        usuario.getAuthorities()
                );

                userToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(userToken);
            }
        }

        filterChain.doFilter(request, response);
    }
}

