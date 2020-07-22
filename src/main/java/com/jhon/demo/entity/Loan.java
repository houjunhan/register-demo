package com.jhon.demo.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Loan {
    private Integer num;
    private String loanStatus;
    private String loanRepayStatus;
}
