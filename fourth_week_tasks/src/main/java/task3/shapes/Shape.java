package task3.shapes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class Shape {

    protected double volume;

    public abstract void print();
}
