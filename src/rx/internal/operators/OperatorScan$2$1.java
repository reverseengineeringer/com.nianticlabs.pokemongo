package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Producer;

class OperatorScan$2$1
  implements Producer
{
  final AtomicBoolean excessive = new AtomicBoolean();
  final AtomicBoolean once = new AtomicBoolean();
  
  OperatorScan$2$1(OperatorScan.2 param2, Producer paramProducer) {}
  
  public void request(long paramLong)
  {
    if (once.compareAndSet(false, true))
    {
      if ((OperatorScan.2.access$300(this$1) == OperatorScan.access$100()) || (paramLong == Long.MAX_VALUE))
      {
        val$producer.request(paramLong);
        return;
      }
      if (paramLong == 1L)
      {
        excessive.set(true);
        val$producer.request(1L);
        return;
      }
      val$producer.request(paramLong - 1L);
      return;
    }
    if ((paramLong > 1L) && (excessive.compareAndSet(true, false)) && (paramLong != Long.MAX_VALUE))
    {
      val$producer.request(paramLong - 1L);
      return;
    }
    val$producer.request(paramLong);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorScan.2.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */