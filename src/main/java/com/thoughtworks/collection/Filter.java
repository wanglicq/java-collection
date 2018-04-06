package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Filter {

    List<Integer>  array;

    public Filter(List<Integer> array) {
     this.array = array;
    }

    public List<Integer> filterEven() {
       return array.stream()
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList());
    }

    public List<Integer> filterMultipleOfThree() {
        return array.stream()
                .filter(number -> number % 3 ==0)
                .collect(Collectors.toList());
    }

    public List<Integer> getCommonElements(List<Integer> firstList, List<Integer> secondList) {
        return firstList.stream()
                .filter(number -> secondList.contains(number))
                .collect(Collectors.toList());
    }

    public List<Integer> getDifferentElements() {
        List<Integer> result = new ArrayList<>();
        array.stream()
                .forEach(number -> {
                    if(!result.contains(number)){
                        result.add(number);
                    }
                });
        return  result;
    }
}