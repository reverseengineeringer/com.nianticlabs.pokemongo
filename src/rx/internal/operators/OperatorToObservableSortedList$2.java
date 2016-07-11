package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import rx.Subscriber;
import rx.internal.producers.SingleDelayedProducer;

class OperatorToObservableSortedList$2
  extends Subscriber<T>
{
  boolean completed;
  List<T> list = new ArrayList(OperatorToObservableSortedList.access$000(this$0));
  
  OperatorToObservableSortedList$2(OperatorToObservableSortedList paramOperatorToObservableSortedList, SingleDelayedProducer paramSingleDelayedProducer, Subscriber paramSubscriber) {}
  
  public void onCompleted()
  {
    List localList;
    if (!completed)
    {
      completed = true;
      localList = list;
      list = null;
    }
    try
    {
      Collections.sort(localList, OperatorToObservableSortedList.access$100(this$0));
      val$producer.setValue(localList);
      return;
    }
    catch (Throwable localThrowable)
    {
      onError(localThrowable);
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    val$child.onError(paramThrowable);
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
 * Qualified Name:     rx.internal.operators.OperatorToObservableSortedList.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */