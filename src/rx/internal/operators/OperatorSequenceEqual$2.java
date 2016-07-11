package rx.internal.operators;

import rx.functions.Func2;

final class OperatorSequenceEqual$2
  implements Func2<Object, Object, Boolean>
{
  OperatorSequenceEqual$2(Func2 paramFunc2) {}
  
  public Boolean call(Object paramObject1, Object paramObject2)
  {
    int i;
    if (paramObject1 == OperatorSequenceEqual.access$000())
    {
      i = 1;
      if (paramObject2 != OperatorSequenceEqual.access$000()) {
        break label38;
      }
    }
    label38:
    for (int j = 1;; j = 0)
    {
      if ((i == 0) || (j == 0)) {
        break label44;
      }
      return Boolean.valueOf(true);
      i = 0;
      break;
    }
    label44:
    if ((i != 0) || (j != 0)) {
      return Boolean.valueOf(false);
    }
    return (Boolean)val$equality.call(paramObject1, paramObject2);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorSequenceEqual.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */