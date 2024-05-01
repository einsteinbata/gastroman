package com.bata.gastroman.constants;

import lombok.Getter;

@Getter
public enum MenuItemCategory {
    APPETIZER ("Aperitivo", "Starter"),
    BREAKFAST ("Pequeno-Almoço", "Breakfast"),
    ENTREE ("Entrada", "Entrée"),
    MAIN ("Prato Principal", "Main Course"),
    DESSERT ("Sobremesa", "Dessert"),
    SIDE ("Acompanhamento", "Side Dish"),
    ALCOHOLIC_BEVERAGE ("Bebidas Alcoólicas", "Alcoholic Drinks"),
    NON_ALCOHOLIC_BEVERAGE ("Bebias Não-Alcoólicas", "Non Alcoholic Drinks");

    private String ptName;
    private String enName;

    MenuItemCategory(String ptName, String enName){
        this.ptName = ptName;
        this.enName = enName;
    }

}
