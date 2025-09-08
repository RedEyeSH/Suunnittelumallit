package strategy;

public class BubbleSort implements SortStrategy {
    @Override
    public void sort(int[] list) {
        int n = list.length;
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list[j] > list[j + 1]) {
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }
}
