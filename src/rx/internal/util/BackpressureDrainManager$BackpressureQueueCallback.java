package rx.internal.util;

public abstract interface BackpressureDrainManager$BackpressureQueueCallback
{
  public abstract boolean accept(Object paramObject);
  
  public abstract void complete(Throwable paramThrowable);
  
  public abstract Object peek();
  
  public abstract Object poll();
}

/* Location:
 * Qualified Name:     rx.internal.util.BackpressureDrainManager.BackpressureQueueCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */