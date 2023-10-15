package com.spring.microservice.service;

import org.springframework.stereotype.Service;

import java.util.Optional;

import com.spring.microservice.entity.PersonProfile;
import com.spring.microservice.repository.PersonProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class IndividualCheckDuplicateService {

    @Autowired
    PersonProfileRepository personProfileRepository;

    public PersonProfile individual(Long personId) {
        PersonProfile result = null;
        Optional<PersonProfile> personProfileOpt = personProfileRepository.findById(personId);
        if(personProfileOpt.isPresent()){
            result = personProfileOpt.get();
        }
        return result;
    }

}
