package jwtapp.apis;

import jwtapp.dto.AuthRequest;
import jwtapp.dto.AuthResponse;
import jwtapp.services.AuthService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;

@RestController
@RequestMapping("api/auth")
public class AuthApi {

    private final AuthService authService;

    public AuthApi(AuthService authService) {
        this.authService = authService;
    }

    // generate token
    @PostMapping("/authenticate")
    @PreAuthorize("permitAll()")
    public AuthResponse authenticate(@RequestBody AuthRequest authRequest) {
        return authService.authenticate(authRequest);
    }
}
