package com.points.taxcalculator.controller;

import com.points.taxcalculator.entity.SalaryTaxResponse;
import com.points.taxcalculator.service.TaxCalculatorService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TaxCalculatorController.class)
class TaxCalculatorControllerITest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TaxCalculatorService taxCalculatorService;

    static final String BASE_PATH = "/api/v1/";


    private Map<Integer, Double> getTaxPerBand() {
        Map<Integer, Double> taxBands = new HashMap<>();
        taxBands.put(1,20000.0);
        taxBands.put(2,40000.0);
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
    void test_givenSalary_thenGetTaxedSalary() throws Exception {
        BigDecimal salary = new BigDecimal(60000);
        int year = 2021;
        given(taxCalculatorService.calculateTax(salary,2021)).willReturn(getSalaryTaxResponse());
        mvc.perform(get(BASE_PATH + "year/"+year+"/salary/" + salary)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.effectiveTaxRate", is(35.0)));
    }

}