package dev.marvin.authenticationprovider;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * we create custom authentication providers given instances our application
 * does not rely on the usual username & password authentication
 * for example: biometrics login, otp sms etc
 */


@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        if (username.equals("Marvin") && password.equals("password")) {
        }

        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
