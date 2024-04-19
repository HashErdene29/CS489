package org.example;

import java.util.Arrays;

public class ArrayReversor {
    private ArrayFlattener arrayFlattener;

    public ArrayReversor(ArrayFlattener arrayFlattener) {
        this.arrayFlattener = arrayFlattener;
    }

    public int[] flattenAndReverseArray(int[][] arr) {
        if (arr == null || arr.length == 0) {return new int[0]; }

        int[] flattenArr = arrayFlattener.flattenArray(arr);
        int[] reversedArr = new int[flattenArr.length];
        for (int i = 0; i < flattenArr.length; i++) {
            reversedArr[i] = flattenArr[flattenArr.length - 1 - i];
        }
        return reversedArr;
    }

}
