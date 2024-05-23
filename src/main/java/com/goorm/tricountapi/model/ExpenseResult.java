package com.goorm.tricountapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ExpenseResult {
    private Long settlementId;
    private Member payerMember;
    private BigDecimal amount;

//    public ExpenseResult(Expense expense, Member member) {
//        this.settlementId = expense.getSettlementId();
//        this.payerMember = member;
//        this.amount = expense.getAmount();
//    }
}
