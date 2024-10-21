package MultiThreadingLockTypes;

public class ConditionMain {
    public static void main(String[] args) {
        ConditionTest conditionTest = new ConditionTest();
        Thread producerThread = new Thread(() -> {
            for (int i=0; i<3; i++)
                conditionTest.producer();
        });

        Thread consumerThread = new Thread(() -> {
            for (int i=0; i<3; i++)
                conditionTest.consumer();
        });

        producerThread.start();
        consumerThread.start();
    }
}
