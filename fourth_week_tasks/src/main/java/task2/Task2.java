package task2;

import task2.converters.Convertable;
import task2.converters.FahrenheitConverter;
import task2.converters.KelvinConverter;

public class Task2 {


    private void convertPrintValue(Convertable convertable, double value){
        System.out.println("Input value: " + value + "; Converted value: " + convertable.convert(value));
    }

    public void doTask(){
        System.out.println("KELVIN:");
        convertPrintValue(new KelvinConverter(), 15);
        System.out.println("\nFAHRENHEIT");
        convertPrintValue(new FahrenheitConverter(), 15);
    }
}
