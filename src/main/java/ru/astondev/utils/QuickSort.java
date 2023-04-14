package ru.astondev.utils;

import ru.astondev.СustomList;

/**
 * В данном классе имеется метод для быстрой сортировки,
 * вынес метод в отдельный клас что бы не перегружать класс MyArrayList
 */
public class QuickSort<T> {
    public <T extends Comparable<T>> void quickSort(СustomList<Integer> tСustomList, int low, int high) {
        if (tСustomList.size() == 0) return;
        if (low >= high) return;
        int middle = low + (high - low) / 2;
        int opora = tСustomList.indexOf(middle);
        int i = low, j = high;
        while (i <= j) {
            while (tСustomList.indexOf(i) < opora) {
                i++;
            }
            while (tСustomList.indexOf(j) > opora) {
                j--;
            }
            if (i <= j) {
                Integer temp = (Integer) tСustomList.get(i);
                tСustomList.set(i, (Integer) tСustomList.get(j));
                tСustomList.set(j, temp);
                i++;
                j--;
            }
        }
        if (low < j)
            quickSort(tСustomList, low, j);
        if (high > i)
            quickSort(tСustomList, i, high);
    }

}
