package edu.miu.cs489;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ArrayReversorTest {

    @Mock
    private ArrayFlattenerService arrayFlattenerService;
    private ArrayReversor arrayReversor;

    @BeforeEach
    void setUp() {
        this.arrayReversor = new ArrayReversor(this.arrayFlattenerService);
    }

    @AfterEach
    void tearDown() {
        this.arrayReversor = null;
    }

    @Test
    void testReverseArray() {
        List<List<Integer>> input = List.of(List.of(1,3), List.of(0), List.of(4,5,9));
        List<Integer> expected = List.of(9,5,4,0,3,1);
        when(arrayFlattenerService.flattenArray(input)).thenReturn(List.of(1,3,0,4,5,9));

        List<Integer> actual = arrayReversor.reverseArray(input);
        assertEquals(expected, actual);

        verify(arrayFlattenerService, times(1)).flattenArray(input);
        verifyNoMoreInteractions(arrayFlattenerService);
    }

    @Test
    void testReverseArrayWithNullInput() {
        assertEquals(null, arrayReversor.reverseArray(null));
        verifyNoInteractions(arrayFlattenerService);
    }
}