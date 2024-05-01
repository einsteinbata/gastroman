package com.bata.gastroman.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@ToString
@Entity(name = "MenuItem")
@Table(name = "menu_item")
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_item")
    Long codItem;

    @Column(name = "item_name", nullable = false)
    String itemName;

    @Column(name = "category")
    String category;

    @Column(name = "details")
    String details;

    @Column(name = "unit_price")
    BigDecimal unitPrice;

    @Column(name = "restrictions")
    List<String> restrictions;

    @Column(name = "alergens")
    List<String> alergens;

}
