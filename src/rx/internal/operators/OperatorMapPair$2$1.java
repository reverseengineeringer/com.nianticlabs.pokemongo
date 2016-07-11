package rx.internal.operators;

import rx.functions.Func1;
import rx.functions.Func2;

class OperatorMapPair$2$1
  implements Func1<U, R>
{
  OperatorMapPair$2$1(OperatorMapPair.2 param2, Object paramObject) {}
  
  public R call(U paramU)
  {
    return (R)this$1.this$0.resultSelector.call(val$outer, paramU);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorMapPair.2.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */