package rx.internal.operators;

import rx.Producer;

class OperatorBufferWithSize$2$1
  implements Producer
{
  private volatile boolean firstRequest = true;
  private volatile boolean infinite = false;
  
  OperatorBufferWithSize$2$1(OperatorBufferWithSize.2 param2, Producer paramProducer) {}
  
  private void requestInfinite()
  {
    infinite = true;
    val$producer.request(Long.MAX_VALUE);
  }
  
  public void request(long paramLong)
  {
    if (paramLong == 0L) {}
    do
    {
      return;
      if (paramLong < 0L) {
        throw new IllegalArgumentException("request a negative number: " + paramLong);
      }
    } while (infinite);
    if (paramLong == Long.MAX_VALUE)
    {
      requestInfinite();
      return;
    }
    if (firstRequest)
    {
      firstRequest = false;
      if (paramLong - 1L >= (Long.MAX_VALUE - this$1.this$0.count) / this$1.this$0.skip)
      {
        requestInfinite();
        return;
      }
      val$producer.request(this$1.this$0.count + this$1.this$0.skip * (paramLong - 1L));
      return;
    }
    if (paramLong >= Long.MAX_VALUE / this$1.this$0.skip)
    {
      requestInfinite();
      return;
    }
    val$producer.request(this$1.this$0.skip * paramLong);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorBufferWithSize.2.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */