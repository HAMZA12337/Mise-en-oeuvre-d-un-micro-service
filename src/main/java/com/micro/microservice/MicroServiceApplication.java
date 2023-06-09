package com.micro.microservice;

import com.micro.microservice.entities.BankAccount;
import com.micro.microservice.enums.AccountType;
import com.micro.microservice.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class MicroServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepository){
        return args->{

            for(int i=0;i<10;i++){

                BankAccount bankAccount=BankAccount.builder()
                        .id(UUID.randomUUID().toString())
                        .type(Math.random()>0.5 ? AccountType.CURRENT_ACCOUNT:AccountType.SAVING_ACCOUNT)
                        .balance(Math.random()*90000)
                        .createdAt(new Date())
                        .currency("MAD")
                        .build();
   bankAccountRepository.save(bankAccount);
            }


        };
    }









}
