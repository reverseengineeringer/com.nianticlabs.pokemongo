package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.functions.Action0;

class OperatorSkipTimed$1
  implements Action0
{
  OperatorSkipTimed$1(OperatorSkipTimed paramOperatorSkipTimed, AtomicBoolean paramAtomicBoolean) {}
  
  public void call()
  {
    val$gate.set(true);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorSkipTimed.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */