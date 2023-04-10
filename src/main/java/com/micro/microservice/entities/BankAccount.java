package com.micro.microservice.entities;

import com.micro.microservice.enums.AccountType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity
@Data  @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccount {

    @Id
    private String id ;
    private Date createdAt;
    private Double balance ;
    private String currency ;

    // we use this annotation to save our type as string or as can we do it as an index
    @Enumerated(EnumType.STRING)
    private  AccountType type ;



}
