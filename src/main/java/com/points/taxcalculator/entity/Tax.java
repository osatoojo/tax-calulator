package com.points.taxcalculator.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tax")
public class Tax implements Serializable {

    private static final long serialVersionUID = -6592953780284932082L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "min_amount")
    private long minAmount;

    @Column(name = "max_amount")
    private long maxAmount;

    @Column(name = "rate")
    private long rate;

    @Column(name = "filling_status")
    private String fillingStatus;

    @Column(name = "year")
    private int year;

}
