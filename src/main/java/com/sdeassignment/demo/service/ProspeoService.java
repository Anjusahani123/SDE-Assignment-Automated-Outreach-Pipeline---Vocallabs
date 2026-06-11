package com.sdeassignment.demo.service;


import com.sdeassignment.demo.dto.ContactDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProspeoService {

    public List<ContactDTO> findDecisionMakers(
            String companyDomain) {

        log.info(
                "Finding contacts for {}",
                companyDomain);

        ContactDTO contact = new ContactDTO();

        contact.setName("John Doe");
        contact.setDesignation("CTO");
        contact.setLinkedinUrl(
                "https://linkedin.com/in/john");

        return List.of(contact);
    }
}