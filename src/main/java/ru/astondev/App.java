package ru.astondev;

public class App {
    public static void main(String[] args) {
        СustomList<Integer> integerСustomList = new СustomArrayList<>();

        integerСustomList.add(1);
        integerСustomList.add(2);
        integerСustomList.add(3);

        integerСustomList.getAll();

        integerСustomList.remove(1);
        integerСustomList.getAll();

    }
}
