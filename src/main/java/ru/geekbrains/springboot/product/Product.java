package ru.geekbrains.springboot.product;

import lombok.Data;

@Data
public class Product {

    final Long id;
    final String title;
    final Double cost;

    @Override
    public String toString() {
        return title + " - " + cost + "$";
    }
}
