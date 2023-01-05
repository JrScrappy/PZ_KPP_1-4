package org.example.pz1;

import java.util.Random;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {

        int n = 0;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter N: ");
            n = sc.nextInt();
        } catch (Exception e) {
            e.printStackTrace();
        }
        int[][] arr = createArray(n);
        int sum = sumArray(arr);
        int min = getMinFromArray(arr);
        int sumOfSquaresBefore = sumOfAllPow(arr);
        printArray(arr);

        System.out.println("Sum of all matrix = " + sum);
        System.out.println("Min element = " + min);
        System.out.println("Array after add abs(min) value to all elements: ");
        addNumberForAllElems(arr, Math.abs(min));
        int sumOfSquaresAfter = sumOfAllPow(arr);
        printArray(arr);
        System.out.println("Sum of all squares before: "+ sumOfSquaresBefore);
        System.out.println("Sum of all squares after: "+ sumOfSquaresAfter);
    }

    public static int sumOfAllPow(int[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j] * arr[i][j];
            }
        }
        return sum;
    }

    public static void addNumberForAllElems(int[][] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] += num;
            }
        }
    }

    public static int getMinFromArray(int[][] arr) {
        int min = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (min > arr[i][j]) {
                    min = arr[i][j];
                }
            }
        }
        return min;
    }

    public static int sumArray(int[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j];
            }
        }
        return sum;
    }

    public static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int[][] createArray(int n) {
        int[][] arr = new int[n + 15][n + 15];
        Random random = new Random();
        for (int i = 0; i < arr.length; ++i) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = random.nextInt(2 * (n + 15) + 1) - n - 15;
            }
        }

        return arr;
    }
}
