package com.rps.payroll;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Payroll {

    private String id;
    private String grade;
    private double rate;

}
