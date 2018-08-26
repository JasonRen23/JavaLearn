package cn.jasonren.javalearn.java8.defaultInterface;

public class Monster implements Resizable, Moveable, Rotatable{

    public static void main(String[] args) {
        Monster m = new Monster();
        m.rotateBy(180);
        m.moveHorizontally(10);
    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public void setX(final int x) {

    }

    @Override
    public void setY(final int y) {

    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public void setWidth(final int width) {

    }

    @Override
    public void setHeight(final int height) {

    }

    @Override
    public void setAbsoluteSize(final int width, final int height) {

    }

    @Override
    public void setRotationAngle(final int angleInDegrees) {

    }

    @Override
    public int getRotationAngle() {
        return 0;
    }
}
