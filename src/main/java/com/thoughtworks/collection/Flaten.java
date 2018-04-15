package com.thoughtworks.collection;


import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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
        throw new NotImplementedException();
    }

    public List<Integer> transformToUnrepeatedOneDimesional() {
        return Stream.of(array).flatMap(childlist -> Arrays.stream(childlist)).distinct().collect(Collectors.toList());
    }
}
