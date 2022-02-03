package com.points.taxcalculator.service.impl;

import com.points.taxcalculator.entity.SalaryTaxResponse;
import com.points.taxcalculator.entity.TaxBracket;
import com.points.taxcalculator.exception.RemoteServerException;
import com.points.taxcalculator.service.TaxBracketService;
import com.points.taxcalculator.service.TaxCalculatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

@Service
@Slf4j
public class TaxCalculatorServiceImpl implements TaxCalculatorService {

    private final TaxBracketService taxBracketService;

    public TaxCalculatorServiceImpl(TaxBracketService taxBracketService) {
        this.taxBracketService = taxBracketService;
    }


    /**
     * calculate Taxed Salary
     */
    @Override
    public SalaryTaxResponse calculateTax(BigDecimal salary, int year) throws RemoteServerException {

        double taxPayable = 0;
        double totalTaxPayable = 0;
        Map<Integer, Double> bandPayableTax = new HashMap<>();

        final LinkedList<TaxBracket> bracketLinkedList = new LinkedList<>(taxBracketService.getTaxBrackets(year));

        Iterator<TaxBracket> bracketIterator = bracketLinkedList.iterator();

        while (bracketIterator.hasNext()) {
            final TaxBracket taxBracket = bracketIterator.next();
            if (salary.doubleValue() <= 0) {
                bandPayableTax.put(0, 0.0);
                return SalaryTaxResponse.builder()
                        .totalTaxPayable(0)
                        .taxPerBand(bandPayableTax)
                        .effectiveTaxRate(0)
                        .build();
            }
            if (salary.doubleValue() < taxBracket.getMax()) {
                taxPayable = salary.doubleValue() * taxBracket.getRate();
                bandPayableTax.put(bracketLinkedList.indexOf(taxBracket), round(taxPayable - totalTaxPayable, 2));
                break;

            }
            if (!bracketIterator.hasNext()) {
                taxPayable = salary.doubleValue() * taxBracket.getRate();
                bandPayableTax.put(bracketLinkedList.indexOf(taxBracket), round(taxPayable - totalTaxPayable, 2));
                break;
            }

            totalTaxPayable += taxBracket.getMaxTaxPayable();
            bandPayableTax.put(bracketLinkedList.indexOf(taxBracket), round(taxBracket.getMaxTaxPayable(), 2));
        }
        double effectiveTaxRate = (taxPayable / salary.doubleValue()) * 100;


        return SalaryTaxResponse.builder()
                .totalTaxPayable(round(taxPayable, 2))
                .taxPerBand(bandPayableTax)
                .effectiveTaxRate(round(effectiveTaxRate, 2))
                .build();

    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }


}
