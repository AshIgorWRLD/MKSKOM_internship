package task3.shapes;

public class Cylinder extends SolidOfRevolution {

    private double height;

    public Cylinder(double volume, double radius, double height) {
        super(volume, radius);
        this.height = height;
    }

    @Override
    public void print(){
        System.out.println("Cylinder: volume = " + volume + "; radius = " + radius +
                "; height = " + height);
    }
}
