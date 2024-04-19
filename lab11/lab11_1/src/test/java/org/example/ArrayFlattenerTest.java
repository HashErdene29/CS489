package org.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(value = MockitoJUnitRunner.class)
public class ArrayFlattenerTest {
    private ArrayFlattener arrayFlattener;

    @Before
    public void setUp() {
        arrayFlattener = new ArrayFlattener();
    }

    @Test
    public void testArrayFlattener() {
        int[][] arr = {{1, 3}, {0}, {4, 5, 9}};
        int[] expected = {1, 3, 0, 4, 5, 9};
        int[] result = arrayFlattener.flattenArray(arr);
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void testArrayFlattenerNull() {
        int[][] arr = null;
        int[] expected = {};
        int[] result = arrayFlattener.flattenArray(arr);
        Assert.assertArrayEquals(expected, result);
    }
}
