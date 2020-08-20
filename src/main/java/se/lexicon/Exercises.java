package se.lexicon;

import se.lexicon.data.DataStorage;
import se.lexicon.model.Gender;
import se.lexicon.model.Person;

import java.time.LocalDate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Exercises {

    private final static DataStorage storage = DataStorage.INSTANCE;

    /*
       1.	Find everyone that has firstName: “Erik” using findMany().
    */
    public static void exercise1(String message) {
        System.out.println(message);
        Predicate<Person> filter = p -> p.getFirstName().equalsIgnoreCase("Erik");
        storage.findMany(filter).forEach(System.out::println);
        System.out.println("----------------------");
    }

    /*
        2.	Find all females in the collection using findMany().
     */
    public static void exercise2(String message) {
        System.out.println(message);
        Predicate<Person> filter = p -> p.getGender().equals(Gender.FEMALE);
        storage.findMany(filter).forEach(System.out::println);
        System.out.println("----------------------");
    }

    /*
        3.	Find all who are born after (and including) 2000-01-01 using findMany().
     */
    public static void exercise3(String message) {
        System.out.println(message);
        Predicate<Person> filter = p -> p.getBirthDate().isAfter(LocalDate.of(2000, 1, 1).minusDays(1));
        storage.findMany(filter).forEach(System.out::println);
        System.out.println("----------------------");
    }

    /*
        4.	Find the Person that has an id of 123 using findOne().
     */
    public static void exercise4(String message) {
        System.out.println(message);
        Predicate<Person> filter = p -> p.getId() == 123;
        System.out.println(storage.findOne(filter));
        System.out.println("----------------------");
    }

    /*
        5.	Find the Person that has an id of 456 and convert to String with following content:
            “Name: Nisse Nilsson born 1999-09-09”. Use findOneAndMapToString().
     */
    public static void exercise5(String message) {
        System.out.println(message);
        Predicate<Person> filter = p -> p.getId() == 456;
        Function<Person, String> action = p -> "Name: " + p.getFirstName() + " " + p.getLastName() + " born " + p.getBirthDate();
        System.out.println(storage.findOneAndMapToString(filter, action));
        System.out.println("----------------------");
    }

    /*
        6.	Find all male people whose names start with “E” and convert each to a String using findManyAndMapEachToString().
     */
    public static void exercise6(String message) {
        System.out.println(message);
        Predicate<Person> filter = p -> p.getFirstName().startsWith("E") && p.getGender().equals(Gender.MALE);
        Function<Person, String> action = Person::toString;
        storage.findManyAndMapEachToString(filter, action).forEach(System.out::println);
        System.out.println("----------------------");
    }

    /*
        7.	Find all people who are below age of 10 and convert them to a String like this:
            “Olle Svensson 9 years”. Use findManyAndMapEachToString() method.
     */
    public static void exercise7(String message) {
        System.out.println(message);
        Predicate<Person> filter = p -> p.getBirthDate().isAfter(LocalDate.now().minusYears(9));
        Function<Person, String> action = p -> p.getFirstName() + " " + p.getLastName() + " " + LocalDate.now().compareTo(p.getBirthDate()) + " years";
        storage.findManyAndMapEachToString(filter, action).forEach(System.out::println);
        System.out.println("----------------------");
    }

    /*
        8.	Using findAndDo() print out all people with firstName “Ulf”.
     */
    public static void exercise8(String message) {
        System.out.println(message);
        Predicate<Person> filter = p -> p.getFirstName().equals("Ulf");
        Consumer<Person> consumer = System.out::println;
        storage.findAndDo(filter, consumer);
        System.out.println("----------------------");
    }

    /*
        9.	Using findAndDo() print out everyone who have their lastName contain their firstName.
     */
    public static void exercise9(String message) { // Note, random name list may not contain a match
        System.out.println(message);
        Predicate<Person> filter = p -> p.getLastName().toLowerCase().contains(p.getFirstName().toLowerCase());
        Consumer<Person> consumer = System.out::println;
        storage.findAndDo(filter, consumer);
        System.out.println("----------------------");
    }

    /*
        10.	Using findAndDo() print out the firstName and lastName of everyone whose firstName is a palindrome.
     */
    public static void exercise10(String message) {
        System.out.println(message);
        Predicate<Person> filter = p -> {
            int endIndex = p.getFirstName().length() - 1;
            for (int i = 0; i < endIndex; i++, endIndex--) {
                if (p.getFirstName().toLowerCase().charAt(i) != p.getFirstName().toLowerCase().charAt(endIndex)) { // Not palindrome
                    return false;
                }
            }
            return true;
        };
        Consumer<Person> consumer = System.out::println;
        storage.findAndDo(filter, consumer);
        System.out.println("----------------------");
    }


    /*
        11.	Using findAndSort() find everyone whose firstName starts with A sorted by birthdate.
     */
    public static void exercise11(String message) {
        System.out.println(message);
        //Write your code here

        System.out.println("----------------------");
    }

    /*
        12.	Using findAndSort() find everyone born before 1950 sorted reversed by lastest to earliest.
     */
    public static void exercise12(String message) {
        System.out.println(message);
        //Write your code here

        System.out.println("----------------------");
    }

    /*
        13.	Using findAndSort() find everyone sorted in following order: lastName > firstName > birthDate.
     */
    public static void exercise13(String message) {
        System.out.println(message);
        //Write your code here

        System.out.println("----------------------");
    }


//    public static void process(Person person) {
//        System.out.println(person);
//    }
//
//    public static void process(List<Person> display) {
//        for (Person person : display) {
//            System.out.println(person);
//        }
//    }

//    public static void process(List<String> display) {
//        for (String person : display) {
//            System.out.println(person);
//        }
//    }


}
