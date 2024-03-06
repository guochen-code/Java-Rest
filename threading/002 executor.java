// tasks to be executed one after one.
ExecutorService executorService = Executors.newSingleThreadExecutor();
executorService.execute(new Task1());
executorService.execute(new Thread(Task2()));

executorService.shutdown();

// executed at the same time.
ExecutorService executorService = Executors.newFixedThreadPool(2);
executorService.execute(new Task1());
executorService.execute(new Thread(Task2()));

// use a callable
Fture<String> welcomeFuture = executorService.submit(new CallableTask("some value"));
String = welcomeMessage = welcomeFuture.get(); // will wait here until the thread is completed.

// waiting for completion of multiple tasks
List<CallableTask> tasks = List.of(new CallableTask("task1"), new CallableTask("task2"), new CallableTask("task3"));
List<Future<String>> results = executorService.invokeAll(tasks);
for(Future<String> result:results){
  System.out.println(result.get(());
}

// get whichever that is the first one
String result = executorService.invokeAny(tasks);




