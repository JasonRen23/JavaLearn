package cn.jasonren.designpattern.Builder;

/**
 * @author JasonRen
 * @since 2018/8/13 下午3:06
 */
public class SuperRoleBuilder extends Builder {
    private Role role = new Role();

    @Override
    public void buildHead() {
        role.setHead("super head");
    }

    @Override
    public void buildFace() {
        role.setFace("super face");
    }

    @Override
    public void buildBody() {
        role.setBody("super body");
    }

    @Override
    public void buildHp() {
        role.setHp(120d);
    }

    @Override
    public void buildSp() {
        role.setSp(120d);
    }

    @Override
    public void buildMp() {
        role.setMp(120d);
    }

    @Override
    public Role getResult() {
        return role;
    }
}
