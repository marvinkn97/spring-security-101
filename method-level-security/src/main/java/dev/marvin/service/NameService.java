package dev.marvin.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class NameService {
    private static final Logger log = LoggerFactory.getLogger(NameService.class);

    @PreAuthorize("hasAuthority('WRITE')")
    public String getName(){
        log.info("Inside getName method of NameService");
        return "Mikey";
    }
}
