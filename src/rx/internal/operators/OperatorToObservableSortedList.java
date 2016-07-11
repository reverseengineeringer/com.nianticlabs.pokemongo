package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import rx.Observable.Operator;
import rx.Subscriber;
import rx.functions.Func2;
import rx.internal.producers.SingleDelayedProducer;

public final class OperatorToObservableSortedList<T>
  implements Observable.Operator<List<T>, T>
{
  private static Comparator DEFAULT_SORT_FUNCTION = new DefaultComparableFunction(null);
  private final int initialCapacity;
  private final Comparator<? super T> sortFunction;
  
  public OperatorToObservableSortedList(int paramInt)
  {
    sortFunction = DEFAULT_SORT_FUNCTION;
    initialCapacity = paramInt;
  }
  
  public OperatorToObservableSortedList(final Func2<? super T, ? super T, Integer> paramFunc2, int paramInt)
  {
    initialCapacity = paramInt;
    sortFunction = new Comparator()
    {
      public int compare(T paramAnonymousT1, T paramAnonymousT2)
      {
        return ((Integer)paramFunc2.call(paramAnonymousT1, paramAnonymousT2)).intValue();
      }
    };
  }
  
  public Subscriber<? super T> call(final Subscriber<? super List<T>> paramSubscriber)
  {
    final SingleDelayedProducer localSingleDelayedProducer = new SingleDelayedProducer(paramSubscriber);
    Subscriber local2 = new Subscriber()
    {
      boolean completed;
      List<T> list = new ArrayList(initialCapacity);
      
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
          Collections.sort(localList, sortFunction);
          localSingleDelayedProducer.setValue(localList);
          return;
        }
        catch (Throwable localThrowable)
        {
          onError(localThrowable);
        }
      }
      
      public void onError(Throwable paramAnonymousThrowable)
      {
        paramSubscriber.onError(paramAnonymousThrowable);
      }
      
      public void onNext(T paramAnonymousT)
      {
        if (!completed) {
          list.add(paramAnonymousT);
        }
      }
      
      public void onStart()
      {
        request(Long.MAX_VALUE);
      }
    };
    paramSubscriber.add(local2);
    paramSubscriber.setProducer(localSingleDelayedProducer);
    return local2;
  }
  
  private static class DefaultComparableFunction
    implements Comparator<Object>
  {
    public int compare(Object paramObject1, Object paramObject2)
    {
      return ((Comparable)paramObject1).compareTo((Comparable)paramObject2);
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorToObservableSortedList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */