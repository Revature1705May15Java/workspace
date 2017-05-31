package com.rev.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {
    public static void main(String[] args) {
        // Initialization
        List nonGen = new ArrayList();
        nonGen.add("asdf");

        List<String> gen = new ArrayList<>();
        gen.add("qwerty");


        // Elimination of casts
        String s1 = (String) nonGen.get(0);

        String s2 = gen.get(0);


        // Allowable types
        GenBox<Number> nb = new GenBox<>();
        nb.setObj(new Integer(42));  // ok
        //nb.setObj(new Object());  // NOT ok
    }

    // Unbounded wildcards
    public static void printList(List<?> list) {
        for (Object elem : list) {
            System.out.print(elem + " ");
        }
    }
}

class NonGenBox {
    private Object obj;

    public void setObj(Object obj) { this.obj = obj; }
    public Object getObj() { return obj; }
}

class GenBox<T> {
    private T obj;

    public void setObj(T obj) { this.obj = obj; }
    public T getObj() { return obj; }
}

interface Comparable<T> {
    int compareTo(T obj);
}

class ComparisonTester<T extends Comparable<T>> {
    public boolean isGreaterThan(T a, T b) {
        return (a.compareTo(b) > 0);
    }
}
