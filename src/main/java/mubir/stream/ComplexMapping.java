package mubir.stream;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ComplexMapping {

    enum GENDER {
        MALE,
        FEMALE
    }

    enum CITY {
        TOKYO,
        OSAKA,
        FUKUOKA
    }

    public record Person(int id, int age, String name, CITY city, GENDER gender) {
    }

    public static void main(String[] args) {

        List<Person> personList = List.of(
                new Person(12, 25, "Ciara Jerry", CITY.TOKYO, GENDER.FEMALE),
                new Person(86, 29, "Lexin Karma", CITY.OSAKA, GENDER.FEMALE),
                new Person(94, 20, "Arinando jake", CITY.FUKUOKA, GENDER.MALE),
                new Person(30, 31, "MIPO GDL", CITY.TOKYO, GENDER.MALE),
                new Person(24, 23, "Ren dal", CITY.FUKUOKA, GENDER.FEMALE),
                new Person(56, 19, "Laix aloga", CITY.OSAKA, GENDER.FEMALE),
                new Person(45, 77, "Hondon Kumar", CITY.TOKYO, GENDER.MALE)
        );

        // create person id-> obj

        Map<Integer, Person> idToPerson = personList.stream().collect(
                Collectors.toMap(
                        Person::id,
                        Function.identity(),// its like t -> t
                        (p1, p2) -> p1 // if collide one will be taken.
                ));
        System.out.println("#########################");
        System.out.println("id-> obj " + idToPerson);
        System.out.println("#########################");

        // create a gender to map of list
        Map<GENDER, List<Person>> genderListMap = personList.stream().collect(
                Collectors.groupingBy(
                        Person::gender
                )
        );
        System.out.println("Gender to List " + genderListMap);
        System.out.println("#########################");

        // create a map of gender to list of person name
        Map<GENDER, List<String>> genderNameList = personList.stream().collect(
                Collectors.groupingBy(
                        Person::gender,
                        Collectors.mapping(
                                Person::name,
                                Collectors.toList()
                        )
                )
        );
        System.out.println("Gender to person's list " + genderNameList);
        System.out.println("#########################");

        // create a map of gender to count of person list
        Map<GENDER, Long> countByGender =
                personList.stream().collect(
                        Collectors.groupingBy(
                                Person::gender,
                                Collectors.counting()
                        )
                );
        System.out.println("Count of person by gender" + countByGender);
        System.out.println("#########################");

        // mapof gender -> map of city -> count
        Map<GENDER, Map<CITY, Long>> towDMap =
                personList.stream().collect(
                        Collectors.groupingBy(
                                Person::gender,
                                Collectors.groupingBy(
                                        Person::city,
                                        Collectors.counting()
                                )
                        )
                );
        System.out.println("Gender to city to count" + towDMap);
        System.out.println("#########################");

        // access this:
        Long count = towDMap
                .computeIfAbsent(GENDER.MALE, p -> new HashMap<>())
                .getOrDefault(CITY.TOKYO, 0L);
        System.out.println(count);
    }
}
