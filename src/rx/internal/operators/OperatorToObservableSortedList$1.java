package rx.internal.operators;

import java.util.Comparator;
import rx.functions.Func2;

class OperatorToObservableSortedList$1
  implements Comparator<T>
{
  OperatorToObservableSortedList$1(OperatorToObservableSortedList paramOperatorToObservableSortedList, Func2 paramFunc2) {}
  
  public int compare(T paramT1, T paramT2)
  {
    return ((Integer)val$sortFunction.call(paramT1, paramT2)).intValue();
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorToObservableSortedList.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */