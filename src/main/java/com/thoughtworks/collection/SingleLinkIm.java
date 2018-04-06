package com.thoughtworks.collection;


public class SingleLinkIm<T> implements SingleLink {

    @Override
    public Object getHeaderData() {
        return null;
    }

    @Override
    public Object getTailData() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean deleteFirst() {
        return false;
    }

    @Override
    public boolean deleteLast() {
        return false;
    }

    @Override
    public void addHeadPointer(Object item) {

    }

    @Override
    public void addTailPointer(Object item) {

    }

    @Override
    public Object getNode(int index) {
        return null;
    }
}
