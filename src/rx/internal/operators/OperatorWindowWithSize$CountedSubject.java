package rx.internal.operators;

import rx.Observable;
import rx.Observer;

final class OperatorWindowWithSize$CountedSubject<T>
{
  final Observer<T> consumer;
  int count;
  final Observable<T> producer;
  
  public OperatorWindowWithSize$CountedSubject(Observer<T> paramObserver, Observable<T> paramObservable)
  {
    consumer = paramObserver;
    producer = paramObservable;
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorWindowWithSize.CountedSubject
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */