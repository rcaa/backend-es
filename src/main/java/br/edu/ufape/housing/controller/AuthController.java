package br.edu.ufape.housing.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufape.housing.dto.AuthDTO;
import br.edu.ufape.housing.dto.LoginResponseDTO;
import br.edu.ufape.housing.dto.UserDTO;
import br.edu.ufape.housing.model.User;
import br.edu.ufape.housing.security.TokenService;
import br.edu.ufape.housing.service.AuthService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final AuthService authService;

    private final TokenService tokenService;

    public AuthController(AuthenticationManager authenticationManager, 
        AuthService authService, TokenService tokenService) {
            this.authenticationManager = authenticationManager;
            this.authService = authService;
            this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid AuthDTO authDTO) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(
            authDTO.getEmail(), authDTO.getPassword());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        String token = this.tokenService.generateToken((User) auth.getPrincipal());
        
        return ResponseEntity.status(HttpStatus.OK).body(new LoginResponseDTO(token));
    }
    
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody @Valid UserDTO userDTO) {
        User registeredUser = this.authService.register(userDTO);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);
    }
    
}
