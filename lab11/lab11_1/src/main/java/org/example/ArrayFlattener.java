package org.example;

public class ArrayFlattener {

    public int[] flattenArray(int[][] arr) {
        if (arr == null || arr.length == 0) { return new int[0];}
        int length = 0;
        for(int[] innerArr : arr) {
            length += innerArr.length;
        }

        int[] result = new int[length];
        int index = 0;
        for (int[] innerArr : arr) {
            for(int num : innerArr) {
                result[index++] = num;
            }
        }
        return result;
    }
}
