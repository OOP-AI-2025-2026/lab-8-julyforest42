package ua.opnu;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        // Завдання 1
        // 1. Порожнє значення (наприклад, у користувача немає по-батькові)
        MyOptional<String> middleName = new MyOptional<>();
        System.out.println(middleName); // MyOptional[empty]
        System.out.println("isPresent: " + middleName.isPresent()); // false
        System.out.println("orElse: " + middleName.orElse("немає")); // "немає"

        // 2. Заповнене значення (наприклад, логін користувача)
        MyOptional<String> username = new MyOptional<>("admin");
        System.out.println(username); // MyOptional[value=admin]
        System.out.println("isPresent: " + username.isPresent()); // true
        System.out.println("get(): " + username.get()); // "admin"
        System.out.println("orElse: " + username.orElse("guest")); // "admin"

        // 3. Перевіримо, що get() на порожньому об'єкті кидає помилку
        try {
            String test = middleName.get(); // має кинути IllegalStateException
            System.out.println("unexpected: " + test);
        } catch (IllegalStateException ex) {
            System.out.println("Очікуваний виняток: " + ex.getMessage());
        }

        // 4. Перевіримо, що конструктор не приймає null
        try {
            MyOptional<String> broken = new MyOptional<>(null);
            System.out.println("unexpected: " + broken);
        } catch (IllegalArgumentException ex) {
            System.out.println("Правильно не дозволив null: " + ex.getMessage());
        }

        // Завдання 2
        BookData b1 = new BookData("Java Basics", "Smith", 10, 40.0);  // rating = 4.0
        BookData b2 = new BookData("Advanced Java", "Brown", 5, 25.0); // rating = 5.0
        BookData b3 = new BookData("Algorithms", "Knuth", 10, 45.0);   // rating = 4.5
        BookData b4 = new BookData("Advanced Java", "White", 0, 0.0);  // rating = 0.0

        List<BookData> books = Arrays.asList(b1, b2, b3, b4);
        System.out.println("До сортування:");
        for (BookData b : books) {
            System.out.println(b);
        }

        Collections.sort(books);

        System.out.println("\nПісля сортування:");
        for (BookData b : books) {
            System.out.println(b);
        }

        // Завдання 3
        Printer myPrinter = new Printer();
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);

        // Завдання 4

        Integer[] numbers = {1, 2, 3, 4, 5, 6};
        Integer[] evens = GenericsUtils.filter(numbers, value -> value % 2 == 0);

        System.out.println("Парні числа: " + Arrays.toString(evens));

        String[] words = {"Java", "Kotlin", "Python", "JavaScript"};
        String[] jWords = GenericsUtils.filter(words, value -> value.startsWith("J"));

        System.out.println("Слова, що починаються на 'J': " + Arrays.toString(jWords));

        // Завдання 5
        String[] langArray = {"Java", "C++", "Python"};
        boolean containsJava = GenericsUtils.contains(langArray, "Java");
        boolean containsGo = GenericsUtils.contains(langArray, "Go");
        System.out.println("Масив містить 'Java': " + containsJava);
        System.out.println("Масив містить 'Go': " + containsGo);

        Integer[] intArr = {10, 20, 30};
        boolean contains20 = GenericsUtils.contains(intArr, 20);
        boolean contains40 = GenericsUtils.contains(intArr, 40);
        System.out.println("Масив містить 20: " + contains20);
        System.out.println("Масив містить 40: " + contains40);

        // Завдання 6
        GenericTwoTuple<String, Integer> tuple1 = new GenericTwoTuple<>("Оцінка з Java", 95);
        System.out.println("Двійковий кортеж: " + tuple1);

        GenericThreeTuple<String, Integer, Boolean> tuple2 =
                new GenericThreeTuple<>("Оцінка з БД", 88, Boolean.TRUE);
        System.out.println("Трійковий кортеж: " + tuple2);

        System.out.println("tuple2.first = " + tuple2.getFirst());
        System.out.println("tuple2.second = " + tuple2.getSecond());
        System.out.println("tuple2.three = " + tuple2.getThree());
    }
}
