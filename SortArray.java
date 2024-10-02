package dumbSort;

import java.util.Arrays;

public class SortArray {

    public static int[] sortArray(int[] array) {
        if (array.length == 0) return new int[0];

        int largestElement = Integer.MIN_VALUE;
        for (int num : array) {
            if (num > largestElement) largestElement = num;
        }

        int[] sortedArray = new int[largestElement + 1];
        for (int num : array) {
            sortedArray[num] = num;
        }

        int nonEmptyCount = 0;
        for (int num : sortedArray) {
            if (num != 0) nonEmptyCount++;
        }

        int[] resultArray = new int[nonEmptyCount];
        int index = 0;
        for (int num : sortedArray) {
            if (num != 0) resultArray[index++] = num;
        }

        return resultArray;
    }

    public static void printArray(int[] array) {
        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}
