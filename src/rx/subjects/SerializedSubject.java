package rx.subjects;

import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.annotations.Experimental;
import rx.observers.SerializedObserver;

public class SerializedSubject<T, R>
  extends Subject<T, R>
{
  private final Subject<T, R> actual;
  private final SerializedObserver<T> observer;
  
  public SerializedSubject(Subject<T, R> paramSubject)
  {
    super(new Observable.OnSubscribe()
    {
      public void call(Subscriber<? super R> paramAnonymousSubscriber)
      {
        unsafeSubscribe(paramAnonymousSubscriber);
      }
    });
    actual = paramSubject;
    observer = new SerializedObserver(paramSubject);
  }
  
  @Experimental
  public Throwable getThrowable()
  {
    return actual.getThrowable();
  }
  
  @Experimental
  public T getValue()
  {
    return (T)actual.getValue();
  }
  
  @Experimental
  public Object[] getValues()
  {
    return actual.getValues();
  }
  
  @Experimental
  public T[] getValues(T[] paramArrayOfT)
  {
    return actual.getValues(paramArrayOfT);
  }
  
  @Experimental
  public boolean hasCompleted()
  {
    return actual.hasCompleted();
  }
  
  public boolean hasObservers()
  {
    return actual.hasObservers();
  }
  
  @Experimental
  public boolean hasThrowable()
  {
    return actual.hasThrowable();
  }
  
  @Experimental
  public boolean hasValue()
  {
    return actual.hasValue();
  }
  
  public void onCompleted()
  {
    observer.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    observer.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    observer.onNext(paramT);
  }
}

/* Location:
 * Qualified Name:     rx.subjects.SerializedSubject
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */