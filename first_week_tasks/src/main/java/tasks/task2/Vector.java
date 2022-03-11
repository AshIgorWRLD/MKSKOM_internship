package tasks.task2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.text.DecimalFormat;
import java.util.Random;

@Getter
@Setter
@AllArgsConstructor
public class Vector {

    private static final String STRING_SEPARATOR = ",";
    private static final String NUMBER_SEPARATOR = ".";

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

    public static Vector[] getBasis(int amount) {
        Random random = new Random(System.currentTimeMillis());
        Vector[] basis = new Vector[amount];
        for (int i = 0; i < basis.length; i++) {
            basis[i] = new Vector(takeFormattedDouble(random.nextDouble()),
                    takeFormattedDouble(random.nextDouble()),
                    takeFormattedDouble(random.nextDouble()));
        }
        return basis;
    }

    public static void printBasis(Vector[] basis) {
        for (Vector vector : basis) {
            vector.printStats();
        }
    }

    public static void calculateBasisScalars(Vector[] basis) {
        for (int i = 0; i < basis.length; i++) {
            for (int j = i; j < basis.length; j++) {
                if (i != j) {
                    System.out.print("Scalar mul of " + i + " and " + j + " : " +
                            takeFormattedDouble(basis[i].getScalarMul(basis[j])) + "\n");
                }
            }
        }
    }

    private double x;
    private double y;
    private double z;

    public double getLength() {
        return Math.sqrt(x + y + z);
    }

    public double getScalarMul(Vector vector) {
        return (this.x * vector.x + this.y * vector.y + this.z * vector.z);
    }

    private void printStats() {
        System.out.println("X: " + x + "; Y: " + y + "; Z: " + z + "; Length: " + getLength());
    }
}
