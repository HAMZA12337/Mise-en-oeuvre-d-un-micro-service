package com.micro.microservice.web;


import com.micro.microservice.entities.BankAccount;
import com.micro.microservice.repositories.BankAccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class AccountRestController {

    private BankAccountRepository bankAccountRepository;

    public AccountRestController(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }



    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts(){

    return bankAccountRepository.findAll();}

    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccount(@PathVariable String id){

        return bankAccountRepository.findById(id).orElseThrow(()-> new RuntimeException(String.format("Account  %s not found",id)));}

    @PostMapping("/bankAccount")
  public BankAccount save(@RequestBody BankAccount bankAccount){


    return bankAccountRepository.save(bankAccount);}


    @PutMapping("/bankAccount/{id}")
    public BankAccount save(@PathVariable String id,@RequestBody BankAccount bankAccount){

        BankAccount account=bankAccountRepository.findById(id).orElse(null);

        if(account !=null ){
            account.setBalance(bankAccount.getBalance());
            account.setCurrency(bankAccount.getCurrency());
            account.setType(bankAccount.getType());
            account.setCreatedAt(new Date());
        }



        return bankAccountRepository.save(bankAccount);}






}
