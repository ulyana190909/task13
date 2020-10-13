package ru.netology.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SmartPhone extends Product {
    private String manufacturer;

    public SmartPhone(int id, String name, int price, String manufacturer) {
        super(id, name, price);
        this.manufacturer = manufacturer;
    }

    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        if (search.equalsIgnoreCase(manufacturer)) {
            return true;
        }
        return false;
    }

}