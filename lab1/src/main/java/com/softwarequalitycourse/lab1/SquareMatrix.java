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
    void xSwap(){
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr.length ; j++) {
                if(i==j||i==arr.length-j-1){
                    arr[i][j]=0;
                }else{
                    if(j<arr.length-i-1){
                        if(j>i){
                            swapArrEl(arr.length-i-1,j,i,j);
                        }else{
                            swapArrEl(i,arr.length-1-j,i,j);
                        }
                    }
                }
            }
        }
    }
    void swapArrEl(int el1y,int el1x,int el2y,int el2x){
        int t = arr[el1y][el1x];
        arr[el1y][el1x]=arr[el2y][el2x];
        arr[el2y][el2x]=t;
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
