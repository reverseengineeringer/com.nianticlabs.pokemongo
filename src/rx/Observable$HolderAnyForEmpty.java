package rx;

import rx.internal.operators.OperatorAny;
import rx.internal.util.UtilityFunctions;

class Observable$HolderAnyForEmpty
{
  static final OperatorAny<?> INSTANCE = new OperatorAny(UtilityFunctions.alwaysTrue(), true);
}

/* Location:
 * Qualified Name:     rx.Observable.HolderAnyForEmpty
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */