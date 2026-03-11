package com.example.borrowedMoney.service;
import com.example.borrowedMoney.entity.MoneyEntity;
import com.example.borrowedMoney.model.MoneyDTO;
import com.example.borrowedMoney.repo.MoneyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MoneyService {
    private  final MoneyRepository moneyRepository;
    public  List<MoneyDTO> getAll(Integer page, Integer size, String sort) {
        // Default values
        if (page == null) page = 0;
        if (size == null) size = 5;
        if (sort == null || sort.isBlank()) sort = "moneyId";

        // Create Pageable WITH sorting
        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by(sort).ascending()
        );

        Page<MoneyEntity> entityPage = moneyRepository.findAll(pageable);

        Page<MoneyEntity> entities =moneyRepository.findAll(pageable);
        List<MoneyDTO> dtoList = new ArrayList<>();
        for(MoneyEntity entity : entities){
            MoneyDTO dto = new MoneyDTO();
            dto.setMoneyId(entity.getMoneyId());
            dto.setName(entity.getName());
            dto.setAmount(entity.getAmount());
            dto.setYear(String.valueOf(entity.getYear()));
            dto.setDueDate(entity.getDueDate());
            dto.setContactNo(entity.getContactNo());

            dtoList.add(dto);

        }
        return dtoList;
    }

    public MoneyDTO create(MoneyDTO moneyDTO) {
        MoneyEntity entity1 = MoneyEntity.builder()
                .moneyId(moneyDTO.getMoneyId())
                .name(moneyDTO.getName())
                .amount(moneyDTO.getAmount())
                .contactNo(moneyDTO.getContactNo())
                .dueDate(moneyDTO.getDueDate())
                .year(moneyDTO.getYear())
                .build();
        MoneyEntity entity = moneyRepository.save(entity1);
        MoneyDTO dto = new MoneyDTO();

        dto.setName(entity.getName());
        dto.setAmount(entity.getAmount());
        dto.setYear(String.valueOf(entity.getYear()));
        dto.setDueDate(entity.getDueDate());
        dto.setContactNo(entity.getContactNo());
        return  dto;
    }
}
