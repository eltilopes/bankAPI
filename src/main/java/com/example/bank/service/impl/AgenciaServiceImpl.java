package com.example.bank.service.impl;


import com.example.bank.entity.Agency;
import com.example.bank.repository.AgencyRepository;
import com.example.bank.service.AgenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service(value = "agenciaService")
public class AgenciaServiceImpl implements AgenciaService {

    @Autowired
    private AgencyRepository agenciaRepository;

    @Override
    public Agency findById(long id) {
        Optional<Agency> optional = agenciaRepository.findById(id);
        return optional.isPresent() ? optional.get() : null;
    }

}
