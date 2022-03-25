package task3;

import task3.shapes.*;

import java.text.DecimalFormat;
import java.util.Random;

public class Task3 {

    private static final String STRING_SEPARATOR = ",";
    private static final String NUMBER_SEPARATOR = ".";

    private final Random random = new Random();

    private void fillBox(Box box) {
        boolean isContinue = true;
        int figureChooser = 0;
        while (isContinue) {
            isContinue = box.add(takeFigure(figureChooser));
            figureChooser++;
        }
    }

    private Shape takeFigure(int figureChooser) {
        switch (figureChooser % 3) {
            case 0 -> {
                return makeBall();
            }
            case 1 -> {
                return makeCylinder();
            }
            case 2 -> {
                return makePyramid();
            }
        }
        return null;
    }

    private Shape makeBall() {
        return new Ball(randNumber(), randNumber());
    }

    private Cylinder makeCylinder() {
        return new Cylinder(randNumber(), randNumber(), randNumber());
    }

    private Pyramid makePyramid() {
        return new Pyramid(randNumber(), randNumber(), randNumber());
    }

    private static double takeFormattedDouble(double number) {
        DecimalFormat decimalFormat = new DecimalFormat("#.###");
        String str = decimalFormat.format(number);
        String[] subStr = str.split(STRING_SEPARATOR);
        if (subStr.length > 1) {
            String newNumber = subStr[0] + NUMBER_SEPARATOR + subStr[1];
            return Double.parseDouble(newNumber);
        }
        return number;
    }

    private double randNumber() {
        return takeFormattedDouble(random.nextDouble());
    }

    public void doTask() {
        Box box = new Box(10);
        fillBox(box);
        box.print();
    }
}
