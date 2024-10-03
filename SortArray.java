package dumbSort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class SortArray {

    public static int[] sortArray(int[] array) {
        // Return an empty array if the input array is empty
        if (array.length == 0) return new int[0];

        HashSet<Integer> uniqueIntegers = new HashSet<>(); // Track unique integers
        int largestElement = Integer.MIN_VALUE; // Track the largest element
        int smallestElement = Integer.MAX_VALUE; // Track the smallest element
        boolean hasZero = false; // Track if zero is present

        // First pass: identify largest and smallest elements and unique integers
        for (int num : array) {
            if (num == 0) {
                hasZero = true; // Track presence of zero
            } else if (!uniqueIntegers.add(num)) {
                // Skip duplicates
                continue;
            }
            // Update largest and smallest elements
            if (num > largestElement) {
                largestElement = num;
            }
            if (num < smallestElement) {
                smallestElement = num;
            }
        }

        // Handle the case where all numbers are negative
        if (largestElement < 0) {
            int[] resultArray = new int[hasZero ? 1 : 0];
            if (hasZero) {
                resultArray[0] = 0; // Return zero if it exists
            }
            return resultArray;
        }

        // Calculate the range of the placeholder array
        int range = largestElement - smallestElement + 1;
        int[] placeholder = new int[range]; // Placeholder array to hold sorted values
        Arrays.fill(placeholder, Integer.MIN_VALUE); // Mark unused spots

        // Fill the placeholder array
        for (int num : array) {
            placeholder[num - smallestElement] = num; // Adjust index based on smallest element
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

        // Sort the result array to place zero correctly if it exists
        Arrays.sort(resultArray);

        return resultArray; // Return the sorted array
    }

    public static void printArray(int[] array) {
        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the size of the array
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        // Initialize a HashSet to track unique integers
        HashSet<Integer> uniqueIntegers = new HashSet<>();

        // Array to hold the user-entered integers
        int[] inputArray = new int[size];

        System.out.println("Enter " + size + " unique integers (only one zero allowed):");
        int index = 0;

        // Input loop to read integers from the user
        while (index < size) {
            int value = scanner.nextInt();

            // Check for duplicates and only allow one zero
            if (value == 0) {
                if (uniqueIntegers.contains(0)) {
                    System.out.println("Error: Only one zero is allowed. Please enter a different number.");
                } else {
                    uniqueIntegers.add(value); // Add zero to the set
                    inputArray[index++] = value; // Add zero to the input array
                }
            } else if (!uniqueIntegers.add(value)) {
                System.out.println("Error: Duplicate value entered. Please enter a unique number.");
            } else {
                inputArray[index++] = value; // Add valid unique integers to the input array
            }
        }

        // Sort the array using the sortArray method
        int[] sortedArray = sortArray(inputArray);

        // Print the sorted array
        printArray(sortedArray);
    }
}
