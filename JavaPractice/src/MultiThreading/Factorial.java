package MultiThreading;


public class Factorial {
    public void getFactorial(int n){
        try{
            System.out.println("In thread " + Thread.currentThread().getName());
            Thread.sleep(10000);
            int output = 1;
            for (int i=1; i<=n;i++){
                output*=i;
            }
            System.out.println("Factorial for " + n + " is " + output + ". Thread is " + Thread.currentThread().getName());
        } catch (InterruptedException exception) {
            //
        }
    }
}
