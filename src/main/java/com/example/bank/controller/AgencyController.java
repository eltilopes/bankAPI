package com.example.bank.controller;

import java.util.List;

import com.example.bank.entity.Agency;
import com.example.bank.repository.AgencyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * The AgencyController controls all calls to the entity Agency.
 *
 * @author  Elton Lopes
 * @version 1.0
 * @since   2021-08-21
 */
@RestController
@RequestMapping("agencia")
class AgencyController {

    private static final Logger log = LoggerFactory.getLogger(AgencyController.class);

    private final AgencyRepository agencyRepository;

    AgencyController(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }

    @GetMapping()
    List<Agency> allAgencies() {
       log.info("GET : allAgencies");
       return agencyRepository.findAll();
    }
}