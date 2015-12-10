package com.softwarequalitycourse.lab1;

import com.softwarequalitycourse.lab1.SquareMatrix;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;

/**
 * Created by sasha on 4/21/15.
 */
public class SquareMatrixTest {
    @Test
    public void testxSwap() throws Exception {
        int[][] arr={{1,2,3},{1,2,3},{3,5,9}};
        int[][] ans={{0,5,0},{3,0,1},{0,2,0}};

        SquareMatrix matrix = new SquareMatrix(arr);
        matrix.xSwap();
        assertArrayEquals(matrix.getArr(),ans);
    }
    @Test
    public void testSwapArrEl()throws Exception{
        int[][] arr={
                {1,2,3},
                {1,2,3},
                {3,5,9}};

        int[][] ans={
                {1,2,3},
                {1,9,3},
                {3,5,2}};

        SquareMatrix matrix = new SquareMatrix(arr);
        matrix.swapArrEl(1,1,2,2);
        //matrix.swapArrEl(1,0,1,2);

        assertArrayEquals(matrix.getArr(),ans);
    }
    @Test
    public void testxSwap5() throws Exception {
        int[][] arr={   {1, 2,  3,  4,  5},
                {7, 8,  9,  10, 11},
                {13,14, 15, 16, 17},
                {18,19, 20, 21, 22},
                {23,24, 25, 26, 27}};
        int[][] ans={   {0, 24, 25, 26,  0},
                {11,0,  20,  0,  7},
                {17,16, 0,  14, 13},
                {22, 0, 9,  0,  18},
                {0, 2,  3,  4, 0 }};

        SquareMatrix matrix = new SquareMatrix(arr);
        matrix.xSwap();
        assertArrayEquals(matrix.getArr(),ans);
    }
    @Test
    public void testxSwapOneEl() throws Exception {
        int[][] arr={{1}};
        int[][] ans={{0}};

        SquareMatrix matrix = new SquareMatrix(arr);
        matrix.xSwap();
        assertArrayEquals(matrix.getArr(),ans);
    }


    @Test(expected = ArrayNotSquareExeption.class)
    public void testIsMatSquare() throws Exception {
        int[][] arr={{1,2},{1,2,3}};
        SquareMatrix matrix = new SquareMatrix(arr);
    }
    @Test(expected = ArrayNotSquareExeption.class)
    public void testIsMatSquareEmptyArr() throws Exception {
        int[][] arr={{}};
        SquareMatrix matrix = new SquareMatrix(arr);
    }
    @Test(expected = ArrayNotSquareExeption.class)
    public void testIsMatSquareEmptyArr2() throws Exception {
        int[][] arr={};
        SquareMatrix matrix = new SquareMatrix(arr);
    }
}
