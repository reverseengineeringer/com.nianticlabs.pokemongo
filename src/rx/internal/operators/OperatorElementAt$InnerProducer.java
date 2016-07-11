package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Producer;

class OperatorElementAt$InnerProducer
  extends AtomicBoolean
  implements Producer
{
  private static final long serialVersionUID = 1L;
  final Producer actual;
  
  public OperatorElementAt$InnerProducer(Producer paramProducer)
  {
    actual = paramProducer;
  }
  
  public void request(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("n >= 0 required");
    }
    if ((paramLong > 0L) && (compareAndSet(false, true))) {
      actual.request(Long.MAX_VALUE);
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorElementAt.InnerProducer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */