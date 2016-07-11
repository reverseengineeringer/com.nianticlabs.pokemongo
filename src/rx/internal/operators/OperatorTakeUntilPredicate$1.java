package rx.internal.operators;

import rx.Producer;

class OperatorTakeUntilPredicate$1
  implements Producer
{
  OperatorTakeUntilPredicate$1(OperatorTakeUntilPredicate paramOperatorTakeUntilPredicate, OperatorTakeUntilPredicate.ParentSubscriber paramParentSubscriber) {}
  
  public void request(long paramLong)
  {
    val$parent.downstreamRequest(paramLong);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorTakeUntilPredicate.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */