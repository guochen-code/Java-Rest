// Task1 extends from Thread

Task1 task1 = new Task1();
task1.start();

// Task2 implements Runnable
Task 2 task2 = new Task2();
Thread thread = new Thread(task2);  // additional step
thread.start();

// set priority
task1.setPriority(1); // 1-10, higher the number higher the priority

// wait
task1.join();

//sleep
Thread.sleep(1000); // 1 second

// yield
Thread.yeild(); // request to give up cpu




