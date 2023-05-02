package fiap.scj.seguranca.controller;

import fiap.scj.seguranca.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/loginValidator")
@CrossOrigin(origins = "*")
public class LoginController {

    private List<User> users = new ArrayList<User>();

    private static final long EXPIRATION_TIME = 86400000; // 24 horas em milissegundos
    private static final String SECRET_KEY = "batatinha-quando-nasce-espalha-rama-pelo-chao";
    private static final String TOKEN_PREFIX = "Bearer ";

    @PostMapping("/login")
    public ResponseEntity<String> register(
            @RequestHeader String login,
            @RequestHeader String passw) {
        try {
            User newUser = new User(login, passw);
            for (User user : users) {
                if (user.getLogin().equals(newUser.getLogin()) && user.getPassw().equals(newUser.getPassw())) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existe!");
                }
            }
            users.add(newUser);
            String token = createToken(newUser);
            return ResponseEntity.status(HttpStatus.OK).body(token);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criar usuário.");
        }
    }

    @GetMapping("/login")
    public ResponseEntity<String> login(
            @RequestHeader String login,
            @RequestHeader String passw) {
        try {
            for (User user : users) {
                if (user.getLogin().equals(login) && user.getPassw().equals(passw)) {
                    String token = createToken(user);
                    return ResponseEntity.status(HttpStatus.OK).body(token);
                }
            }
            return ResponseEntity.status(HttpStatus.OK).body("Usuário não cadastrado!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao buscar o usuário.");
        }
    }

    private String createToken(User user) {
        String token = Jwts.builder()
                .setSubject(user.getLogin())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
        return TOKEN_PREFIX + token;
    }
}
