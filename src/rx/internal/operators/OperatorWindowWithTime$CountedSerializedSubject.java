package rx.internal.operators;

import rx.Observable;
import rx.Observer;
import rx.observers.SerializedObserver;

final class OperatorWindowWithTime$CountedSerializedSubject<T>
{
  final Observer<T> consumer;
  int count;
  final Observable<T> producer;
  
  public OperatorWindowWithTime$CountedSerializedSubject(Observer<T> paramObserver, Observable<T> paramObservable)
  {
    consumer = new SerializedObserver(paramObserver);
    producer = paramObservable;
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorWindowWithTime.CountedSerializedSubject
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */