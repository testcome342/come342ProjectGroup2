package Agate.help;

import java.util.Scanner;

public class ScanHelper {




    private static Scanner scanner;

    public static int scanInt() {
        scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static String scanString() {
        scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static Double scanDouble() {
        scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }
}