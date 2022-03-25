package task3.shapes;

import java.util.ArrayList;
import java.util.List;

public class Box extends Shape {

    List<Shape> figures;

    public Box(double volume) {
        super(volume);
        figures = new ArrayList<>();
    }

    public boolean add(Shape newShape){
        if(figures.size() >= volume){
            return false;
        }
        figures.add(newShape);
        return true;
    }

    @Override
    public void print(){
        System.out.println(figures.size());
        figures.forEach(Shape::print);
    }
}
