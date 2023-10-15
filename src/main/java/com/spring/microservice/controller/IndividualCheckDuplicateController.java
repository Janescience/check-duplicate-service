package com.spring.microservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.spring.microservice.service.IndividualCheckDuplicateService;
import org.springframework.http.ResponseEntity;

import com.spring.microservice.entity.PersonProfile;
import com.spring.microservice.payload.response.MsgResponse;


@Slf4j
@RestController
@RequestMapping("/individual")
public class IndividualCheckDuplicateController {

    @Autowired
    private IndividualCheckDuplicateService individualCheckDuplicateService;


    @GetMapping
    public  String serviceName() {
        log.info("CHECK DUPLICATE SERVICE");
        return "CHECK DUPLICATE SERVICE";
    }


    @GetMapping("/{personId}")
    public ResponseEntity<?> individual(@PathVariable Long personId) {
        log.info("CHECK DUPLICATE PROFILE CALLED");
        try {
            PersonProfile personProfile =  individualCheckDuplicateService.individual(personId);
            if(personProfile != null){
                return ResponseEntity.ok(new MsgResponse("Duplicate profile.","200","success",personProfile));
            }else{
                return ResponseEntity.ok(new MsgResponse("Not duplicate profile.","200","success",null));
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.ok(new MsgResponse("Internal error.","500","error",e.getMessage()));
        }
        
    }
}
