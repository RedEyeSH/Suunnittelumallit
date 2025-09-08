package strategy;

import java.util.Random;

public class Main {
    public static int[] generateRandom(int size) {
        int[] list = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            list[i] = random.nextInt(1000);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] smallArray = generateRandom(30);
        int[] largeArray = generateRandom(100000);

        SortStrategy[] algorithms = {
                new BubbleSort(),
                new MergeSort(),
                new QuickSort()
        };

        String[] algorithmsName = {
                "Bubble Sort",
                "Merge Sort",
                "Quick Sort"
        };

        SortContext sorter = new SortContext();

        System.out.println("===Small Array===");
        for (int i = 0; i < algorithms.length; i++) {
            int[] copy = smallArray.clone();
            sorter.setStrategy(algorithms[i]);
            long start = System.nanoTime();
            sorter.sort(copy);
            long end = System.nanoTime();
            System.out.println(algorithmsName[i] + " took " + (end - start) + " ns");
        }

        System.out.println();

        System.out.println("===Large Array===");
        for (int i = 0; i < algorithms.length; i++) {
            int[] copy = largeArray.clone();
            sorter.setStrategy(algorithms[i]);
            long start = System.nanoTime();
            sorter.sort(copy);
            long end = System.nanoTime();
            System.out.println(algorithmsName[i] + " took " + ((end - start) / 1000000) + " ms");
        }
    }
}
