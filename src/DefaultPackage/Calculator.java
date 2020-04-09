package DefaultPackage;

import java.io.IOException;
import java.math.BigDecimal;

public class Calculator extends MethodsClass {

    public static void main(String[] args) throws IOException {

        printMsg("Enter the number 1: ");
        String str = readValue();
        while (!isNumeric(str)) {
            printMsg("This value is not numeric, enter a valid number: ");
            str = readValue();
        }
        BigDecimal num1 = str2Decimal(str);

        printMsg("Enter the number 2: ");
        String str2 = readValue();
        while (!isNumeric(str2)) {
            printMsg("This value is not numeric, enter a valid number: ");
            str2 = readValue();
        }
        BigDecimal num2 = str2Decimal(str2);

        printMsg(info);
        String operation = readValue();

        while (!isValidOp(operation)) {
            printMsg("This operation is invalid, enter a valid operation: ");
            operation = readValue();
        }

        switch (operation) {
            case "+":
                BigDecimal add = sum2Num(num1, num2);
                String formattedSum = formatBigDecimal(add);
                printMsg("The result of the sum is: " + formattedSum);
                break;
            case "-":
                BigDecimal rest = rest2Num(num1, num2);
                String formattedSubs = formatBigDecimal(rest);
                printMsg("The result of the subtraction is: " + formattedSubs);
                break;
            case "*":
                BigDecimal multi = mult2Num(num1, num2);
                String formattedMulti = formatBigDecimal(multi);
                printMsg("The result of multiplication es: " + formattedMulti);
                break;

            case "/":
                BigDecimal division = divide2Num(num1, num2);
                String formattedDiv = formatBigDecimal(division);
                if (division == null)
                    printMsg("Sorry, the result of this operation is not valid, try again from scratch");
                else
                    printMsg("The result of division is: " + formattedDiv);
                break;

            case "p":
                BigDecimal power = raiseToPower(num1, num2);
                String formattedPower = formatBigDecimal(power);
                printMsg("The result of raising " + num1 + " to the power of " + num2 + " is: " + formattedPower);
                break;
            case "r":
                BigDecimal squareRoot = squareRoot(num1, num2);
                String formattedSqrRoot = formatBigDecimal(squareRoot);
                printMsg("The square root of " + num1 + " is: " + formattedSqrRoot);
                break;
            case "a":
                allOperations(num1, num2);
                break;
        }

    }

}
