package org.example.pz1;

import java.util.Random;
import java.util.Scanner;
import java.lang.Math;
import static java.lang.Math.*;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a:");
        double a1 = sc.nextDouble();
        System.out.println("Enter c:");
        double c1 = sc.nextDouble();

        for (int d = 2; d < 15; d++) {
            for (double t = 0; t < 5; t += 0.5) {
                for (double m = -2; m < 2; m += 0.41) {
                    double b = ((pow(c1, 2) + 1)/2) + (m/(sqrt(pow(a1, 2) + 1))) - (2.9 *a1);
                    double a;
                    if (d > t && t > 10 && d < 1) {
                        a = t + d;
                    } else if (t > 1) {
                        a = 2 * pow(t, 2) - t * d + 3 * pow(d, 2) - 7 * t - 12 * d + 1;
                    } else {
                        a = (pow(t, 2) * d) / tan(6);
                    }
                    double c = (abs(pow(a, 2) - 5 * b + 4 )/abs(pow(d,2) -4)) * m;
                    System.out.println(
                            "a = " + a +
                                    " d = " + d +
                                    " t = " + t +
                                    " m = " + m +
                                    " b = " + b +
                                    " c = " + c);
                }
            }
        }


    }
}