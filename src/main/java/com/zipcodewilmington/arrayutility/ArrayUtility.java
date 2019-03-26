package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
    private T[] resultArr;
    
    public ArrayUtility(T[] inputArray) {
        resultArr = inputArray;
    }
    
    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        Long answer = Stream.concat(Stream.of(resultArr), Stream.of(arrayToMerge))
                .filter(valueToEvaluate::equals)
                .count();
        return answer.intValue();
    }
    
    public T[] removeValue(T valueToRemove) {
        List<T> list = Arrays.stream(resultArr)
                .filter(x -> !valueToRemove.equals(x))
                .collect(Collectors.toList());
        T[] result = (T[]) Array.newInstance(resultArr.getClass().getComponentType(), list.size());
        return list.toArray(result);
    }
    
    public T getMostCommonFromMerge(T[] arrayToMerge) {
        T answer = null;
        int counter = 0;
        List<T> list = Stream.concat(Stream.of(resultArr), Stream.of(arrayToMerge))
                .collect(Collectors.toList());
        for (T object : list) {
            if (getNumOfOccurrences(object) > counter) {
                answer = object;
                counter = getNumOfOccurrences(object);
            }
        }
        return answer;
    }
    
    public Integer getNumOfOccurrences(T valueToEvaluate) {
        Long answer = Arrays.stream(resultArr)
                .filter(valueToEvaluate::equals)
                .count();
        return answer.intValue();
    }
}