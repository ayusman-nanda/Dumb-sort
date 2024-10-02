import java.util.Arrays;
import java.util.Scanner;

public class SortArrayByIndex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] inputArray = new int[size];

        System.out.println("Enter " + size + " integers:");
        for (int i = 0; i < size; i++) {
            inputArray[i] = scanner.nextInt();
        }

        int[] sortedArray = sortArrayByIndex(inputArray);
        System.out.println("Sorted array: " + Arrays.toString(sortedArray));
    }

    public static int[] sortArrayByIndex(int[] array) {
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
}
