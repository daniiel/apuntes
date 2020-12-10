import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreams {

    public static void main(String[] args) {
        JavaStreams streams = new JavaStreams();

        streams.intStream();
        streams.intStreamWith_skip();
        streams.intStreamWith_sum();
        streams.streamOfWith_sortAndFindFirst();
        streams.streamFromArrayWith_sortAndFilter();
        streams.streamWith_mapAndAverage();
        streams.steamFromListWith_filterAndPrint();
        streams.streamFromListWith_collect();
        streams.streamWith_reduce();
        streams.streamWith_summaryStatistics();
    }

    public void intStream() {
        System.out.println(">> Integer Stream");
        IntStream.range(1, 10).forEach(System.out::print); // reference operator
    }

    public void intStreamWith_skip() {
        System.out.println(">> Integer Stream with SKIP");
        IntStream.range(1, 5)
                .skip(2)
                .forEach(x -> System.out.println(x)); // lambda expression
    }

    public void intStreamWith_sum() {
        System.out.println(">> Integer Stream with SUM");
        System.out.println( IntStream.range(1, 5).sum() );
    }

    public void streamOfWith_sortAndFindFirst() {
        System.out.println(">> Stream with SORT and FIND FIRST");
        Stream.of("Darth Vader", "Luke Skywalker", "Leia Organa", "Han Solo")
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);
    }

    public void streamFromArrayWith_sortAndFilter() {
        System.out.println(">> Stream with SORT and FILTER");
        String[] names = {"Darth", "Vader", "Luke", "Skywalker", "Leia", "Organa", "Han", "Solo"};
        Arrays.stream(names)    // same as Stream.of(names)
                .filter(x -> x.startsWith("S"))
                .sorted()
                .forEach(System.out::println);
    }

    public void streamWith_mapAndAverage() {
        System.out.println(">> Stream squares of an INT");
        Arrays.stream(new int[] {2, 4, 6, 8, 10})
                .map(x -> x * x)
                .average()
                .ifPresent(System.out::println);
    }

    public void steamFromListWith_filterAndPrint() {
        System.out.println(">> Stream from LIST with FILTER ");
        List<String> people = Arrays.asList("Al", "Ankit", "Brent", "Sarika", "amanda", "Hans");
        people.stream()
            .map(String::toLowerCase)
            .filter(x -> x.startsWith("a"))
            .forEach(System.out::println);
    }

    public void streamFromListWith_collect() {
        System.out.println(">> Stream from COLLECTION ");
        List<String> people = Arrays.asList("Al", "Ankit", "Brent", "Sarika", "amanda", "Hans");
        List<String> containsA = people.stream()
                .filter(x -> x.contains("a"))
                .collect(Collectors.toList()); // create a collection with the elements
        containsA.forEach(System.out::println);
    }

    public void streamWith_reduce() {
        System.out.println(">> Stream with REDUCE ");
        double total = Stream.of(7.3, 1.5, 4.8)
                .reduce(0.0, (Double a, Double b) -> a +b );
        System.out.println("Total: " + total);
    }

    public void streamWith_summaryStatistics() {
        System.out.println(">> Stream with SUMMARY_STATISTICS ");
        IntSummaryStatistics summary = IntStream.of(7, 2, 19, 88, 73, 4, 10)
                .summaryStatistics();
        System.out.println(summary); // IntSummaryStatistics{count=7, sum=203, min=2, average=29,000000, max=88}
    }
}
