package rx.internal.util;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import rx.Producer;
import rx.annotations.Experimental;

@Experimental
public final class BackpressureDrainManager
  implements Producer
{
  protected static final AtomicLongFieldUpdater<BackpressureDrainManager> REQUESTED_COUNT = AtomicLongFieldUpdater.newUpdater(BackpressureDrainManager.class, "requestedCount");
  protected final BackpressureQueueCallback actual;
  protected boolean emitting;
  protected Throwable exception;
  protected volatile long requestedCount;
  protected volatile boolean terminated;
  
  public BackpressureDrainManager(BackpressureQueueCallback paramBackpressureQueueCallback)
  {
    actual = paramBackpressureQueueCallback;
  }
  
  public final void drain()
  {
    boolean bool1;
    long l1;
    int n;
    int m;
    int i;
    BackpressureQueueCallback localBackpressureQueueCallback;
    try
    {
      if (emitting) {
        return;
      }
      emitting = true;
      bool1 = terminated;
      l1 = requestedCount;
      n = 0;
      m = 0;
      i = n;
    }
    finally {}
    try
    {
      localBackpressureQueueCallback = actual;
    }
    finally
    {
      label115:
      if (i != 0) {
        break label311;
      }
    }
    if (bool1)
    {
      i = n;
      if (localBackpressureQueueCallback.peek() == null)
      {
        i = 1;
        localBackpressureQueueCallback.complete(exception);
        if (1 != 0) {
          break label388;
        }
        try
        {
          emitting = false;
          return;
        }
        finally {}
      }
      if (l1 == 0L)
      {
        i = n;
        i = m;
      }
    }
    for (;;)
    {
      int k;
      int j;
      try
      {
        bool1 = terminated;
        i = m;
        if (((BackpressureQueueCallback)localObject2).peek() != null)
        {
          k = 1;
          i = m;
          if (requestedCount != Long.MAX_VALUE) {
            break label314;
          }
          if ((k != 0) || (bool1)) {
            continue;
          }
          j = 1;
          i = j;
          emitting = false;
          i = j;
          if (1 != 0) {
            break label388;
          }
          try
          {
            emitting = false;
            return;
          }
          finally {}
          i = n;
          Object localObject9 = ((BackpressureQueueCallback)localObject3).poll();
          if (localObject9 == null) {
            break label115;
          }
          i = n;
          boolean bool2 = ((BackpressureQueueCallback)localObject3).accept(localObject9);
          if (bool2)
          {
            if (1 != 0) {
              break label388;
            }
            try
            {
              emitting = false;
              return;
            }
            finally {}
          }
          l1 -= 1L;
          j += 1;
          break label391;
        }
        k = 0;
        continue;
        l1 = Long.MAX_VALUE;
        i = m;
      }
      finally {}
      try
      {
        emitting = false;
        label311:
        throw ((Throwable)localObject6);
        label314:
        i = m;
        l2 = REQUESTED_COUNT.addAndGet(this, -j);
        if (l2 != 0L)
        {
          l1 = l2;
          if (k != 0) {
            continue;
          }
          break label406;
          j = 1;
          i = j;
          emitting = false;
          i = j;
          if (1 == 0) {
            try
            {
              emitting = false;
              return;
            }
            finally {}
          }
        }
      }
      finally
      {
        long l2;
        label388:
        label391:
        label406:
        do
        {
          throw ((Throwable)localObject8);
          return;
          j = 0;
          if (l1 > 0L) {
            break;
          }
          if (!bool1) {
            break label115;
          }
          break;
        } while (!bool1);
        l1 = l2;
      }
    }
  }
  
  public final boolean isTerminated()
  {
    return terminated;
  }
  
  public final void request(long paramLong)
  {
    if (paramLong == 0L) {
      return;
    }
    label31:
    label73:
    label101:
    for (;;)
    {
      long l2 = requestedCount;
      if (l2 == 0L) {}
      for (int i = 1; l2 == Long.MAX_VALUE; i = 0)
      {
        if (i == 0) {
          break label73;
        }
        drain();
        return;
      }
      long l1;
      if (paramLong == Long.MAX_VALUE)
      {
        l1 = paramLong;
        i = 1;
      }
      for (;;)
      {
        if (!REQUESTED_COUNT.compareAndSet(this, l2, l1)) {
          break label101;
        }
        break label31;
        break;
        if (l2 > Long.MAX_VALUE - paramLong) {
          l1 = Long.MAX_VALUE;
        } else {
          l1 = l2 + paramLong;
        }
      }
    }
  }
  
  public final void terminate()
  {
    terminated = true;
  }
  
  public final void terminate(Throwable paramThrowable)
  {
    if (!terminated)
    {
      exception = paramThrowable;
      terminated = true;
    }
  }
  
  public final void terminateAndDrain()
  {
    terminated = true;
    drain();
  }
  
  public final void terminateAndDrain(Throwable paramThrowable)
  {
    if (!terminated)
    {
      exception = paramThrowable;
      terminated = true;
      drain();
    }
  }
  
  public static abstract interface BackpressureQueueCallback
  {
    public abstract boolean accept(Object paramObject);
    
    public abstract void complete(Throwable paramThrowable);
    
    public abstract Object peek();
    
    public abstract Object poll();
  }
}

/* Location:
 * Qualified Name:     rx.internal.util.BackpressureDrainManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */