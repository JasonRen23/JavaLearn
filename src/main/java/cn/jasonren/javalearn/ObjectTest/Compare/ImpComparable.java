package cn.jasonren.javalearn.ObjectTest.Compare;

import java.util.Comparator;
import java.util.TreeSet;

public class ImpComparable {
    public static void main(String[] args) {
        TreeSet<Dog> d = new TreeSet<>();
        d.add(new Dog(1));
        d.add(new Dog(2));
        d.add(new Dog(3));
    }
}

class Dog implements Comparable<Dog>{
    int size;

    Dog(int s) {
        size = s;
    }

    @Override
    public int compareTo(final Dog o) {
        return o.size - this.size;
    }
}

// class DogSizeComparator implements Comparator<Dog> {
//     @Override
//     public int compare(final Dog d1, final Dog d2) {
//         return d1.size - d2.size;
//     }
// }
