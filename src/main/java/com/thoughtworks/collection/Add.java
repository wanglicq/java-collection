package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Add {


    public int getSumOfEvens(int leftBorder, int rightBorder) {
        List<Integer> numbers = getNumbers(leftBorder, rightBorder);
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .reduce(Integer::sum)
                .get();
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        List<Integer> numbers = getNumbers(leftBorder, rightBorder);
        return numbers.stream()
                .filter(number -> number % 2 != 0)
                .reduce(Integer::sum)
                .get();
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        List<Integer> tripleAddTwoNumbers = new ArrayList<>();
        for (Integer number : arrayList) {
            tripleAddTwoNumbers.add(number * 3 + 2);
        }
        return tripleAddTwoNumbers.stream()
                .reduce(Integer::sum)
                .get();
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            if(arrayList.get(i) % 2 != 0){
                arrayList.set(i, arrayList.get(i) * 3 + 2);
            }
        }
        return arrayList;
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        List<Integer> oddNumbers = getOddNumbers(arrayList);
        for (int i = 0; i < oddNumbers.size(); i++) {
            oddNumbers.set(i, oddNumbers.get(i) * 3 + 5);
        }
        return oddNumbers.stream()
                .reduce(Integer::sum)
                .get();
    }

    public double getMedianOfEvenIndex(List<Integer> arrayList) {
        List<Integer> evenNumbers = getEvenNumbers(arrayList);
        int size = evenNumbers.size();
        return size % 2 != 0 ? (double) evenNumbers.get((size+1)/2-1) : (double) (evenNumbers.get(size/2-1) + evenNumbers.get(size/2))/2;
    }

    public double getAverageOfEvenIndex(List<Integer> arrayList) {
        List<Integer> evenNumbers = getEvenNumbers(arrayList);
        return (evenNumbers.stream()
                .reduce(Integer::sum)
                .get())/2;
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        List<Integer> evenNumbers = getEvenNumbers(arrayList);
        return evenNumbers.contains(specialElment);
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        List<Integer> evenNumbers = getEvenNumbers(arrayList);
        List<Integer> unrepeatedEvenNumbers = new ArrayList<>();
        evenNumbers.stream()
                .forEach(number -> {
                    if(!unrepeatedEvenNumbers.contains(number)){
                        unrepeatedEvenNumbers.add(number);
                    }
                });
        return unrepeatedEvenNumbers;
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> evenNumbers = getEvenNumbers(arrayList).stream().sorted().collect(Collectors.toList());
        List<Integer> oddNumbers = getOddNumbers(arrayList).stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        List<Integer> newList = new ArrayList<>();
        newList.addAll(evenNumbers);
        newList.addAll(oddNumbers);
        return newList;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> newlist = new ArrayList<>();
        for (int i = 0; i < arrayList.size() - 1; i++) {
            newlist.add((arrayList.get(i) + arrayList.get(i+1)) * 3);
        }
        return newlist;
    }

    private List<Integer> getNumbers(int leftBorder, int rightBorder) {
        int min = leftBorder < rightBorder ? leftBorder : rightBorder;
        int max = leftBorder < rightBorder ? rightBorder : leftBorder;
        List<Integer> numbers = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            numbers.add(i);
        }
        return leftBorder < rightBorder ? numbers.stream().sorted().collect(Collectors.toList()) : numbers.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    private List<Integer> getOddNumbers(List<Integer> arrayList) {
        return arrayList.stream()
                .filter(number -> number % 2 != 0)
                .collect(Collectors.toList());
    }

    private List<Integer> getEvenNumbers(List<Integer> arrayList) {
        return arrayList.stream()
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList());
    }

}
