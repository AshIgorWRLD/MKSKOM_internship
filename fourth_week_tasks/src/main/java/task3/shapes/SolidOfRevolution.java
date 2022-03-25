package task3.shapes;

import lombok.Getter;

@Getter
abstract class SolidOfRevolution extends Shape {

    protected double radius;

    public SolidOfRevolution(double volume, double radius) {
        super(volume);
        this.radius = radius;
    }
}
