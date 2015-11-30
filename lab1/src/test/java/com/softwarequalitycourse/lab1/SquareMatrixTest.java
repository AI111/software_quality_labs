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
    public void testCustomSum() throws Exception {
        int[][] arr=
                {{1,2,3},
                        {4,5,6},
                        {7,8,5}};
        SquareMatrix matrix = new SquareMatrix(arr);
        int ans =matrix.customSum();
        assertEquals(21,ans);
    }
    @Test
    public void testCustomSumEmptyArr() throws Exception {
        int[][] arr= {{5}};
        SquareMatrix matrix = new SquareMatrix(arr);
        int ans =matrix.customSum();
        assertEquals(0,ans);
    }
    @Test
    public void testDiagonalMaxElIndex() throws Exception {
        int[][] arr=
                {{1,2,3},
                        {4,5,6},
                        {7,8,5}};
        SquareMatrix matrix = new SquareMatrix(arr);
        int ans =matrix.diagonalMaxElIndex();
        assertEquals(1,ans);
    }
    @Test
    public void testDiagonalMaxElIndexEmptyArr() throws Exception {
        int[][] arr= {{100}};
        SquareMatrix matrix = new SquareMatrix(arr);
        int ans =matrix.diagonalMaxElIndex();
        assertEquals(0,ans);
    }
    @Test
    public void testDiagonalSwap() throws Exception {
        int[][] arr=
                {{1,2,3},
                        {4,5,6},
                        {7,8,9}};
        int[][] ans=
                {{3,2,1},
                        {4,5,6},
                        {9,8,7}};
        SquareMatrix matrix = new SquareMatrix(arr);
        matrix.diagonalSwap();
        assertArrayEquals(matrix.getArr(), ans);
    }
    @Test
    public void testDiagonalSwapSingeArr() throws Exception {
        int[][] arr=
                {{777}};
        SquareMatrix matrix = new SquareMatrix(arr);
        matrix.diagonalSwap();
        assertArrayEquals(matrix.getArr(), arr);
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
