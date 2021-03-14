package ru.netology.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@Data
@EqualsAndHashCode(callSuper = true)

public class TShirt extends Product {
    private String color;
    private String size;

    public TShirt() {
        super();
    }

    public TShirt(int id, String name, int price, String color, String size) {
        super(id, name, price);
        this.color = color;
        this.size = size;
    }
}





