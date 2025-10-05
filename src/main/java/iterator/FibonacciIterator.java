package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FibonacciIterator implements Iterator<Integer> {
    private int count = 0;
    private int maxElements = Integer.MAX_VALUE;
    private long prev = 0;
    private long current = 1;

    public FibonacciIterator() {}

    public FibonacciIterator(int maxElements) {
        this.maxElements = maxElements;
    }

    @Override
    public boolean hasNext() {
        return count < maxElements;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements in Fibonacci");
        }

        int nextValue;
        if (count == 0 || count == 1) {
            nextValue = 1;
        } else {
            nextValue = (int)(prev + current);
            prev = current;
            current = nextValue;
        }

        count++;
        if (count <= 2) {
            prev = 1;
            current = 1;
        }

        return nextValue;
    }
}
