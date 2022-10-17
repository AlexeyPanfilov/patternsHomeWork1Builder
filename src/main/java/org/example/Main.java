package org.example;

public class Main {
    public static void main(String[] args) {
        Person person = new PersonBuilder()
                .address("Не дом и не улица")
                .name("Вася")
                .lastName("Шмидт")
                .age(25)
                .build();
        System.out.println(person);
        person.happyBirthday();
        Person son = person.newChildBuilder()
                .name("Антошка")
                .build();
        System.out.println("У " + person + " есть сын " + son);

        Person person1 = new PersonBuilder()
                .name("Vlad")
                .lastName(("Petrov"))
                .build();
        System.out.println(person1);

        try {
            Person noName = new PersonBuilder()
                    .lastName("Ivanov")
                    .build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            Person negAge = new PersonBuilder()
                    .lastName("Ivanov")
                    .name("Evgeniy")
                    .age(-15)
                    .build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}