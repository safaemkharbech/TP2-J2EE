package com.example.ap2.dto;

import com.example.ap2.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data@NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccountResponseDTO {
    private  String id;
    private Date createdAt;
    private Double balance;
    private String currency;
    private AccountType type;
}
