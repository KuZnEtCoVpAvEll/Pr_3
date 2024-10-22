package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        boolean continueCalculating = true;

        while (true) {
            System.out.println("Введіть 'start' для початку роботи або 'exit' для виходу:");
            String command = scanner.next();

            if (command.equals("exit")) {
                System.out.println("Дякуємо за використання калькулятора!");
                break;
            } else if (!command.equals("start")) {
                System.out.println("Некоректна команда. Спробуйте ще раз.");
                continue;
            }

            while (continueCalculating) {
                try {
                    System.out.println("Введіть операцію (+, -, *, /, sqrt) або 'exit' для виходу:");
                    String operation = scanner.next();

                    if (operation.equals("exit")) {
                        continueCalculating = false;
                        break;
                    }

                    System.out.println("Введіть перше число: ");
                    double num1 = scanner.nextDouble();

                    System.out.println("Введіть друге число: ");
                    double num2 = scanner.nextDouble();

                    double result = 0;

                    switch (operation) {
                        case "+":
                            result = calculator.add(num1, num2);
                            break;
                        case "-":
                            result = calculator.subtract(num1, num2);
                            break;
                        case "*":
                            result = calculator.multiply(num1, num2);
                            break;
                        case "/":
                            result = calculator.divide(num1, num2);
                            break;
                        case "sqrt":
                            System.out.println("Оберіть, до якого числа застосувати квадратний корінь (1 або 2): ");
                            int choice = scanner.nextInt();
                            if (choice == 1) {
                                result = calculator.squareRoot(num1);
                            } else if (choice == 2) {
                                result = calculator.squareRoot(num2);
                            } else {
                                throw new InvalidInputException("Некоректний вибір числа для операції.");
                            }
                            break;
                        default:
                            throw new InvalidInputException("Некоректна операція.");
                    }

                    System.out.println("Результат: " + result);

                } catch (InputMismatchException e) {
                    System.out.println("Помилка: введено нечислове значення.");
                    scanner.next();
                } catch (ArithmeticException e) {
                    System.out.println("Помилка: " + e.getMessage());
                } catch (InvalidInputException e) {
                    System.out.println("Помилка: " + e.getMessage());
                } finally {
                    System.out.println("Запит оброблено.");
                }
            }
        }

        scanner.close();
    }
}










