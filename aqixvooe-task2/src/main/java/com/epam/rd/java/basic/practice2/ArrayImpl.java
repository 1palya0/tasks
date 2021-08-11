package com.epam.rd.java.basic.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class ArrayImpl implements Array {

    private Object[] array;
    private int ple = 0;

    @Override
    public void clear() {
        for (int i = 0; i < ple; i++) {
            array[i] = null;
        }
        ple = 0;
    }

    public ArrayImpl(int INIT_SIZE) {
        array = new Object[INIT_SIZE];
    }

    @Override
    public int size() {
        return ple;
    }

    @Override
    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {
        private int ind = 0;

        @Override
        public boolean hasNext() {
            return ind != size();
        }

        @Override
        public Object next() {
            if (ind > size()) throw new NoSuchElementException();
            return array[ind++];
        }
    }


    @Override
    public void add(Object element) {
        if (ple == array.length - 1) {
            Object[] newArray = new Object[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, ple);
            array = newArray;
        }
        array[ple++] = element;
    }

    @Override
    public void set(int index, Object element) {
        array[index] = element;
    }

    @Override
    public Object get(int index) {
        return array[index];
    }

    @Override
    public int indexOf(Object element) {
        if (element == null) {
            for (int i = 0; i < size(); i++)
                if (array[i] == null) {
                    return i;
                }
        } else {
            for (int i = 0; i < size(); i++)
                if (element.equals(array[i])) {
                    return i;
                }
        }
        return -1;

    }

    @Override
    public void remove(int index) {
        array[index] = null;
        if (ple - index >= 0) System.arraycopy(array, index + 1, array, index, ple - index);
        ple = ple - 1;

    }

    @Override
    public String toString() {
        if (size() == 0) {
            return "[]";
        }
        StringBuilder string = new StringBuilder();
        string.append('[');
        for (int i = 0; i < ple; i++) {
            string.append(array[i]);
            if (i+1==ple) {
                string.append(']');
                break;
            }
            string.append(", ");
        }
        return string.toString();
    }
    public static void main(String[] args) {
        ArrayImpl array = new ArrayImpl(15);
        array.add("A");
        array.add("B");
        array.add("C");
        System.out.println("init array");
        for (Object o : array) {
            System.out.print(o + " ");
        }
        System.out.println("\nget size");
        System.out.println(array.size());
        System.out.println("change first element");
        array.set(0, "1");
        System.out.println(array);
        System.out.println("get third element");
        System.out.println(array.get(2));
        System.out.println("remove second element");
        array.remove(1);
        System.out.println(array);
        System.out.println("remove all elements");
        array.clear();
        System.out.println(array);
    }
}



