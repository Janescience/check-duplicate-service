package com.spring.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.microservice.entity.PersonProfile;

@Repository
public interface PersonProfileRepository extends JpaRepository<PersonProfile,Long> {
    
}
