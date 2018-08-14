package cn.jasonren.designpattern.Builder;

/**
 * @author JasonRen
 * @since 2018/8/13 下午3:03
 */
public class CommonRoleBuilder extends Builder {

    private Role role = new Role();

    @Override
    public void buildHead() {
        role.setHead("common head");
    }

    @Override
    public void buildFace() {
        role.setFace("common face");
    }

    @Override
    public void buildBody() {
        role.setBody("common body");
    }

    @Override
    public void buildHp() {
        role.setHp(100d);
    }

    @Override
    public void buildSp() {
        role.setSp(100d);
    }

    @Override
    public void buildMp() {
        role.setMp(100d);
    }

    @Override
    public Role getResult() {
        return role;
    }
}
