package com.points.taxcalculator.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Comparator;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class TaxBracket implements Serializable, Comparator<TaxBracket> {

    private static final long serialVersionUID = 7514242753748293996L;

    private int min;
    private int max;
    private double rate;

    public double getMaxTaxPayable() {
        return rate * (max - min);
    }

    @Override
    public int compare(TaxBracket a, TaxBracket b) {
        return Integer.compare(a.getMin(), b.getMin()
        );
    }
}
