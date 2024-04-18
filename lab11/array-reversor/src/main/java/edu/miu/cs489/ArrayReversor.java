package edu.miu.cs489;

import java.util.List;

public class ArrayReversor {

    private ArrayFlattenerService arrayFlattenerService;

    public ArrayReversor(ArrayFlattenerService arrayFlattenerService) {
        this.arrayFlattenerService = arrayFlattenerService;
    }

    public List<Integer> reverseArray(List<List<Integer>> array) {
        if (array == null)
            return null;

        return this.arrayFlattenerService.flattenArray(array).reversed();
    }

}
