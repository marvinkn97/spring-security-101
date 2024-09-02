package dev.marvin.passwordencoder;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class PasswordEncoderConfig {

    public PasswordEncoder noOp(){
        return NoOpPasswordEncoder.getInstance();
    }

    public PasswordEncoder standard(){
        return new StandardPasswordEncoder("secret");
    }

    public PasswordEncoder bcrypt(){
        return new BCryptPasswordEncoder();
    }

    public PasswordEncoder encoder(){
        Map<String, PasswordEncoder> passwordEncoderMap = new HashMap<>();
        passwordEncoderMap.put("noop", NoOpPasswordEncoder.getInstance());
        passwordEncoderMap.put("bcrypt", new BCryptPasswordEncoder());
        passwordEncoderMap.put("scrypt", new SCryptPasswordEncoder(16384,8,1,32,64));
        return new DelegatingPasswordEncoder("bcrypt", passwordEncoderMap); //the default encoder is given as the first parameter when constructing the DelegatingPasswordEncoder Instance
    }
}
