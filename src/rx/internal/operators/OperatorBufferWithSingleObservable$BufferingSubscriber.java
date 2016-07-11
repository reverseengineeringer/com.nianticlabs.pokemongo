package rx.internal.operators;

import java.util.ArrayList;
import java.util.List;
import rx.Subscriber;

final class OperatorBufferWithSingleObservable$BufferingSubscriber
  extends Subscriber<T>
{
  final Subscriber<? super List<T>> child;
  List<T> chunk;
  boolean done;
  
  public OperatorBufferWithSingleObservable$BufferingSubscriber(Subscriber<? super List<T>> paramSubscriber)
  {
    Subscriber localSubscriber;
    child = localSubscriber;
    chunk = new ArrayList(initialCapacity);
  }
  
  void emit()
  {
    try
    {
      if (done) {
        return;
      }
      List localList = chunk;
      chunk = new ArrayList(this$0.initialCapacity);
      try
      {
        child.onNext(localList);
        return;
      }
      catch (Throwable localThrowable1)
      {
        unsubscribe();
        try
        {
          if (done) {
            return;
          }
        }
        finally {}
      }
      done = true;
    }
    finally {}
    child.onError(localThrowable2);
  }
  
  public void onCompleted()
  {
    try
    {
      try
      {
        if (done) {
          return;
        }
        done = true;
        List localList = chunk;
        chunk = null;
        child.onNext(localList);
        child.onCompleted();
        unsubscribe();
        return;
      }
      finally {}
      return;
    }
    catch (Throwable localThrowable)
    {
      child.onError(localThrowable);
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    try
    {
      if (done) {
        return;
      }
      done = true;
      chunk = null;
      child.onError(paramThrowable);
      unsubscribe();
      return;
    }
    finally {}
  }
  
  public void onNext(T paramT)
  {
    try
    {
      if (done) {
        return;
      }
      chunk.add(paramT);
      return;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorBufferWithSingleObservable.BufferingSubscriber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */