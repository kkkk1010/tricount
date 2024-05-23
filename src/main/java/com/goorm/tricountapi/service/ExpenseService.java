package com.goorm.tricountapi.service;


import com.goorm.tricountapi.model.Expense;
import com.goorm.tricountapi.model.ExpenseRequest;
import com.goorm.tricountapi.model.Settlement;
import com.goorm.tricountapi.repository.ExpenseRepository;
import com.goorm.tricountapi.repository.SettlementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExpenseService {
    private final SettlementRepository settlementRepository;
    private final ExpenseRepository expenseRepository;


    public void addExpense(ExpenseRequest expenseRequest) {
        //정산방이 있는지 체크
        Optional<Settlement> settlement = settlementRepository.findById(expenseRequest.getSettlementId());
        if(!settlement.isPresent()) {
            throw new RuntimeException("INVALID");
        }

        //있다면, 지출내역을 저장한다.
        Expense expense = new Expense();
        expense.setName(expenseRequest.getName());
        expense.setSettlementId(expenseRequest.getSettlementId());
        expense.setPayerMemberId(expenseRequest.getPayerMemberId());
        expense.setAmount(expenseRequest.getAmount());
        expense.setExpenseDateTime(LocalDateTime.now());
        expenseRepository.save(expense);
    }
}
