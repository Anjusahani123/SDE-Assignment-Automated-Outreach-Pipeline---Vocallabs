package com.sdeassignment.demo.service;

import com.sdeassignment.demo.dto.ContactDTO;
import com.sdeassignment.demo.util.EmailValidatorUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class OutreachPipelineService {

    private final OceanService oceanService;
    private final ProspeoService prospeoService;
    private final EazyReachService eazyReachService;
    private final BrevoService brevoService;

    public void execute(String domain) {

        log.info("Pipeline Started");

        List<String> companies =
                oceanService.findSimilarCompanies(
                        domain);

        System.out.println();
        System.out.println(
                "===== PIPELINE SUMMARY =====");

        companies.forEach(System.out::println);

        Scanner scanner =
                new Scanner(System.in);

        System.out.println();
        System.out.println(
                "Proceed With Outreach ? (Y/N)");

        String choice =
                scanner.nextLine();

        if (!choice.equalsIgnoreCase("Y")) {

            log.info(
                    "Pipeline Stopped By User");

            return;
        }

        Set<String> processedEmails =
                new HashSet<>();

        for (String company : companies) {

            try {

                List<ContactDTO> contacts =
                        prospeoService
                                .findDecisionMakers(
                                        company);

                for (ContactDTO contact
                        : contacts) {

                    String email =
                            eazyReachService
                                    .findEmail(
                                            contact.getLinkedinUrl());

                    if (!EmailValidatorUtil
                            .isValid(email)) {

                        log.warn(
                                "Invalid Email {}",
                                email);

                        continue;
                    }

                    if (processedEmails
                            .contains(email)) {

                        log.warn(
                                "Duplicate Email {}",
                                email);

                        continue;
                    }

                    processedEmails
                            .add(email);

                    contact.setEmail(email);

                    brevoService.sendEmail(
                            email,
                            company);
                }

            } catch (Exception e) {

                log.error(
                        "Error Processing Company {}",
                        company,
                        e);
            }
        }

        log.info(
                "Pipeline Completed Successfully");
    }
}