package edu.miu.cs489;

import java.util.Collection;
import java.util.List;

public class ArrayFlattenerService {
    public List<Integer> flattenArray(List<List<Integer>> array) {
        if (array == null)
            return null;

        return array.stream()
                .flatMap(Collection::stream)
                .toList();
    }
}
