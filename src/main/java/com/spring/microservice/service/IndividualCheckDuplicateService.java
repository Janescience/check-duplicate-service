package com.spring.microservice.service;

import org.springframework.stereotype.Service;

import com.spring.microservice.entity.PersonProfile;
import com.spring.microservice.repository.PersonProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class IndividualCheckDuplicateService {

    @Autowired
    PersonProfileRepository personProfileRepository;

    public PersonProfile individual(String cisNo) {
        return personProfileRepository.findByCisNo(cisNo);
    }

}
