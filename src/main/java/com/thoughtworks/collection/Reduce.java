package com.thoughtworks.collection;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return arrayList.stream().max(Comparator.naturalOrder()).get();
    }

    public double getMinimum() {
        return arrayList.stream().min(Comparator.naturalOrder()).get();
    }

    public double getAverage() {
        return arrayList.stream().mapToDouble(Double::new).average().getAsDouble();
    }

    public double getOrderedMedian() {
        int size = arrayList.size();
        return size % 2 != 0 ? (double) arrayList.get((size+1)/2-1) : (double) (arrayList.get(size/2-1) + arrayList.get(size/2))/2;
    }

    public int getFirstEven() {
        return arrayList.stream().filter(number -> number % 2 ==0).collect(Collectors.toList()).stream().findFirst().get();
    }

    public int getIndexOfFirstEven() {
        return arrayList.indexOf(arrayList.stream().filter(number -> number % 2 == 0).findFirst().get());
    }

    public boolean isEqual(List<Integer> arrayList) {
        return this.arrayList.stream().allMatch(number -> arrayList.contains(number));
    }

    //实现接口SingleLink，然后再此函数内使用
    public Double getMedianInLinkList(SingleLink singleLink) {
        arrayList.stream().forEach(singleLink::addTailPointer);
        return ((Integer) singleLink.getNode(6) + (Integer) singleLink.getNode(7)) / 2.0;
    }

    public int getLastOdd() {
        List<Integer> oddNumbers = arrayList.stream().filter(number -> number % 2 !=0).collect(Collectors.toList());
        return oddNumbers.get(oddNumbers.size()-1);
    }

    public int getIndexOfLastOdd() {
        /*for (int i = arrayList.size()-1; i > -1; i--) {
            if(arrayList.get(i) % 2 != 0){
                return i;
            }
        }
        return -1;*/
        List<Integer> oddList = arrayList.stream().filter(number -> number % 2 == 1).collect(Collectors.toList());
        return arrayList.lastIndexOf(oddList.get(oddList.size() - 1));
    }
}
