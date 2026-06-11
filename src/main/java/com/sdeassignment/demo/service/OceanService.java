package com.sdeassignment.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class OceanService {

    public List<String> findSimilarCompanies(
            String domain) {

        log.info("Searching similar companies for {}",
                domain);

        return List.of(
                "anthropic.com",
                "cohere.com",
                "perplexity.ai"
        );
    }
}