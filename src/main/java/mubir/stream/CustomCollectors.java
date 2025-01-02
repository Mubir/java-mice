package mubir.stream;

import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/***
 * https://docs.oracle.com/javase/8/docs/api/java/util/stream/Collector.html
 */
public class CustomCollectors {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("The quick", "fox jumped", "over the", "lazy dog");

        Collector<String, StringBuilder, String> customCollector = Collector.of(
                // Supplier: Provides the initial intermediate accumulator
                StringBuilder::new,
                // Accumulator: Adds elements to the intermediate accumulator
                StringBuilder::append,
                // Combiner: Combines two partial results (used in parallel streams)
                (left, right) -> {
                    left.append(right);
                    return left;
                },
                // Finisher: Converts the accumulator to the final result
                StringBuilder::toString
        );
        //  String result = stream.collect(customCollector);
        //  System.out.println(result);

        Collector<String, StringBuilder, String> spaceSeparated = Collector.of(
                () -> new StringBuilder(),
                (builder, str) -> builder.append(str + " "),
                (left, right) -> {
                    left.append(right);
                    return left;
                },
                builder -> builder.toString()
        );

        String result2 = stream.collect(spaceSeparated);
        System.out.println(result2);
    }

}
