import dumbSort.SortArray;

public class Main {
    public static void main(String[] args) {
        // Define an array to sort
        int[] arrayToSort = {12, -7, 3, -15, 21,
    -4, 8, 14, -30, 5,
    -22, 18, 7, -11, 0,
    9, -2, 16, -8, 25,
    -19};

        // Sort the array using the SortArray class
        int[] sortedArray = SortArray.sortArray(arrayToSort);

        // Print the sorted array
        SortArray.printArray(sortedArray);
    }
}
