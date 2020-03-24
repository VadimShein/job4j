package ru.job4j.pojo;

import java.util.Objects;

public class Product {
    private String name;
    private int count;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return count == product.count && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, count);
    }

    public Product(String name, int count) {
        this.name = name;
        this.count = count;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public Product[] delete(Product[] products, int index) {
        products[index] = null;
        for (int i = 0; i < products.length; i++) {
            if (i == products.length - 1) {
                products[i] = null;
            } else if (products[i] == null) {
                products[i] = products[i + 1];
                products[i + 1] = null;
            }
        }
        return products;
    }
}