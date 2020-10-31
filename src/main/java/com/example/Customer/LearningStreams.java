package com.example.Customer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.Thread.sleep;

public class LearningStreams {


    public static void main(String[] args) throws IOException {
        //   IntStream.range(1,10).sorted().skip(5).forEach(x-> System.out.println(x));
        // IntStream.range(1,10).filter(value -> false ).forEach(x-> System.out.println(x));
        //   IntStream.range(1,10).forEach(System.out::print);
//       int a =  IntStream.range(1,10).sum();
//        System.out.println(a);
//
//        Stream.of("Shankar","Pranai","Deepa","Dhruv").sorted().findFirst().ifPresent(x-> System.out.println(x));
//
//        String[] aa = {"Saanar","Second Shankar","deepa","pranavi","dhruv"};
//
//        Arrays.stream(aa).filter(s -> s.startsWith("S")).sorted().forEach(s -> System.out.println(s));
//
//        Arrays.stream(new int[] { 2,1,3}).map(x->x*x).average().ifPresent(System.out::println);


//        List<String> name = Arrays.asList("Shankar","deepa","Pranu","Dhruv");
//        name.stream()
//                .map(String::toLowerCase)
//                .map(String::length)
//               // .filter(s -> s.startsWith("s"))
//                .forEach(System.out::println);

//        Stream<String> bands = Files.lines(Paths.get("C:\\Users\\shank\\git\\demo\\src\\main\\bands.txt"));
//        bands.sorted().map(String::toLowerCase).filter(x -> x.startsWith("s")).filter(x -> x.length() > 1).forEach(System.out::println);
//        bands.close();


        List<String> bands2 = Files.lines(Paths.get("C:\\Users\\shank\\git\\demo\\src\\main\\bands.txt"))
                .filter(x -> x.length() > 2)
                .collect(Collectors.toList());

        bands2.forEach(x -> System.out.println(x));


        Stream<String> bands3 = Files.lines(Paths.get("C:\\Users\\shank\\git\\demo\\src\\main\\data.txt"));

        int rowcount = (int) bands3.map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .filter(x -> Integer.parseInt(x[1]) > 1)
                .count();

        System.out.println(rowcount + "rows");
        bands3.close();


        Stream<String> bands4 = Files.lines(Paths.get("C:\\Users\\shank\\git\\demo\\src\\main\\data.txt"));

        bands4.map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .filter(x -> Integer.parseInt(x[1]) > 1)
                .forEach(x -> System.out.println(x[0]));
        bands4.close();


        Stream<String> bands5 = Files.lines(Paths.get("C:\\Users\\shank\\git\\demo\\src\\main\\data.txt"));

        Map<String, Integer> map = new HashMap<>();

        map = bands5.map(x -> x.split(","))
                .parallel()
                .filter(x -> x.length == 3)
                .filter(x -> Integer.parseInt(x[1]) >= 2)
                .collect(Collectors.toMap(
                        x -> x[0],
                        x -> Integer.parseInt(x[1])));

        bands5.close();

        for (String key : map.keySet()) {
            System.out.println(key + map.get(key));
        }


        double total = Stream.of(2.3, 8.6)
                .reduce(0.0, (Double a, Double b) -> a + b);

        System.out.println("Total::" + total);


        IntSummaryStatistics summaryStatistics = IntStream.of(7, 6, 67, 8, 9, 9, 0, 222)
                .summaryStatistics();

        System.out.println("summaryStats::" + summaryStatistics);


        System.out.println("***************");
        Stream<Integer> makedouble = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println(
                makedouble.filter(x -> x % 2 == 0)
                        .mapToInt(x -> x * 2)
                        .sum());


        Stream<Integer> num = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        num.map(x -> {
            try {
                return LearningStreams.transform(x);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return x;
        })
                .forEach(System.out::print);

        System.out.println();
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        numbers.parallelStream().map(x-> {
            try {
                return transform(x);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return x;
        }).forEach(System.out::print);





    }

    static int transform(int x) throws InterruptedException {
        sleep(1000);
       // System.out.print(",");
        return x * 1;
    }



}
