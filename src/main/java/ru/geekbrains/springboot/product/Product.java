package ru.geekbrains.springboot.product;

import lombok.Data;

@Data
public class Product {

    final int id;
    final String title;
    final int cost;

    @Override
    public String toString() {
        return title + " - " + cost + "$";
    }
}
