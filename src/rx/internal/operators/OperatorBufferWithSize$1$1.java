package rx.internal.operators;

import rx.Producer;

class OperatorBufferWithSize$1$1
  implements Producer
{
  private volatile boolean infinite = false;
  
  OperatorBufferWithSize$1$1(OperatorBufferWithSize.1 param1, Producer paramProducer) {}
  
  public void request(long paramLong)
  {
    if (infinite) {
      return;
    }
    if (paramLong >= Long.MAX_VALUE / this$1.this$0.count)
    {
      infinite = true;
      val$producer.request(Long.MAX_VALUE);
      return;
    }
    val$producer.request(this$1.this$0.count * paramLong);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorBufferWithSize.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */