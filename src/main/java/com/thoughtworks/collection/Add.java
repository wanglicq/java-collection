package com.thoughtworks.collection;


import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Add {


    public int getSumOfEvens(int leftBorder, int rightBorder) {
        throw new NotImplementedException();
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        throw new NotImplementedException();
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().mapToInt(number -> number * 3 + 2).sum();
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().map(number -> number % 2 == 1 ? number * 3 + 2 : number).collect(Collectors.toList());
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream().filter(number -> number % 2 == 1).mapToInt(number -> number * 3 + 5).sum();
    }

    public double getMedianOfEvenIndex(List<Integer> arrayList) {
        List<Integer> evenNumbers = arrayList.stream().filter(number -> number % 2 == 0).collect(Collectors.toList());
        int size = evenNumbers.size();
        return size % 2 != 0 ? (double) evenNumbers.get((size+1)/2-1) : (double) (evenNumbers.get(size/2-1) + evenNumbers.get(size/2))/2;
    }

    public double getAverageOfEvenIndex(List<Integer> arrayList) {
        return arrayList.stream().filter(number -> number % 2 == 0).mapToDouble(even -> even).summaryStatistics().getAverage();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        return arrayList.stream().filter(number -> number % 2 == 0).anyMatch(even -> (even==specialElment));
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList.stream().filter(number -> number % 2 == 0).distinct().collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> evenNumbers = arrayList.stream().filter(number -> number % 2 == 0).sorted().collect(Collectors.toList());
        List<Integer> oddNumbers = arrayList.stream().filter(number -> number % 2 == 1).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        evenNumbers.addAll(oddNumbers);
        return evenNumbers;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> newList = arrayList.stream().skip(1).collect(Collectors.toList());
        for (int i = 0; i < newList.size(); i++){
            newList.set(i, (arrayList.get(i) + newList.get(i)) * 3);
        }
        return newList;
    }

}
