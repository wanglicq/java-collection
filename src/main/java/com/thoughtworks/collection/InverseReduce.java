package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class InverseReduce {

    private Random random = new Random();

    public InverseReduce() {}

    public InverseReduce(Random random) {
        this.random = random;
    }

    public List<Integer> divideToSmaller(int number) {
        List<Integer> resultList = new ArrayList<>();
        int count = number / random.nextInt(3);
        for (int i = 0; i < count; i++) {
            number -= random.nextInt(3);
            resultList.add(number);
        }
        return resultList;
    }
}
