package com.epam.rd.java.basic.practice2;

import java.util.Iterator;

public class StackImpl implements Stack {


    private final ListImpl list;
    @Override
    public void clear() {
        list.clear();
    }

    public StackImpl() {
        list = new ListImpl();
    }

    public static void main(String[] args) {
        StackImpl stack = new StackImpl();
        stack.push("Aa");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack.size());
        stack.clear();
        System.out.println(stack);
    }

    @Override
    public int size() {
        return list.size();
    }

    public Iterator<Object> iterator() {
        return list.iterator();
    }

    @Override
    public void push(Object element) {
        list.addFirst(element);
    }

    @Override
    public Object pop() {
        if (size()==0){
            return null;
        }
        Object head = list.getFirst();
        list.removeFirst();
        return head;
    }

    @Override
    public Object top() {
        return list.getFirst();

    }

    @Override
    public String toString() {
        if (size() == 0) {
            return "[]";
        }
        StringBuilder string = new StringBuilder();
        Object[] elements = new Object[size()];
        int i = 0;
        for (Object el : this) {
            elements[i++] = el;
        }
        string.append('[');
        i = elements.length - 1;
        while (true) {
            string.append(elements[i--]);
            if (i == -1) {
                string.append(']');
                return string.toString();
            }
            string.append(", ");
        }
    }

}