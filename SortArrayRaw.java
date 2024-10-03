import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class SortArrayRaw{
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

        // Sort the array using the placeholder method
        int[] sortedArray = sortArrayWithPlaceholder(inputArray);

        // Print the sorted array
        System.out.println("Sorted array: " + Arrays.toString(sortedArray));
    }

    public static int[] sortArrayWithPlaceholder(int[] array) {
        // Return an empty array if the input array is empty
        if (array.length == 0) return new int[0];

        int largestElement = Integer.MIN_VALUE; // Initialize to the smallest possible integer
        int smallestElement = Integer.MAX_VALUE; // Initialize to the largest possible integer

        // Find the largest and smallest elements in the array
        for (int num : array) {
            if (num > largestElement) largestElement = num; // Update largest if current number is larger
            if (num < smallestElement) smallestElement = num; // Update smallest if current number is smaller
        }

        // Calculate the range of the placeholder array
        int range = largestElement - smallestElement + 1;
        int[] placeholder = new int[range]; // Placeholder array to hold sorted values
        Arrays.fill(placeholder, Integer.MIN_VALUE); // Fill with Integer.MIN_VALUE to mark unused spots

        // Fill the placeholder array, including zeros
        for (int num : array) {
            placeholder[num - smallestElement] = num; // Adjust index based on smallest element
        }

        // Count valid (non-empty) numbers for the result array
        int nonEmptyCount = 0;
        for (int value : placeholder) {
            if (value != Integer.MIN_VALUE) nonEmptyCount++; // Count only valid entries
        }

        // Create the result array with space for zero if it exists in the input
        int[] resultArray = new int[nonEmptyCount];
        int index = 0;

        // Populate the result array with valid values from the placeholder
        for (int value : placeholder) {
            if (value != Integer.MIN_VALUE) {
                resultArray[index++] = value; // Fill the result array with valid entries
            }
        }

        // Sort the result array to place zero correctly
        Arrays.sort(resultArray);

        return resultArray; // Return the sorted array
    }
}
