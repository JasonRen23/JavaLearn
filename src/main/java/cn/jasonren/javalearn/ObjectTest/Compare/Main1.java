package cn.jasonren.javalearn.ObjectTest.Compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main1 {
    public static void main(String[] args) {
        HDTV_1 tv1 = new HDTV_1(55, "Samsung");
        HDTV_1 tv2 = new HDTV_1(60, "Sony");
        HDTV_1 tv3 = new HDTV_1(42, "Panasonic");

        ArrayList<HDTV_1> al = new ArrayList<HDTV_1>();
        al.add(tv1);
        al.add(tv2);
        al.add(tv3);

        Collections.sort(al, new SizeComparator());
        for (HDTV_1 a : al) {
            System.out.println(a.getBrand());
        }

    }
}

class HDTV_1 {
    private int size;
    private String brand;

    public HDTV_1(final int size, final String brand) {
        this.size = size;
        this.brand = brand;
    }

    public int getSize() {
        return size;
    }

    public void setSize(final int size) {
        this.size = size;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(final String brand) {
        this.brand = brand;
    }

}

class SizeComparator implements Comparator<HDTV_1> {
    @Override
    public int compare(final HDTV_1 tv1, final HDTV_1 tv2) {
        int tv1Size = tv1.getSize();
        int tv2Size = tv2.getSize();

        if (tv1Size > tv2Size) {
            return 1;
        } else if (tv1Size < tv2Size) {
            return -1;
        } else {
            return 0;
        }
    }
}
