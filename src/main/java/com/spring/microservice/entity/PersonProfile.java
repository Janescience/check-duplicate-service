
package com.spring.microservice.entity;


import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name="SSC_PERSONPROFILE")
public class PersonProfile {
    
    @Id
    private Long personId;
    private Long sessionNo;
    private String cisNo;
}
