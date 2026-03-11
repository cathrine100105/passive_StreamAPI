package com.example.borrowedMoney.controller;

import com.example.borrowedMoney.api.MoneyApi;
import com.example.borrowedMoney.model.MoneyDTO;
import com.example.borrowedMoney.service.MoneyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MoneyController implements MoneyApi {
    private final MoneyService moneyService;
    @Override
    public ResponseEntity<List<MoneyDTO>> moneyGet(Integer page, Integer size, String sort) {
        return ResponseEntity.ok(moneyService.getAll(page,size,sort));
    }

    @Override
    public ResponseEntity<MoneyDTO> moneyPost(MoneyDTO moneyDTO) {
        return ResponseEntity.ok(moneyService.create(moneyDTO));
    }
}
