package ed.lab;

import java.util.Random;

public class SortingAlgorithms {

    public static <T extends Comparable<T>> void highPivotQuickSort(T[] array) {
        quickSortHigh(array, 0, array.length - 1);
    }

    public static <T extends Comparable<T>> void lowPivotQuickSort(T[] array) {
        quickSortLow(array, 0, array.length - 1);
    }

    public static <T extends Comparable<T>> void randomPivotQuickSort(T[] array) {
        quickSortRandom(array, 0, array.length - 1);
    }

    // ---------- Implementaciones ----------

    private static <T extends Comparable<T>> void quickSortHigh(T[] a, int low, int high) {
        if (low < high) {
            int p = partitionHigh(a, low, high);
            quickSortHigh(a, low, p - 1);
            quickSortHigh(a, p + 1, high);
        }
    }

    private static <T extends Comparable<T>> int partitionHigh(T[] a, int low, int high) {
        T pivot = a[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (a[j].compareTo(pivot) <= 0) {
                swap(a, ++i, j);
            }
        }
        swap(a, i + 1, high);
        return i + 1;
    }

    private static <T extends Comparable<T>> void quickSortLow(T[] a, int low, int high) {
        if (low < high) {
            int p = partitionLow(a, low, high);
            quickSortLow(a, low, p - 1);
            quickSortLow(a, p + 1, high);
        }
    }

    private static <T extends Comparable<T>> int partitionLow(T[] a, int low, int high) {
        T pivot = a[low];
        int i = high + 1;
        for (int j = high; j > low; j--) {
            if (a[j].compareTo(pivot) > 0) {
                swap(a, --i, j);
            }
        }
        swap(a, low, i - 1);
        return i - 1;
    }

    private static <T extends Comparable<T>> void quickSortRandom(T[] a, int low, int high) {
        if (low < high) {
            int randomIndex = low + new Random().nextInt(high - low + 1);
            swap(a, randomIndex, high);
            int p = partitionHigh(a, low, high);
            quickSortRandom(a, low, p - 1);
            quickSortRandom(a, p + 1, high);
        }
    }

    private static <T> void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}