package com.thoughtworks.collection;


import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        return array.stream().map(number -> number * 3).collect(toList());
    }

    public List<String> mapLetter() {
        return array.stream().map(number -> letters[number-1]).collect(toList());
    }

    public List<String> mapLetters() {
        List<List<Integer>> collect = array.stream().map(x -> mapLettersHelper(x, newArrayList((x - 1) % 26))).collect(toList());
        ArrayList<String> strings = new ArrayList<>();
        for(List<Integer> list : collect){
            String string = new String();
            for(int i = list.size() - 1; i >= 0; i--){
                string += letters[list.get(i)];
            }
            strings.add(string);
        }
        return strings;
    }

    private <T> List<T> newArrayList(T x) {
        List<T> ts = new ArrayList<>();
        ts.add(x);
        return ts;
    }

    private List<Integer> mapLettersHelper(int number, List<Integer> results) {
        int i = number / 26;
        if(results.get(results.size() - 1) == 25){
            i -= 1;
        }
        if (i > 26) {
            results.add(0);
            return mapLettersHelper(i, results);
        } else if (i != 0) {
            results.add(i - 1);
        }
        return results;
    }

    public List<Integer> sortFromBig() {
        throw new NotImplementedException();
    }

    public List<Integer> sortFromSmall() {
        return array.stream().sorted(Comparator.naturalOrder()).collect(toList());
    }
}
