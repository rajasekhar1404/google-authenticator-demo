package com.authenticate.controller;

import com.authenticate.entity.User;
import com.authenticate.service.AuthenticationService;
import com.google.zxing.WriterException;
import org.apache.commons.codec.binary.Base32;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.SecureRandom;

@RestController
public class UserController {

    private AuthenticationService authenticationService;

    public UserController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping("/login/{code}")
    public String login(@PathVariable String code) {
        return authenticationService.login(code);
    }

    @GetMapping("/secret-key")
    public String generateSecretKey() {
        return authenticationService.generateSecretKey();
    }

    @PostMapping("/generate-qr")
    public void generateQRCode(@RequestBody User user) throws IOException, WriterException {
        authenticationService.generateBarCode(user);
    }

}
