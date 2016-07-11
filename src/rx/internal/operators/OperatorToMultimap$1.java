package rx.internal.operators;

import java.util.Collection;
import java.util.Map;
import rx.Subscriber;
import rx.functions.Func0;
import rx.functions.Func1;

class OperatorToMultimap$1
  extends Subscriber<T>
{
  private Map<K, Collection<V>> map = (Map)OperatorToMultimap.access$000(this$0).call();
  
  OperatorToMultimap$1(OperatorToMultimap paramOperatorToMultimap, Subscriber paramSubscriber1, Subscriber paramSubscriber2)
  {
    super(paramSubscriber1);
  }
  
  public void onCompleted()
  {
    Map localMap = map;
    map = null;
    val$subscriber.onNext(localMap);
    val$subscriber.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    map = null;
    val$subscriber.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    Object localObject1 = OperatorToMultimap.access$100(this$0).call(paramT);
    Object localObject2 = OperatorToMultimap.access$200(this$0).call(paramT);
    Collection localCollection = (Collection)map.get(localObject1);
    paramT = localCollection;
    if (localCollection == null)
    {
      paramT = (Collection)OperatorToMultimap.access$300(this$0).call(localObject1);
      map.put(localObject1, paramT);
    }
    paramT.add(localObject2);
  }
  
  public void onStart()
  {
    request(Long.MAX_VALUE);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorToMultimap.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */