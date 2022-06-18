package jwtapp.apis;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/test")
public class TestApi {

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public Map<String, String> isSecurityWorks(Authentication authentication) {

        return Map.of(
                "works", "true",
                "email" , authentication.getName()
        );
    }


}
