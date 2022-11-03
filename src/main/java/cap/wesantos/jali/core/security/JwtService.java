package cap.wesantos.jali.core.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class JwtService {
    @Value("${security.jwt.validade}")
    private String validade;
    @Value("${security.jwt.assinatura}")
    private String chaveAssinatura;

    public String gerarToken(String nomeUsuario) {
        SecretKey assinatura = Keys.hmacShaKeyFor(chaveAssinatura.getBytes());
        Long validadeLong = Long.valueOf(validade);
        LocalDateTime dataHoraValidade = LocalDateTime.now().plusMinutes(validadeLong);
        Instant instant = dataHoraValidade.atZone(ZoneId.systemDefault()).toInstant();
        Date data = Date.from(instant);

        return Jwts.builder()
                .setSubject(nomeUsuario)
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
        SecretKey assinatura = Keys.hmacShaKeyFor(chaveAssinatura.getBytes());
        return Jwts.parserBuilder()
                .setSigningKey(assinatura)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}