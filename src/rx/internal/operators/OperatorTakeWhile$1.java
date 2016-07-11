package rx.internal.operators;

import rx.functions.Func1;
import rx.functions.Func2;

class OperatorTakeWhile$1
  implements Func2<T, Integer, Boolean>
{
  OperatorTakeWhile$1(Func1 paramFunc1) {}
  
  public Boolean call(T paramT, Integer paramInteger)
  {
    return (Boolean)val$underlying.call(paramT);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorTakeWhile.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */