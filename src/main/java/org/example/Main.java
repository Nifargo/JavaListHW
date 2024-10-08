package org.example;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        Дано список чисел. Потрібно знайти середнє значення
        List<Integer> list1 = List.of(1, 2, 3, 4, 5, 6, 8, 9, 10);
        Stream<Integer> stream1 = list1.stream();
        System.out.println("Result is" + " " + stream1.mapToInt(value -> value.intValue()).average());

//        2. Дано список String. Отримати список з перетвореними усіма рядками в uppercase.
        List<String> list2 = List.of("anna", "ben", "can", "did", "empty", "five", "go", "hey");
        Stream<String> stream2 = list2.stream();
        stream2.map(s -> s.toUpperCase()).forEach(System.out::println);

//        3. Дано список чисел. Знайти усі парні числа.
        List<Integer> list = List.of(1, 2, 3, 4, 5, 67, 8, 9, 10);
        Stream<Integer> stream = list.stream();
        stream.filter(i -> i % 2 == 0).forEach(System.out::println);

//        Дано список String. Знайти усі рядки котрі починаються на велику літеру.
        List<String> list3 = List.of("Anna", "ben", "Can", "did", "Empty", "five", "go", "Hey");
        Stream<String> stream3 = list3.stream();
        stream3.filter(s -> Character.isUpperCase(s.charAt(0))).forEach(System.out::println);

//        Дано список чисел. Знайти максимальне і мінімальне число.
        List<Integer> list4 = List.of(1, 2, 3, 4, 5, 6, 8, 9, 10);
        List<Integer> list44 = List.of();
        Stream<Integer> stream4Max = list4.stream();
        Stream<Integer> stream4Min = list4.stream();
        Integer minimum = list44.stream().min(Integer::compareTo).orElse(0);
        System.out.println("Look here" + minimum);
//        stream4Min.min(Integer::compareTo).ifPresent(System.out::println);
//        stream4Max.max((a, b) -> a.compareTo(b)).ifPresent(System.out::println);


//        Дано список чисел. Відсортувати числа по зростанню.
        List<Integer> list5 = List.of(10, 2, 3, 9, 5, 6, 8, 4, 1);
        Stream<Integer> stream5 = list5.stream();
        stream5.sorted().forEach(System.out::println);

//        Двно список Users. User
//        Отримати список з усіма іменами
        List<String> list6 = List.of("Anna", "Ben", "Cindy", "Anna", "Robert", "Roy", "Gwen", "Ben", "Anna");
        Stream<String> stream6 = list6.stream();
        stream6.forEach(System.out::println);

//        7.2. Отримати список з усіма унікальними іменами
        List<String> list7 = List.of("Anna", "Ben", "Cindy", "Anna", "Robert", "Roy", "Gwen", "Ben", "Anna");
        Stream<String> stream7 = list7.stream();
        stream7.distinct().forEach(System.out::println);

//        Двно список Users з датами нарождення.
//        7.1. Отримати список з усіма іменами
        HashMap<String, List<Integer>> list8 = new HashMap<>();
        list8.put("Anna", new ArrayList<>(List.of(1990)));
        list8.put("Ben", new ArrayList<>(List.of(1993)));
        list8.put("Cindy", new ArrayList<>(List.of(1992)));
        list8.get("Anna").add(1996);
        list8.put("Robert", new ArrayList<>(List.of(1991)));
        list8.put("Roy", new ArrayList<>(List.of(1994)));
        list8.put("Gwen", new ArrayList<>(List.of(1995)));
        List<String> stream8 = list8.entrySet().stream().flatMap(e -> Stream.generate(() -> e.getKey()).limit(e.getValue().size()))
                .toList();
        ;
        System.out.println("Result is" + " " + stream8);

        //        7.2. Отримати список з усіма унікальними іменами
        HashMap<String, List<Integer>> list9 = new HashMap<>();
        list9.put("Anna", new ArrayList<>(List.of(1990)));
        list9.put("Ben", new ArrayList<>(List.of(1993)));
        list9.put("Cindy", new ArrayList<>(List.of(1992)));
        list9.get("Anna").add(1996);
        list9.put("Robert", new ArrayList<>(List.of(1991)));
        list9.put("Roy", new ArrayList<>(List.of(1994)));
        list9.put("Gwen", new ArrayList<>(List.of(1995)));
        List<String> stream9 = list9.keySet().stream().toList();
        System.out.println("Result is" + " " + stream9);

//        Відсортувати елементи по даті народження
        HashMap<String, List<Integer>> list10 = new HashMap<>();
        list10.put("Anna", new ArrayList<>(List.of(1990)));
        list10.put("Ben", new ArrayList<>(List.of(1993)));
        list10.put("Cindy", new ArrayList<>(List.of(1992)));
        list10.get("Anna").add(1996);
        list10.put("Robert", new ArrayList<>(List.of(1991)));
        list10.put("Roy", new ArrayList<>(List.of(1994)));
        list10.put("Gwen", new ArrayList<>(List.of(1995)));
        List<Map.Entry<String, Integer>> sortedUsers = list10.entrySet().stream()
                .flatMap(e -> e.getValue().stream().map(birthYear -> new AbstractMap.SimpleEntry<>(e.getKey(), birthYear)))
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList());
        System.out.println("Birthday is" + " " + sortedUsers);

//        7.4. Вивести найстаршого User
        HashMap<String, List<Integer>> list11 = new HashMap<>();
        list11.put("Anna", new ArrayList<>(List.of(1990)));
        list11.put("Ben", new ArrayList<>(List.of(1993)));
        list11.put("Cindy", new ArrayList<>(List.of(1992)));
        list11.get("Anna").add(1996);
        list11.put("Robert", new ArrayList<>(List.of(1991)));
        list11.put("Roy", new ArrayList<>(List.of(1994)));
        list11.put("Gwen", new ArrayList<>(List.of(1995)));
        Optional<AbstractMap.SimpleEntry<String, Integer>> sortedUsers1 = list11.entrySet().stream()
                .flatMap(e -> e.getValue().stream().map(birthYear -> new AbstractMap.SimpleEntry<>(e.getKey(), birthYear)))
                .max(Map.Entry.comparingByValue());
        System.out.println("Oldest user is" + " " + sortedUsers1);

//        Створити Map: ключ - дата народження, значення - кількість таких User
        HashMap<String, List<Integer>> list12 = new HashMap<>();
        list12.put("Anna", new ArrayList<>(List.of(1990)));
        list12.put("Ben", new ArrayList<>(List.of(1993)));
        list12.put("Cindy", new ArrayList<>(List.of(1992)));
        list12.get("Anna").add(1996);
        list12.put("Robert", new ArrayList<>(List.of(1990)));
        list12.put("Roy", new ArrayList<>(List.of(1994)));
        list12.put("Gwen", new ArrayList<>(List.of(1995)));
        Map<Integer, Long> sortedUsers2 = list12.entrySet().stream()
                .flatMap(e -> e.getValue().stream().map(birthYear -> new AbstractMap.SimpleEntry<>(e.getKey(), birthYear)))
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.counting()));
        System.out.println("Map is" + " " + sortedUsers2);

        //        Створити Map: ключ - дата народження, значення - список таких Users
        HashMap<String, List<Integer>> list13 = new HashMap<>();
        list13.put("Anna", new ArrayList<>(List.of(1990)));
        list13.put("Ben", new ArrayList<>(List.of(1993)));
        list13.put("Cindy", new ArrayList<>(List.of(1992)));
        list13.get("Anna").add(1996);
        list13.put("Robert", new ArrayList<>(List.of(1990)));
        list13.put("Roy", new ArrayList<>(List.of(1994)));
        list13.put("Gwen", new ArrayList<>(List.of(1995)));
        Map<Integer, List<String>> sortedUsers3 = list13.entrySet().stream()
                .flatMap(e -> e.getValue().stream().map(birthYear -> new AbstractMap.SimpleEntry<>(e.getKey(), birthYear)))
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
        System.out.println("Map is" + " " + sortedUsers3);


//        Отримати список з усіма іменами User
        List<User> list14 = List.of(new User("Anna", 1990), new User("Ben", 1993), new User("Cindy", 1992), new User("Anna", 1996),
                new User("Robert", 1990), new User("Roy", 1994), new User("Gwen", 1995));
        list14.stream().map(User -> User.getName()).forEach(System.out::println);
//
//        Отримати список з усіма унікальними іменами User
        List<User> list15 = List.of(new User("Anna", 1990), new User("Ben", 1993), new User("Cindy", 1992), new User("Anna", 1996),
                new User("Robert", 1990), new User("Roy", 1994), new User("Gwen", 1995));
        list15.stream().map(User -> User.getName()).distinct().forEach(System.out::println);

//        Відсортувати елементи по даті народження User
        List<User> list16 = List.of(new User("Anna", 1990), new User("Ben", 1993), new User("Cindy", 1992), new User("Anna", 1996),
                new User("Robert", 1990), new User("Roy", 1994), new User("Gwen", 1995));
        list16.stream().sorted(Comparator.comparing(User::getAge)).forEach(System.out::println);

//        Вивести найстаршого User
        List<User> list17 = List.of(new User("Anna", 1990), new User("Ben", 1993), new User("Cindy", 1992), new User("Anna", 1996),
                new User("Robert", 1990), new User("Roy", 1994), new User("Gwen", 1995));
        list17.stream().max(Comparator.comparing(User::getAge)).ifPresent(System.out::println);

//        Створити Map: ключ - дата народження, значення - кількість таких User
        List<User> list18 = List.of(new User("Anna", 1990), new User("Ben", 1993), new User("Cindy", 1992), new User("Anna", 1996),
                new User("Robert", 1990), new User("Roy", 1994), new User("Gwen", 1995));
        Map<Integer, Long> sortedUsers4 = list18.stream()
                .collect(Collectors.groupingBy(User::getAge, Collectors.counting()));
        System.out.println("Map is" + " " + sortedUsers4);

//        Створити Map: ключ - дата народження, значення - список таких Users
        List<User> list19 = List.of(new User("Anna", 1990), new User("Ben", 1993), new User("Cindy", 1992), new User("Anna", 1996),
                new User("Robert", 1990), new User("Roy", 1994), new User("Gwen", 1995));
        Map<Integer, List<String>> sortedUsers5 = list19.stream().collect(Collectors.groupingBy(User::getAge, Collectors.mapping(User::getName, Collectors.toList())));
        System.out.println("Map is" + " " + sortedUsers5);
    }
}
