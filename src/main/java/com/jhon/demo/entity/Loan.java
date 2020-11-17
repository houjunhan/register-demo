package com.jhon.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Loan {
    private Integer id;
    private Integer num;
    private String loanStatus;
    private String loanRepayStatus;
    private Long money;
}
