package dev.marvin.grantedauthority;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {
    @Override
    public String getAuthority() {
        return null;
    }
}
