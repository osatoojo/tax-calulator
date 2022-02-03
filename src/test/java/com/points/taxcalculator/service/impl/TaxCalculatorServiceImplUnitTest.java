package com.points.taxcalculator.service.impl;

import com.points.taxcalculator.entity.SalaryTaxResponse;
import com.points.taxcalculator.entity.TaxBracket;
import com.points.taxcalculator.exception.RemoteServerException;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TaxCalculatorServiceImplUnitTest {

    @InjectMocks
    private TaxCalculatorServiceImpl taxCalculatorService;

    @Mock
    private TaxBracketServiceImpl taxBracketService;


    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
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

    private List<TaxBracket> getTaxBrackets(){
        List<TaxBracket> taxBrackets = new ArrayList<>();
        TaxBracket.builder()
                .max(20000)
                .min(10000)
                .rate(0.1)
                .build();
      return taxBrackets;
    }



    @Test
    public void test_GetTaxedSalary() throws RemoteServerException {
        int year = 2019;
        BigDecimal salary = new BigDecimal(1000);
        Mockito.when(taxBracketService.getTaxBrackets(year)).thenReturn(getTaxBrackets());
        final SalaryTaxResponse salaryTaxResponse = taxCalculatorService.calculateTax(salary, year);
        System.out.println(salaryTaxResponse);
        Assertions.assertEquals(0.0,salaryTaxResponse.getTotalTaxPayable());
    }


}