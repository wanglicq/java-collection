package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Flaten {

    Integer[][] array;
    public Flaten(Integer[][] array) {
        this.array = array;
    }

    public List<Integer> transformToOneDimesional() {
        return Stream.of(Arrays.asList(array[0]),
                Arrays.asList(array[1]),
                Arrays.asList(array[2]))
                .flatMap(childlist -> childlist.stream())
                .collect(Collectors.toList());
    }

    public List<Integer> transformToUnrepeatedOneDimesional() {
        List<Integer> result = new ArrayList<>();
        List<Integer> list = Stream.of(
                Arrays.asList(array[0]),
                Arrays.asList(array[1]),
                Arrays.asList(array[2]))
                .flatMap(childList -> childList.stream())
                .collect(Collectors.toList());
        list.stream()
                .forEach(number -> {
                    if(!result.contains(number)){
                        result.add(number);
                    }
                });
        return result;
    }
}
