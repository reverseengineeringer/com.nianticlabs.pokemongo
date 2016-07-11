package rx.internal.operators;

import java.util.Map;
import rx.Subscriber;
import rx.functions.Func0;
import rx.functions.Func1;

class OperatorToMap$1
  extends Subscriber<T>
{
  private Map<K, V> map = (Map)OperatorToMap.access$000(this$0).call();
  
  OperatorToMap$1(OperatorToMap paramOperatorToMap, Subscriber paramSubscriber1, Subscriber paramSubscriber2)
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
    Object localObject = OperatorToMap.access$100(this$0).call(paramT);
    paramT = OperatorToMap.access$200(this$0).call(paramT);
    map.put(localObject, paramT);
  }
  
  public void onStart()
  {
    request(Long.MAX_VALUE);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorToMap.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */