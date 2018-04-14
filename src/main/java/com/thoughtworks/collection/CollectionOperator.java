package com.thoughtworks.collection;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        if (left < right) {
            return Stream.iterate(left, number -> number + 1).limit(right - left + 1).collect(Collectors.toList());
        } else {
            return Stream.iterate(left, number -> number - 1).limit(left - right + 1).collect(Collectors.toList());
        }
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        return getListByInterval(left, right).stream().filter(number -> number % 2 == 0).collect(Collectors.toList());
    }

    public List<Integer> popEvenElments(int[] array) {
        return Arrays.stream(array).filter(number -> number % 2 == 0).mapToObj(Integer::valueOf).collect(Collectors.toList());
    }

    public int popLastElment(int[] array) {
        return array[array.length - 1];
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();
        for (int element : firstArray) {
            firstList.add(element);
        }
        for (int element : secondArray) {
            secondList.add(element);
        }
        firstList.retainAll(secondList);
        return firstList;
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> firstList = Stream.of(firstArray).collect(Collectors.toList());
        List<Integer> secondList = Stream.of(secondArray).collect(Collectors.toList());
        secondList.removeAll(firstList);
        firstList.addAll(secondList);
        return firstList;
    }
}
