package ru.job4j.pojo;

public class Shop {
    public static Product[] delete(Product[] products, int index) {
        products[index] = null;
        for (int i = index; i < products.length; i++) {
            if (i < products.length - 1) {
                products[i] = products[i + 1];
                products[i + 1] = null;
            }
        }
        return products;
    }

    public static void main(String[] args) {
        Product[] products = new Product[5];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);

        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                System.out.println(products[i].getName());
            } else {
                System.out.println("null");
            }
        }
        delete(products, 1);
        System.out.println("");
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                System.out.println(products[i].getName());
            } else {
                System.out.println("null");
            }
        }
    }
}