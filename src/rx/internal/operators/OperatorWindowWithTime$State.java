package rx.internal.operators;

import rx.Observable;
import rx.Observer;

final class OperatorWindowWithTime$State<T>
{
  static final State<Object> EMPTY = new State(null, null, 0);
  final Observer<T> consumer;
  final int count;
  final Observable<T> producer;
  
  public OperatorWindowWithTime$State(Observer<T> paramObserver, Observable<T> paramObservable, int paramInt)
  {
    consumer = paramObserver;
    producer = paramObservable;
    count = paramInt;
  }
  
  public static <T> State<T> empty()
  {
    return EMPTY;
  }
  
  public State<T> clear()
  {
    return empty();
  }
  
  public State<T> create(Observer<T> paramObserver, Observable<T> paramObservable)
  {
    return new State(paramObserver, paramObservable, 0);
  }
  
  public State<T> next()
  {
    return new State(consumer, producer, count + 1);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorWindowWithTime.State
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */