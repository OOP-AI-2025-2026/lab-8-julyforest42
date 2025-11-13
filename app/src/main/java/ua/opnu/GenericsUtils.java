package ua.opnu;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.Predicate;

class GenericsUtils {

    public static <T> T[] filter(T[] input, Predicate<T> p) {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) Array.newInstance(input.getClass().getComponentType(), input.length);

        int counter = 0;
        for (T element : input) {
            if (p.test(element)) {
                result[counter] = element;
                counter++;
            }
        }

        return Arrays.copyOf(result, counter);
    }

    public static <T extends Comparable<T>, V extends T> boolean contains(T[] array, V element) {
        for (T item : array) {
            if (item.compareTo(element) == 0) {
                return true;
            }
        }
        return false;
    }
}