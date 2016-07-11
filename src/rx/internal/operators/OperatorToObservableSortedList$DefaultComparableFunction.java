package rx.internal.operators;

import java.util.Comparator;

class OperatorToObservableSortedList$DefaultComparableFunction
  implements Comparator<Object>
{
  public int compare(Object paramObject1, Object paramObject2)
  {
    return ((Comparable)paramObject1).compareTo((Comparable)paramObject2);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorToObservableSortedList.DefaultComparableFunction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */