package com.example.account.service;

import com.example.account.entity.AccountEntity;
import com.example.account.model.AccountDTO;
import com.example.account.model.TransactionDTO;
import com.example.account.repo.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    public AccountDTO deposit(TransactionDTO transactionDTO) {
        AccountEntity entity = accountRepository.findById(transactionDTO.getAccountId()).orElseThrow();

        entity.setBalance(entity.getBalance()+ transactionDTO.getAccountId());
        AccountEntity savedEntity = accountRepository.save(entity);

        AccountDTO dto = new AccountDTO();
        dto.setAccountId(savedEntity.getAccountId());
        dto.setAccountHolderName(savedEntity.getAccountHolderName());
        dto.setBalance(savedEntity.getBalance());
        dto.setBranch(savedEntity.getBranch());
        dto.setContact(savedEntity.getContact());

        return dto;
    }


    public AccountDTO createAccount(AccountDTO accountDTO) {
        AccountEntity entity = AccountEntity.builder()
                .accountHolderName(accountDTO.getAccountHolderName())
                .balance(accountDTO.getBalance())
                .branch(accountDTO.getBranch())
                .contact(accountDTO.getContact())
                .build();

        AccountEntity savedEntity = accountRepository.save(entity);
        AccountDTO dto = new AccountDTO();

        dto.setAccountId(savedEntity.getAccountId());
        dto.setAccountHolderName(savedEntity.getAccountHolderName());
        dto.setBalance(savedEntity.getBalance());
        dto.setBranch(savedEntity.getBranch());
        dto.setContact(savedEntity.getContact());

        return dto;
    }

    public AccountDTO withdraw(TransactionDTO transactionDTO) {
        AccountEntity entity = accountRepository.findById(transactionDTO.getAccountId()).orElseThrow();
        if(entity.getBalance() < transactionDTO.getAccountId()){
            System.out.println("Insufficient Balance!");
        }
        entity.setBalance(entity.getBalance() - transactionDTO.getAccountId());
        AccountEntity savedEntity = accountRepository.save(entity);
        AccountDTO dto = new AccountDTO();

        dto.setAccountId(savedEntity.getAccountId());
        dto.setAccountHolderName(savedEntity.getAccountHolderName());
        dto.setBalance(savedEntity.getBalance());
        dto.setBranch(savedEntity.getBranch());
        dto.setContact(savedEntity.getContact());

        return dto;
    }
}
