package task3.shapes;

public class Pyramid extends Shape {

    private double s;
    private double h;

    public Pyramid(double volume, double s, double h) {
        super(volume);
        this.s = s;
        this.h = h;
    }

    @Override
    public void print(){
        System.out.println("Pyramid: volume = " + volume + "; s = " + s + "; h = " + h);
    }
}
