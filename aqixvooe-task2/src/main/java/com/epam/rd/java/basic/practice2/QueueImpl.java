package com.epam.rd.java.basic.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueImpl implements Queue {


    private ListImpl list;

    public QueueImpl() {
        list = new ListImpl();
    }

    @Override
    public void clear() {
    list.clear();
    }
    @Override
    public int size() {
        return list.size();
    }

    public Iterator<Object> iterator() {
        return list.iterator();
    }

    @Override
    public void enqueue(Object element) {
        list.addLast(element);
    }

    @Override
    public Object dequeue() {
        Object head = list.getFirst();
        try{
            list.removeFirst();
        }catch (NoSuchElementException e){
            return null;
        }
        return head;
    }

    @Override
    public Object top() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        return list.toString();
    }

    public static void main(String[] args) {
        QueueImpl queue = new QueueImpl();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.enqueue("D");
        System.out.println(queue.size());
        System.out.println(queue.top());
        System.out.println(queue.dequeue());
        System.out.println(queue);
        System.out.println(queue);
    }

}