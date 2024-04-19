package org.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(value = MockitoJUnitRunner.class)
public class ArrayReversorTest {
    @Mock
    ArrayFlattener arrayFlattener;

    @Test
    public void reverseArray() {
        int[][] arr = {{1, 3}, {0}, {4, 5, 9}};
        int[] expected1 = {1, 3, 0, 4, 5, 9};
        int[] expected2 = {9, 5, 4, 0, 3, 1};

        ArrayReversor arrayReversor = new ArrayReversor(arrayFlattener);
        when(arrayFlattener.flattenArray(arr)).thenReturn(expected1);

        int[] res = arrayReversor.flattenAndReverseArray(arr);
        Assert.assertArrayEquals(expected2, res);
        verify(arrayFlattener).flattenArray(arr);
    }

    @Test
    public void ArrayReverseTestNull(){
        ArrayReversor arrayReversor = new ArrayReversor(null);
        int[][] arr = null;
        int[] expected = {};
        int[] res = arrayReversor.flattenAndReverseArray(arr);
        Assert.assertArrayEquals(expected, res);
    }


}
