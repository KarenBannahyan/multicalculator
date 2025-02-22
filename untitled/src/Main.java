import java.util.Scanner;
import java.io.IOException;
public class Main {
    public static String toRoman(int num) {

        String[] romanSymbols = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] values = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        StringBuilder result = new StringBuilder();

        int i = values.length - 1;

        while (num > 0) {
            if (num >= values[i]) {
                result.append(romanSymbols[i]);
                num -= values[i];
            } else {
                i--;
            }
        }

        return result.toString();
    }
    public static boolean isRoman(String s) {
        String[] roman = {"I","V","X","L","C","D","M"};
        for (String x : roman) {
            if (s.contains(x)) {
                return true;
            }
        }
        return false;
    }
    public static int roman(String s) {
        int res = 0;
        int val = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int curValue = getValue(s.charAt(i));
            if (curValue < val) {
                res -= curValue;
            } else {
                res += curValue;
            }
            val = curValue;
        }
        return res;
    }

    public static int getValue(char roman) {
        switch (roman) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

   public static void main(String[] args) throws IOException{
        while(true) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input:");
        String expression = scanner.nextLine();


        String[] variables = expression.split("\\s+");
        String[] parts = expression.split("\\+");
            if (variables.length == 1) {
                throw new IOException("строка не является математической операцией");
            }
            else if (parts.length >= 3) {
                throw new IOException("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }
            if (variables[1].equals("+")) {
                if (parts.length == 2) {

                    String a = parts[0].trim();
                    String b = parts[1].trim();

                    if (isRoman(a) && isRoman(b)) {
                        System.out.println("Output:");
                        System.out.println(toRoman(roman(a) + roman(b)));
                    }
                    else if (isRoman(a) && !isRoman(b) || isRoman(b) && !isRoman(a)) {
                        throw new IOException("используются одновременно разные системы счисления");
                    }
                    else {
                        int num1 = Integer.parseInt(a);
                        int num2 = Integer.parseInt(b);
                        System.out.println("Output:");
                        System.out.println(num1 + num2);
                    }
                }

                else {
                    System.out.println("Output:");
                    System.out.println("Ошибка: Неверный формат выражения.");
                }
            }
            else if (variables[1].equals("-")) {
                String[] parts1 = expression.split("-");
                if (parts1.length == 2) {

                    String a = parts1[0].trim();
                    String b = parts1[1].trim();

                    if (isRoman(a) && isRoman(b)) {
                        int result = roman(a) - roman(b);
                        if (result < 0) {
                             {
                                throw new IOException("в римской системе нет отрицательных чисел");
                            }
                        }
                        System.out.println("Output:");
                        System.out.println(toRoman(result));
                    }
                    else if (isRoman(a) && !isRoman(b) || isRoman(b) && !isRoman(a)) {
                        throw new IOException("используются одновременно разные системы счисления");
                    }
                    else {
                        int num1 = Integer.parseInt(a);
                        int num2 = Integer.parseInt(b);
                        System.out.println("Output:");
                        System.out.println(num1 - num2);
                    }
                } else {
                    System.out.println("Output:");
                    System.out.println("Ошибка: Неверный формат выражения.");
                }
            }
            else if (variables[1].equals("*")) {
                String[] parts1 = expression.split("\\*");
                if (parts1.length == 2) {

                    String a = parts1[0].trim();
                    String b = parts1[1].trim();

                    if (isRoman(a) && isRoman(b)) {
                        System.out.println("Output:");
                        System.out.println(toRoman(roman(a) * roman(b)));
                    }
                    else if (isRoman(a) && !isRoman(b) || isRoman(b) && !isRoman(a)) {
                        throw new IOException("используются одновременно разные системы счисления");
                    }
                    else {
                        int num1 = Integer.parseInt(a);
                        int num2 = Integer.parseInt(b);
                        System.out.println("Output:");
                        System.out.println(num1 * num2);
                    }
                } else {
                    System.out.println("Output:");
                    System.out.println("Ошибка: Неверный формат выражения.");
                }
            }
            else if (variables[1].equals("/")) {
                String[] parts1 = expression.split("/");
                if (parts1.length == 2) {

                    String a = parts1[0].trim();
                    String b = parts1[1].trim();

                    if (isRoman(a) && isRoman(b)) {
                        System.out.println("Output:");
                        System.out.println(toRoman(roman(a) / roman(b)));
                    }
                    else if (isRoman(a) && !isRoman(b) || isRoman(b) && !isRoman(a)) {
                        throw new IOException("используются одновременно разные системы счисления");
                    }
                    else {
                        int num1 = Integer.parseInt(a);
                        int num2 = Integer.parseInt(b);
                        System.out.println("Output:");
                        System.out.println(num1 / num2);
                    }
                } else {
                    System.out.println("Output:");
                    System.out.println("Ошибка: Неверный формат выражения.");
                }
            }
    }
}
}