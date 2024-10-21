package MultiThreading.ForkJoin;

import java.util.concurrent.RecursiveTask;

public class ForkJoinPractice extends RecursiveTask<Integer> {
    public static final int THRESHOLD=4;
    private int min;
    private int max;
    ForkJoinPractice(int min, int max){
        this.min = min;
        this.max = max;
    }
    @Override
    protected Integer compute() {
        if ((max - min) <= THRESHOLD){
            int sum = 0;
            for (int i=min; i<= max; i++){
                sum += i;
            }
            return sum;
        } else {
            int mid = (max + min)/2;
            ForkJoinPractice leftTask = new ForkJoinPractice(min, mid);
            ForkJoinPractice rightTask = new ForkJoinPractice(mid+1, max);

            leftTask.fork();
            rightTask.fork();

            int leftSum = leftTask.join();
            int rightSum = rightTask.join();
            return leftSum + rightSum;
        }
    }
}
