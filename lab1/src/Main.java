import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.System.out.printf("Hello World!");

        System.out.println("Hello world!");
        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        for (String str : languages) {
            System.out.println(str);
        }
        int n = (int) (Math.random() * 1_000_000);
        System.out.println(n);
        n = n * 3;
        n = n + Integer.parseInt("10101", 2);
        n = n + Integer.parseInt("FF", 16);
        n = n * 6;
        System.out.println(n);
        int digit = 0, sum = 0;
        int result = n;
        while (n > 9) {
            sum=0;
            while (n > 0) {
                digit = n % 10;
                sum += digit;
                n /= 10;
            }
            n = sum;
        }
        System.out.println(n);
        System.out.println("Willy-nilly, this semester I will learn " + languages[n]);
    }
}