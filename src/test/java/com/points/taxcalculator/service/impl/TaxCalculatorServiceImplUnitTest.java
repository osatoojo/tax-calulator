package com.points.taxcalculator.service.impl;

import com.points.taxcalculator.entity.SalaryTaxResponse;
import com.points.taxcalculator.service.TaxCalculatorService;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class TaxCalculatorServiceImplUnitTest {

    @InjectMocks
    private TaxCalculatorServiceImpl taxCalculatorService;

    private static final String taxBracketsUrl = "http://localhost:5000/tax-calculator/brackets";

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(taxCalculatorService, "taxBracketsUrl", taxBracketsUrl);
    }

    private Map<Integer, Double> getTaxPerBand() {
        Map<Integer, Double> taxBands = new HashMap<>();
        taxBands.put(0,20000.0);
        taxBands.put(1,40000.0);
        return taxBands;
    }

    private SalaryTaxResponse getSalaryTaxResponse() {
        return SalaryTaxResponse.builder()
                .effectiveTaxRate(35.0)
                .taxPerBand(getTaxPerBand())
                .totalTaxPayable(3000)
                .build();
    }



    @Test
    void calculateTaxedSalary() {
//        final SalaryTaxResponse salaryTaxResponse = taxCalculatorService.calculateTaxedSalary(new BigDecimal(60000),2021);
////        Assertions.assertNotNull(salaryTaxResponse);
////        Assertions.assertEquals(12300.0, salaryTaxResponse.getTotalTaxPayable());
//
//
//
//
    }


}