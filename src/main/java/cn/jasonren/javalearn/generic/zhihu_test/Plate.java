package cn.jasonren.javalearn.generic.zhihu_test;

public class Plate<T> {
    private T item;

    public Plate(T t) {
        item = t;
    }

    public void set(T t) {
        item = t;
    }

    public T get() {
        return item;
    }

    public static void main(String[] args) {
        Plate<? extends Fruit> p1 = new Plate<Apple>(new Apple());
        // p1.set(new Fruit()); //error
        // p1.set(new Apple()); //error

        Fruit newFruit1 = p1.get();
        Object newFruit2 = p1.get();
        // Apple newFruit3 = p1.get(); //error

        Plate<? super Fruit> p2 = new Plate<Fruit>(new Fruit());

        p2.set(new Fruit());
        p2.set(new Apple());

        // Apple newFruit4 = p2.get();
        // Fruit newFruit5 = p2.get();
        Object newFruit6 = p2.get();
    }
}
