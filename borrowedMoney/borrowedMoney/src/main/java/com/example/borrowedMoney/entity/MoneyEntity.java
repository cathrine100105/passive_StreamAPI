package com.example.borrowedMoney.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "Money")
public class MoneyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int moneyId;

    private String name;
    private int amount;
    private int year;
    private String dueDate;
    private  int contactNo;
}
