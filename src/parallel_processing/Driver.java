package parallel_processing;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Driver {

    public static void main(String[] args) {
        final int N = 900000;
        int[] list = new int[N];

        for (int i = 0 ; i < N;i++)
            list[i] = i;
        System.out.println("Max number : " + max(list));
        System.out.println("Processors : " + Runtime.getRuntime().availableProcessors());
    }

    private static int max(int[] list){
        RecursiveTask<Integer> task = new FindMaxTask(list , 0, list.length);
        ForkJoinPool pool = new ForkJoinPool();
        return pool.invoke(task);
    }
}
