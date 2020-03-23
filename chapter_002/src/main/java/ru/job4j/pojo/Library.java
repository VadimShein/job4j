package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book firstBook = new Book("Clean code", 120);
        Book secondBook = new Book("php", 100);
        Book thirdBook = new Book("java", 150);
        Book fourthBook = new Book("c++", 210);

        Book[] programming = new Book[4];
        programming[0] = firstBook;
        programming[1] = secondBook;
        programming[2] = thirdBook;
        programming[3] = fourthBook;


        for (int index = 0; index < programming.length; index++) {
            System.out.println(programming[index].getName() + " " + programming[index].getCount());
        }
        System.out.println();

        Book tempBook;
        tempBook = programming[0];
        programming[0] = programming[3];
        programming[3] = tempBook;

        System.out.println("Replace book");
        for (int index = 0; index < programming.length; index++) {
            System.out.println(programming[index].getName() + " " + programming[index].getCount());
        }
        System.out.println();

        System.out.println("book search");
        for (int index = 0; index < programming.length; index++) {
            if (programming[index].getName().equals("Clean code")) {
                System.out.println(programming[index].getName() + " " + programming[index].getCount());
            }
        }
    }
}
