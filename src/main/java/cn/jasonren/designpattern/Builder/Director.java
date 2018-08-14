package cn.jasonren.designpattern.Builder;

/**
 * @author JasonRen
 * @since 2018/8/13 下午3:07
 */
public class Director {
    public void construct(Builder builder) {
        builder.buildBody();
        builder.buildHead();
        builder.buildFace();
        builder.buildHp();
        builder.buildMp();
        builder.buildSp();
    }
}
