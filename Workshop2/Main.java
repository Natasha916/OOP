package Workshop2;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        int result1 = calculator.add(5, 8);
        System.out.println("Sum of 5 and 8 (integers): " + result1);

        int result2 = calculator.add(10, 15, 20);
        System.out.println("Sum of 10, 15, and 20 (integers): " + result2);

        double result3 = calculator.add(3.5, 2.7);
        System.out.println("Sum of 3.5 and 2.7 (doubles): " + result3);

        double result4 = calculator.add(1.1, 2.2, 3.3);
        System.out.println("Sum of 1.1, 2.2, and 3.3 (doubles): " + result4);
    }
}
