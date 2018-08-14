package cn.jasonren.designpattern.Builder;

/**
 * @author JasonRen
 * @since 2018/8/13 下午3:08
 */
public class Main {
    public static void main(String[] args) {

        Director director = new Director();
        Builder commonBuilder = new CommonRoleBuilder();

        director.construct(commonBuilder);
        Role commonRole = commonBuilder.getResult();
        System.out.println(commonRole);

        Builder superBuilder = new SuperRoleBuilder();
        director.construct(superBuilder);
        Role superRole = superBuilder.getResult();
        System.out.println(superRole);

        System.out.println(System.getProperty("os.name"));
    }
}
