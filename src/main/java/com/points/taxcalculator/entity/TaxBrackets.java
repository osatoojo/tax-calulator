package com.points.taxcalculator.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class TaxBrackets implements Serializable {

    private static final long serialVersionUID = 7514242753748293996L;

    @JsonProperty("tax_brackets")
    private List <TaxBracket> taxBrackets;
}
