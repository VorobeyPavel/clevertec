package ru.clevertec.check.bean;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    int id;
    String name;
    double priceProduct;
    int count;
    double priceTotal;

    public Product(int id, int count) {
        this.id = id;
        this.count = count;
    }

    public Product(int id, String name, double priceProduct) {
        this.id = id;
        this.name = name;
        this.priceProduct = priceProduct;
    }
}
