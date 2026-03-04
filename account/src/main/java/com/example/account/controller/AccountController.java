package com.example.account.controller;

import com.example.account.api.AccountApi;
import com.example.account.model.AccountDTO;
import com.example.account.model.TransactionDTO;
import com.example.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class AccountController implements AccountApi {
    private final AccountService accountService;
    @Override
    public ResponseEntity<AccountDTO> depositAmount(TransactionDTO transactionDTO) {
        return ResponseEntity.ok(accountService.deposit(transactionDTO));
    }

    @Override
    public ResponseEntity<AccountDTO> openAccount(AccountDTO accountDTO) {
        return ResponseEntity.ok(accountService.createAccount(accountDTO));
    }

    @Override
    public ResponseEntity<AccountDTO> withdrawAmount(TransactionDTO transactionDTO) {
        return ResponseEntity.ok(accountService.withdraw(transactionDTO));
    }
}
