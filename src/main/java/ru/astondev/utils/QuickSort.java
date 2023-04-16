package ru.astondev.utils;

import ru.astondev.СustomList;

/**
 * В данном классе имеется метод для быстрой сортировки,
 * вынес метод в отдельный клас что бы не перегружать класс MyArrayList
 */
public class QuickSort<T> {
    public static  <T extends Comparable<T>> void quickSort(СustomList<T> tСustomList, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(tСustomList, low, high);
            quickSort(tСustomList, low, pivotIndex - 1);
            quickSort(tСustomList, pivotIndex + 1, high);
        }
    }

    private static  <T extends Comparable<T>> int partition(СustomList<T> tСustomList, int low, int high) {
        T pivotValue = tСustomList.get(high);
        int i = low;

        for (int j = low; j < high; j++) {
            if (tСustomList.get(j).compareTo(pivotValue) < 0) {
                swap(tСustomList, i, j);
                i++;
            }
        }
        swap(tСustomList, i, high);
        return i;
    }

    private static  <T> void swap(СustomList<T> tСustomList, int i, int j) {
        T temp = tСustomList.get(i);
        tСustomList.set(i, tСustomList.get(j));
        tСustomList.set(j, temp);
    }

}
