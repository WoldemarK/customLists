package ru.astondev;


import ru.astondev.utils.QuickSort;



public class App {
    public static void main(String[] args) {
        СustomList<Integer>integer = new СustomArrayList<>();

        integer.add(8);
        integer.add(5);
        integer.add(7);
        integer.add(1);
        integer.add(4);
        integer.add(2);
        integer.add(3);
        integer.add(6);

        QuickSort.quickSort(integer,0,7);

        for (int i = 0; i < integer.size(); i++) {
            System.out.println(integer.get(i)+"\n");
        }


    }
}
