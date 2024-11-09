package com.example.ap2.service;

import com.example.ap2.dto.BankAccountResponseDTO;
import com.example.ap2.dto.BankAccountRequestDTO;
import com.example.ap2.entities.BankAccount;
import com.example.ap2.enums.AccountType;

public interface AccountService {
    BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);
}
