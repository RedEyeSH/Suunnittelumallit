package iterator;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Sequence fibonacci = new FibonacciSequence();
        Iterator<Integer> iterator = fibonacci.iterator();

        for (int i = 0; i < 10; i++) {
            System.out.print(iterator.next() + " ");
        }
    }
}
