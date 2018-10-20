import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Solver solver = new Solver();
        Scanner in = new Scanner(System.in);

        int num1 = in.nextInt();
        solver.readFromFile().filter(row -> Integer.parseInt(row.get(1)) == num1).findFirst().ifPresent(row -> System.out.println(row.get(0)));

        int num2 = in.nextInt();
        solver.readFromFile().filter(row -> Integer.parseInt(row.get(1)) == num2).findFirst().ifPresent(row -> System.out.println(row.get(0)));

        int num3 = in.nextInt();
        solver.readFromFile().filter(row -> Integer.parseInt(row.get(1)) == num3).findFirst().ifPresent(row -> System.out.println(row.get(0)));
    }
}
