package cap.wesantos.jali.core.security;

import cap.wesantos.jali.data.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class JwtService {

    @Value("${security.jwt.validade}")
    private String validade;
    @Value("${security.jwt.assinatura}")
    private String chaveAssinatura;

    private SecretKey assinatura;

    {
        assinatura = Keys.hmacShaKeyFor(chaveAssinatura.getBytes());
    }

    public String gerarToken(Usuario usuario) {
        Long validadeLong = Long.valueOf(validade);
        LocalDateTime dataHoraValidade = LocalDateTime.now().plusMinutes(validadeLong);
        Instant instant = dataHoraValidade.atZone(ZoneId.systemDefault()).toInstant();
        Date data = Date.from(instant);

        return Jwts.builder()
                .setSubject(usuario.getLogin())
                .setExpiration(data)
                .signWith(assinatura)
                .compact();
    }

    public String obterLoginUsuario(String token) throws ExpiredJwtException {
        return obterClaims(token).getSubject();
    }

    public boolean isTokenValido(String token) {
        try {
            Claims claims = obterClaims(token);
            Date data = claims.getExpiration();
            LocalDateTime dataValidade = data
                    .toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();
            return !LocalDateTime.now().isAfter(dataValidade);
        } catch (Exception e) {
            return false;
        }
    }
    private Claims obterClaims(String token) throws ExpiredJwtException {
        return Jwts.parserBuilder()
                .setSigningKey(assinatura)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }


}
