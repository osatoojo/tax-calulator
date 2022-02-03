package com.points.taxcalculator.service;

import com.points.taxcalculator.entity.SalaryTaxResponse;
import com.points.taxcalculator.exception.RemoteServerException;

import java.math.BigDecimal;

public interface TaxCalculatorService {
    SalaryTaxResponse calculateTax(BigDecimal salary, int year) throws RemoteServerException;
}
