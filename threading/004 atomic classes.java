private AtomicInteger i = new AtomicInteger(); // now can remove the lock. it is thread safe

public void incrementI(){
  i.incrementAndGet();
}

public int getI(){
  return i.get();
}

