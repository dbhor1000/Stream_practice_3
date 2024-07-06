import java.util.concurrent.RecursiveTask;

public class FactorialTask extends RecursiveTask<Integer> {
    private final int n;

    public FactorialTask(int n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if (n <= 1) {
            return 1;
        } else {
            FactorialTask subtask = new FactorialTask(n-1);
            subtask.fork(); // Асинхронное выполнение подзадачи
            return n * subtask.join(); // Получение результата подзадачи и комбинирование его
        }
    }
}

