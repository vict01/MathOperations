package DefaultPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MethodsClass {

    public static String info = "Please enter following sign for each one operation according the equivalence below:\n" +
            "Sum = '+' \n" +
            "Subtraction = '-' \n" +
            "Multiplication = '*' \n" +
            "Division = '/' \n" +
            "Power = 'p' \n" +
            "Square root = 'r' \n" +
            "All previous operations together = 'a' \n" +
            "NOTE: This program is not case sensitive. \n" +
            "Enter desired operation: \n";

    public static BigDecimal result, sum, subtraction, multi, division, sqrRoot, power;

    public static void printMsg(String str) {
        System.out.println(str);
    }

    public static String readValue() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine().toLowerCase();
    }

    public static boolean isNumeric(String str) {
        try {
            result = new BigDecimal(str).setScale(2, RoundingMode.DOWN);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static BigDecimal str2Decimal(String num) {
        result = new BigDecimal(num).setScale(2, RoundingMode.DOWN);
        return result;
    }

    public static String formatBigDecimal(BigDecimal num) {
        DecimalFormat df = new DecimalFormat("#,###,###,##0.00");
        result = new BigDecimal(String.valueOf(num)).setScale(2, RoundingMode.DOWN);
        return df.format(result);
    }

    public static boolean isValidOp(String str) {
        boolean valid = false;
        String[] value = {"+", "-", "*", "/", "p", "r", "a"};
        for (String s : value) {
            if (s.equals(str)) {
                valid = true;
                break;
            }
        }
        return valid;
    }

    public static BigDecimal sum2Num(BigDecimal a, BigDecimal b) {
        result = new BigDecimal(String.valueOf(a)).add(b);
        return result;
    }

    public static BigDecimal rest2Num(BigDecimal a, BigDecimal b) {
        result = new BigDecimal(String.valueOf(a)).subtract(b);
        return result;
    }

    public static BigDecimal mult2Num(BigDecimal a, BigDecimal b) {
        result = new BigDecimal(String.valueOf(a)).multiply(b);
        return result;
    }

    public static BigDecimal divide2Num(BigDecimal a, BigDecimal b) {
        try {
            result = new BigDecimal(String.valueOf(a)).divide(b, 2, RoundingMode.HALF_UP);
            return result;
        } catch (ArithmeticException e) {
            printMsg("Division by zero is not possible");
            return null;
        }
    }

    public static BigDecimal raiseToPower(BigDecimal a, BigDecimal b) {
        double x = Double.parseDouble(String.valueOf(a));
        double y = Double.parseDouble(String.valueOf(b));
        double result = Math.pow(x, y);
        return new BigDecimal(result).setScale(2, RoundingMode.DOWN);
    }

    public static BigDecimal squareRoot(BigDecimal a, BigDecimal b) {
        double x = Double.parseDouble(String.valueOf(a));
        double result = Math.sqrt(x);
        printMsg(b + " was ignored for square root because for this operation second value is not applicable");
        return new BigDecimal(result).setScale(2, RoundingMode.DOWN);
    }

    public static void allOperations(BigDecimal a, BigDecimal b) {
        sum = sum2Num(a, b);
        subtraction = rest2Num(a, b);
        multi = mult2Num(a, b);
        division = divide2Num(a, b);
        sqrRoot = squareRoot(a, b);
        power = raiseToPower(a, b);
        printMsg("The result of the sum is: " + formatBigDecimal(sum));
        printMsg("The result of the subtraction is: " + formatBigDecimal(subtraction));
        printMsg("The result of the multiplication is: " + formatBigDecimal(multi));
        printMsg("The result of the division is: " + formatBigDecimal(division));
        printMsg("The result of the square root of " + a + " is: " + formatBigDecimal(sqrRoot));
        printMsg("The result of the power is: " + formatBigDecimal(power));
    }

}
