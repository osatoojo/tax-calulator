package com.points.taxcalculator.controller;

import com.points.taxcalculator.entity.SalaryTaxResponse;
import com.points.taxcalculator.exception.RemoteServerException;
import com.points.taxcalculator.service.TaxCalculatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TaxCalculatorControllerUnitTest {

    @InjectMocks
    TaxCalculatorController taxCalculatorController;

    @Mock
    TaxCalculatorService taxCalculatorService;

    private Map<Integer, Double> getTaxPerBand() {
        Map<Integer, Double> taxBands = new HashMap<>();
        taxBands.put(1, 20000.0);
        taxBands.put(2, 40000.0);
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
    public void test_GetTaxedSalary() throws RemoteServerException {
        int year = 2021;
        BigDecimal salary = new BigDecimal(90000);
        when(taxCalculatorService.calculateTax(salary,year)).thenReturn(getSalaryTaxResponse());
        ResponseEntity<Object> objectResponseEntity = taxCalculatorController.getTaxedSalary(2021,new BigDecimal(90000));
        Assertions.assertTrue(objectResponseEntity.getStatusCode().is2xxSuccessful());
    }

}