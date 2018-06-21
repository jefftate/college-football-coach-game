/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.collegefootballcoach.ui;

import java.util.Scanner;

/**
 *
 * @author jefftate
 */
public class UserIOConsoleImpl implements UserIO {

    private double d;
    private float f;
    private int i;
    private long l;
    private String s;
    private String goodOrNot;

    Scanner sc = new Scanner(System.in);

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public double readDouble(String prompt) {
        System.out.println(prompt);
        return sc.nextDouble();
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        goodOrNot = "Not Good";

        while (goodOrNot.equals("Not Good")) {
            System.out.println(prompt);
            d = sc.nextDouble();
            sc.nextLine();

            if (min > d || max < d) {
                System.out.println("Number must be between " + min + " and " + max);
            } else {
                goodOrNot = "Good";
            }
        }
        return d;
    }

    @Override
    public float readFloat(String prompt) {
        System.out.println(prompt);
        return sc.nextFloat();
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        goodOrNot = "Not Good";

        while (goodOrNot.equals("Not Good")) {
            System.out.println(prompt);
            f = sc.nextFloat();
            sc.nextLine();

            if (min > f || max < f) {
                System.out.println("Number must be between " + min + " and " + max);
            } else {
                goodOrNot = "Good";
            }
        }
        return f;
    }

    @Override
    public int readInt(String prompt) {
        System.out.println(prompt);
        return sc.nextInt();
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        goodOrNot = "Not Good";

        while (goodOrNot.equals("Not Good")) {
            System.out.println(prompt);
            i = sc.nextInt();
            sc.nextLine();

            if (min > i || max < i) {
                System.out.println("Number must be between " + min + " and " + max);
            } else {
                goodOrNot = "Good";
            }
        }
        return i;
    }

    @Override
    public long readLong(String prompt) {
        System.out.println(prompt);
        return sc.nextLong();
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        goodOrNot = "Not Good";

        while (goodOrNot.equals("Not Good")) {
            System.out.println(prompt);
            l = sc.nextLong();
            sc.nextLine();

            if (min > l || max < l) {
                System.out.println("Number must be between " + min + " and " + max);
            } else {
                goodOrNot = "Good";
            }
        }
        return l;
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        return sc.nextLine();
    }
}
