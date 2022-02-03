package com.points.taxcalculator.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Map;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SalaryTaxResponse implements Serializable {

    private static final long serialVersionUID = -104481923014577511L;

    private double totalTaxPayable;
    private Map<Integer, Double> taxPerBand;
    private double effectiveTaxRate;
}


