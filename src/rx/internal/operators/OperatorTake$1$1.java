package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;

class OperatorTake$1$1
  implements Producer
{
  final AtomicLong requested = new AtomicLong(0L);
  
  OperatorTake$1$1(OperatorTake.1 param1, Producer paramProducer) {}
  
  public void request(long paramLong)
  {
    if ((paramLong > 0L) && (!this$1.completed)) {}
    long l1;
    long l2;
    do
    {
      l1 = requested.get();
      l2 = Math.min(paramLong, this$1.this$0.limit - l1);
      if (l2 == 0L) {
        return;
      }
    } while (!requested.compareAndSet(l1, l1 + l2));
    val$producer.request(l2);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorTake.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */