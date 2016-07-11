package rx.internal.operators;

import rx.Producer;

class OperatorGroupBy$GroupBySubscriber$2$1
  implements Producer
{
  OperatorGroupBy$GroupBySubscriber$2$1(OperatorGroupBy.GroupBySubscriber.2 param2) {}
  
  public void request(long paramLong)
  {
    this$1.this$0.requestFromGroupedObservable(paramLong, this$1.val$groupState);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorGroupBy.GroupBySubscriber.2.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */