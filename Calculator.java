package Calculator;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        
        while (true) {
            System.out.println("Enter first number:");
            double num1 = scanner.nextDouble();
            
            System.out.println("Enter an operator (+, -, *, /):");
            char operator = scanner.next().charAt(0);
            
            System.out.println("Enter second number:");
            double num2 = scanner.nextDouble();
            
            Operation operation = calculator.getOperation(operator);
            if (operation != null) {
                double result = operation.perform(num1, num2);
                System.out.println("Result: " + result);
            } else {
                System.out.println("Invalid operator. Please try again.");
            }
            
            System.out.println("Do you want to perform another calculation? (yes/no)");
            String response = scanner.next();
            if (response.equalsIgnoreCase("no")) {
                break;
            }
        }
        scanner.close();
    }

    public Operation getOperation(char operator) {
        switch (operator) {
            case '+':
                return new Addition();
            case '-':
                return new Subtraction();
            case '*':
                return new Multiplication();
            case '/':
                return new Division();
            default:
                return null;
        }
    }
}
