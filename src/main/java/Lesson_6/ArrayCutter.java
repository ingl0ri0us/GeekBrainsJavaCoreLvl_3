package Lesson_6;

import java.util.Arrays;

public class ArrayCutter {
    private int[] initialArray;
    private int[] resultArray;

    public static void main(String[] args) {
        ArrayCutter arrayCutter = new ArrayCutter();
        arrayCutter.initialArray = new int[] {4};
        arrayCutter.resultArray = arrayCutter.splitArrayAfterFour(arrayCutter.initialArray);
        System.out.println(Arrays.toString(arrayCutter.resultArray));
    }

    public int[] splitArrayAfterFour (int[] initArray) {
        boolean containsFour = false;

        for (int i :
                initArray) {
            if (i == 4) containsFour = true;
        }

        if(!containsFour) {
            throw new RuntimeException("There is no '4' in array!");
        }

        int lastFour = 0;

        for (int i = 0; i < initArray.length; i++) {
            if (initArray [i] == 4) {
                lastFour = i;
            }
        }

        return Arrays.copyOfRange(initArray,lastFour + 1, initArray.length);
    }
}
