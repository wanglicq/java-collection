package com.thoughtworks.collection;


import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InverseReduce {

    private Random random = new Random();

    public InverseReduce() {}

    public InverseReduce(Random random) {
        this.random = random;
    }

    public List<Integer> divideToSmaller(int number) {
        int divider = random.nextInt(3);
        int count = number / divider;
        return Stream.iterate(number - divider, num -> num - divider).limit(count).collect(Collectors.toList());
    }
}
