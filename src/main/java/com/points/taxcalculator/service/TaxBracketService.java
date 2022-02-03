package com.points.taxcalculator.service;

import com.points.taxcalculator.entity.TaxBracket;
import com.points.taxcalculator.exception.RemoteServerException;

import java.util.List;

public interface TaxBracketService {

    List<TaxBracket> getTaxBrackets(int year) throws RemoteServerException;
}
