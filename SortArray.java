package dumbSort;

import java.util.Arrays;
import java.util.HashSet;

public class SortArray {

    public static int[] sortArray(int[] array) {
        // Return an empty array if the input array is empty
        if (array.length == 0) return new int[0];

        HashSet<Integer> uniqueIntegers = new HashSet<>(); // Track unique integers
        int largestElement = Integer.MIN_VALUE; // Track the largest element
        boolean hasZero = false; // Track if zero is present

        // First pass: identify largest element and unique integers
        for (int num : array) {
            if (num == 0) {
                if (!hasZero) {
                    hasZero = true; // Only allow one zero
                }
            } else if (!uniqueIntegers.add(num)) {
                // Skip duplicates
                continue;
            }
            // Update largest element
            if (num > largestElement) {
                largestElement = num;
            }
        }

        // Create a placeholder array based on the largest element
        int[] placeholder = new int[largestElement + 1];
        Arrays.fill(placeholder, Integer.MIN_VALUE); // Mark unused spots

        // Fill the placeholder array, including zero if it exists
        for (int num : array) {
            if (num != 0) {
                placeholder[num] = num; // Place non-zero values
            }
        }
        // Place zero in the correct position if it exists
        if (hasZero) {
            placeholder[0] = 0;
        }

        // Count valid (non-empty) numbers for the result array
        int nonEmptyCount = 0;
        for (int value : placeholder) {
            if (value != Integer.MIN_VALUE) {
                nonEmptyCount++; // Count valid entries
            }
        }

        // Create the result array
        int[] resultArray = new int[nonEmptyCount];
        int index = 0;

        // Populate the result array with valid values from the placeholder
        for (int value : placeholder) {
            if (value != Integer.MIN_VALUE) {
                resultArray[index++] = value; // Fill the result array with valid entries
            }
        }

        return resultArray; // Return the sorted array
    }

    public static void printArray(int[] array) {
        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}
