package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        int min = left < right ? left : right;
        int max = left < right ? right : left;
        List<Integer> numbers = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            numbers.add(i);
        }
        return left < right ? numbers.stream().sorted().collect(Collectors.toList()) : numbers.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        List<Integer> numbers = getListByInterval(left, right);
        return numbers.stream()
                .filter(number -> number % 2 == 0 )
                .collect(Collectors.toList());
    }

    public List<Integer> popEvenElments(int[] array) {
        List<Integer> evenElements = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                evenElements.add(array[i]);
            }
        }
        return evenElements;
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
