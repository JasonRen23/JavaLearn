package cn.jasonren.javalearn.innerclass;

/**
 * @author zhicheng
 * @create 2018-07-06 下午3:09
 */


public class Outer6 {
    public static void main(String[] args) {
//        Size size = Size.MEDIUM;
//        System.out.println(size.ordinal());
//        System.out.println(Size.SMALL == Size.valueOf("SMALL"));
//        for(Size size1 : Size.values()){
//            System.out.println(size1);
//        }

        Size s = Size.MEDIUM;
        System.out.println(s.getAbbr());
        s = Size.fromAbbr("L");
        System.out.println(s.getTitle());
    }
    static void onChosen(Size size){
        switch (size){
            case SMALL:
                System.out.println("chosen small");break;
            case MEDIUM:
                System.out.println("chosen medium");break;
            case LARGE:
                System.out.println("chosen large");break;
        }
    }
}
