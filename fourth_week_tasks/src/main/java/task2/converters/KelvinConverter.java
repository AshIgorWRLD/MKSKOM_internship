package task2.converters;

public class KelvinConverter implements Convertable {

    @Override
    public double convert(double value) {
        return 273.15+value;
    }
}
