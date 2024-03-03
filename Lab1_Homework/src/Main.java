import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static boolean kReductible(int x, int k) {
        int copy = x;
        while (copy > k && copy > 9) {
            int sum = 0;
            int copy1 = copy;
            while (copy1 > 0) {
                sum += (copy1 % 10) * (copy1 % 10);
                copy1 /= 10;
            }
            copy = sum;
        }
        if (copy == k) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int a, b, k;
        if (args.length != 3) {
            System.out.println("Incorrect format! Use java Main <a> <b> <k>");
            return;
        }
        try {
            a = Integer.parseInt(args[0]);
            b = Integer.parseInt(args[1]);
            k = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            System.out.println("Only integers are accepted");
            return;
        }
        if (a > b) {
            System.out.println("Invalid interval, a should be smaller than b");
            return;
        }
        long startTime = System.nanoTime();
        StringBuilder numbers = new StringBuilder();
        while (a < b) {
            if (kReductible(a, k))
                numbers.append(a).append(" ");
            a++;
        }
        long endTime = System.nanoTime();
        long time = (endTime - startTime);
        System.out.println(numbers.toString());
        System.out.println("Running time: " + time);
    /*Scanner input = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int value = input.nextInt();
        System.out.print("Enter k: ");
        int k = input.nextInt();
        if (kReductible(value, k)) {
            System.out.println("The number " + value + " is " + k + "-reductible");
        } else {
            System.out.println("noooo");
        }
        input.close();*/
    }
}