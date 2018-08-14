package cn.jasonren.javalearn.ObjectTest;

/**
 * @author JasonRen
 * @since 2018/8/11 下午7:55
 */
public class test1 {
    public static void main(String[] args) {
        BigFruit f = new BigFruit();
    }
}

class Fruit {
    private Core c;

    protected class Core {
        public Core() {
            System.out.println("Fruit.Core()");
        }
    }

    public Fruit() {
        System.out.println("New Fruit()");
        c = new Core();
    }
}

class BigFruit extends Fruit {
    public class Core {
        public Core() {
            System.out.println("BigFruit.Core()");
        }
    }
}

