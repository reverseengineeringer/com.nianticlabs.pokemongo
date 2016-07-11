package rx.internal.operators;

import rx.Observable;
import rx.Observer;
import rx.observers.SerializedObserver;

final class OperatorWindowWithStartEndObservable$SerializedSubject<T>
{
  final Observer<T> consumer;
  final Observable<T> producer;
  
  public OperatorWindowWithStartEndObservable$SerializedSubject(Observer<T> paramObserver, Observable<T> paramObservable)
  {
    consumer = new SerializedObserver(paramObserver);
    producer = paramObservable;
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorWindowWithStartEndObservable.SerializedSubject
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */