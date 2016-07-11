package rx.observables;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

public class GroupedObservable<K, T>
  extends Observable<T>
{
  private final K key;
  
  protected GroupedObservable(K paramK, Observable.OnSubscribe<T> paramOnSubscribe)
  {
    super(paramOnSubscribe);
    key = paramK;
  }
  
  public static final <K, T> GroupedObservable<K, T> create(K paramK, Observable.OnSubscribe<T> paramOnSubscribe)
  {
    return new GroupedObservable(paramK, paramOnSubscribe);
  }
  
  public static <K, T> GroupedObservable<K, T> from(K paramK, Observable<T> paramObservable)
  {
    new GroupedObservable(paramK, new Observable.OnSubscribe()
    {
      public void call(Subscriber<? super T> paramAnonymousSubscriber)
      {
        val$o.unsafeSubscribe(paramAnonymousSubscriber);
      }
    });
  }
  
  public K getKey()
  {
    return (K)key;
  }
}

/* Location:
 * Qualified Name:     rx.observables.GroupedObservable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */