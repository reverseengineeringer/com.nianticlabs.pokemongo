package rx.internal.operators;

import rx.Producer;

class OperatorWindowWithSize$ExactSubscriber$2
  implements Producer
{
  OperatorWindowWithSize$ExactSubscriber$2(OperatorWindowWithSize.ExactSubscriber paramExactSubscriber) {}
  
  public void request(long paramLong)
  {
    if (paramLong > 0L)
    {
      long l2 = paramLong * this$1.this$0.size;
      long l1 = l2;
      if (l2 >>> 31 != 0L)
      {
        l1 = l2;
        if (l2 / paramLong != this$1.this$0.size) {
          l1 = Long.MAX_VALUE;
        }
      }
      this$1.requestMore(l1);
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorWindowWithSize.ExactSubscriber.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */