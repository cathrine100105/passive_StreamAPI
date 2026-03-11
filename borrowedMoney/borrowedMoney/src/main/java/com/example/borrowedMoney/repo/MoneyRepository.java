package com.example.borrowedMoney.repo;

import com.example.borrowedMoney.entity.MoneyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoneyRepository extends JpaRepository<MoneyEntity,Integer> {
}
