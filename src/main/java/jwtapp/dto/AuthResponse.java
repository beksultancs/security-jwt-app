package jwtapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponse {

    private String email;

    private String jwt;

    public AuthResponse() {
    }

    public AuthResponse(String email, String jwt) {
        this.email = email;
        this.jwt = jwt;
    }
}
