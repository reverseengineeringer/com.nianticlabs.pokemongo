package rx.internal.operators;

import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.Observable.Operator;
import rx.Subscriber;
import rx.functions.Func0;
import rx.observers.SerializedSubscriber;
import rx.observers.Subscribers;

public final class OperatorBufferWithSingleObservable<T, TClosing>
  implements Observable.Operator<List<T>, T>
{
  final Func0<? extends Observable<? extends TClosing>> bufferClosingSelector;
  final int initialCapacity;
  
  public OperatorBufferWithSingleObservable(final Observable<? extends TClosing> paramObservable, int paramInt)
  {
    bufferClosingSelector = new Func0()
    {
      public Observable<? extends TClosing> call()
      {
        return paramObservable;
      }
    };
    initialCapacity = paramInt;
  }
  
  public OperatorBufferWithSingleObservable(Func0<? extends Observable<? extends TClosing>> paramFunc0, int paramInt)
  {
    bufferClosingSelector = paramFunc0;
    initialCapacity = paramInt;
  }
  
  public Subscriber<? super T> call(Subscriber<? super List<T>> paramSubscriber)
  {
    try
    {
      Observable localObservable = (Observable)bufferClosingSelector.call();
      final BufferingSubscriber localBufferingSubscriber = new BufferingSubscriber(new SerializedSubscriber(paramSubscriber));
      Subscriber local2 = new Subscriber()
      {
        public void onCompleted()
        {
          localBufferingSubscriber.onCompleted();
        }
        
        public void onError(Throwable paramAnonymousThrowable)
        {
          localBufferingSubscriber.onError(paramAnonymousThrowable);
        }
        
        public void onNext(TClosing paramAnonymousTClosing)
        {
          localBufferingSubscriber.emit();
        }
      };
      paramSubscriber.add(local2);
      paramSubscriber.add(localBufferingSubscriber);
      localObservable.unsafeSubscribe(local2);
      return localBufferingSubscriber;
    }
    catch (Throwable localThrowable)
    {
      paramSubscriber.onError(localThrowable);
    }
    return Subscribers.empty();
  }
  
  final class BufferingSubscriber
    extends Subscriber<T>
  {
    final Subscriber<? super List<T>> child;
    List<T> chunk;
    boolean done;
    
    public BufferingSubscriber()
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
        chunk = new ArrayList(initialCapacity);
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
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorBufferWithSingleObservable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */