package rest;

import com.fasterxml.jackson.databind.ObjectMapper;
//import com.sun.org.apache.xml.internal.security.algorithms.SignatureAlgorithm;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import javax.crypto.spec.SecretKeySpec;
import javax.ws.rs.NotAuthorizedException;
import java.security.Key;
import java.util.Calendar;

public class JWTHandler {

    private static Key key;
    private static final int TOKEN_EXPIRY = 2880; //2 days

    public static String generateJwtToken(User user) {
        System.out.println("generateJwtToken");
        Calendar expiry = Calendar.getInstance();
        expiry.add(Calendar.MINUTE, TOKEN_EXPIRY);
        return Jwts.builder()
                .setIssuer("Login")
                .claim("user", user)
                .signWith(SignatureAlgorithm.HS512, getKey())
                .setExpiration(expiry.getTime())
                .compact();
    }

    private static Key getKey() {
        System.out.println("getKey");
        //Genererer en hemmelig nøgle, hvis der ikke er en specificet endnu.
        // if-betingelse. Aktivieres kun hvis der ikke er en key.
        if (key == null) {
            // Endnu en if-betingelse. Aktiviseres kun hvis værdien af environmentet "JWT_SECRET_KEY" ikke er null eller tom.
            if (System.getenv("JWT_SECRET_KEY") != null && System.getenv("JWT_SECRET_KEY") != "") {
                //Væriden af environmentet "JWT_SECRET_KEY" kan så benyttes.
                String string = System.getenv("JWT_SECRET_KEY");
                key = new SecretKeySpec(string.getBytes(), 0, string.length(), "HS512");
            } else {
                // Ellers hvis ikke der var en værdi af environmentet "JWT_SECRET_KEY", så generes der en ny key.
                key = MacProvider.generateKey(SignatureAlgorithm.HS512);
            }
        }
        return key;
    }



    // Validering af token
    public static User validate(String authentication) {
        System.out.println("validate");
        System.out.println(authentication);
        if(authentication == null){
            throw new NotAuthorizedException("ingen header");
        }
        String[] tokenArray = authentication.split(" ");
        String token = tokenArray[tokenArray.length - 1];

        System.out.println(token);
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(getKey())
                    .parseClaimsJws(token)
                    .getBody();
            System.out.println("test2");
            ObjectMapper mapper = new ObjectMapper();
            User user = mapper.convertValue(claims.get("user"), User.class);
            System.out.println(user);
            return user;
        } catch (JwtException e){
            System.out.println(e.getClass() +":  "+ e.getMessage());
            throw new NotAuthorizedException(e.getMessage());
        }
    }
}
