package com.softwarequalitycourse.lab1;

import com.softwarequalitycourse.lab1.ArrayNotSquareExeption;
import java.util.Arrays;

/**
 * Created by sasha on 4/21/15.
 */
public class SquareMatrix {
    private int[][]arr;
    public SquareMatrix(int[][]arr) throws ArrayNotSquareExeption {
        if (!isMatSquare(arr)) {
            throw new ArrayNotSquareExeption("");
        }
        this.arr=arr;
    }
    public int[][] getArr() {
        return arr;
    }
    public int customSum(){
        int i = diagonalMaxElIndex();
        int min = arr[i][i];
        int sum=0;
        for(int[] array:arr){
            for (int el: array){
                if(el>min)sum+=el;
            }
        }
        return sum;
    }
    int diagonalMaxElIndex() {
        int max = arr[0][0];
        int index=0;
        for(int i=1;i<arr.length;i++){
            if (arr[i][i]>max) {
                max = arr[i][i];
                index=i;
            }
        }
        return index;
    }
    public void diagonalSwap(){
        int tmp;
        for (int i = 0; i < arr.length; i++) {
            tmp=arr[i][i];
            arr[i][i]=arr[i][arr.length-i-1];
            arr[i][arr.length-i-1]=tmp;
        }
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder= new StringBuilder("Arr =\n");
        for(int[]row:arr) stringBuilder.append(Arrays.toString(row)).append("\n");
        return stringBuilder.toString();
    }
    boolean isMatSquare(int[][] arr) {
        if(arr.length==0)return  false;
        for (int[] row : arr) {
            if (row.length != arr.length) return false;
        }
        return true;
    }
}
