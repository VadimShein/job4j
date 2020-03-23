package ru.job4j.polo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Shein Vadim");
        student.setGroup("A1");
        student.setCreated(new Date());

        System.out.println(student.getFullName() + " is studying in " + student.getGroup()
                + " group at " + student.getCreated());
    }
}
