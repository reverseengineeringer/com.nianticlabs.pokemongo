package rx.internal.operators;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import rx.Subscriber;
import rx.internal.producers.SingleDelayedProducer;

class OperatorToObservableList$1
  extends Subscriber<T>
{
  boolean completed = false;
  List<T> list = new LinkedList();
  
  OperatorToObservableList$1(OperatorToObservableList paramOperatorToObservableList, SingleDelayedProducer paramSingleDelayedProducer, Subscriber paramSubscriber) {}
  
  public void onCompleted()
  {
    if (!completed) {
      completed = true;
    }
    try
    {
      ArrayList localArrayList = new ArrayList(list);
      list = null;
      val$producer.setValue(localArrayList);
      return;
    }
    catch (Throwable localThrowable)
    {
      onError(localThrowable);
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    val$o.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    if (!completed) {
      list.add(paramT);
    }
  }
  
  public void onStart()
  {
    request(Long.MAX_VALUE);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorToObservableList.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */