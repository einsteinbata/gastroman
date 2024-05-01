package com.bata.exemp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@Entity(name = "Bill")
@Table(name = "table_bills")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id")
    private Long billId;

    @Column(name = "tableCod")
    private int table;

    @Column(name = "opening_date", nullable = false)
    private Date openingDate;

    @Column(name = "closing_date")
    private Date closingDate;

    @Column(name = "total")
    private BigDecimal total;

    @Column(name = "state")
    private String state;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_bill_id", referencedColumnName = "bill_id")
    private List<Order> orders;

}
