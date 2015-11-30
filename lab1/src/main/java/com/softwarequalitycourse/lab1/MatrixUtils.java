package com.softwarequalitycourse.lab1;

import java.util.Random;

/**
 * Created by sasha on 4/23/15.
 */
public class MatrixUtils {

    public static int[][] genSquereMat(int size) {
        int arr[][] = new int[size][size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr[i][j] = random.nextInt(1000);
            }
        }

        return arr;
    }
}
