package com.points.taxcalculator.controller;

import com.points.taxcalculator.exception.RemoteServerException;
import com.points.taxcalculator.service.TaxCalculatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

import static com.points.taxcalculator.controller.ApiController.*;

/**
 * <p>
 * Tax Calculator apis
 */
@RestController
@RequestMapping(ApiController.BASE_PATH)
@Slf4j
@CrossOrigin
public class TaxCalculatorController {

    private final TaxCalculatorService taxCalculatorService;


    public TaxCalculatorController(TaxCalculatorService taxCalculatorService) {
        this.taxCalculatorService = taxCalculatorService;
    }

    /**
     * api to get Taxed Salary
     *
     * @param salary -
     * @return
     */
    @GetMapping(value = YEAR + "/{year}/" + SALARY + "/{salary}")
    public ResponseEntity<Object> getTaxedSalary(@PathVariable int year, @PathVariable BigDecimal salary) {
        try {
            return ResponseEntity.status(200).body(taxCalculatorService.calculateTax(salary, year));
        } catch (RemoteServerException e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}
