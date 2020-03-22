package DefaultPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class MethodsClass {

    public static void printMsg(String str) {
        System.out.println(str);
    }

    public static String readValue() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

    public static boolean isNumeric(String str) {
        try {
            BigDecimal bigDecimal = new BigDecimal(str).setScale(2, BigDecimal.ROUND_DOWN);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static BigDecimal str2Decimal(String num) {
        BigDecimal bigDecimal = new BigDecimal(num).setScale(2, BigDecimal.ROUND_DOWN);
        return bigDecimal;
    }

    public static boolean isValidOp(String str) {
        int valid = 0;
        String [] value = {"+","-","*","/","p","r"};
        for (String s : value) {
            if (!s.equals(str)) {
                valid++;
            }
        }
        return valid==value.length-1;
    }

    public static BigDecimal sum2Num(BigDecimal a, BigDecimal b) {
        BigDecimal result = new BigDecimal(String.valueOf(a)).add(b);
        return result;
    }

    public static BigDecimal rest2Num(BigDecimal a, BigDecimal b) {
        BigDecimal result = new BigDecimal(String.valueOf(a)).subtract(b);
        return result;
    }

    public static BigDecimal mult2Num(BigDecimal a, BigDecimal b){
        BigDecimal result = new BigDecimal(String.valueOf(a)).multiply(b);
        return result;
    }

    public static BigDecimal divide2Num(BigDecimal a, BigDecimal b){
        try {
            BigDecimal result = new BigDecimal(String.valueOf(a)).divide(b, 2, RoundingMode.HALF_UP);
            return result;
        } catch (ArithmeticException e) {
            System.out.println("Division by zero is not possible");
            return null;
        }
    }

    public static BigDecimal raiseToPower(BigDecimal a, BigDecimal b) {
        double x = Double.parseDouble(String.valueOf(a));
        double y = Double.parseDouble(String.valueOf(b));
        double result = Math.pow(x,y);
        return new BigDecimal(result).setScale(2,BigDecimal.ROUND_DOWN);
    }

    public static BigDecimal squareRoot(BigDecimal a) {
        double x = Double.parseDouble(String.valueOf(a));
        double result = Math.sqrt(x);
        return new BigDecimal(result).setScale(2,BigDecimal.ROUND_DOWN);
    }

}
