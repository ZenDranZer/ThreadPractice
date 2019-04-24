package parallel_processing;

import java.util.concurrent.RecursiveTask;

public class FindMaxTask extends RecursiveTask<Integer> {

    private static final int THRESHOLD = 1000;
    private int[] list;
    private int low;
    private int high;

    public FindMaxTask(int[] list, int low, int high) {
        this.list = list;
        this.low = low;
        this.high = high;
    }

    @Override
    protected Integer compute() {
        if(high-low < THRESHOLD){
            int max = list[0];
            for(int i = low;i<high;i++){
                if(list[i] > max)
                    max = list[i];
            }
            return max;
        }
        else{
            int mid = (high + low)/2;
            RecursiveTask<Integer> left = new FindMaxTask(list,low,mid);
            RecursiveTask<Integer> right = new FindMaxTask(list,mid,high);
            right.fork();
            left.fork();
            return Math.max(left.join(), right.join());
        }
    }
}
