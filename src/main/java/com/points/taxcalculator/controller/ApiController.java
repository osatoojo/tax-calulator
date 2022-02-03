package com.points.taxcalculator.controller;


import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * all the api paths used in the controllers are defined here
 */
@CrossOrigin
public abstract class ApiController {

    static final String BASE_PATH = "/api/v1/";
    static final String YEAR = "year";
    static final String SALARY = "salary";
}
