package edu.miu.cs489;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayFlattenerTest {

    private ArrayFlattener arrayFlattener;

    @BeforeEach
    void setUp() {
        this.arrayFlattener = new ArrayFlattener();
    }

    @AfterEach
    void tearDown() {
        this.arrayFlattener = null;
    }

    @Test
    void testFlattenArray() {
        List<List<Integer>> input = List.of(List.of(1,3), List.of(0), List.of(4,5,9));
        List<Integer> expected = List.of(1,3,0,4,5,9);
        List<Integer> actual = this.arrayFlattener.flattenArray(input);
        assertEquals(expected, actual);
    }

    @Test
    void testFlattenArrayWithNullInput() {
        List<Integer> actual = this.arrayFlattener.flattenArray(null);
        assertEquals(null, actual);
    }
}