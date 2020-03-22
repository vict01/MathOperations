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

        printMsg("Enter desired Math operation: ");
        String operation = readValue();

        while (!isValidOp(operation)) {
            printMsg("This operation is invalid, enter a valid operation: ");
            operation = readValue();
        }

        switch (operation) {
            case "+":
                BigDecimal add = sum2Num(num1, num2);
                printMsg("The result of the sum is: " + add);
                break;
            case "-":
                BigDecimal rest = rest2Num(num1, num2);
                printMsg("The result of the subtraction is: " + rest);
                break;
            case "*":
                BigDecimal mult = mult2Num(num1, num2);
                printMsg("The result of multiplication es: " + mult);
                break;
            case "/":
                BigDecimal division = divide2Num(num1, num2);
                if (division==null)
                    printMsg("Sorry, the result of this operation is not valid, try again from scratch");
                 else
                    printMsg("The result of division is: " + division);
                break;
            case "p":
                printMsg("The result of raising " +num1+ " to the power of " +num2+ " is: "+raiseToPower(num1, num2));
                break;
            case "r":
                printMsg("The root square of " +num1+ " is: "+squareRoot(num1));
                printMsg(num2 + " was ignored for this operation because in this case is not applicable");
                break;
        }

    } // this is the end of main method

}
