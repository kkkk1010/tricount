package com.goorm.tricountapi.model;


import com.goorm.tricountapi.MemberContext;
import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;

@Data
public class ExpenseRequest {
    @NonNull
    private String name;

    @NonNull
    private Long settlementId;

    private Long payerMemberId = MemberContext.getCurrentMember().getId();

    @NonNull
    private BigDecimal amount;
}
