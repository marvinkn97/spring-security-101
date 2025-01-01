package dev.marvin.auth;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.List;

public class CustomJwtConverter implements Converter<Jwt, CustomAuthenticationToken> {
    @Override
    public CustomAuthenticationToken convert(Jwt source) {
        List<GrantedAuthority> grantedAuthorities = List.of(()-> "READ");
        String priority = source.getClaimAsString("claim");
        return new CustomAuthenticationToken(source, grantedAuthorities, priority);
    }

    @Override
    public <U> Converter<Jwt, U> andThen(Converter<? super CustomAuthenticationToken, ? extends U> after) {
        return Converter.super.andThen(after);
    }
}
