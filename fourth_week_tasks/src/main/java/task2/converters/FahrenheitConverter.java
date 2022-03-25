package task2.converters;

public class FahrenheitConverter implements Convertable {

    @Override
    public double convert(double value) {
        return 32+value*1.8;
    }
}
