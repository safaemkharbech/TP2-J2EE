package com.example.ap2.web;

import com.example.ap2.dto.BankAccountRequestDTO;
import com.example.ap2.dto.BankAccountResponseDTO;
import com.example.ap2.entities.BankAccount;
import com.example.ap2.mappers.AccountMapper;
import com.example.ap2.repositories.BankAccountRepository;
import com.example.ap2.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AccountRestController {
    private BankAccountRepository bankAccountRepository;
    private AccountService accountService;
    private AccountMapper accountMapper;

    public AccountRestController(BankAccountRepository bankAccountRepository, AccountService accountService, AccountMapper accountMapper) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }

    @GetMapping("/bankAccounts")
    public  List<BankAccount> bankAccounts(){
        return  bankAccountRepository.findAll();
    }


    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccount (@PathVariable String id){
        return  bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Account %s not found", id)));
    }

    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO save (@RequestBody BankAccountRequestDTO requestDTO){
        return  accountService.addAccount(requestDTO);
    }

    @PutMapping("/bankAccounts/{id}")
    public BankAccount update (@PathVariable String id , @RequestBody BankAccount bankAccount){
        BankAccount account = bankAccountRepository.findById(id).orElseThrow();
        if (bankAccount.getBalance()!= null) account.setBalance(bankAccount.getBalance());
        if (bankAccount.getCreatedAt()!= null) account.setCreatedAt(new Date());
        if (bankAccount.getType()!= null) account.setType(bankAccount.getType());
        if (bankAccount.getCurrency()!= null) account.setCurrency(bankAccount.getCurrency());
        return  bankAccountRepository.save(bankAccount);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void deleteAccount (@PathVariable String id){
        bankAccountRepository.deleteById(id);
    }

}
