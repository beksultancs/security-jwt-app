package jwtapp.services;

import jwtapp.dto.AuthRequest;
import jwtapp.dto.AuthResponse;
import jwtapp.models.User;
import jwtapp.repositories.UserRepo;
import jwtapp.security.JwtUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepo userRepo;
    private final JwtUtils jwtUtils;

    public AuthService(UserRepo userRepo,
                       JwtUtils jwtUtils) {
        this.userRepo = userRepo;
        this.jwtUtils = jwtUtils;
    }

    public AuthResponse authenticate(AuthRequest authRequest) {

        User user = userRepo.findByEmail(authRequest.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException(
                        "user with email = " + authRequest.getEmail() + " not found!"
                ));

        if (!user.getPassword().equals(authRequest.getPassword())) {
            throw new BadCredentialsException(
                    "invalid password"
            );
        }

        String jwt = jwtUtils.generateJwt(user);

        return new AuthResponse(
                user.getEmail(),
                jwt
        );
    }
}
