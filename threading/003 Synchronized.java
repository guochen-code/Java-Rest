synchronized public void increment(){
  i++;
}

// it is ok for single variable i
// the problem starts to merge when it is a binary counter with i and j
// thread 1 to change i while thread 2 to change j, locked
Lock lockForI = new ReentrantLock();
Lock lockForJ = new ReentrantLock();

public void incrementI(){
  lockForI.lock(); // will check if another other thread holds a lock on i. If not, gain the lock; if yes, wait.
  i++;
  lockForI.unlock();
}

public void increment()J{
  lockForJ.lock();
  j++;
  lockForJ.unlock();
}

//if you want to control how long you want to wait to gain the lock
lockForI.try() // return false if not get the lock
lockForI.try(long time,TimeUnit unit) // wait for 10 seconds

