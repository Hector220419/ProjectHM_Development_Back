package com.HM.controller;

import com.HM.jwt.config.JwtFilter;
import com.HM.model.Customer;
import com.HM.model.Token;
import com.HM.service.CustomerService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import java.util.Calendar;
import java.util.Date;

@RestController
@RequestMapping(path="/wm/login/")
public class LoginController {

    @Autowired
    private final CustomerService customerService;

    public LoginController(CustomerService userService) {
        this.customerService = userService;
    }

    @PostMapping
    public Token Customer(@RequestBody Customer customer) throws ServletException {
        if(customerService.loginCifrado(customer.getEmail(),customer.getPassword())){
            return new Token(generateToken(customer.getEmail()));
        }
        throw new ServletException(("Correo electronico o contraseña incorrectos"));
    }

    //Metodo para generar un token
    private String generateToken(String username) {//token asociado al usuario
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, 10);
        return Jwts.builder().setSubject(username).claim("role", "user")
                .setIssuedAt(new Date()).setExpiration(calendar.getTime())
                .signWith(SignatureAlgorithm.HS256, JwtFilter.secret).compact();
    }
}
