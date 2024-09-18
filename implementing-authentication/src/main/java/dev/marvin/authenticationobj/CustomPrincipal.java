package dev.marvin.authenticationobj;

import java.security.Principal;

public class CustomPrincipal implements Principal {
    @Override
    public String getName() {
        return "custom principal name";
    }
}
