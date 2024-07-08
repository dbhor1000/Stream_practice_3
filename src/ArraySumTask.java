import java.util.concurrent.RecursiveTask;

public class ArraySumTask extends RecursiveTask<Integer> {

    private final Integer[] array;
    private final int start;
    private final int end;
    private static final int THRESHOLD = 5;

    public ArraySumTask(Integer[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    public ArraySumTask(Integer[] array) {
        this.array = array;
        this.start = 0;
        this.end = array.length;
    }

    @Override
    protected Integer compute() {
        int length = end - start;
        if (length < THRESHOLD) {
            int sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            return sum;
        } else {
            int third1 = start + (length / 3);
            int third2 = start + (length * 2 / 3);
            ArraySumTask leftTask = new ArraySumTask(array, start, third1);
            ArraySumTask rightTask1 = new ArraySumTask(array, third1, third2);
            ArraySumTask rightTask2 = new ArraySumTask(array, third2, end);

            leftTask.fork();
            rightTask1.fork();
            Integer rightResult2 = rightTask2.compute();
            Integer leftResult = leftTask.join();
            Integer rightResult1 = rightTask1.join();
            return leftResult + rightResult1 + rightResult2;
        }
    }
}
