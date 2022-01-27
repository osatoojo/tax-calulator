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
@Table(name = "salary")
public class Salary implements Serializable {

    private static final long serialVersionUID = -5247855193339429622L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "amount")
    private long amount;

    @Column(name = "additional_amount")
    private long additionalAmount;

    @Column(name = "year")
    private int year;

//    @Column(name = "user_id")
//    private int userId;

    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "tax_id")
    private int taxId;

}
