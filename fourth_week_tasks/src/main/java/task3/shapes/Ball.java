package task3.shapes;

public class Ball extends SolidOfRevolution {
    public Ball(double volume, double radius) {
        super(volume, radius);
    }

    @Override
    public void print(){
        System.out.println("Ball: volume = " + volume + "; radius = " + radius);
    }
}
