package ru.astondev;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.astondev.utils.QuickSort;


public class QuickSortTest {
    private QuickSort quickSort;

    @BeforeEach
    void init() {
        quickSort = new QuickSort();
    }

    @Test
    void testMethodQuickSort() {
        СustomList<Integer> integerСustomList = new СustomArrayList<>();
        integerСustomList.add(6);
        integerСustomList.add(1);
        integerСustomList.add(3);
        integerСustomList.add(2);
        integerСustomList.add(5);
        integerСustomList.add(4);

        quickSort.quickSort(integerСustomList,0,4);

        for (int i = 0; i < integerСustomList.size() - 1; i++) {
           // assertTrue(integerСustomList.get(i)<= integerСustomList.get(i+1));
        }

    }
}
