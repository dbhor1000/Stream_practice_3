import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {

        //Рассмотрим задачу вычисления факториала числа с использованием ForkJoinPool. Факториал числа n обозначается как n!
        //и вычисляется как произведение всех положительных целых чисел от 1 до n.
        //Реализуйте класс FactorialTask, который расширяет RecursiveTask. Этот класс будет выполнять рекурсивное вычисление факториала числа.

        //В конструкторе FactorialTask передайте число n, факториал которого нужно вычислить.
        //В методе compute() разбейте задачу на подзадачи и используйте fork() для их асинхронного выполнения.
        //Используйте join() для получения результатов подзадач и комбинирования их для получения общего результата.
        //В основном методе создайте экземпляр FactorialTask с числом, для которого нужно вычислить факториал, и запустите его в ForkJoinPool.
        //Выведите результат вычисления факториала.

        int n = 10; // Вычисление факториала для числа 10

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        FactorialTask factorialTask = new FactorialTask(n);

        long result = forkJoinPool.invoke(factorialTask);

        System.out.println("Факториал " + n + "! = " + result);

        Integer[] inputArr = {1, 3 ,4 ,5 ,2, 2, 3, 4, 6, 5, 8, 5, 6, 7, 9, 10};
        ArraySumTask arraySumTask = new ArraySumTask(inputArr);
        Integer result2 = forkJoinPool.invoke(arraySumTask);

        System.out.println("Сумма массива из " + inputArr.length + " элементов = " + result2);

    }
}