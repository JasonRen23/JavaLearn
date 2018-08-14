package cn.jasonren.designpattern.Builder;

/**
 * @author JasonRen
 * @since 2018/8/13 下午3:01
 */
public abstract class Builder {

    protected Role role = new Role();

    public abstract void buildHead();

    public abstract void buildFace();

    public abstract void buildBody();

    public abstract void buildHp();

    public abstract void buildSp();

    public abstract void buildMp();

    public Role getResult() {
        return role;
    }
}
