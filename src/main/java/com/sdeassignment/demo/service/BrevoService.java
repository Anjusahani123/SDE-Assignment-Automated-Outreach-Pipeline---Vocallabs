package com.sdeassignment.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BrevoService {

    public void sendEmail(
            String email,
            String company) {

        String subject =
                "Helping " + company +
                        " automate outreach";

        String body =
                """
                Hi,

                We help companies automate
                lead generation and outreach.

                Would love to connect.

                Regards,
                Prasanth
                """;

        log.info("=================================");
        log.info("MAIL SENT");
        log.info("TO : {}", email);
        log.info("SUBJECT : {}", subject);
        log.info("=================================");
    }
}