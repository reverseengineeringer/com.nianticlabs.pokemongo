package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;

class OperatorOnBackpressureDrop$1
  implements Producer
{
  OperatorOnBackpressureDrop$1(OperatorOnBackpressureDrop paramOperatorOnBackpressureDrop, AtomicLong paramAtomicLong) {}
  
  public void request(long paramLong)
  {
    BackpressureUtils.getAndAddRequest(val$requested, paramLong);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorOnBackpressureDrop.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */