package com.epam.rd.java.basic.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class ListImpl implements List {
    private Node first;
    private Node last;
    private int size;

    public ListImpl() {
        first = last = null;
        size = 0;
    }

    private static class Node {
        Object item;
        Node next;


        public Node(Object item, Node next) {
            this.item = item;
            this.next = next;
        }
    }


    @Override
    public void clear() {
        Node x;
        do {
            x = first;
            first = first.next;
            x.item = null;
            x.next = null;

        }while (first != null);
        size=0;
    }

    @Override
    public int size() {
        return size;
    }

    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Object item = current.item;
            current = current.next;
            return item;
        }

    }

    @Override
    public void addFirst(Object element) {
        first = new Node(element, first);
        size++;
        if (size == 1) {
            last = first;
        }
    }

    @Override
    public void addLast(Object element) {
        Node inserted = new Node(element, null);
        if (last == null) {
            first = last = inserted;
        } else {
            last.next = inserted;
            last = inserted;
        }
        size++;
    }

    @Override
    public void removeFirst() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        Node x = first;
        first = first.next;
        x.item = null;
    }

    @Override
    public void removeLast() {
        Node x = first;
        if (first == last) {
            first.item = null;
        }
        while (x.next != last) {
            x = x.next;

        }
        last.item = null;
        last = x;
        last.next = null;
        size = size - 1;
    }

    @Override
    public Object getFirst() {
        if (first == null) {
            return null;
        }
        return first.item;
    }

    @Override
    public Object getLast() {
        if (last == null) {
            return null;
        }
        return last.item;
    }

    @Override
    public Object search(Object element) {
        Node x = first;
        if (x != null) {
            while (!element.equals(x.item)) {
                x = x.next;
                if(x==null){
                    return null;
                }
            }
            return x.item;
        }

        return null;
    }

    @Override
    public boolean remove(Object element) {
        Node currentElement = first;
        if (element == null) {
            while (currentElement != null) {
                if (currentElement.item == null) {
                    removeElement(currentElement);
                    return true;
                }
                currentElement = currentElement.next;
            }
        } else {
            while (currentElement != null) {
                if (currentElement.item==null){
                    currentElement = currentElement.next;
                    continue;
                }
                if (element.equals(currentElement.item)) {
                    removeElement(currentElement);
                    return true;
                }
                currentElement = currentElement.next;
            }
        }
        return false;
    }

    private void removeElement(Node element) {
        if (element == first) {
            first = first.next;
            size--;
            if (size == 1) {
                last = first;
            }
        } else {
            Node prevLast = first;
            while (prevLast.next != element) {
                prevLast = prevLast.next;
            }
            if (element == last) {
                last = prevLast;
            }
            prevLast.next = element.next;
            size--;
        }
        element.next = null;
        element.item = null;
        if (size == 0) {
            last = first = null;
        }
    }


    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Object> iter = iterator();
        while (true) {
            sb.append(iter.next());
            if (!iter.hasNext()) {
                sb.append("]");
                return sb.toString();
            }
            sb.append(", ");
        }

    }

    public static void main(String[] args) {
        System.out.print("Вивід");
    }
}
