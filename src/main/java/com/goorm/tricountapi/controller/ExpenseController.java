package com.goorm.tricountapi.controller;


import com.goorm.tricountapi.model.ExpenseRequest;
import com.goorm.tricountapi.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class ExpenseController {
    private final ExpenseService expenseService;

    @PostMapping("/expenses/add")
    public ResponseEntity<Void> addExpenseToSettlement(@RequestBody @Valid ExpenseRequest expenseRequest) {
        expenseService.addExpense(expenseRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
