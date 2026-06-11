package com.sdeassignment.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EazyReachService {

    public String findEmail(
            String linkedinUrl) {

        log.info(
                "Resolving email from {}",
                linkedinUrl);

        return "john@example.com";
    }
}