package cn.jasonren.designpattern.Builder;

/**
 * @author JasonRen
 * @since 2018/8/13 下午2:58
 */
public class Role {
    private String head;
    private String face;
    private String body;
    private Double hp;
    private Double sp;
    private Double mp;

    public String getHead() {
        return head;
    }

    public void setHead(final String head) {
        this.head = head;
    }

    public String getFace() {
        return face;
    }

    public void setFace(final String face) {
        this.face = face;
    }

    public String getBody() {
        return body;
    }

    public void setBody(final String body) {
        this.body = body;
    }

    public Double getHp() {
        return hp;
    }

    public void setHp(final Double hp) {
        this.hp = hp;
    }

    public Double getSp() {
        return sp;
    }

    public void setSp(final Double sp) {
        this.sp = sp;
    }

    public Double getMp() {
        return mp;
    }

    public void setMp(final Double mp) {
        this.mp = mp;
    }

    @Override
    public String toString() {
        return "Role:" + " head is " + getHead() +
                ", face is " + getFace() +
                ", body is " + getBody() +
                ", hp is " + getHp() +
                ", sp is " + getSp() +
                ", mp is " + getMp();
    }
}
