package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import rx.Observable.Operator;
import rx.Subscriber;
import rx.functions.Func0;
import rx.functions.Func1;

public final class OperatorToMultimap<T, K, V>
  implements Observable.Operator<Map<K, Collection<V>>, T>
{
  private final Func1<? super K, ? extends Collection<V>> collectionFactory;
  private final Func1<? super T, ? extends K> keySelector;
  private final Func0<? extends Map<K, Collection<V>>> mapFactory;
  private final Func1<? super T, ? extends V> valueSelector;
  
  public OperatorToMultimap(Func1<? super T, ? extends K> paramFunc1, Func1<? super T, ? extends V> paramFunc11)
  {
    this(paramFunc1, paramFunc11, new DefaultToMultimapFactory(), new DefaultMultimapCollectionFactory());
  }
  
  public OperatorToMultimap(Func1<? super T, ? extends K> paramFunc1, Func1<? super T, ? extends V> paramFunc11, Func0<? extends Map<K, Collection<V>>> paramFunc0)
  {
    this(paramFunc1, paramFunc11, paramFunc0, new DefaultMultimapCollectionFactory());
  }
  
  public OperatorToMultimap(Func1<? super T, ? extends K> paramFunc1, Func1<? super T, ? extends V> paramFunc11, Func0<? extends Map<K, Collection<V>>> paramFunc0, Func1<? super K, ? extends Collection<V>> paramFunc12)
  {
    keySelector = paramFunc1;
    valueSelector = paramFunc11;
    mapFactory = paramFunc0;
    collectionFactory = paramFunc12;
  }
  
  public Subscriber<? super T> call(final Subscriber<? super Map<K, Collection<V>>> paramSubscriber)
  {
    new Subscriber(paramSubscriber)
    {
      private Map<K, Collection<V>> map = (Map)mapFactory.call();
      
      public void onCompleted()
      {
        Map localMap = map;
        map = null;
        paramSubscriber.onNext(localMap);
        paramSubscriber.onCompleted();
      }
      
      public void onError(Throwable paramAnonymousThrowable)
      {
        map = null;
        paramSubscriber.onError(paramAnonymousThrowable);
      }
      
      public void onNext(T paramAnonymousT)
      {
        Object localObject1 = keySelector.call(paramAnonymousT);
        Object localObject2 = valueSelector.call(paramAnonymousT);
        Collection localCollection = (Collection)map.get(localObject1);
        paramAnonymousT = localCollection;
        if (localCollection == null)
        {
          paramAnonymousT = (Collection)collectionFactory.call(localObject1);
          map.put(localObject1, paramAnonymousT);
        }
        paramAnonymousT.add(localObject2);
      }
      
      public void onStart()
      {
        request(Long.MAX_VALUE);
      }
    };
  }
  
  public static final class DefaultMultimapCollectionFactory<K, V>
    implements Func1<K, Collection<V>>
  {
    public Collection<V> call(K paramK)
    {
      return new ArrayList();
    }
  }
  
  public static final class DefaultToMultimapFactory<K, V>
    implements Func0<Map<K, Collection<V>>>
  {
    public Map<K, Collection<V>> call()
    {
      return new HashMap();
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorToMultimap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */